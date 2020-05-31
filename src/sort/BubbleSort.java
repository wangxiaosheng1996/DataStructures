package sort;
//冒泡排序
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = {3,9,-1,10,20};
		//测试冒泡排序的速度，给80000个数据测试
		int arr[] = new int[80000];
		for(int i=0; i<80000; i++) {
			arr[i] = (int)(Math.random()*8000000);
		}
		
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
		String datestr = sdf.format(date1);
		System.out.println("排序前的时间:" + datestr);
		
//		System.out.println("排序前的数组:" + Arrays.toString(arr));
		bubbleSort(arr);
		
		Date date2 = new Date();
		String datestr2 = sdf.format(date2);
		System.out.println("排序后的时间:" + datestr2);

//		System.out.println("排序后的数组:" + Arrays.toString(arr));

	}
	
	
	//将冒泡排序算法封装成一个方法
	public static void bubbleSort(int[] arr) {
		int temp = 0;  //临时变量，用于数据交换
		boolean flag = false;   //标识变量，标识是否进行过交换，用于优化算法
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {  //如果前面的数比后一位大
					flag = true;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				
			}
			if(!flag) {  //在一趟排序中，一次交换都没有发生过，表明数组中的元素已经全部有序
				break;
			}else {
				flag = false;
			}
		}
	}

}
