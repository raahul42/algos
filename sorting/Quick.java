package algos.sorting;

import java.util.Arrays;

public class Quick {

	public static void main(String[] args) {
		int[] arr = { 4, 6, 11, 0, 17, 7, 9, -1, 3 };
		quickSort(arr, 0, 8);
		System.out.println(Arrays.toString(arr));

	}

	static void quickSort(int[] a, int l, int h) {
		if (l < h) {
			int pivot = partition(a, l, h);
			quickSort(a, l, pivot - 1);
			quickSort(a, pivot + 1, h);
		}
	}

	static int partition(int[] a, int l, int r) {

		int pivot = a[l];
		int i = l;
		int j = r;

		while (i < j) {

			while (a[i] <= pivot && i <= r - 1) {
				i++;
			}

			while (a[j] > pivot && j >= l + 1) {
				j--;
			}

			if (i < j) {
				swap(a, i, j);
			}
		}
		swap(a, l, j);
		return j;
	}

	static void swap(int[] a, int m, int n) {
		if (m >= 0 && n >= 0 && m < a.length && n < a.length) {
			int temp = a[m];
			a[m] = a[n];
			a[n] = temp;
		}
	}
}
