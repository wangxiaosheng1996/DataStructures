package linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建双向链表的节点
		HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
		HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
		HeroNode2 hero3 = new HeroNode2(3,"吴用","智多星");
		HeroNode2 hero4 = new HeroNode2(4,"林冲","豹子头");
		//创建双向链表
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.addByOrder(hero2);
		doubleLinkedList.addByOrder(hero4);
		doubleLinkedList.addByOrder(hero1);
		doubleLinkedList.addByOrder(hero3);
		
		doubleLinkedList.list();
		
		//修改
		HeroNode2 newHero = new HeroNode2(3,"武松","行者");
		doubleLinkedList.update(newHero);
		System.out.println("修改后");
		doubleLinkedList.list();
		
		//删除
		doubleLinkedList.delete(4);
		System.out.println("删除后");
		doubleLinkedList.list();
		

	}

}


//定义双向链表类DoubleLinkedList管理英雄
class DoubleLinkedList{
	//先初始化一个头节点，头节点不要动，不存放具体数据
	private HeroNode2 head = new HeroNode2(0,"","");
	
	public HeroNode2 getHead() {
		return head;
	}
	
	
	//添加节点到双向链表，不考虑编号顺序，直接加在链表最后面
	public void add(HeroNode2 hero) {
		HeroNode2 temp = head;  // 辅助变量(指针)
		//遍历列表
		while(true){
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		
		//退出while循环时，temp就指向了链表的最后
		temp.next = hero;
		hero.pre = temp;
	}
	
	//添加节点到双向链表，考虑编号顺序
	public void addByOrder(HeroNode2 hero) {
		HeroNode2 temp = head;
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
			if(temp.next != null) {	
				temp.next.pre = hero;
			}
			hero.next = temp.next;
			hero.pre = temp;
			temp.next = hero;
		}
		
	}
	
	
	
	//修改节点的信息，根据no编号来修改，即no编号不能改
	public void update(HeroNode2 newHero) {
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		HeroNode2 temp = head.next;
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
	
	
	//删除节点,双向链表可以自我删除
	public void delete(int no) {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空，无法删除");
			return;
		}		
		HeroNode2 temp = head.next;
		boolean flag = false;
		while(true) {
			if(temp == null) {
				break;
			}
			if(temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {  //找到
			temp.pre.next = temp.next;
			//如果要删除的是最后一个节点，就不需要执行下面这句话，否则会出现空指针异常
			if(temp.next != null) {
				temp.next.pre = temp.pre;
			}
		}else {
			System.out.printf("要删除的%d节点不存在\n",no);
		}
	}
	
	//显示链表,遍历
	public void list() {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空");
			return;
		}
		
		HeroNode2 temp = head.next;
		while(true) {
			if(temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
		
	}
	
	
	
}




//定义HeroNode节点，每个HeroNode对象就是一个节点
class HeroNode2{
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;  //指向下一个节点
	public HeroNode2 pre;   //指向前一个节点
	
	//构造器
	public HeroNode2(int no,String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	//重写toString方法
	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}