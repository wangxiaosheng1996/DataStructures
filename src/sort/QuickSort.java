package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int[] arr = {101,34,119,1,-1,90,123};
		System.out.println("排序前:" + Arrays.toString(arr));
		quickSort(arr,0,arr.length-1);
		System.out.println("排序后:" + Arrays.toString(arr));
		*/
		int arr[] = new int[800000];
		for(int i=0; i<800000; i++) {
			arr[i] = (int)(Math.random()*800000000);
		}
		
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
		String datestr = sdf.format(date1);
		System.out.println("排序前的时间:" + datestr);

		quickSort(arr,0,arr.length-1);
		
		Date date2 = new Date();
		String datestr2 = sdf.format(date2);
		System.out.println("排序后的时间:" + datestr2);

	}
	
	public static void quickSort(int[] s,int l,int r) {
		if(l<r) {   //先判断，左下标必须小于右下标
			//这里的基准数是最左边的数
			//如果要以中间的数为基准数，只需要下面一步，把中间的数和第一个数交换
//			int temp = s[l];
//			s[l] = s[(l+r)/2];
//			s[(l+r)/2] = temp;
			
			int i = l,j = r, x= s[l];    //基准数保存到变量x中
			while(i<j) {   //在while循环里分别从左向右和从右向左遍历
				while(i<j && s[j]>=x) {  // 从右向左找第一个小于x的数
					j--;
				}
				if(i<j) {
					s[i++] = s[j];
				}
				while(i<j && s[i]<x) {  // 从左向右找第一个大于等于x的数
					i++;
				}
				if(i<j) {
					s[j--] = s[i];
				}
				//等于基准数的数据放在右边
			}
			s[i] = x;  //退出while后将一开始保存到x中的基准数赋值给s[i],此时i==j
			quickSort(s,l,i-1);
			quickSort(s,i+1,r);
		}
	}

}
