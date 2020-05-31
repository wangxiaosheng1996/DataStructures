package sort;
//选择排序
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {101,34,119,1,-1,90,123};
		
		int arr[] = new int[80000];
		for(int i=0; i<80000; i++) {
			arr[i] = (int)(Math.random()*8000000);
		}
		
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
		String datestr = sdf.format(date1);
		System.out.println("排序前的时间:" + datestr);
		
//		System.out.println("排序前:" + Arrays.toString(arr));
		selectSort(arr);
		
		Date date2 = new Date();
		String datestr2 = sdf.format(date2);
		System.out.println("排序后的时间:" + datestr2);
		
//		System.out.println("排序后:" + Arrays.toString(arr));
	}
	

	public static void selectSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			int minIndex = i;
			int min = arr[i];
			for(int j=i+1; j<arr.length; j++) {
				if(min>arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			if(minIndex != i) {
				arr[minIndex] = arr[i];
				arr[i] = min;
			}
		}
	}

}
