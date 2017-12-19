package dataStructures;

import dataStructures.queues.LinkedPriorityQueue;
import dataStructures.queues.LinkedQueue;
import dataStructures.queues.QueueArray;
import dataStructures.queues.QueueFromTwoStacks;

public class MainQueue {

	public static void main(String[] args) {

		QueueArray<Integer> queue = new QueueArray<>(5);
		LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
		QueueFromTwoStacks<Integer> stackQueue = new QueueFromTwoStacks<>();
		LinkedPriorityQueue priorityQueue = new LinkedPriorityQueue();
		
//		queue.enqueue(2);
//		queue.enqueue(10);
//		queue.enqueue(23);
//		queue.enqueue(7);
//		queue.enqueue(13);
//		
//		System.out.println(queue);
//
//		queue.dequeue();
//		queue.dequeue();
//		
//		System.out.println(queue);
		
//		linkedQueue.enqueue(25);
//		linkedQueue.enqueue(7);
//		linkedQueue.enqueue(1024);
//		linkedQueue.enqueue(13);
//		linkedQueue.enqueue(-19);
//		linkedQueue.enqueue(23);
//		
//		System.out.println(linkedQueue);
//		
//		linkedQueue.dequeue();
//		
//		System.out.println(linkedQueue);
	
//		stackQueue.enqueue(23);
//		stackQueue.enqueue(17);
//		System.out.println(stackQueue);
//		stackQueue.enqueue(5);
//		System.out.println(stackQueue);
//		stackQueue.dequeue();
//		System.out.println(stackQueue);
		
		priorityQueue.enqueue(25);
		priorityQueue.enqueue(12);
		priorityQueue.enqueue(9);
		
		System.out.println(priorityQueue.dequeueMin());
		System.out.println(priorityQueue.dequeueMin());
	}
}