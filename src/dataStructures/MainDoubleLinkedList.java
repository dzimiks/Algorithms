package dataStructures;

import dataStructures.list.DoubleLinkedList;

public class MainDoubleLinkedList {

	public static void main(String[] args) {
		
		DoubleLinkedList<Integer> list = new DoubleLinkedList<>();
		
		list.addToStart(2);
		list.addToStart(42);
		list.addToStart(99);
		list.addToStart(11);
		list.addAfter(23, 11);
		
		System.out.println(list);
		
		list.delete(11);
		
		System.out.println(list);
	}
}