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
		System.out.println("排序前的时间:" + datestr);

		
		shellSort1(arr);//交换法(未优化)
//		shellSort11(arr); //交换法(优化)
//		shellSort2(arr);  //移位法
		Date date2 = new Date();
		String datestr2 = sdf.format(date2);
		System.out.println("排序后的时间:" + datestr2);
		

	}
	
	//第一种希尔排序，用交换法
	public static void shellSort1(int[] arr) {
		int temp = 0;
		int count = 0;
		//使增量gap逐渐减小,gap初始化为arr.length/2
		for(int gap = arr.length/2; gap>0; gap/=2) {
			//因为从0到gap-1分别属于不同的组，总共有gap个组，因此从第gap个元素开始插入
			for(int i=gap; i<arr.length; i++) { 
				for(int j=i-gap; j>=0; j-=gap) {
					if(arr[j]>arr[j+gap]) {
						temp = arr[j];
						arr[j] = arr[j+gap];
						arr[j+gap] = temp;
					}
				}
			}
//			System.out.println("希尔排序第" + (++count) + "轮:" + Arrays.toString(arr));
		}
	}
	
	//对交换法进行优化
	public static void shellSort11(int[] arr) {
		int temp = 0;
		int count = 0;
		//使增量gap逐渐减小,gap初始化为arr.length/2
		for(int gap = arr.length/2; gap>0; gap/=2) {
			//因为从0到gap-1分别属于不同的组，总共有gap个组，因此从第gap个元素开始插入
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
//			System.out.println("希尔排序第" + (++count) + "轮:" + Arrays.toString(arr));
		}
	}
	
	//第二种希尔排序，用移位法
	public static void shellSort2(int[] arr) {
		int insertIndex = 0;
		int insertVal = 0;
		int count = 0;
		//使增量gap逐渐减小,gap初始化为arr.length/2
		for(int gap = arr.length/2; gap>0; gap/=2) {
			//因为从0到gap-1分别属于不同的组，总共有gap个组，因此从第gap个元素开始插入,使用直接插入排序
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
//			System.out.println("希尔排序第" + (++count) + "轮:" + Arrays.toString(arr));
		}
	}

}
