package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


//逆波兰计算器：
//1.支持+-*/()   2.支持小数点   3.兼容处理，过滤空白字符，包括空格、制表符、换行符

public class PolandNotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		//先定义逆波兰表达式
		//(30+4)×5-6  => 30 4 + 5 × 6 - => 164
		// 4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +      76
		//说明为了方便，逆波兰表达式的数字和符号使用空格隔开
		String suffixExpression = "30 4 + 5 * 6 -";
		String suffixExpression2 = "4 5 * 8 - 60 + 8 2 / +"; 
		List<String> list = getStringList(suffixExpression2);
		System.out.println("list:" + list);
		int res = calculate(list);
		System.out.println("结算结果是:" + res);
		*/
		
		/*
		将一个中缀表达式转成后缀表达式
		1.    1+((2+3)×4)-5 => 转成  1 2 3 + 4 × + 5 –
		2.    直接对字符串操作不方便，先将字符串转为ArrayList<String>
		3.    将中缀ArrayList<String>转成后缀ArrayList<String>(最主要!!!)
		*/
		
		String Infixexpression =  "1  +(2.5+3.5)*	4-5";
		//去除中缀表达式中的空白字符
		Infixexpression = Infixexpression.replaceAll("\\s+", "");    //1+(2.5+3.5)*4-5
		List<String> InfixList = toInfixExpressionList(Infixexpression);
		System.out.println("中缀表达式:" + InfixList);
		List<String> SuffixList = InfixToSuffix(InfixList);
		System.out.println("后缀表达式:" + SuffixList);
		System.out.println("计算结果:" + calculate(SuffixList));

	}
	
	//中缀表达式转换成后缀表达式        1+(2.5+3.5)*4)-5 => 转成  1 2 3 + 4 × + 5 –
	public static List<String> InfixToSuffix(List<String> ls){
		//由于s2这个栈没有出栈操作，因此用list来替代，这样最后也不用逆序输出了
		Stack<String> s1 = new Stack<String>();   //符号栈
		List<String> s2 = new ArrayList<String>();  //存放中间结果
		
		for(String s:ls) {
			if(s.matches("\\d+(\\.\\d+)*")) {   //数组直接入s2
				s2.add(s);
			}else if(s.equals("(")) {  //"("直接入s1
				s1.push(s);
			}else if(s.equals(")")){   //")",依次弹出s1栈顶的运算符，压入s2，直到遇到左括号，然后将这对括号丢弃
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();   //将右括号)弹出s1栈
				
			}else {  //运算符，判断优先级，当s的优先级低于或等于栈顶运算符，将s1栈顶的运算符弹出并加入s2，再与s1栈顶运算符比较
				while(s1.size() != 0 && Operation.getPriority(s1.peek()) >= Operation.getPriority(s)) {
					s2.add(s1.pop());
				}
				s1.push(s);
			}
		}
		
		//将s1中剩余的运算符依次弹出加入s2
		while(s1.size() != 0) {
			s2.add(s1.pop());
		}
		return s2;
		
	}
	
	
	//方法：将 中缀表达式转成对应的List    1+(2.5+3.5)*4-5
	//  s="1+((2+3)×4)-5";
	public static List<String> toInfixExpressionList(String s){
		List<String> ls = new ArrayList<String>();
		int i = 0;  //索引，用于遍历字符串
		String str = null;   //用于拼接数字字符串
		char c;   
		do{
			//  '0':48   '0':57
			if((c=s.charAt(i))=='+' || (c=s.charAt(i))=='-'|| (c=s.charAt(i))=='*'|| (c=s.charAt(i))=='/'|| (c=s.charAt(i))=='('|| (c=s.charAt(i))==')') {   //+-*/()
				ls.add(c+"");
				i++;
			}else {  //为数字，要考虑多位数
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
	
	
	
	
	
	//将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
	public static List<String> getStringList(String suffixExpression){
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for(String s:split) {
			list.add(s);
		}
		return list;
	}
	
	//完成对逆波兰表达式的运算
	public static double calculate(List<String> ls) {
		Stack<String> stack = new Stack<String>();
		for(String s:ls) {
			if(s.matches("\\d+(\\.\\d+)*")) {  //取出的是多位数
				stack.push(s);
			}else {   //取出的运算符
  				//pop出两个数并运算，再入栈
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
					throw new RuntimeException("运算符有误");
				}
				stack.push(""+res);
			}
		}
		//最后留在栈中的数据是运算结果
		return Double.parseDouble(stack.pop());
	}

}


//编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation{
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;

	//返回对应的优先级
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





