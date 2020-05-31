package stack;

import java.util.Scanner;
public class ArrayStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack stack = new ArrayStack(4);
		String key = "";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		
		while(loop) {
			System.out.println("show:显示栈的内容");
			System.out.println("push:入栈");
			System.out.println("pop:出栈");
			System.out.println("exit:退出程序");
			System.out.println("请输入你的选择");
			key = scanner.next();
			switch(key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("请输入一个数");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("出栈的数据是%d\n",res);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();
				loop = false;
				break;
			default:
				break;

			}
			
		}
		System.out.println("程序退出");
		

	}

}


//定义一个ArrayStack表示栈
class ArrayStack{
	private int maxSize;  //栈的大小
	private int[] stack;   //数组模拟栈，数据就放在数组里
	private int top = -1;    //表示栈顶，初始化为-1
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
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
	
}








