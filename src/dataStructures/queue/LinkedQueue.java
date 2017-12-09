package dataStructures.queue;

import dataStructures.list.LinkedList;

public class LinkedQueue<T> implements Queue<T> {

	private LinkedList<T> linkedQueue;
	
	public LinkedQueue() {
		linkedQueue = new LinkedList<T>();
	}

	@Override
	public boolean enqueue(T data) {
		if (data == null)
			return false;
		
		linkedQueue.addToEnd(data);
		return true;
	}

	@Override
	public T dequeue() {
		if (linkedQueue.isEmpty())
			return null;
		
		T data = linkedQueue.getFirstElement();
		linkedQueue.delete(linkedQueue.getHead().getData());
		
		return data;
	}

	@Override
	public boolean isEmpty() {
		return linkedQueue.isEmpty();
	}
	
	@Override
	public String toString() {
		return linkedQueue.toString();
	}
}