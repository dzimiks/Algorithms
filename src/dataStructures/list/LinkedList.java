package dataStructures.list;

public class LinkedList<T> {

	protected Node<T> head;
	protected Node<T> tail;
	
	public LinkedList() {
		head = null;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public T getFirstElement() {
		if (head == null)
			return null;
		
		return head.data;
	}
	
	public boolean addToStart(T data) {
		if (data == null)
			return false;
		
		head = new Node<T>(data, head);
		
		if (tail == null)
			tail = head;
		
		return true;
	}
	
	public boolean addToEnd(T data) {
		if (data == null)
			return false;
		
		if (head == null)
			return addToStart(data);
		
		Node<T> newNode = new Node<T>(data);
		tail.next = newNode;
		tail = newNode;
		
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
		
		Node<T> newNode = new Node<T>(data, tmp.next);
		tmp.next = newNode;
		
		if (tmp == tail)
			tail = newNode;
		
		return true;
	}
	
	public boolean addBefore(T data, T key) {
		if (data == null)
			return false;
		
		if (head != null && head.data.equals(key)) {
			addToStart(data);
			return true;
		}
		
		Node<T> tmp = head;
		
		while (tmp != null && !tmp.data.equals(key))
			tmp = tmp.next;
		
		if (tmp == null)
			return false;
		
		Node<T> newNode = new Node<T>(data, tmp.next);
		tmp.next = newNode;
		
		T tmpData = newNode.data;
		newNode.data = tmp.data;
		tmp.data = tmpData;
		
		return true;
	}
	
	public boolean delete(T data) {
		if (head == null || data == null)
			return false;
		
		if (head.data.equals(data)) {
			head = head.next;
			
			if (head == null)
				tail = null;
			
			return true;
		}
		
		Node<T> curr = head;
		Node<T> prev = null;
		
		while (curr != null && !curr.data.equals(data)) {
			prev = curr;
			curr = curr.next;
		}
		
		if (curr == null)
			return false;
		
		prev.next = curr.next;
		
		if (curr.next == null)
			tail = prev;
		
		return true;
	}
	
	public void deleteList() {
		head = null;
		tail = null;
	}
	
	public boolean isExist(T data) {
		if (head == null || data == null)
			return false;
		
		Node<T> curr = head;
		
		while (curr != null && !curr.data.equals(data))
			curr = curr.next;
		
		if (curr == null)
			return false;
		
		return true;
	}
	
	public int size() {
		int cnt = 0;
		
		if (head == null)
			return cnt;
		
		while (head != null) {
			cnt++;
			head = head.next;
		}
		
		return cnt;
	}
	
	public void invert() {
		Node<T> p = head, q = null, r;
		
		while (p != null) {
			r = q;
			q = p;
			p = p.next;
			q.next = r;
		}
		
		head = q;
	}
	
	public void concat(LinkedList<T> secondList) {
		if (secondList == null)
			return;
		
		if (head == null) {
			head = secondList.head;
			return;
		}
		
		Node<T> tmp = head;
		
		while (tmp.next != null)
			tmp = tmp.next;
		
		tmp.next = secondList.head;
		secondList = null;
	}
	
	public void deleteDuplicatesFromUnsortedList() {
		if (head == null)
			return;
		
		Node<T> tmp1 = head;
		
		while (tmp1 != null) {
			Node<T> prev = tmp1;
			Node<T> tmp2 = prev.next;
			
			while (tmp2 != null) {
				if (tmp2.data == tmp1.data) {
					prev.next = tmp2.next;
					tmp2 = tmp2.next;
					continue;
				}
				
				prev = tmp2;
				tmp2 = tmp2.next;
			}
			
			tmp1 = tmp1.next;
		}
	}
	
	public void deleteDuplicatesFromSortedList() {
		if (head == null)
			return;
		
		int val = (int) head.data;
		Node<T> tmp = head.next, prev = head;
		
		while (tmp != null) {
			if ((int) tmp.data == val) {
				tmp = tmp.next;
				prev.next = tmp;
				continue;
			}
			
			val = (int) tmp.data;
			prev = tmp;
			tmp = tmp.next;
		}
		
	}
	
	public LinkedList<T> copy() {
		if (head == null)
			return null;
		
		LinkedList<T> copyList = new LinkedList<>();
		Node<T> tmp = head.next;
		copyList.head = new Node<T>(head.data);
		Node<T> tmpCopy = copyList.head;
		
		while (tmp != null) {
			Node<T> nodeCopy = new Node<T>(tmp.data);
			tmpCopy.next = nodeCopy;
			tmpCopy = tmpCopy.next;
			tmp = tmp.next;
		}
		
		return copyList;
	}

	public boolean hasCycle() {
		if (isEmpty())
			return false;
		
		Node<T> slow = head, fast = head;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast)
				return true;
		}
		
		return false;
	}
	
	public boolean isPalindrome() {
		LinkedList<T> copy = copy();
		
		if (copy == null)
			return true;
		
		copy.invert();
		int num = copy.size();
		
		if (num % 2 == 0)
			num = num / 2;
		else
			num = (num / 2) + 1;
		
		Node<T> tmp1 = head, tmp2 = copy.head;
		
		while (num > 0) {
			if (tmp1.data != tmp2.data)
				return false;
			
			tmp1 = tmp1.next;
			tmp2 = tmp2.next;
			num--;
		}
		
		return true;
	}
	
	public T kthElementFromEnd(int k) {
		Node<T> tmp = head;
		int n = size() - k;
		
		for (int i = 0; i < n; i++) 
			tmp = tmp.next;
		
		return tmp.data;
	}
	
	public LinkedList<Integer> sumOfTwoNumsFromLists(LinkedList<T> list) {
		LinkedList<Integer> ans = new LinkedList<>();
		Node<T> head1 = head;
		Node<T> head2 = list.head;
		String num1 = "";
		String num2 = "";
		int sum = 0;
		
		while (head1 != null) {
			num1 += head1.data.toString();
			head1 = head1.next;
		}
		
		while (head2 != null) {
			num2 += head2.data.toString();
			head2 = head2.next;
		}
		
		sum = Integer.parseInt(num1) + Integer.parseInt(num2);
		
		while (sum > 0) {
			int digit = sum % 10;
			ans.addToStart(digit);
			sum /= 10;
		}
		
		return ans;
	}
	
	@Override
	public String toString() {
		Node<T> curr = head;
		StringBuilder output = new StringBuilder();
		
		while (curr.next != null) {
			output.append(curr + " -> ");
			curr = curr.next;
		}
		
		output.append(curr);
		return output.toString();
	}
	
	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public Node<T> getTail() {
		return tail;
	}

	public void setTail(Node<T> tail) {
		this.tail = tail;
	}

	public static class Node<T> {
		
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
		
		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			if (data == null)
				return "";
			
			return data.toString();
		}
		
		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public Node<T> getNext() {
			return next;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}
	}
}