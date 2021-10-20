package algos.sorting;

import java.util.Arrays;

public class Merge {

	public static void main(String[] args) {
		int[] arr = { 4, 6, 11, 0, 7, 9, -1, 3 };
		mergeSort(arr, 0, 7);
		System.out.println(Arrays.toString(arr));
	}

	static void mergeSort(int[] a, int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(a, l, mid); // breaking down till it has one element (which is sorted anyway)
			mergeSort(a, mid + 1, r);
			merge(a, l, mid, r); // assuming left and right part are sorted
		}

	}

	static void merge(int[] a, int l, int mid, int r) {

		int i = l;
		int j = mid + 1;
		int k = l;
		int[] b = new int[a.length];

		while (i <= mid && j <= r) {
			if (a[i] < a[j]) {
				b[k] = a[i];
				i++;
			} else {
				b[k] = a[j];
				j++;
			}
			k++;
		}

		if (i > mid) {
			while (j <= r) {
				b[k] = a[j];
				k++;
				j++;
			}
		} else {
			while (i <= mid) {
				b[k] = a[i];
				k++;
				i++;
			}
		}

		for (int m = l; m <= r; m++) {
			a[m] = b[m];
		}
	}
}
