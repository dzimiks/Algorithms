package algorithms.stack;

public class StackArray<T> implements Stack<T> {

	private T[] arr;
	private int top;
	private int maxValue;
	
	public StackArray(int maxValue) {
		this.maxValue = maxValue;
		arr = (T[]) new Object[maxValue];
		top = -1;
	}
	
	@Override
	public boolean push(T data) {
		if (data == null || isFull())
			return false;
		
		arr[++top] = data;
		return true;
	}

	@Override
	public T pop() {
		if (isEmpty())
			return null;
		
		return arr[top--];
	}

	@Override
	public boolean isEmpty() {
		return top == -1;
	}

	@Override
	public T peek() {
		if (isEmpty())
			return null;
		
		return arr[top];
	}

	public boolean isFull() {
		return top == maxValue - 1;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) 
			sb.append("| " + arr[i] + " |\n");

		return sb.toString();
	}
}
