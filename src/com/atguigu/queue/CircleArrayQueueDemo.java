package com.atguigu.queue;

import java.util.Scanner;
public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleArray queue = new CircleArray(4);  //输入4，其队列有效数据最大是3
		char key = ' ';//接收用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		//输出一个菜单
		while(loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get):从队列取出数据");
			System.out.println("h(head):查看队列头的数据");
			key = scanner.next().charAt(0);  //接收一个字符
			switch(key) {
			case 's':
				queue.showQueue();
				break;
			
			case 'a':
				if(queue.isFull()) {
					System.out.println("队列已满，不能添加数据!");
					break;
				}
				try {
					System.out.println("请输入一个数");
					int value = scanner.nextInt();
					queue.addQueue(value);
				}catch(Exception e) {
					System.out.println("输入的不是整数！");
				}
				break;
				
			case 'g':
				try {
					int res = queue.getQueue();
					System.out.printf("取出的数据是:%d\n", res);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 'h':
				try {
					int res = queue.headQueue();
					System.out.printf("队列头的数据是:%d\n",res);
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
		System.out.println("程序退出~~");
	}

}


//使用数组模拟队列-编写一个ArrayQueue类
class CircleArray{
	private int maxSize;  //表示数组的最大容量
	private int front;    //队列头
	private int rear;     //队列尾的后一个
	private int[] arr;    //该数组用于存放数据，模拟队列，牺牲一个元素空间
	
	public CircleArray(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
		front = 0;   //指向队头
		rear = 0;    //指向队列尾的后一个位置
	}
	
	//判断队列是否满
	
	public boolean isFull() {
		return (rear+1) % maxSize == front;
	}
	
	//判断队列是否为空
	public boolean isEmpty() {
		return rear == front;
	}
	
	//添加数据到队列
	public void addQueue(int n) {
		//判断队列是否已满
		if(isFull()) {
			System.out.println("队列满，不能添加数据");
			return;
		}
		arr[rear] = n;
		rear = (rear+1) % maxSize;
		
	}
	
	//获取队列的数据，出队列
	public int getQueue() {
		//判断队列是否为空
		if(isEmpty()) {
			throw new RuntimeException("队列为空，不能取数据");
		}
	
		int num = arr[front];
		front = (front+1) % maxSize;
		return num;
	}
	
	public void showQueue() {
		//遍历
		if(isEmpty()) {
			System.out.println("队列为空，没有数据");
			return;
		}
		
		for(int i=front; i<front+size(); i++) {
			System.out.printf("arr[%d] = %d\n",i%maxSize,arr[i%maxSize]);
		}
	
	}
	
	//显示队列的头数据，注意不是取出数据
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列为空，没有数据");
		}
		
		return arr[front];
	}
	
	//求出当前队列有效数据的个数
	public int size() {
		return (rear-front+maxSize)%maxSize;
	}
	
	
	
	
	
}