package dataStructures.stack;

public interface Stack<T> {

	public boolean push(T data);
	public T pop();
	public boolean isEmpty();
	public T peek();
}