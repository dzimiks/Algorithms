package algorithms.sorting;

// Time Complexity: O(n^2)
// Auxiliary Space: O(1)

public class SelectionSort {

	public void sort(int[] arr, int n) {
		
		for (int i = 0 ; i < n - 1; i++) {
			int minElementIndex = i;
			
			for (int j = i + 1; j < n; j++)
				if (arr[j] < arr[minElementIndex])
					minElementIndex = j;
			
			int tmp = arr[minElementIndex];
			arr[minElementIndex] = arr[i];
			arr[i] = tmp;
		}
		
		for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
	}
}
