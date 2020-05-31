package recursion;

public class Queen8 {

	// �����ܹ��ж��ٸ��ʺ�
	int max = 8;

	// �������飬����ÿһ�лʺ�ڷŵ�����
	int[] arr = new int[max];

	static int count = 0; // ��¼�ܹ��ж����ֽⷨ
	static int judgeCount = 0; // ��¼�ж��˶��ٴ�

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queen8 queen8 = new Queen8();
		queen8.check(0);
		System.out.println("һ���нⷨ:" + count);
		System.out.println("�жϵ��ܴ���:" + judgeCount);

	}

	/**
	 * 
	 * @param n:�ڷŵ�n���ʺ󣬴�0��ʼ�ڷ�
	 */
	private void check(int n) {
		if (n == max) { // ������������n=8ʱ��ʾ0-7�ʺ��Ѿ�ȫ���ڷź�
			print();
			return;
		}
		// ����ÿ���ʺ󣬶����Դӵ�0�аڷŵ���7��
		for (int i = 0; i < max; i++) {
			arr[n] = i;
			if (judge(n)) { // �ûʺ�ڷ���ȷ
				check(n + 1); // ���ŷŵ�n+1���ʺ�

			}
			// �����ͻ���Ͱѵ�ǰ�ʺ�ڷ��ڵ�ǰ�е���һ��
		}

	}

	private boolean judge(int n) {
		judgeCount++;
		for (int i = 0; i < n; i++) { // ��n���ʺ�Ҫ��ǰ��n-1���Ƚ�
			// ��ͬһ�л���ͬһб���ϣ���ʾ��ͻ������false
			if (arr[i] == arr[n] || (n - i) == Math.abs(arr[n] - arr[i])) {
				return false;
			}
		}
		return true;
	}

	// ���ʺ�ڷŵ�λ�����
	private void print() {
		count++;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
