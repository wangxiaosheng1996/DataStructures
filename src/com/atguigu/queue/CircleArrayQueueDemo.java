package com.atguigu.queue;

import java.util.Scanner;
public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleArray queue = new CircleArray(4);  //����4���������Ч���������3
		char key = ' ';//�����û�����
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		//���һ���˵�
		while(loop) {
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exit):�˳�����");
			System.out.println("a(add):������ݵ�����");
			System.out.println("g(get):�Ӷ���ȡ������");
			System.out.println("h(head):�鿴����ͷ������");
			key = scanner.next().charAt(0);  //����һ���ַ�
			switch(key) {
			case 's':
				queue.showQueue();
				break;
			
			case 'a':
				if(queue.isFull()) {
					System.out.println("���������������������!");
					break;
				}
				try {
					System.out.println("������һ����");
					int value = scanner.nextInt();
					queue.addQueue(value);
				}catch(Exception e) {
					System.out.println("����Ĳ���������");
				}
				break;
				
			case 'g':
				try {
					int res = queue.getQueue();
					System.out.printf("ȡ����������:%d\n", res);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 'h':
				try {
					int res = queue.headQueue();
					System.out.printf("����ͷ��������:%d\n",res);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 'e':
				scanner.close();
				loop = false;
				break;
				
			default:
				break;

			}
			
		}
		System.out.println("�����˳�~~");
	}

}


//ʹ������ģ�����-��дһ��ArrayQueue��
class CircleArray{
	private int maxSize;  //��ʾ������������
	private int front;    //����ͷ
	private int rear;     //����β�ĺ�һ��
	private int[] arr;    //���������ڴ�����ݣ�ģ����У�����һ��Ԫ�ؿռ�
	
	public CircleArray(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
		front = 0;   //ָ���ͷ
		rear = 0;    //ָ�����β�ĺ�һ��λ��
	}
	
	//�ж϶����Ƿ���
	
	public boolean isFull() {
		return (rear+1) % maxSize == front;
	}
	
	//�ж϶����Ƿ�Ϊ��
	public boolean isEmpty() {
		return rear == front;
	}
	
	//������ݵ�����
	public void addQueue(int n) {
		//�ж϶����Ƿ�����
		if(isFull()) {
			System.out.println("�������������������");
			return;
		}
		arr[rear] = n;
		rear = (rear+1) % maxSize;
		
	}
	
	//��ȡ���е����ݣ�������
	public int getQueue() {
		//�ж϶����Ƿ�Ϊ��
		if(isEmpty()) {
			throw new RuntimeException("����Ϊ�գ�����ȡ����");
		}
	
		int num = arr[front];
		front = (front+1) % maxSize;
		return num;
	}
	
	public void showQueue() {
		//����
		if(isEmpty()) {
			System.out.println("����Ϊ�գ�û������");
			return;
		}
		
		for(int i=front; i<front+size(); i++) {
			System.out.printf("arr[%d] = %d\n",i%maxSize,arr[i%maxSize]);
		}
	
	}
	
	//��ʾ���е�ͷ���ݣ�ע�ⲻ��ȡ������
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("����Ϊ�գ�û������");
		}
		
		return arr[front];
	}
	
	//�����ǰ������Ч���ݵĸ���
	public int size() {
		return (rear-front+maxSize)%maxSize;
	}
	
	
	
	
	
}