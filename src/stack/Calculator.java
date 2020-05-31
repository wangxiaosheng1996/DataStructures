package stack;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "40+70*3-50";
		//创建两个栈，一个数栈，一个符号栈
		ArrayStack2 numStack = new ArrayStack2(10);
		ArrayStack2 operStack = new ArrayStack2(10);
		
		//定义需要的相关变量
		int index = 0;  //用于扫描
		int num1 = 0;
		int num2 = 0;
		int oper = 0;
		int res = 0;
		char ch = ' ';
		String keepNum = "";  //用于拼接多位数
		//开始while循环扫描expression
		while(true) {
			//依次得到每个字符
			ch = expression.charAt(index);
			//判断ch是什么，做相应的处理
			if(operStack.isOper(ch)) { //如果是运算符
				//判断当前符号栈是否为空
				if(!operStack.isEmpty()) { //符号栈不为空
					//当前操作符优先级小于或等于栈顶的操作符，从数栈pop两个数，从符号栈pop一个符号，进行运算，将结果存入数栈，然后将当前操作符存入符号栈
					if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1, num2, oper);
						numStack.push(res);
						operStack.push(ch);
					}else {  //当前操作符优先级大于栈顶的操作符，就直接入符号栈
						operStack.push(ch);	
					}
					
				}else {  //符号栈为空，直接入符号栈
					operStack.push(ch);	
				}
			}else {  //如果是数，则直接入数栈
				//处理多位数时，不能发现是一个数就直接入栈，因为可能是多位数
				//要向expression表达式的index后再看一位，如果是数就进行继续扫描，如果是符号才入栈
				//因此需要定义一个字符串变量用于拼接
				keepNum += ch;
				//如果ch是expression的最后一位，就直接入栈
				if(index == expression.length()-1) {
					numStack.push(Integer.parseInt(keepNum));
				}else {
					if(operStack.isOper(expression.charAt(index+1))) {
						//后一位是运算符
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
		//当表达式扫描完毕，就顺序地从数栈和符号栈中pop出相应的数和符号并运算
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
		int res2 = numStack.pop();  //最终的结果
		System.out.printf("%s=%d", expression,res2);
		
	}

}


//创建一个栈，直接用前面数组模拟的栈
class ArrayStack2{
	private int maxSize;  //栈的大小
	private int[] stack;   //数组模拟栈，数据就放在数组里
	private int top = -1;    //表示栈顶，初始化为-1
	
	public ArrayStack2(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	
	//增加一个方法，可以返回当前栈顶的值，但是不是出栈
	public int peek(){
		return stack[top];
	}
	
	
	//栈满
	public boolean isFull() {
		return top == maxSize-1;
	}
	
	//栈空
	public boolean isEmpty() {
		return top == -1;
	}
	
	//入栈
	public void push(int value) {
		//先判断是否栈满
		if(isFull()) {
			System.out.println("栈满，不能压入数据");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	//出栈
	public int pop() {
		//先判断是否栈空
		if(isEmpty()) {
			throw new RuntimeException("栈空，没有数据");
		}
		int value = stack[top];
		top--;
		return value;
	}
	
	//遍历，从栈顶开始
	public void list() {
		if(isEmpty()) {
			System.out.println("栈空，没有数据");
			return;
		}
		for(int i=top;i>=0;i--) {
			System.out.printf("stack[%d]=%d\n",i,stack[i]);
		}
	}
	
	//返回运算符的优先级，这个优先级是由程序员来确定的，优先级使用数字来表示
	//数字越大，表示优先级越高
	public int priority(int oper) {
		if(oper=='*'||oper=='/') {
			return 1;
		}else if(oper=='+'||oper=='-') {
			return 0;
		}else {
			return -1;   //假定目前表达式只有+-*/
		}
	}
	
	//判断是不是一个运算符
	public boolean isOper(char val) {
		return val=='+'||val=='-'||val=='*'||val=='/';
	}
	
	//计算方法
	public int cal(int num1,int num2,int oper) {
		int res = 0;  //用于存放计算的结果
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