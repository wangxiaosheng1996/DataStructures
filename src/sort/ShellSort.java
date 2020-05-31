package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {8,9,1,7,2,3,5,4,6,0};
//		int[] arr = {101,34,119,1,-1,90,123};
//		shellSort2(arr);
		int arr[] = new int[8000000];
		for(int i=0; i<8000000; i++) {
			arr[i] = (int)(Math.random()*800000000);
		}
		
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
		String datestr = sdf.format(date1);
		System.out.println("����ǰ��ʱ��:" + datestr);

		
		shellSort1(arr);//������(δ�Ż�)
//		shellSort11(arr); //������(�Ż�)
//		shellSort2(arr);  //��λ��
		Date date2 = new Date();
		String datestr2 = sdf.format(date2);
		System.out.println("������ʱ��:" + datestr2);
		

	}
	
	//��һ��ϣ�������ý�����
	public static void shellSort1(int[] arr) {
		int temp = 0;
		int count = 0;
		//ʹ����gap�𽥼�С,gap��ʼ��Ϊarr.length/2
		for(int gap = arr.length/2; gap>0; gap/=2) {
			//��Ϊ��0��gap-1�ֱ����ڲ�ͬ���飬�ܹ���gap���飬��˴ӵ�gap��Ԫ�ؿ�ʼ����
			for(int i=gap; i<arr.length; i++) { 
				for(int j=i-gap; j>=0; j-=gap) {
					if(arr[j]>arr[j+gap]) {
						temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					}
				}
			}
//			System.out.println("ϣ�������" + (++count) + "��:" + Arrays.toString(arr));
		}
	}
	
	//�Խ����������Ż�
	public static void shellSort11(int[] arr) {
		int temp = 0;
		int count = 0;
		//ʹ����gap�𽥼�С,gap��ʼ��Ϊarr.length/2
		for(int gap = arr.length/2; gap>0; gap/=2) {
			//��Ϊ��0��gap-1�ֱ����ڲ�ͬ���飬�ܹ���gap���飬��˴ӵ�gap��Ԫ�ؿ�ʼ����
			for(int i=gap; i<arr.length; i++) { 
				for(int j=i-gap; j>=0; j-=gap) {
					if(arr[j]>arr[j+gap]) {
						temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					}else {
						break;
					}
				}
			}
//			System.out.println("ϣ�������" + (++count) + "��:" + Arrays.toString(arr));
		}
	}
	
	//�ڶ���ϣ����������λ��
	public static void shellSort2(int[] arr) {
		int insertIndex = 0;
		int insertVal = 0;
		int count = 0;
		//ʹ����gap�𽥼�С,gap��ʼ��Ϊarr.length/2
		for(int gap = arr.length/2; gap>0; gap/=2) {
			//��Ϊ��0��gap-1�ֱ����ڲ�ͬ���飬�ܹ���gap���飬��˴ӵ�gap��Ԫ�ؿ�ʼ����,ʹ��ֱ�Ӳ�������
			for(int i=gap; i<arr.length; i++) { 
				insertIndex = i-gap;
				insertVal = arr[i];
				while(insertIndex>=0 && arr[insertIndex]>insertVal) {
					arr[insertIndex+gap] = arr[insertIndex];
					insertIndex -= gap;
				}
				if(insertIndex+gap != i) {
					arr[insertIndex+gap] = insertVal;
				}

			}
//			System.out.println("ϣ�������" + (++count) + "��:" + Arrays.toString(arr));
		}
	}

}
