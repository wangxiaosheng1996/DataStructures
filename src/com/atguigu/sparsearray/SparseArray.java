package com.atguigu.sparsearray;

import java.io.*;
public class SparseArray {
	
	public static void main(String[] args) {
		//����һ��ԭʼ�Ķ�ά���� 11*11
		//0:��ʾû������  1����ʾ����  2����ʾ����
		int chessArr[][] = new int[11][11];
		chessArr[1][2] = 1;
		chessArr[2][3] = 2;
		chessArr[4][5] = 2;
		
		//���ԭʼ�Ķ�ά����
		System.out.println("ԭʼ�Ķ�ά����");
		for(int[] row : chessArr) {
			for(int data : row) {
				System.out.printf("%d\t",data);
			}
			System.out.println();
		}
		
		//����ά����ת��ϡ������
		//1���ȱ�����ά���飬�õ���0���ݵĸ���
		int sum = 0;
		for(int i=0; i<11; i++) {
			for(int j=0; j<11; j++) {
				if(chessArr[i][j] != 0) {
					sum++;
				}
			}
		}
		
		//2.������Ӧ��ϡ������
		int sparseArr[][] = new int[sum+1][3];
		//��ϡ�����鸳ֵ
		sparseArr[0][0] = 11;
		sparseArr[0][1] = 11;
		sparseArr[0][2] = sum;
		//������ά���飬����0��ֵ��ŵ�sparseArr��
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

		
		//���ϡ������
		System.out.println();
		System.out.println("�õ���ϡ������Ϊ");
		for(int i=0; i<sparseArr.length; i++) {
			for(int j=0; j<3; j++) {
				System.out.printf("%d\t",sparseArr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		
		//��ϡ�����鱣�浽�ļ��У��ļ���ΪsparseArr.data
		DataOutputStream dos= null;
		try {
			FileOutputStream fos = new FileOutputStream("D:\\���ݽṹ���㷨\\sparseArr.data");
			dos = new DataOutputStream(fos);
			for(int i=0; i<sparseArr.length; i++) {
				for(int j=0; j<3; j++) {
					dos.writeInt(sparseArr[i][j]);
				}
			}
		}catch(IOException e) {
			throw new RuntimeException("���鱣��ʧ��");
		}finally {
			try {
				dos.close();
			}catch(IOException e) {
				throw new RuntimeException("������ر�ʧ��");
			}
			
		}
		
		//��ȡsparseArr.data�ļ��е����ݣ��ָ���ԭʼ��ά����
		DataInputStream dis = null;
		try {
			FileInputStream fis = new FileInputStream("D:\\���ݽṹ���㷨\\sparseArr.data");
			dis = new DataInputStream(fis);
			int chessArr2[][] = new int[dis.readInt()][dis.readInt()]; 
			int num = dis.readInt();  //��0Ԫ�صĸ���
			for(int i=0; i<num; i++) {
				chessArr2[dis.readInt()][dis.readInt()] = dis.readInt();
			}
			//����ָ���Ķ�ά����
			System.out.println();
			System.out.println("��Ӳ�ָ̻���Ķ�ά����");
			for(int[] row : chessArr2) {
				for(int data : row) {
					System.out.printf("%d\t", data);
				}
				System.out.println();
			}
		}catch(IOException e) {
			throw new RuntimeException("���鱣��ʧ��");
		}finally {
			try {
				dis.close();
			}catch(IOException e) {
				throw new RuntimeException("������ر�ʧ��");
			}
			
		}
		
		
/*		
		
		//��ϡ������ָ���ԭʼ�Ķ�ά����
		//1���ȶ�ȡϡ������ĵ�һ�У����ݵ�һ�е����ݣ�����ԭʼ�Ķ�ά����
		int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
		//2���ٶ�ȡϡ��������е����ݣ��ӵڶ��п�ʼ��������ֵ��ԭʼ�Ķ�ά����
		for(int i=1; i<sparseArr.length; i++) {
			chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
		}

*/	

		
	
		
		
	}

}
