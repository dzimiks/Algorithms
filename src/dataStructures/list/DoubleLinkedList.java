package dataStructures.list;

public class DoubleLinkedList<T> {

	private Node<T> head;
	
	public DoubleLinkedList() {
		head = null;
	}
	
	public boolean addToStart(T data) {
		if (data == null)
			return false;
		
		head = new Node<T>(data, head, null);
		
		if (head.next != null)
			head.next.prev = head;
		
		return true;
	}
	
	public boolean addAfter(T data, T key) {
		if (data == null)
			return false;
		
		Node<T> tmp = head;
		
		while (tmp != null && !tmp.data.equals(key))
			tmp = tmp.next;
		
		if (tmp == null)
			return false;
		
		tmp.next = new Node<T>(data, tmp.next, tmp);
		return true;
	}
	
	public boolean delete(T data) {
		if (data == null || head == null)
			return false;
		
		if (head.data.equals(data)) {
			head = head.next;
			
			if (head != null)
				head.prev = null;
			
			return true;
		}
		
		Node<T> tmp = head;
		
		while (tmp != null && !tmp.data.equals(data))
			tmp = tmp.next;
		
		if (tmp == null)
			return false;
		
		Node<T> prev = tmp.prev;
		prev.next = tmp.next;
		
		if (tmp.next != null)
			tmp.next.prev = prev;
		
		return true;
	}
	
	@Override
	public String toString() {
		Node<T> curr = head;
		String ans = "";
		
		while (curr != null) {
			ans += curr.data.toString();
			
			if (curr.next != null)
				ans += " <-> ";
			else
				ans += "\n";
			
			curr = curr.next;
		}
		
		return ans;
	}
	
	public class Node<T> {
		T data;
		Node<T> next;
		Node<T> prev;
		
		public Node(T data, Node<T> next, Node<T> prev) {
			super();
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
	}
}