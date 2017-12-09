package dataStructures.queue;

public class Deque<T>  {

	private T[] arr;
	private int front;
	private int rear;
	private int size;
	
	public Deque(int size) {
		arr = (T[]) new Object[size];
		front = -1;
		rear = 0;
		this.size = size;
	}
	
	public boolean isFull() {
		return front == 0 && rear == size - 1 || front == rear + 1;
	}
	
	public boolean isEmpty() {
		return front == -1;
	}
	
	public void insertFront(T data) {
		if (isFull())
			return;
		
		if (front == -1) {
			front = 0;
			rear = 0;
		}
		else if (front == 0) 
			front = size - 1;
		else 
			front--;
		
		arr[front] = data;
	}
	
	public void insertRear(T data) {
        if (isFull())
            return;
  
        if (front == -1) {
            front = 0;
            rear = 0;
        }
        else if (rear == size - 1)
            rear = 0;
        else
            rear++;
         
        arr[rear] = data;
    }
	
	public void deleteFront() {
        if (isEmpty())
            return ;
  
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else {
            if (front == size -1)
                front = 0;
            else 
                front++;
        }
    }
  
    public void deleteRear() {
        if (isEmpty())
            return ;
  
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else if (rear == 0)
            rear = size - 1;
        else
            rear--;
    }
  
    public T getFront() {
        if (isEmpty())
            return null;

        return arr[front];
    }
  
    public T getRear() {
        if(isEmpty() || rear < 0)
            return null;

        return arr[rear];
    }
}