package dataStructures.sorting;

// Time Complexity: O(n^2)
// Auxiliary Space: O(1)

public class InsertionSort {

	public void sort(int[] arr, int n) {
		
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j--;
			}
			
			arr[j + 1] = key;
		}
		
		for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
	}
}