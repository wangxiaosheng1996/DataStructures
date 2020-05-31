package sort;
//插入排序
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int[] arr = {101,34,119,1,-1,90,123};
		System.out.println("排序前:" + Arrays.toString(arr));
		insertSort(arr);
		System.out.println("排序后:" + Arrays.toString(arr));
		*/
		int arr[] = new int[80000];
		for(int i=0; i<80000; i++) {
			arr[i] = (int)(Math.random()*8000000);
		}
		
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
		String datestr = sdf.format(date1);
		System.out.println("排序前的时间:" + datestr);

		
		insertSort(arr);
		
		Date date2 = new Date();
		String datestr2 = sdf.format(date2);
		System.out.println("排序后的时间:" + datestr2);

	}
	
	public static void insertSort(int[] arr) {
		int insertVal = 0;
		int insertIndex = 0;
		for(int i=1; i<arr.length; i++) {
			insertVal = arr[i];
			insertIndex = i-1;
			while(insertIndex>=0 && insertVal<arr[insertIndex]) {
				arr[insertIndex+1] = arr[insertIndex];
				insertIndex--;
			}
			//当退出while循环时，说明插入的位置找到，为insertIndex+1
			//判断是否需要插值，当insertIndex+1 == i时说明不需要插值
			if(insertIndex+1 != i) {
				arr[insertIndex+1] = insertVal;
			}
		}
	}

}
