package algorithms.list;

public class SortedLinkedList {

	protected Node head;
	
	public SortedLinkedList() {
		head = null;
	}
	
	public void add(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		
		Node newNode = new Node(data);
		
		if (head.data > data) {
			newNode.next = head;
			head = newNode;
			return;
		}
		
		Node curr = head, prev = null;
		
		while (curr != null && prev.data <= data) {
			prev = curr;
			curr = curr.next;
		}
		
		newNode.next = curr;
		prev.next = newNode;
	}
	
	public boolean isExist(int data) {
		Node curr = head;
		
		while (curr != null && curr.data <= data) {
			if (curr.data == data)
				return true;
			
			curr = curr.next;
		}
		
		if (curr == null)
			return false;
		
		return true;
	}
	
	public boolean delete(int data) {
		if (head == null)
			return false;
		
		if (head.data == data) {
			head = head.next;
			return true;
		}
		
		Node curr = head, prev = null;
		
		while (curr != null && curr.data < data) {
			prev = curr;
			curr = curr.next;
		}
		
		if (curr == null)
			return false;
		
		if (curr.data == data) {
			prev.next = curr.next;
			return true;
		}
		else 
			return false;
	}
	
	public Integer getFirstElement() {
		if (head == null)
			return null;
		
		return head.data;
	}
	
	@Override
	public String toString() {
		if (head == null)
			return "";
		
		Node tmp = head;
		StringBuilder sb = new StringBuilder();
		
		while (tmp != null) {
			sb.append("[" + tmp.data + "]");
			tmp = tmp.next;
		}
		
		return sb.toString();
	}
	
	protected static class Node {
		
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
			next = null;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		@Override
		public String toString() {
			return Integer.toString(data);
		}
	}
}