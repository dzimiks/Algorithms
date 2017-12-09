package dataStructures.sorting;

// Time Complexity: O(n^2)

public class ShellSort {

	public void sort(int[] arr, int n) {
		
		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i++) {
				int tmp = arr[i];
				int j;
				
				for (j = i; j >= gap && arr[j - gap] > tmp; j -= gap)
					arr[j] = arr[j - gap];
				
				arr[j] = tmp;
			}
		}
		
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}