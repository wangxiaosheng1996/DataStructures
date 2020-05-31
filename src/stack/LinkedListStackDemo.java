package stack;

import java.util.Scanner;

//������ģ��ջ
public class LinkedListStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListStack stack = new LinkedListStack();
		String key = "";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		
		while(loop) {
			System.out.println("show:��ʾջ������");
			System.out.println("push:��ջ");
			System.out.println("pop:��ջ");
			System.out.println("exit:�˳�����");
			System.out.println("���������ѡ��");
			key = scanner.next();
			switch(key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("������ѧ������");
				String name = scanner.next();
				Student s = new Student(name);
				stack.push(s);
				break;
			case "pop":
				try {
					Student res = stack.pop();
					System.out.println("��ջѧ����"+res);
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
		System.out.println("�����˳�");
		

	}

}


//��һ��˫������ģ��ջ
class LinkedListStack{
	private Student head = new Student("");  //�����ͷ�ڵ�
	private Student top = head;   //ջ��
	
	//�ж��Ƿ�ջ��
	public boolean isEmpty() {
		return head == top;
	}
	
	//��ջ
	public void push(Student s) {
		top.setNext(s);
		s.setPre(top);
		top = s;
	}
	
	//��ջ
	public Student pop() {
		if(isEmpty()) {
			throw new RuntimeException("ջ�գ�û������");
		}
		Student s = top;
		top.getPre().setNext(null);
		top = top.getPre();
		return s;
	}
	
	//����
	public void list() {
		if(isEmpty()) {
			System.out.println("ջ�գ�û������");
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

//�ڵ���
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