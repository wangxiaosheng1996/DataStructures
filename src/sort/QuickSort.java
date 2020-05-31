package sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int[] arr = {101,34,119,1,-1,90,123};
		System.out.println("����ǰ:" + Arrays.toString(arr));
		quickSort(arr,0,arr.length-1);
		System.out.println("�����:" + Arrays.toString(arr));
		*/
		int arr[] = new int[800000];
		for(int i=0; i<800000; i++) {
			arr[i] = (int)(Math.random()*800000000);
		}
		
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
		String datestr = sdf.format(date1);
		System.out.println("����ǰ��ʱ��:" + datestr);

		quickSort(arr,0,arr.length-1);
		
		Date date2 = new Date();
		String datestr2 = sdf.format(date2);
		System.out.println("������ʱ��:" + datestr2);

	}
	
	public static void quickSort(int[] s,int l,int r) {
		if(l<r) {   //���жϣ����±����С�����±�
			//����Ļ�׼��������ߵ���
			//���Ҫ���м����Ϊ��׼����ֻ��Ҫ����һ�������м�����͵�һ��������
//			int temp = s[l];
//			s[l] = s[(l+r)/2];
//			s[(l+r)/2] = temp;
			
			int i = l,j = r, x= s[l];    //��׼�����浽����x��
			while(i<j) {   //��whileѭ����ֱ�������Һʹ����������
				while(i<j && s[j]>=x) {  // ���������ҵ�һ��С��x����
					j--;
				}
				if(i<j) {
					s[i++] = s[j];
				}
				while(i<j && s[i]<x) {  // ���������ҵ�һ�����ڵ���x����
					i++;
				}
				if(i<j) {
					s[j--] = s[i];
				}
				//���ڻ�׼�������ݷ����ұ�
			}
			s[i] = x;  //�˳�while��һ��ʼ���浽x�еĻ�׼����ֵ��s[i],��ʱi==j
			quickSort(s,l,i-1);
			quickSort(s,i+1,r);
		}
	}

}
