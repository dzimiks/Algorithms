package dataStructures.queues;

public interface PriorityQueue<T> {

	public boolean enqueue(T data);
	public T dequeueMin();
}