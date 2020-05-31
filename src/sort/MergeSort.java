package sort;
//归并排序
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int[] arr = {101,34,119,1,-1,90,123};
		int[] temp = new int[arr.length];
		System.out.println("排序前:" + Arrays.toString(arr));
		mergeSort(arr,0,arr.length-1,temp);
		System.out.println("排序后:" + Arrays.toString(arr));
		*/
		
		int arr[] = new int[8000000];
		for(int i=0; i<8000000; i++) {
			arr[i] = (int)(Math.random()*800000000);
		}
		int[] temp = new int[arr.length];    //归并排序需要一个额外的空间
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
		String datestr = sdf.format(date1);
		System.out.println("排序前的时间:" + datestr);

		mergeSort(arr,0,arr.length-1,temp);
		
		Date date2 = new Date();
		String datestr2 = sdf.format(date2);
		System.out.println("排序后的时间:" + datestr2);

	}
	
	
	//分治思想
	public static void mergeSort(int[] arr,int left,int right,int[] temp) {
		if(left<right) {
			int mid = (left+right)/2;
			//向左递归进行分解
			mergeSort(arr,left,mid,temp);
			//向右递归进行分解
			mergeSort(arr,mid+1,right,temp);
			//合并
			merge(arr,left,mid,right,temp);
			
		}
	}
	
	
	
	
	/**
	 * 
	 * @param arr     排序的原始数组
	 * @param left    左边有序序列的初始索引
	 * @param mid     中间索引，左边有序序列的最后索引
	 * @param right   左边有序序列的最后索引
	 * @param temp    中转数组
	 */
	public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
		int i = left;   //初始化i,左边有序序列的初始索引
		int j = mid+1;  //初始化j,右边有序序列的初始索引
		int t = 0;    //初始化t，temp数组的索引
		
		//1.先把左右两边的有序数据按照规则填充到temp数组中,直到有一边的数据处理完毕
		while(i<=mid && j<=right) {  //左右两边的数据都还没有超过边界
			if(arr[i]<=arr[j]) {  //如果左边的数据小于或等于右边数据,将左边数据填充到temp数组,然后左边索引+1
				temp[t++] = arr[i++];
			}else {
				temp[t++] = arr[j++];
			}
		}
		//退出while循环，说明有一边数据处理完毕，需要判断是哪边数据处理完了
		//2.把剩余数据的那边的剩余数据依次全部填充到temp数组中
		while(i<=mid) {
			temp[t++] = arr[i++];
		}
		while(j<=right) {
			temp[t++] = arr[j++];
		}
		
		//3.把temp数组中的数据拷贝到arr
		t = 0;
		int tempLeft = left;
		while(tempLeft<=right) {
			arr[tempLeft++] = temp[t++];
		}
		
	} 

}














