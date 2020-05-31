package com.atguigu.sparsearray;

import java.io.*;
public class SparseArray {
	
	public static void main(String[] args) {
		//创建一个原始的二维数组 11*11
		//0:表示没有棋子  1：表示黑子  2：表示蓝子
		int chessArr[][] = new int[11][11];
		chessArr[1][2] = 1;
		chessArr[2][3] = 2;
		chessArr[4][5] = 2;
		
		//输出原始的二维数组
		System.out.println("原始的二维数组");
		for(int[] row : chessArr) {
			for(int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		//将二维数组转成稀疏数组
		//1、先遍历二维数组，得到非0数据的个数
		int sum = 0;
		for(int i=0; i<11; i++) {
			for(int j=0; j<11; j++) {
				if(chessArr[i][j] != 0) {
					sum++;
				}
			}
		}
		
		//2.创建对应的稀疏数组
		int sparseArr[][] = new int[sum+1][3];
		//给稀疏数组赋值
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		//遍历二维数组，将非0的值存放到sparseArr中
		int count = 0;
		for(int i=0; i<11; i++) {
			for(int j=0; j<11; j++) {
				if(chessArr[i][j] != 0) {
					count++;
					sparseArr[count][0] = i;
					sparseArr[count][1] = j;
					sparseArr[count][2] = chessArr[i][j];
					
				}
			}
		}

		
		//输出稀疏数组
		System.out.println();
		System.out.println("得到的稀疏数组为");
		for(int i=0; i<sparseArr.length; i++) {
			for(int j=0; j<3; j++) {
				System.out.printf("%d\t",sparseArr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		//将稀疏数组保存到文件中，文件名为sparseArr.data
		DataOutputStream dos= null;
		try {
			FileOutputStream fos = new FileOutputStream("D:\\数据结构与算法\\sparseArr.data");
			dos = new DataOutputStream(fos);
			for(int i=0; i<sparseArr.length; i++) {
				for(int j=0; j<3; j++) {
					dos.writeInt(sparseArr[i][j]);
				}
			}
		}catch(IOException e) {
			throw new RuntimeException("数组保存失败");
		}finally {
			try {
				dos.close();
			}catch(IOException e) {
				throw new RuntimeException("输出流关闭失败");
			}
			
		}
		
		//读取sparseArr.data文件中的数据，恢复成原始二维数组
		DataInputStream dis = null;
		try {
			FileInputStream fis = new FileInputStream("D:\\数据结构与算法\\sparseArr.data");
			dis = new DataInputStream(fis);
			int chessArr2[][] = new int[dis.readInt()][dis.readInt()]; 
			int num = dis.readInt();  //非0元素的个数
			for(int i=0; i<num; i++) {
				chessArr2[dis.readInt()][dis.readInt()] = dis.readInt();
			}
			//输出恢复后的二维数组
			System.out.println();
			System.out.println("从硬盘恢复后的二维数组");
			for(int[] row : chessArr2) {
				for(int data : row) {
					System.out.printf("%d\t", data);
				}
				System.out.println();
			}
		}catch(IOException e) {
			throw new RuntimeException("数组保存失败");
		}finally {
			try {
				dis.close();
			}catch(IOException e) {
				throw new RuntimeException("输出流关闭失败");
			}
			
		}
		
		
/*		
		
		//将稀疏数组恢复成原始的二维数组
		//1、先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		//2、再读取稀疏数组后几行的数据（从第二行开始），并赋值给原始的二维数组
		for(int i=1; i<sparseArr.length; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}

*/	

		
	
		
		
	}

}
