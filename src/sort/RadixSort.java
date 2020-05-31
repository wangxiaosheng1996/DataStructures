package sort;

import java.util.Arrays;

//��������
public class RadixSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = { 101, 34, 119, 1, -1, 90, 123 };
//		System.out.println("����ǰ:" + Arrays.toString(arr));
//		radixSort(arr);
		System.out.println(-2%10);

	}

	public static void radixSort(int[] arr) {
		// ����Ҫ�����������������λ��
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int maxLength = (max + "").length(); // �õ��������λ��

		// ����һ����ά���飬��ʾ10��Ͱ��ÿ��Ͱ����һ��һά����
		// Ϊ�˷�ֹ���������ÿ��һά����ĳ�����Ϊarr.length
		// ���Կ����������������ÿռ任ʱ��ľ����㷨
		int[][] bucket = new int[10][arr.length];

		// ����һ��һά���飬����¼ÿ��Ͱ�д�ŵ����ݸ���
		int[] bucketElementCount = new int[10];

		// ��ѭ����ɽ����ݷ���Ͱ�в���Ͱ����ȡ�صĲ���
		for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
			// �ֱ��Ԫ�صĶ�Ӧλ���д����ֱ��Ǹ�λ��ʮλ����λ...
			// ���ն�Ӧλ�Ĵ�С�����Ӧ��Ͱ��
			for (int j = 0; j < arr.length; j++) {
				int digitOfElement = arr[j] / n % 10;
				bucket[digitOfElement][bucketElementCount[digitOfElement]] = arr[j];
				bucketElementCount[digitOfElement]++;
			}

			// ��Ͱ�е�Ԫ�ذ�˳��Ż�����
			// ����ÿһ��Ͱ
			int index = 0;
			for (int k = 0; k < bucketElementCount.length; k++) {
				// ���Ͱ�������ݣ��ͷŻ�ԭ����
				if (bucketElementCount[k] != 0) {
					// ѭ��ȡ����Ͱ�е�����
					for (int l = 0; l < bucketElementCount[k]; l++) {
						arr[index++] = bucket[k][l];
					}
					// ȡ�����ݺ󣬽�bucketElementCount��Ӧλ��0
					bucketElementCount[k] = 0;
				}
			}
			System.out.println("��" + (i + 1) + "��:" + Arrays.toString(arr));
		}

	}

}
