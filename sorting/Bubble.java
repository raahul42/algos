package algos.sorting;

import java.util.Arrays;

public class Bubble {

	public static void main(String[] args) {
		int[] arr = { 2, 7, -1, 9, 5, 6 };
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));

	}

	static void bubbleSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) { // outer loop for n-1 cycles
			boolean swapped = false;
			for (int j = 0; j < n - 1 - i; j++) { // inner loop comparing adjacent elements and taking the highest
													// element to the end
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					swapped = true;
				}
			}
			if (!swapped) // if nothing gets swapped, break from loop --> little optimising
				break;
		}
	}

	static void swap(int[] a, int m, int n) {

		int temp = a[m];
		a[m] = a[n];
		a[n] = temp;
	}
}
