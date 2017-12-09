package dataStructures.queue;

public interface Queue<T> {

	public boolean enqueue(T data);
	public T dequeue();
	public boolean isEmpty();
}