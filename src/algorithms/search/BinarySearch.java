package algorithms.search;

public class BinarySearch {

	public static int binarySearch(int[] arr, int x) {

		int n = arr.length;
		int low = 0;
		int high = n - 1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (arr[mid] == x)
				return mid;
			else if (arr[mid] > x)
				high = mid - 1;
			else
				low = mid + 1;
		}
		
		return -1;
	}
	
	public static int firstOccurence(int[] arr, int x) {
		
		int n = arr.length;
		int low = 0;
		int high = n - 1;
		int result = -1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (arr[mid] == x) {
				result = mid;
				high = mid - 1;
			}
			else if (arr[mid] > x)
				high = mid - 1;
			else
				low = mid + 1;
		}
		
		return result;
	}
	
	public static int lastOccurence(int[] arr, int x) {
		
		int n = arr.length;
		int low = 0;
		int high = n - 1;
		int result = -1;
		
		while (low <= high) {
			int mid = low + (high - low) / 2;
			
			if (arr[mid] == x) {
				result = mid;
				low = mid + 1;
			}
			else if (arr[mid] > x)
				high = mid - 1;
			else 
				low = mid + 1;
		}
		
		return result;
	}
	
	public static int countOccurences(int[] arr, int x) {
		return lastOccurence(arr, x) - firstOccurence(arr, x) + 1;
	}
}