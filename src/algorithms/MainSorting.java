package algorithms;

import algorithms.sorting.BubbleSort;
import algorithms.sorting.CountingSort;
import algorithms.sorting.HeapSort;
import algorithms.sorting.InsertionSort;
import algorithms.sorting.MergeSort;
import algorithms.sorting.QuickSort;
import algorithms.sorting.RadixSort;
import algorithms.sorting.SelectionSort;
import algorithms.sorting.ShellSort;

public class MainSorting {

	public static void main(String[] args) {

		int[] arr = {100, 23, 38, 7, 351, 14, 521, 33, 19, 56, 119, 48, 71, 137, 31, 12, 4, 515};
		int n = arr.length;
		
		// Ways of sorting
		CountingSort countingSort = new CountingSort();
		RadixSort radixSort = new RadixSort();
		SelectionSort selectionSort = new SelectionSort();
		BubbleSort bubbleSort = new BubbleSort();
		InsertionSort insertionSort = new InsertionSort();
		MergeSort mergeSort = new MergeSort();
		QuickSort quickSort = new QuickSort();
		HeapSort heapSort = new HeapSort();
		ShellSort shellSort = new ShellSort();
		
		// Examples
//		System.out.println("Counting sort:");
//		countingSort.sort(arr, n);
		
//		System.out.println("\nRadix sort:");
//		radixSort.sort(arr, n);
		
//		System.out.println("\nSelection sort:");
//		selectionSort.sort(arr, n);
		
//		System.out.println("\nBubble sort:");
//		bubbleSort.sort(arr, n);
		
//		System.out.println("\nInsertion sort:");
//		insertionSort.sort(arr, n);
		
		// TODO FIX
//		System.out.println("\nMerge sort:");
//		mergeSort.sort(arr, 0, n - 1);
		
//		System.out.println("\nQuick sort:");
//		quickSort.sort(arr, 0, n - 1);
//		quickSort.print(arr, n);
		
//		System.out.println("\nHeap sort:");
//		heapSort.sort(arr, n);
//		heapSort.print(arr, n);
		
		System.out.println("\nShell sort:");
		shellSort.sort(arr, n);
	}
}