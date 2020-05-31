package stack;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "40+70*3-50";
		//��������ջ��һ����ջ��һ������ջ
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		
		//������Ҫ����ر���
		int index = 0;  //����ɨ��
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';
		String keepNum = "";  //����ƴ�Ӷ�λ��
		//��ʼwhileѭ��ɨ��expression
		while(true) {
			//���εõ�ÿ���ַ�
			ch = expression.charAt(index);
			//�ж�ch��ʲô������Ӧ�Ĵ���
			if(operStack.isOper(ch)) { //����������
				//�жϵ�ǰ����ջ�Ƿ�Ϊ��
				if(!operStack.isEmpty()) { //����ջ��Ϊ��
					//��ǰ���������ȼ�С�ڻ����ջ���Ĳ�����������ջpop���������ӷ���ջpopһ�����ţ��������㣬�����������ջ��Ȼ�󽫵�ǰ�������������ջ
					if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						numStack.push(res);
						operStack.push(ch);
					}else {  //��ǰ���������ȼ�����ջ���Ĳ���������ֱ�������ջ
						operStack.push(ch);	
					}
					
				}else {  //����ջΪ�գ�ֱ�������ջ
					operStack.push(ch);	
				}
			}else {  //�����������ֱ������ջ
				//�����λ��ʱ�����ܷ�����һ������ֱ����ջ����Ϊ�����Ƕ�λ��
				//Ҫ��expression���ʽ��index���ٿ�һλ����������ͽ��м���ɨ�裬����Ƿ��Ų���ջ
				//�����Ҫ����һ���ַ�����������ƴ��
				keepNum += ch;
				//���ch��expression�����һλ����ֱ����ջ
				if(index == expression.length()-1) {
					numStack.push(Integer.parseInt(keepNum));
				}else {
					if(operStack.isOper(expression.charAt(index+1))) {
						//��һλ�������
						numStack.push(Integer.parseInt(keepNum));
						keepNum = "";
					}
				}

				
			}
			index++;
			if(index >= expression.length()) {
				break;
			}
			
		}
		//�����ʽɨ����ϣ���˳��ش���ջ�ͷ���ջ��pop����Ӧ�����ͷ��Ų�����
		while(true) {
			if(operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);
		}
		int res2 = numStack.pop();  //���յĽ��
		System.out.printf("%s=%d", expression,res2);
		
	}

}


//����һ��ջ��ֱ����ǰ������ģ���ջ
class ArrayStack2{
	private int maxSize;  //ջ�Ĵ�С
	private int[] stack;   //����ģ��ջ�����ݾͷ���������
	private int top = -1;    //��ʾջ������ʼ��Ϊ-1
	
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	
	//����һ�����������Է��ص�ǰջ����ֵ�����ǲ��ǳ�ջ
	public int peek(){
		return stack[top];
	}
	
	
	//ջ��
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	//ջ��
	public boolean isEmpty() {
		return top == -1;
	}
	
	//��ջ
	public void push(int value) {
		//���ж��Ƿ�ջ��
		if(isFull()) {
			System.out.println("ջ��������ѹ������");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	//��ջ
	public int pop() {
		//���ж��Ƿ�ջ��
		if(isEmpty()) {
			throw new RuntimeException("ջ�գ�û������");
		}
		int value = stack[top];
		top--;
		return value;
	}
	
	//��������ջ����ʼ
	public void list() {
		if(isEmpty()) {
			System.out.println("ջ�գ�û������");
			return;
		}
		for(int i=top;i>=0;i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
	
	//��������������ȼ���������ȼ����ɳ���Ա��ȷ���ģ����ȼ�ʹ����������ʾ
	//����Խ�󣬱�ʾ���ȼ�Խ��
	public int priority(int oper) {
		if(oper=='*'||oper=='/') {
			return 1;
		}else if(oper=='+'||oper=='-') {
			return 0;
		}else {
			return -1;   //�ٶ�Ŀǰ���ʽֻ��+-*/
		}
	}
	
	//�ж��ǲ���һ�������
	public boolean isOper(char val) {
		return val=='+'||val=='-'||val=='*'||val=='/';
	}
	
	//���㷽��
	public int cal(int num1,int num2,int oper) {
		int res = 0;  //���ڴ�ż���Ľ��
		switch(oper) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		default:
			break;
		}
		return res;
		
	}
	
	
	
	
	
	
	
	
	
}