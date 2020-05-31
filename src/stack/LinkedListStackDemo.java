package stack;

import java.util.Scanner;

//用链表模拟栈
public class LinkedListStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListStack stack = new LinkedListStack();
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
				System.out.println("请输入学生姓名");
				String name = scanner.next();
				Student s = new Student(name);
				stack.push(s);
				break;
			case "pop":
				try {
					Student res = stack.pop();
					System.out.println("出栈学生是"+res);
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


//用一个双向链表模拟栈
class LinkedListStack{
	private Student head = new Student("");  //链表的头节点
	private Student top = head;   //栈顶
	
	//判断是否栈空
	public boolean isEmpty() {
		return head == top;
	}
	
	//入栈
	public void push(Student s) {
		top.setNext(s);
		s.setPre(top);
		top = s;
	}
	
	//出栈
	public Student pop() {
		if(isEmpty()) {
			throw new RuntimeException("栈空，没有数据");
		}
		Student s = top;
		top.getPre().setNext(null);
		top = top.getPre();
		return s;
	}
	
	//遍历
	public void list() {
		if(isEmpty()) {
			System.out.println("栈空，没有数据");
			return;
		}
		Student temp = head.getNext();
		while(true) {
			if(temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.getNext();
			
		}
	}
}

//节点类
class Student{
	private String name;
	private Student pre;
	private Student next;
	
	public Student getPre() {
		return pre;
	}

	public void setPre(Student pre) {
		this.pre = pre;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getNext() {
		return next;
	}

	public void setNext(Student next) {
		this.next = next;
	}

	public Student(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}
	

}