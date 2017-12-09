package algorithms;

import algorithms.search.BinarySearch;

public class MainSearch {

	public static void main(String[] args) {

		int[] arr = {1, 2, 3, 3, 3, 3, 67, 78, 99};
		int x = 3;
		int ans = BinarySearch.binarySearch(arr, x);
		int first = BinarySearch.firstOccurence(arr, x);
		int last = BinarySearch.lastOccurence(arr, x);
		int occurs = BinarySearch.countOccurences(arr, x);
		
		System.out.println(ans);
		System.out.println("First occurence: " + first);
		System.out.println("Last occurence: " + last);
		System.out.println("Count occurences: " + occurs);
	}
}