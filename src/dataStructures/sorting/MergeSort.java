package dataStructures.sorting;

// Time Complexity: O(n * logn)
// Auxiliary Space: O(n)

public class MergeSort {

	public void merge(int[] arr, int low, int mid, int high) {
	
		int n1 = mid - low + 1;
		int n2 = high - mid;
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for (int i = 0; i < n1; i++)
			L[i] = arr[low + i];
		
		for (int i = 0; i < n2; i++)
			R[i] = arr[mid + i + 1];
		
		int i = 0;
		int j = 0;
		int k = low;
		
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) 
				arr[k++] = L[i++];
			else 
				arr[k++] = R[j++];
		}
		
		while (i < n1) 
			arr[k++] = L[i++];
		
		while (j < n2) 
			arr[k++] = R[j++];
	}
	
	public void sort(int[] arr, int low, int high) {
		if (low < high) {
			int m = low + (high - low) / 2;
			sort(arr, low, m);
			sort(arr, m + 1, high);
			merge(arr, low, m, high);
		}
	}
	
	public void print(int[] arr, int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}