package dataStructures.sorting;

// Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of input.
// Auxiliary Space: O(n+k)

public class CountingSort {

	public void sort(int[] arr, int n) {
		
		int[] output = new int[n];
		int[] count = new int[1000];
		
		for (int i = 0; i < 1000; i++)
			count[i] = 0;
		
		for (int i = 0; i < n; i++)
			count[arr[i]]++;
		
		for (int i = 1; i < 1000; i++)
			count[i] += count[i-1];
	
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