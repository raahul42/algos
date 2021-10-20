package algos.sorting;

import java.util.Arrays;

public class Insertion {

	public static void main(String[] args) {
		int[] arr = { 2, 7, 3, 9, 5, 6 };
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));

	}

	static void insertionSort(int[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			int temp = a[i];
			for (int j = i - 1; j >= 0; j--) { // insert the first element from unsorted part to the sorted part in
												// correct position
				if (temp < a[j])
					a[j + 1] = a[j];
				if (temp > a[j]) {
					a[j + 1] = temp;
					break;
				}
			}
		}
	}
}
