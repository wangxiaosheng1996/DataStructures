package linkedlist;

import java.util.Stack;
public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����ڵ�
		HeroNode hero1 = new HeroNode(1,"�ν�","��ʱ��");
		HeroNode hero2 = new HeroNode(2,"¬����","������");
		HeroNode hero3 = new HeroNode(3,"����","�Ƕ���");
		HeroNode hero4 = new HeroNode(4,"�ֳ�","����ͷ");
		HeroNode hero5 = new HeroNode(5,"����","����");
		HeroNode hero6 = new HeroNode(6,"³����","������");
	
		
		
		
		//��������
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		SingleLinkedList singleLinkedList2 = new SingleLinkedList();
		
		//���
//		singleLinkedList.add(hero1);
//		singleLinkedList.add(hero4);
//		singleLinkedList.add(hero2);
//		singleLinkedList.add(hero3);
		
		//��ӣ����ձ�ŵ�˳��
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero6);
		singleLinkedList.addByOrder(hero1);
		
		singleLinkedList2.addByOrder(hero3);
		singleLinkedList2.addByOrder(hero5);
		singleLinkedList2.addByOrder(hero2);
		
//		System.out.println("��תǰ");
		System.out.println("����1");
		singleLinkedList.list();
		
		System.out.println("����2");
		singleLinkedList2.list();
		
		SingleLinkedList singleLinkedList3 = combine(singleLinkedList,singleLinkedList2);
		System.out.println("�ϲ��������");
		singleLinkedList3.list();
		
		
//		System.out.println("�����ӡ");
//		reversePrint(singleLinkedList.getHead());
//		reverseList(singleLinkedList.getHead());
//		System.out.println("��ת��");
//		singleLinkedList.list();
		
		//�޸�
//		HeroNode newHero = new HeroNode(2,"С¬","С����");
//		singleLinkedList.update(newHero);
				
//		System.out.println("�޸ĺ�");
//		singleLinkedList.list();
		
//		System.out.println(findLastIndexNode(singleLinkedList.getHead(), 2));
//		System.out.println(findLastIndexNode(singleLinkedList.getHead(), 3));
		
//		System.out.println(getLength(singleLinkedList.getHead()));

		//ɾ��
//		singleLinkedList.delete(1);
//		singleLinkedList.delete(4);
//		System.out.println("ɾ����");
//		singleLinkedList.list();
		
//		System.out.println(getLength(singleLinkedList.getHead()));

	}
	
	
	
	//����:�������ͷ�ڵ㣬����ֵ����Ч�ڵ�ĸ���
	public static int getLength(HeroNode head) {
		int length = 0;
		HeroNode cur = head.next;
		while(cur != null) {
			length++;
			cur = cur.next;
		}
		return length;
	}
	
	//���ҵ������еĵ�����k���ڵ㣬������ͷ�ڵ㣬������index���ڵ�
	public static HeroNode findLastIndexNode(HeroNode head,int index) {
		if(head.next == null) {
			return null;
		}
		
		int size = getLength(head);
		
		//��һ��indexУ��
		if(index <= 0 || index > size) {
			return null;
		}
		
		HeroNode cur = head.next;
		for(int i=0; i<size-index; i++) {
			cur = cur.next;
		}
		return cur;
		
	}
	
	
	//��ת������
	public static void reverseList(HeroNode head) {
		//�����ǰ����Ϊ�գ�����ֻ��һ���ڵ㣬���跴ת��ֱ�ӷ���
		if(head.next == null || head.next.next == null) {
			return;
		}
		
		HeroNode cur = head.next;
		HeroNode next = null;   //ָ��ǰ�ڵ�cur����һ���ڵ�
		HeroNode reverseHead = new HeroNode(0,"","");
		
		//����ԭ��������ÿ����һ���ڵ㣬�ͽ���ȡ�����������µ��������ǰ��
		while(cur != null) {
			next = cur.next;
			cur.next = reverseHead.next;  //��cur����һ���ڵ�ָ���µ��������ǰ��
			reverseHead.next = cur;         //��cur���ӵ��µ�������
			cur = next;
		}
		
		//��head.nextָ��reverseHead.next��ʵ�ֵ�����ķ�ת
		head.next = reverseHead.next;
	}
	
	
	//�����������ӡ:����ջ���Ƚ�����ص�
	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			return; //���������ܴ�ӡ
		}
		
		//����һ��ջ
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		//�������ڵ�ѹ��ջ
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		
		//��ջ�еĽڵ�ȡ����ӡ
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
	
	
	//�ϲ���������ĵ������ϲ���ĵ�����Ҳ�������
	//�ڵ�һ������Ļ����ϣ������ڶ��������ѵڶ��������ÿһ���ڵ���뵽��һ�������У����õ��ľ�������ĺϲ��б�
	//��󷵻��������ͷ�ڵ�
	public static SingleLinkedList combine(SingleLinkedList singleLinkedList,SingleLinkedList singleLinkedList2) {
		HeroNode cur = singleLinkedList2.getHead().next; //��ȡ�ڶ��������ͷ�ڵ����һ���ڵ�
		HeroNode next = null;
		while(cur != null) {
			next = cur.next;
			singleLinkedList.addByOrder(cur);
			cur = next;
		}
		return singleLinkedList;
	}
	
	
	
	
	
	
	
	
	
	

}


//����HeroNode�ڵ㣬ÿ��HeroNode�������һ���ڵ�
class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;  //ָ����һ���ڵ�
	
	//������
	public HeroNode(int no,String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	//��дtoString����
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}


//���嵥������SingleLinkedList����Ӣ��
class SingleLinkedList{
	//�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻Ҫ��������ž�������
	private HeroNode head = new HeroNode(0,"","");
	
	public HeroNode getHead() {
		return head;
	}
	
	
	//��ӽڵ㵽�����������Ǳ��˳��ֱ�Ӽ������������
	public void add(HeroNode hero) {
		HeroNode temp = head;  // ��������(ָ��)
		//�����б�
		while(true){
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		
		//�˳�whileѭ��ʱ��temp��ָ������������
		temp.next = hero;
	}
	
	public void addByOrder(HeroNode hero) {
		HeroNode temp = head;
		boolean flag = false;  //�����ӵı���Ƿ���ڣ����ھͱ��ture
		
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no > hero.no) {
				break;
			}else if(temp.next.no == hero.no) {
				flag = true; //��Ҫ��ӵı���Ѵ���
				break;
			}
			temp = temp.next;
		}
		
		if(flag) {
			System.out.printf("׼����ӵ�Ӣ�۵ı��%d�Ѵ��ڣ��������",hero.no);
		}else {
			hero.next = temp.next;
			temp.next = hero;
		}
		
	}
	
	
	//�޸Ľڵ����Ϣ������no������޸ģ���no��Ų��ܸ�
	public void update(HeroNode newHero) {
		if(head.next == null) {
			System.out.println("����Ϊ��");
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
			System.out.printf("û���ҵ����%d�Ľڵ㣬�����޸�",newHero.no);
		}
	}
	
	
	//ɾ���ڵ�
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
			System.out.printf("Ҫɾ����%d�ڵ㲻����\n",no);
		}
	}
	
	//��ʾ����
	public void list() {
		//�ж������Ƿ�Ϊ��
		if(head.next == null) {
			System.out.println("����Ϊ��");
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
















