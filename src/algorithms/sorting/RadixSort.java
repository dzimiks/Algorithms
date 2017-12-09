package algorithms.sorting;

import java.util.Arrays;

// Let there be d digits in input integers. 
// Radix Sort takes O(d * (n + b)) time where b is the base for representing numbers, 
// for example, for decimal system, b is 10. What is the value of d? If k is the maximum possible value, 
// then d would be O(logb(k)). So overall time complexity is O((n + b) * logb(k)).

public class RadixSort {

	public static int getMax(int[] arr, int n) {
		
		int max = arr[0];
		
		for (int i = 1; i < n; i++)
			if (arr[i] > max)
				max = arr[i];
		
		return max;
	}
	
	public static void countingSort(int[] arr, int n, int exp) {
		
		int[] output = new int[n];
		int[] count = new int[10];
		Arrays.fill(count, 0);
		
		for (int i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;
		
		for (int i = 1; i < 10; i++)
			count[i] += count[i - 1];
		
		for (int i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		
		for (int i = 0; i < n; i++)
			arr[i] = output[i];
	}
	
	public void sort(int[] arr, int n) {
		
		int m = getMax(arr, n);
		
		for (int exp = 1; m / exp > 0; exp *= 10) 
			countingSort(arr, n, exp);
		
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}