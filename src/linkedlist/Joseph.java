package linkedlist;

public class Joseph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(5);
//		circleSingleLinkedList.showBoy();
		circleSingleLinkedList.countBoy(1, 2, 5);
	}

}

//����һ�����εĵ�������
class CircleSingleLinkedList{
	private Boy first = null;  //����һ��first�ڵ㣬��ǰû�б��
	
	//���С���ڵ㣬����һ����������
	public void addBoy(int nums) {
		//numsУ��
		if(nums < 1) {
			System.out.println("nums��ֵ����ȷ");
			return;
		}
		
		Boy curBoy = null;  //����ָ�룬����������������
		
		//ʹ��ѭ������������
		for(int i=1; i<=nums; i++) {
			//���ݱ�ţ�����С���ڵ�
			Boy boy = new Boy(i);
			//����ǵ�һ��С��
			if(i==1) {
				first = boy;
				first.setNext(first);   //���ɻ�
				curBoy = first;   //��curBoyָ���һ��С��
			}else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
				
			}
		}
	}
	
	//������ǰ�Ļ�������
	public void showBoy() {
		//�ж������Ƿ�Ϊ��
		if(first == null) {
			System.out.println("û���κ�С��");
			return;
		}
		
		Boy curBoy = first;
		while(true) {
			System.out.printf("С���ı��%d\n",curBoy.getNo());
			if(curBoy.getNext() == first) {
				break;
			}
			curBoy = curBoy.getNext();
		}
	}
	
	
	//С����Ȧ
	/**
	 * 
	 * @param startNo    ��ʾ�ӵڼ���С����ʼ����
	 * @param countNum   ��ʾ������
	 * @param nums       ��ʾ����ж���С����Ȧ��
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		//����У��
		if(first==null || startNo<1 || startNo>nums) {
			System.out.println("����������������������");
			return;
		}
		
		Boy helper = first; //����ָ�룬һ��ʼָ������������һ���ڵ�
		while(true) {
			if(helper.getNext()==first) {  //˵��helperָ�����һ���ڵ�
				break;
			}
			helper = helper.getNext();
		}
		
		//С������ǰ����first��helperָ��ͬʱ�ƶ�
		while(true) {
			if(helper == first) {   //˵��������ֻ��һ���ڵ�
				break;
			}
			//��first��helperͬʱ�ƶ�countNum-1
			for(int j=0; j<countNum-1; j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			//��ʱfirstָ��Ľڵ����Ҫ��Ȧ��С���Ľڵ�
			System.out.printf("С��%d��Ȧ\n",first.getNo());
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("�������Ȧ�е�С�����%d",first.getNo());
		
	}
	
	
	
}



//����һ��Boy�࣬��ʾһ���ڵ�
class Boy{
	private int no;   //���
	private Boy next; //ָ����һ���ڵ㣬Ĭ��Ϊnull
	
	public Boy(int no) {
		this.no = no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public Boy getNext() {
		return next;
	}

	public void setNext(Boy next) {
		this.next = next;
	}
}