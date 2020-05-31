package linkedlist;

import java.util.Stack;
public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建节点
		HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
		HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
		HeroNode hero3 = new HeroNode(3,"吴用","智多星");
		HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
		HeroNode hero5 = new HeroNode(5,"武松","行者");
		HeroNode hero6 = new HeroNode(6,"鲁智深","花和尚");
	
		
		
		
		//创建链表
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		SingleLinkedList singleLinkedList2 = new SingleLinkedList();
		
		//添加
//		singleLinkedList.add(hero1);
//		singleLinkedList.add(hero4);
//		singleLinkedList.add(hero2);
//		singleLinkedList.add(hero3);
		
		//添加，按照编号的顺序
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero6);
		singleLinkedList.addByOrder(hero1);
		
		singleLinkedList2.addByOrder(hero3);
		singleLinkedList2.addByOrder(hero5);
		singleLinkedList2.addByOrder(hero2);
		
//		System.out.println("反转前");
		System.out.println("链表1");
		singleLinkedList.list();
		
		System.out.println("链表2");
		singleLinkedList2.list();
		
		SingleLinkedList singleLinkedList3 = combine(singleLinkedList,singleLinkedList2);
		System.out.println("合并后的链表");
		singleLinkedList3.list();
		
		
//		System.out.println("逆序打印");
//		reversePrint(singleLinkedList.getHead());
//		reverseList(singleLinkedList.getHead());
//		System.out.println("反转后");
//		singleLinkedList.list();
		
		//修改
//		HeroNode newHero = new HeroNode(2,"小卢","小麒麟");
//		singleLinkedList.update(newHero);
				
//		System.out.println("修改后：");
//		singleLinkedList.list();
		
//		System.out.println(findLastIndexNode(singleLinkedList.getHead(), 2));
//		System.out.println(findLastIndexNode(singleLinkedList.getHead(), 3));
		
//		System.out.println(getLength(singleLinkedList.getHead()));

		//删除
//		singleLinkedList.delete(1);
//		singleLinkedList.delete(4);
//		System.out.println("删除后：");
//		singleLinkedList.list();
		
//		System.out.println(getLength(singleLinkedList.getHead()));

	}
	
	
	
	//参数:单链表的头节点，返回值：有效节点的个数
	public static int getLength(HeroNode head) {
		int length = 0;
		HeroNode cur = head.next;
		while(cur != null) {
			length++;
			cur = cur.next;
		}
		return length;
	}
	
	//查找单链表中的倒数第k个节点，参数：头节点，倒数第index个节点
	public static HeroNode findLastIndexNode(HeroNode head,int index) {
		if(head.next == null) {
			return null;
		}
		
		int size = getLength(head);
		
		//做一个index校验
		if(index <= 0 || index > size) {
			return null;
		}
		
		HeroNode cur = head.next;
		for(int i=0; i<size-index; i++) {
			cur = cur.next;
		}
		return cur;
		
	}
	
	
	//反转单链表
	public static void reverseList(HeroNode head) {
		//如果当前链表为空，或者只有一个节点，无需反转，直接返回
		if(head.next == null || head.next.next == null) {
			return;
		}
		
		HeroNode cur = head.next;
		HeroNode next = null;   //指向当前节点cur的下一个节点
		HeroNode reverseHead = new HeroNode(0,"","");
		
		//遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表的最前端
		while(cur != null) {
			next = cur.next;
			cur.next = reverseHead.next;  //将cur的下一个节点指向新的链表的最前段
			reverseHead.next = cur;         //将cur连接到新的链表上
			cur = next;
		}
		
		//将head.next指向reverseHead.next，实现单链表的反转
		head.next = reverseHead.next;
	}
	
	
	//单链表逆序打印:利用栈的先进后出特点
	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			return; //空链表，不能打印
		}
		
		//创建一个栈
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		//将各个节点压入栈
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		
		//将栈中的节点取出打印
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
	
	
	//合并两个有序的单链表，合并后的单链表也是有序的
	//在第一个链表的基础上，遍历第二个链表，把第二个链表的每一个节点加入到第一个链表中，最后得到的就是有序的合并列表
	//最后返回新链表的头节点
	public static SingleLinkedList combine(SingleLinkedList singleLinkedList,SingleLinkedList singleLinkedList2) {
		HeroNode cur = singleLinkedList2.getHead().next; //获取第二个链表的头节点的下一个节点
		HeroNode next = null;
		while(cur != null) {
			next = cur.next;
			singleLinkedList.addByOrder(cur);
			cur = next;
		}
		return singleLinkedList;
	}
	
	
	
	
	
	
	
	
	
	

}


//定义HeroNode节点，每个HeroNode对象就是一个节点
class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;  //指向下一个节点
	
	//构造器
	public HeroNode(int no,String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	//重写toString方法
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}


//定义单链表类SingleLinkedList管理英雄
class SingleLinkedList{
	//先初始化一个头节点，头节点不要动，不存放具体数据
	private HeroNode head = new HeroNode(0,"","");
	
	public HeroNode getHead() {
		return head;
	}
	
	
	//添加节点到单链表，不考虑编号顺序，直接加在链表最后面
	public void add(HeroNode hero) {
		HeroNode temp = head;  // 辅助变量(指针)
		//遍历列表
		while(true){
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		
		//退出while循环时，temp就指向了链表的最后
		temp.next = hero;
	}
	
	public void addByOrder(HeroNode hero) {
		HeroNode temp = head;
		boolean flag = false;  //标记添加的编号是否存在，存在就变成ture
		
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no > hero.no) {
				break;
			}else if(temp.next.no == hero.no) {
				flag = true; //想要添加的编号已存在
				break;
			}
			temp = temp.next;
		}
		
		if(flag) {
			System.out.printf("准备添加的英雄的编号%d已存在，不能添加",hero.no);
		}else {
			hero.next = temp.next;
			temp.next = hero;
		}
		
	}
	
	
	//修改节点的信息，根据no编号来修改，即no编号不能改
	public void update(HeroNode newHero) {
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode temp = head.next;
		boolean flag = false;
		while(true) {
			if(temp == null) {
				break;
			}
			if(temp.no == newHero.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		
		if(flag) {
			temp.name = newHero.name;
			temp.nickname = newHero.nickname;
		}else {
			System.out.printf("没有找到编号%d的节点，不能修改",newHero.no);
		}
	}
	
	
	//删除节点
	public void delete(int no) {
		HeroNode temp = head;
		boolean flag = false;
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			temp.next = temp.next.next;
		}else {
			System.out.printf("要删除的%d节点不存在\n",no);
		}
	}
	
	//显示链表
	public void list() {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		
		HeroNode temp = head.next;
		while(true) {
			if(temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
		
	}
	
	
	
}
















