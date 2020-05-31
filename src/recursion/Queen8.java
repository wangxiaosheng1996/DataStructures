package recursion;

public class Queen8 {

	// 定义总共有多少个皇后
	int max = 8;

	// 定义数组，保存每一行皇后摆放的列数
	int[] arr = new int[max];

	static int count = 0; // 记录总共有多少种解法
	static int judgeCount = 0; // 记录判断了多少次

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queen8 queen8 = new Queen8();
		queen8.check(0);
		System.out.println("一共有解法:" + count);
		System.out.println("判断的总次数:" + judgeCount);

	}

	/**
	 * 
	 * @param n:摆放第n个皇后，从0开始摆放
	 */
	private void check(int n) {
		if (n == max) { // 结束条件，当n=8时表示0-7皇后已经全部摆放好
			print();
			return;
		}
		// 对于每个皇后，都可以从第0列摆放到第7列
		for (int i = 0; i < max; i++) {
			arr[n] = i;
			if (judge(n)) { // 该皇后摆放正确
				check(n + 1); // 接着放第n+1个皇后

			}
			// 如果冲突，就把当前皇后摆放在当前行的下一列
		}

	}

	private boolean judge(int n) {
		judgeCount++;
		for (int i = 0; i < n; i++) { // 第n个皇后要与前面n-1个比较
			// 在同一列或不在同一斜线上，表示冲突，返回false
			if (arr[i] == arr[n] || (n - i) == Math.abs(arr[n] - arr[i])) {
				return false;
			}
		}
		return true;
	}

	// 将皇后摆放的位置输出
	private void print() {
		count++;
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
