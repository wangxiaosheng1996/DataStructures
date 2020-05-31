package recursion;

public class Maze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��һ����������ʾ�Թ�,1��ʾǽ�򵲰�,0��ʾ��δ�߹�
		int[][] map = new int[8][7];
		//����ȫ����Ϊ1
		for(int i=0; i<7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		
		//����ȫ����Ϊ1
		for(int i=0; i<8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		
		//���õ���
		map[3][1] = 1;
		map[3][2] = 1;
		map[5][3] = 1;
		
		//�����ͼ
		System.out.println("��ͼ���");
		for(int i=0; i<8; i++) {
			for(int j=0; j<7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		setWay(map,1,1);
		
		//���������ͼ
		System.out.println("С���߹���ĵ�ͼ");
		for(int i=0; i<8; i++) {
			for(int j=0; j<7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	public static boolean setWay(int[][] map,int i,int j) {
		if(i==6 && j==5) { //ͨ·�Ѿ��ҵ�
			map[i][j] = 2;
			return true;
		}else {
			if(map[i][j] == 0) {//��ǰ����㻹û���߹�
				//���ղ���  ��-��-��-��
				map[i][j] = 2;
				if(setWay(map,i+1,j)) { //������
					return true;
				}else if(setWay(map,i,j+1)) { //������
					return true;
				}else if(setWay(map,i-1,j)) { //������
					return true;
				}else if(setWay(map,i,j-1)) { //������
					return true;
				}else {  //˵���õ����ĸ������߶��߲�ͨ����·����Ϊ3
					map[i][j] = 3;
					return false;
				}
			}else {   //map[i][j] != 0,����Ϊ1��2��3
				return false;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	

}
