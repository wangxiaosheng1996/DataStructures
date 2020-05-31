package sort;
//�鲢����
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int[] arr = {101,34,119,1,-1,90,123};
		int[] temp = new int[arr.length];
		System.out.println("����ǰ:" + Arrays.toString(arr));
		mergeSort(arr,0,arr.length-1,temp);
		System.out.println("�����:" + Arrays.toString(arr));
		*/
		
		int arr[] = new int[8000000];
		for(int i=0; i<8000000; i++) {
			arr[i] = (int)(Math.random()*800000000);
		}
		int[] temp = new int[arr.length];    //�鲢������Ҫһ������Ŀռ�
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
		String datestr = sdf.format(date1);
		System.out.println("����ǰ��ʱ��:" + datestr);

		mergeSort(arr,0,arr.length-1,temp);
		
		Date date2 = new Date();
		String datestr2 = sdf.format(date2);
		System.out.println("������ʱ��:" + datestr2);

	}
	
	
	//����˼��
	public static void mergeSort(int[] arr,int left,int right,int[] temp) {
		if(left<right) {
			int mid = (left+right)/2;
			//����ݹ���зֽ�
			mergeSort(arr,left,mid,temp);
			//���ҵݹ���зֽ�
			mergeSort(arr,mid+1,right,temp);
			//�ϲ�
			merge(arr,left,mid,right,temp);
			
		}
	}
	
	
	
	
	/**
	 * 
	 * @param arr     �����ԭʼ����
	 * @param left    ����������еĳ�ʼ����
	 * @param mid     �м�����������������е��������
	 * @param right   ����������е��������
	 * @param temp    ��ת����
	 */
	public static void merge(int[] arr,int left,int mid,int right,int[] temp) {
		int i = left;   //��ʼ��i,����������еĳ�ʼ����
		int j = mid+1;  //��ʼ��j,�ұ��������еĳ�ʼ����
		int t = 0;    //��ʼ��t��temp���������
		
		//1.�Ȱ��������ߵ��������ݰ��չ�����䵽temp������,ֱ����һ�ߵ����ݴ������
		while(i<=mid && j<=right) {  //�������ߵ����ݶ���û�г����߽�
			if(arr[i]<=arr[j]) {  //�����ߵ�����С�ڻ�����ұ�����,�����������䵽temp����,Ȼ���������+1
				temp[t++] = arr[i++];
			}else {
				temp[t++] = arr[j++];
			}
		}
		//�˳�whileѭ����˵����һ�����ݴ�����ϣ���Ҫ�ж����ı����ݴ�������
		//2.��ʣ�����ݵ��Ǳߵ�ʣ����������ȫ����䵽temp������
		while(i<=mid) {
			temp[t++] = arr[i++];
		}
		while(j<=right) {
			temp[t++] = arr[j++];
		}
		
		//3.��temp�����е����ݿ�����arr
		t = 0;
		int tempLeft = left;
		while(tempLeft<=right) {
			arr[tempLeft++] = temp[t++];
		}
		
	} 

}














