package dataStructures;

import dataStructures.queue.Deque;

public class MainDeque {

	public static void main(String[] args) {
		
		Deque<Integer> deque = new Deque<>(5);
		
		deque.insertRear(5);
		deque.insertRear(10);
		System.out.println(deque.getRear());
		deque.deleteRear();
		System.out.println(deque.getRear());
		deque.insertFront(15);
		System.out.println(deque.getFront());
		deque.deleteFront();
		System.out.println(deque.getFront());
	}
}