package sort;
//ð������
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = {3,9,-1,10,20};
		//����ð��������ٶȣ���80000�����ݲ���
		int arr[] = new int[80000];
		for(int i=0; i<80000; i++) {
			arr[i] = (int)(Math.random()*8000000);
		}
		
		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
		String datestr = sdf.format(date1);
		System.out.println("����ǰ��ʱ��:" + datestr);
		
//		System.out.println("����ǰ������:" + Arrays.toString(arr));
		bubbleSort(arr);
		
		Date date2 = new Date();
		String datestr2 = sdf.format(date2);
		System.out.println("������ʱ��:" + datestr2);

//		System.out.println("����������:" + Arrays.toString(arr));

	}
	
	
	//��ð�������㷨��װ��һ������
	public static void bubbleSort(int[] arr) {
		int temp = 0;  //��ʱ�������������ݽ���
		boolean flag = false;   //��ʶ��������ʶ�Ƿ���й������������Ż��㷨
		for(int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j]>arr[j+1]) {  //���ǰ������Ⱥ�һλ��
					flag = true;
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				
			}
			if(!flag) {  //��һ�������У�һ�ν�����û�з����������������е�Ԫ���Ѿ�ȫ������
				break;
			}else {
				flag = false;
			}
		}
	}

}
