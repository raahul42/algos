package algos.sorting;

import java.util.Arrays;

public class Selection {

	public static void main(String[] args) {
		int[] arr = { 2, 7, 4, 11, 5, 6 };
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));

	}

	static void selectionSort(int[] a) {

		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i; j < n; j++) {
				if (a[min] > a[j]) {
					min = j;
				}
			}
			swap(a, i, min); // select the minimum from unsorted part and replace it with the first element
								// of the unsorted part
		}
	}

	static void swap(int[] a, int m, int n) {
		int temp = a[m];
		a[m] = a[n];
		a[n] = temp;
	}
}
