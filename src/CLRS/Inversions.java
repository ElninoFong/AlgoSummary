package CLRS;

import java.util.Arrays;

/* 2-4 Inversions
 * Definition: Let A[1..n] be an array of n distinct numbers. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A.
 * Give an algorithm that determins the number of inversions in any permutation on n elements in O(nlgn) worst-case time. 
 * (Hint: Modify merge sort).
 */

// http://www.ahathinking.com/archives/135.html
public class Inversions {
	int res;
	public void mergeSort(int[] arr, int l, int r) {
		if (l >= r) return;
		int m = (l + r) / 2;
		mergeSort(arr, l, m);
		mergeSort(arr, m + 1, r);
		merge(arr, l, m, r);
	}
	
	void merge(int[] arr, int l, int m, int r) {
		int i = l, j = m + 1, curr = 0;
		int[] tmp = new int[r - l + 1];
		while (i <= m && j <= r) {
			if (arr[i] <= arr[j]) {
				tmp[curr++] = arr[i++];
			} else {
				res += m - i + 1;		// key
				tmp[curr++] = arr[j++];
			}
		}
		while (i <= m) {
			tmp[curr++] = arr[i++];
		}
		while (j <= r) {
			tmp[curr++] = arr[j++];
		}
		// replace
		for (int k = l, c = 0; k <= r; k++, c++) {
			arr[k] = tmp[c];
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 8, 6, 1};
		Inversions inv = new Inversions();
		inv.mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		System.out.println(inv.res);
	}
}
