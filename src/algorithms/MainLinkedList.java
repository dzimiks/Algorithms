package algorithms;

import algorithms.list.LinkedList;
import algorithms.list.SortedLinkedList;

public class MainLinkedList {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<>();
		LinkedList<Integer> secondList = new LinkedList<Integer>();
		SortedLinkedList sortedList = new SortedLinkedList();
		
		// Add to list
		list.addToStart(2);
		list.addToStart(5);
		list.addToStart(9);
//		list.addToEnd(19);
//		list.addToStart(423);
//		list.addBefore(78, 19);
//		list.addAfter(77, 19);
		
		// Add to second list
//		secondList.addToEnd(23);
//		secondList.addToEnd(56);
		secondList.addToEnd(2);
		secondList.addToEnd(1);
//		secondList.addToEnd(23);
//		secondList.addToEnd(-123);
		
		// Add to sorted list
		sortedList.add(15);
		sortedList.add(7);
		sortedList.add(5);
		sortedList.add(-3);
		sortedList.delete(-3);
		
		System.out.println("Started list: "  + list);
		System.out.println("Second list: " + secondList);
		System.out.println("Sorted list: " + sortedList);
		
//		list.delete(78);
//		
//		System.out.println("Deleted 78: " + list);
//		
//		list.invert();
//		
//		System.out.println("Inverted list: "  + list);
//		
//		list.concat(secondList);
//		
//		System.out.println("Concated lists: " + list);
//		
//		secondList.deleteDuplicatesFromUnsortedList();
//		
//		System.out.println("\nDeleted duplicates: " + secondList);
//		
//		LinkedList<Integer> listCopy = list.copy();
//		
//		System.out.println("List copy: " + listCopy);
//		System.out.println("\nHas cycle: " + (list.hasCycle() ? "Yes" : "No"));
//		System.out.println("Kth element from end: " + list.kthElementFromEnd(2));
//		System.out.println("Sum of two nums from lists: " + list.sumOfTwoNumsFromLists(secondList));
//		System.out.println(sortedList.isExist(7) ? "True" : "False");
	}
}