package sort;

import java.util.Arrays;

//基数排序
public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 101, 34, 119, 1, -1, 90, 123 };
//		System.out.println("排序前:" + Arrays.toString(arr));
//		radixSort(arr);
		System.out.println(-2%10);

	}

	public static void radixSort(int[] arr) {
		// 首先要获得数组中最大的数的位数
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int maxLength = (max + "").length(); // 得到最大数的位数

		// 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
		// 为了防止数据溢出，每个一维数组的长度设为arr.length
		// 可以看到，基数排序是用空间换时间的经典算法
		int[][] bucket = new int[10][arr.length];

		// 定义一个一维数组，来记录每个桶中存放的数据个数
		int[] bucketElementCount = new int[10];

		// 用循环完成将数据放入桶中并从桶中再取回的操作
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			// 分别对元素的对应位进行处理，分别是个位，十位，百位...
			// 按照对应位的大小放入对应的桶中
			for (int j = 0; j < arr.length; j++) {
				int digitOfElement = arr[j] / n % 10;
				bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
				bucketElementCount[digitOfElement]++;
			}

			// 把桶中的元素按顺序放回数组
			// 遍历每一个桶
			int index = 0;
			for (int k = 0; k < bucketElementCount.length; k++) {
				// 如果桶中有数据，就放回原数组
				if (bucketElementCount[k] != 0) {
					// 循环取出该桶中的数据
					for (int l = 0; l < bucketElementCount[k]; l++) {
						arr[index++] = bucket[k][l];
					}
					// 取出数据后，将bucketElementCount相应位置0
					bucketElementCount[k] = 0;
				}
			}
			System.out.println("第" + (i + 1) + "轮:" + Arrays.toString(arr));
		}

	}

}
