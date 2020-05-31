package linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����˫������Ľڵ�
		HeroNode2 hero1 = new HeroNode2(1,"�ν�","��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2,"¬����","������");
		HeroNode2 hero3 = new HeroNode2(3,"����","�Ƕ���");
		HeroNode2 hero4 = new HeroNode2(4,"�ֳ�","����ͷ");
		//����˫������
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.addByOrder(hero2);
		doubleLinkedList.addByOrder(hero4);
		doubleLinkedList.addByOrder(hero1);
		doubleLinkedList.addByOrder(hero3);
		
		doubleLinkedList.list();
		
		//�޸�
		HeroNode2 newHero = new HeroNode2(3,"����","����");
		doubleLinkedList.update(newHero);
		System.out.println("�޸ĺ�");
		doubleLinkedList.list();
		
		//ɾ��
		doubleLinkedList.delete(4);
		System.out.println("ɾ����");
		doubleLinkedList.list();
		

	}

}


//����˫��������DoubleLinkedList����Ӣ��
class DoubleLinkedList{
	//�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻Ҫ��������ž�������
	private HeroNode2 head = new HeroNode2(0,"","");
	
	public HeroNode2 getHead() {
		return head;
	}
	
	
	//��ӽڵ㵽˫�����������Ǳ��˳��ֱ�Ӽ������������
	public void add(HeroNode2 hero) {
		HeroNode2 temp = head;  // ��������(ָ��)
		//�����б�
		while(true){
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		
		//�˳�whileѭ��ʱ��temp��ָ������������
		temp.next = hero;
		hero.pre = temp;
	}
	
	//��ӽڵ㵽˫���������Ǳ��˳��
	public void addByOrder(HeroNode2 hero) {
		HeroNode2 temp = head;
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
			if(temp.next != null) {	
				temp.next.pre = hero;
			}
			hero.next = temp.next;
			hero.pre = temp;
			temp.next = hero;
		}
		
	}
	
	
	
	//�޸Ľڵ����Ϣ������no������޸ģ���no��Ų��ܸ�
	public void update(HeroNode2 newHero) {
		if(head.next == null) {
			System.out.println("����Ϊ��");
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
			System.out.printf("û���ҵ����%d�Ľڵ㣬�����޸�",newHero.no);
		}
	}
	
	
	//ɾ���ڵ�,˫�������������ɾ��
	public void delete(int no) {
		//�ж������Ƿ�Ϊ��
		if(head.next == null) {
			System.out.println("����Ϊ�գ��޷�ɾ��");
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
		if(flag) {  //�ҵ�
			temp.pre.next = temp.next;
			//���Ҫɾ���������һ���ڵ㣬�Ͳ���Ҫִ��������仰���������ֿ�ָ���쳣
			if(temp.next != null) {
				temp.next.pre = temp.pre;
			}
		}else {
			System.out.printf("Ҫɾ����%d�ڵ㲻����\n",no);
		}
	}
	
	//��ʾ����,����
	public void list() {
		//�ж������Ƿ�Ϊ��
		if(head.next == null) {
			System.out.println("����Ϊ��");
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




//����HeroNode�ڵ㣬ÿ��HeroNode�������һ���ڵ�
class HeroNode2{
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;  //ָ����һ���ڵ�
	public HeroNode2 pre;   //ָ��ǰһ���ڵ�
	
	//������
	public HeroNode2(int no,String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	//��дtoString����
	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}