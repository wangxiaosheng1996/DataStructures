package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//�沨����������
//1.֧��+-*/()   2.֧��С����   3.���ݴ������˿հ��ַ��������ո��Ʊ�������з�

public class PolandNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		//�ȶ����沨�����ʽ
		//(30+4)��5-6  => 30 4 + 5 �� 6 - => 164
		// 4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +      76
		//˵��Ϊ�˷��㣬�沨�����ʽ�����ֺͷ���ʹ�ÿո����
		String suffixExpression = "30 4 + 5 * 6 -";
		String suffixExpression2 = "4 5 * 8 - 60 + 8 2 / +"; 
		List<String> list = getStringList(suffixExpression2);
		System.out.println("list:" + list);
		int res = calculate(list);
		System.out.println("��������:" + res);
		*/
		
		/*
		��һ����׺���ʽת�ɺ�׺���ʽ
		1.    1+((2+3)��4)-5 => ת��  1 2 3 + 4 �� + 5 �C
		2.    ֱ�Ӷ��ַ������������㣬�Ƚ��ַ���תΪArrayList<String>
		3.    ����׺ArrayList<String>ת�ɺ�׺ArrayList<String>(����Ҫ!!!)
		*/
		
		String Infixexpression =  "1  +(2.5+3.5)*	4-5";
		//ȥ����׺���ʽ�еĿհ��ַ�
		Infixexpression = Infixexpression.replaceAll("\\s+", "");    //1+(2.5+3.5)*4-5
		List<String> InfixList = toInfixExpressionList(Infixexpression);
		System.out.println("��׺���ʽ:" + InfixList);
		List<String> SuffixList = InfixToSuffix(InfixList);
		System.out.println("��׺���ʽ:" + SuffixList);
		System.out.println("������:" + calculate(SuffixList));

	}
	
	//��׺���ʽת���ɺ�׺���ʽ        1+(2.5+3.5)*4)-5 => ת��  1 2 3 + 4 �� + 5 �C
	public static List<String> InfixToSuffix(List<String> ls){
		//����s2���ջû�г�ջ�����������list��������������Ҳ�������������
		Stack<String> s1 = new Stack<String>();   //����ջ
		List<String> s2 = new ArrayList<String>();  //����м���
		
		for(String s:ls) {
			if(s.matches("\\d+(\\.\\d+)*")) {   //����ֱ����s2
				s2.add(s);
			}else if(s.equals("(")) {  //"("ֱ����s1
				s1.push(s);
			}else if(s.equals(")")){   //")",���ε���s1ջ�����������ѹ��s2��ֱ�����������ţ�Ȼ��������Ŷ���
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();   //��������)����s1ջ
				
			}else {  //��������ж����ȼ�����s�����ȼ����ڻ����ջ�����������s1ջ�������������������s2������s1ջ��������Ƚ�
				while(s1.size() != 0 && Operation.getPriority(s1.peek()) >= Operation.getPriority(s)) {
					s2.add(s1.pop());
				}
				s1.push(s);
			}
		}
		
		//��s1��ʣ�����������ε�������s2
		while(s1.size() != 0) {
			s2.add(s1.pop());
		}
		return s2;
		
	}
	
	
	//�������� ��׺���ʽת�ɶ�Ӧ��List    1+(2.5+3.5)*4-5
	//  s="1+((2+3)��4)-5";
	public static List<String> toInfixExpressionList(String s){
		List<String> ls = new ArrayList<String>();
		int i = 0;  //���������ڱ����ַ���
		String str = null;   //����ƴ�������ַ���
		char c;   
		do{
			//  '0':48   '0':57
			if((c=s.charAt(i))=='+' || (c=s.charAt(i))=='-'|| (c=s.charAt(i))=='*'|| (c=s.charAt(i))=='/'|| (c=s.charAt(i))=='('|| (c=s.charAt(i))==')') {   //+-*/()
				ls.add(c+"");
				i++;
			}else {  //Ϊ���֣�Ҫ���Ƕ�λ��
				str = "";
				while(i<s.length() && (((c=s.charAt(i))>=48 && (c=s.charAt(i))<=57) || (c=s.charAt(i))=='.')) {
					str += c;
					i++;
				}
				ls.add(str);
			}
		}while(i<s.length());
		return ls;
	}
	
	
	
	
	
	//��һ���沨�����ʽ�����ν����ݺ���������뵽ArrayList��
	public static List<String> getStringList(String suffixExpression){
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for(String s:split) {
			list.add(s);
		}
		return list;
	}
	
	//��ɶ��沨�����ʽ������
	public static double calculate(List<String> ls) {
		Stack<String> stack = new Stack<String>();
		for(String s:ls) {
			if(s.matches("\\d+(\\.\\d+)*")) {  //ȡ�����Ƕ�λ��
				stack.push(s);
			}else {   //ȡ���������
  				//pop�������������㣬����ջ
				double num2 = Double.parseDouble(stack.pop());
				double num1 = Double.parseDouble(stack.pop());
				double res = 0;
				if(s.equals("+")) {
					res = num1 + num2;
				}else if(s.equals("-")) {
					res = num1 - num2;
				}else if(s.equals("*")) {
					res = num1 * num2;
				}else if(s.equals("/")) {
					res = num1 / num2;
				}else {
					throw new RuntimeException("���������");
				}
				stack.push(""+res);
			}
		}
		//�������ջ�е�������������
		return Double.parseDouble(stack.pop());
	}

}


//��дһ���� Operation ���Է���һ������� ��Ӧ�����ȼ�
class Operation{
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;

	//���ض�Ӧ�����ȼ�
	public static int getPriority(String operation) {
		int result = 0;
		switch(operation) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
		default:
			break;	
		}
		return result;
	}
	
	
	
}





