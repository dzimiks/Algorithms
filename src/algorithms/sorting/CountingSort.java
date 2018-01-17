package algorithms.sorting;

// Time Complexity: O(n + k) where n is the number of elements in input array and k is the range of input.
// Auxiliary Space: O(n + k)

public class CountingSort {

	public void sort(int[] arr, int k) {
		
		int n = arr.length;
		int[] output = new int[n];
		int[] count = new int[k];
		
		for (int i = 0; i < k; i++)
			count[i] = 0;
		
		for (int i = 0; i < n; i++)
			count[arr[i]]++;
		
		for (int i = 1; i < k; i++)
			count[i] += count[i - 1];
	
		for (int i = 0; i < n; i++) {
			output[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		
		for (int i = 0; i < n; i++)
			arr[i] = output[i];
		
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}