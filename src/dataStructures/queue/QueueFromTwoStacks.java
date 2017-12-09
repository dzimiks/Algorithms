package dataStructures.queue;

import java.util.Stack;

public class QueueFromTwoStacks<T> implements Queue<T> {

	private Stack<T> stack1 = new Stack<>();
	private Stack<T> stack2 = new Stack<>();
	
	@Override
	public boolean enqueue(T data) {
		return stack1.add(data);
	}

	@Override
	public T dequeue() {
		while (!stack1.isEmpty())
			stack2.push(stack1.pop());
		
		T data = stack2.pop();
		
		while (!stack2.isEmpty())
			stack1.push(stack2.pop());
		
		return data;
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty();
	}

	@Override
	public String toString() {
		return stack1.toString();
	}
}