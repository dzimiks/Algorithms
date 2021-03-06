package dataStructures;

import dataStructures.heaps.IndexMaxPriorityQueue;
import dataStructures.heaps.IndexMinPriorityQueue;
import dataStructures.heaps.MaxHeap;
import dataStructures.heaps.MaxPriorityQueue;
import dataStructures.heaps.MinHeap;
import dataStructures.heaps.MinPriorityQueue;

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
        
        // Max Priority Queue
        MaxPriorityQueue<Integer> maxPQ = new MaxPriorityQueue<>();

        maxPQ.insert(5);
        maxPQ.insert(3);
        maxPQ.insert(17);
        maxPQ.insert(10);
        maxPQ.insert(84);
        maxPQ.insert(19);
        maxPQ.insert(6);
        maxPQ.insert(22);
        maxPQ.insert(9);
        
        System.out.println("\nMax Priority Queue\n");
        System.out.println("Max element is: " + maxPQ.delMax() + ", size of maxPQ: " + maxPQ.size());
        
        // Index Max Priority Queue
        System.out.println("\nIndex Max Priority Queue\n");
        String[] strings = {"it", "was", "the", "best", "of", "times", "it", "was", "the", "worst"};
        IndexMaxPriorityQueue<String> indexMaxPQ = new IndexMaxPriorityQueue<>(strings.length);
        
        for (int i = 0; i < strings.length; i++)
        	indexMaxPQ.insert(i, strings[i]);
        
        for (int i : indexMaxPQ)
        	System.out.println(i + " " + strings[i]);
        
        // Min Priority Queue
        MinPriorityQueue<Integer> minPQ = new MinPriorityQueue<>();
        
        minPQ.insert(5);
        minPQ.insert(3);
        minPQ.insert(17);
        minPQ.insert(10);
        minPQ.insert(84);
        minPQ.insert(19);
        minPQ.insert(6);
        minPQ.insert(22);
        minPQ.insert(9);
        
        System.out.println("\nMin Priority Queue\n");
        System.out.println("Min element is: " + minPQ.delMin() + ", size of minPQ: " + minPQ.size());
	
        // Index Min Priority Queue
        System.out.println("\nIndex Min Priority Queue\n");
        String[] names = {"Vanja", "Olja", "Gohrica", "Gohran", "Ruz'ca", "Mislisa"};
        IndexMinPriorityQueue<String> indexMinPQ = new IndexMinPriorityQueue<>(names.length);
        
        for (int i = 0; i < names.length; i++)
        	indexMinPQ.insert(i, names[i]);
        
        for (int i : indexMinPQ)
        	System.out.println(i + " " + names[i]);
	}
}
