package dataStructures;

import dataStructures.heap.MaxHeap;
import dataStructures.heap.MinHeap;

public class MainHeap {

	public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap(15);
        MinHeap minHeap = new MinHeap(15);
        
        // Max Heap
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.maxHeap();
        
        // Min Heap
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(22);
        minHeap.insert(9);
        minHeap.minHeap();
 
        System.out.println("The Max Heap is:");
        maxHeap.print();
        System.out.println("The max val is " + maxHeap.remove());
        
        System.out.println("\nThe Min Heap is:");
        minHeap.print();
        System.out.println("The Min val is " + minHeap.remove());
	}
}