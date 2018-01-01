package algorithms;

import algorithms.mst.KruskalMST;
import algorithms.mst.PrimMST;
import dataStructures.graphs.Edge;

public class MainMST {

	public static void main(String[] args) {
		
		/* 
	        2   3
	    (0)--(1)--(2)
	     |   / \   |
	    6| 8/   \5 |7
	     | /     \ |
	    (3)-------(4)
	          9          
	    */
		
		PrimMST primMST = new PrimMST();
		KruskalMST kruskalMST = new KruskalMST();
		
		// Prim's MST
		int[][] graph = {{0, 2, 0, 6, 0},
		                 {2, 0, 3, 8, 5},
		                 {0, 3, 0, 0, 7},
		                 {6, 8, 0, 0, 9},
		                 {0, 5, 7, 9, 0}};
		
		System.out.println("==========");
		System.out.println("Prim's MST");
		System.out.println("==========\n");
		primMST.primMST(graph, 5);
		System.out.println();
		
		// Kruskal's MST
		System.out.println("=============");
		System.out.println("Kruskal's MST");
		System.out.println("=============\n");

		kruskalMST.add(new Edge(0, 1, 2));
		kruskalMST.add(new Edge(0, 3, 6));
		kruskalMST.add(new Edge(1, 0, 2));
		kruskalMST.add(new Edge(1, 2, 3));
		kruskalMST.add(new Edge(1, 3, 8));
		kruskalMST.add(new Edge(1, 4, 5));
		kruskalMST.add(new Edge(2, 1, 3));
		kruskalMST.add(new Edge(2, 4, 7));
		kruskalMST.add(new Edge(3, 0, 6));
		kruskalMST.add(new Edge(3, 1, 8));
		kruskalMST.add(new Edge(3, 4, 9));
		kruskalMST.add(new Edge(4, 1, 5));
		kruskalMST.add(new Edge(4, 2, 7));
		kruskalMST.add(new Edge(4, 3, 9));
		kruskalMST.kruskalMST();
	}
}