package dataStructures.stacks;

import dataStructures.lists.LinkedList;

public class LinkedStack<T> implements Stack<T> {

	private LinkedList<T> stackList = new LinkedList<>();
	
	@Override
	public boolean push(T data) {
		if (data == null)
			return false;
		
		stackList.addToStart(data);
		return true;
	}

	@Override
	public T pop() {
		if (isEmpty())
			return null;
		
		T data = stackList.getHead().getData();
		stackList.delete(stackList.getHead().getData());
		
		return data;
	}

	@Override
	public boolean isEmpty() {
		return stackList.getHead() == null;
	}

	@Override
	public T peek() {
		if (isEmpty())
			return null;
		
		return stackList.getHead().getData();
	}

	@Override
	public String toString() {
		return stackList.toString();
	}
}
