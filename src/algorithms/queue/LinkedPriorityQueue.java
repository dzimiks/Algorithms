package algorithms.queue;

import algorithms.list.SortedLinkedList;

public class LinkedPriorityQueue implements PriorityQueue<Integer> {

	private SortedLinkedList listQueue = new SortedLinkedList();
	
	@Override
	public boolean enqueue(Integer data) {
		if (data == null)
			return false;
		
		listQueue.add(data);
		return true;
	}

	@Override
	public Integer dequeueMin() {
		Integer first = listQueue.getFirstElement();
		if (first != null)
			listQueue.delete(listQueue.getFirstElement());
		
		return first;
	}
}