package recursion;

public class Maze {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//用一个数组来表示迷宫,1表示墙或挡板,0表示还未走过
		int[][] map = new int[8][7];
		//上下全部置为1
		for(int i=0; i<7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		
		//左右全部置为1
		for(int i=0; i<8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		
		//设置挡板
		map[3][1] = 1;
		map[3][2] = 1;
		map[5][3] = 1;
		
		//输出地图
		System.out.println("地图情况");
		for(int i=0; i<8; i++) {
			for(int j=0; j<7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
		setWay(map,1,1);
		
		//重新输出地图
		System.out.println("小球走过后的地图");
		for(int i=0; i<8; i++) {
			for(int j=0; j<7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	public static boolean setWay(int[][] map,int i,int j) {
		if(i==6 && j==5) { //通路已经找到
			map[i][j] = 2;
			return true;
		}else {
			if(map[i][j] == 0) {//当前这个点还没有走过
				//按照策略  下-右-上-左
				map[i][j] = 2;
				if(setWay(map,i+1,j)) { //向下走
					return true;
				}else if(setWay(map,i,j+1)) { //向右走
					return true;
				}else if(setWay(map,i-1,j)) { //向上走
					return true;
				}else if(setWay(map,i,j-1)) { //向左走
					return true;
				}else {  //说明该点往哪个方向走都走不通，死路，置为3
					map[i][j] = 3;
					return false;
				}
			}else {   //map[i][j] != 0,可能为1，2，3
				return false;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	

}
