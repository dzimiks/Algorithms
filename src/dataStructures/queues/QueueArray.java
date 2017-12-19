package dataStructures.queues;

import java.util.Arrays;

public class QueueArray<T> implements Queue<T> {

	private int front;
	private int rear;
	private T[] arr;

	public QueueArray(int size) {
		if (size <= 0)
			size = 10;
		
		arr = (T[]) new Object[size];
		front = 0;
		rear = 0;
	}

	@Override
	public boolean enqueue(T data) {
		if (isFull() || data == null)
			return false;
		
		arr[rear++] = data;
		
		if (rear == arr.length)
			rear = 0;
		
		return true;
	}

	@Override
	public T dequeue() {
		if (isEmpty())
			return null;
		
		T data = arr[front];
		arr[front++] = null;
		
		if (front == arr.length)
			front = 0;
		
		return data;
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}
	
	public boolean isFull() {
		return ((rear + 1) % arr.length) == rear;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(arr);
	}
}