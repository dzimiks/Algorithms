package algorithms.sorting;

// Time Complexity: O(n * logn)
// Auxiliary Space: O(n)

public class QuickSort {

	public int partition(int[] arr, int low, int high) {
		
		int pivot = arr[high];
		int index = low - 1;
		
		for (int i = low; i < high; i++) {
			if (arr[i] <= pivot) {
				index++;
				int tmp = arr[index];
				arr[index] = arr[i];
				arr[i] = tmp;
			}
		}
		
		int tmp = arr[index + 1];
		arr[index + 1] = arr[high];
		arr[high] = tmp;
		
		return index + 1;
	}
	
	public void sort(int[] arr, int low, int high) {
		
		if (low < high) {
			int partitionIndex = partition(arr, low, high);
			sort(arr, low, partitionIndex - 1);
			sort(arr, partitionIndex + 1, high);
		}
	}
	
	public void print(int[] arr, int n) {
		
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}