package algos;

public class ArrayStuff {

	public static void main(String[] args) {

		int[] a = { 2, 2, -5, 2, 4, 2, -2 };
		int[] b = { 0, 4, 2, 1, 3, 7 };

		System.out.println("most frequent element : " + maxFreq(a));
		System.out.println("max sum in sub arrays : " + maxSumSubArr(a));
		System.out.println("total possible profit : " + stockSellProf(b));
		System.out.println("max possible profit   : " + maxStockSellProf(b));
		System.out.println("rain water trapped is : " + rainWaterIn(b));

	}

	// boyer-moore voting algorithm
	static int maxFreq(int[] arr) { // element occuring more than n/2 times

		int ans_index = 0;
		int count = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[ans_index] == arr[i]) {
				count++;
			} else
				count--;

			if (count < 0) {
				ans_index = i;
				count = 1;
			}
		}
		return isFreq(arr, arr[ans_index]) ? arr[ans_index] : -1;
	}

	static boolean isFreq(int[] arr, int a) {

		int count = 0;
		for (int i : arr) {
			if (i == a)
				count++;
		}
		return (count > (arr.length / 2));
	}

	// Kadane's algorithm (imp)
	static int maxSumSubArr(int[] arr) { // max sum in possible sub arrays

		int max_sum = arr[0];
		int sum = arr[0];

		for (int i = 1; i < arr.length; i++) {

			sum += arr[i];
			if (sum > 0) {
				max_sum = Math.max(max_sum, sum);
			} else
				sum = 0;
		}
		return max_sum;
	}

	static int stockSellProf(int[] arr) { // total possible profits by buying and selling

		int prof = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] - arr[i - 1] > 0) {
				prof += arr[i] - arr[i - 1];
			}
		}
		return prof;
	}

	static int maxStockSellProf(int[] arr) { // max profit possible
		int max_profit = 0;
		int min_price = arr[0];

		for (int i = 1; i < arr.length; i++) {
			min_price = Math.min(arr[i], min_price);
			max_profit = Math.max(arr[i] - min_price, max_profit);
		}
		return max_profit;
	}

	static int rainWaterIn(int[] arr) { // try constant space complexity

		int n = arr.length;
		int[] fromLt = new int[n];
		int[] fromRt = new int[n];

		fromLt[0] = arr[0];
		fromRt[n - 1] = arr[n - 1];

		for (int i = 1; i < n; i++) {
			fromLt[i] = Math.max(fromLt[i - 1], arr[i]);
		}

		for (int i = n - 2; i >= 0; i--) {
			fromRt[i] = Math.max(fromRt[i + 1], arr[i]);
		}

		int level = 0;
		for (int i = 0; i < n; i++) {
			level += (Math.min(fromLt[i], fromRt[i]) - arr[i]);
		}
		return level;
	}
}
