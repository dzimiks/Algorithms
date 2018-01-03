package algorithms;

import java.util.LinkedList;

import algorithms.mst.KruskalMST;
import algorithms.mst.PrimMST;
import algorithms.mst.TarjanStronglyConnectedComponents;
import dataStructures.In;
import dataStructures.digraphs.Digraph;
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
		
		In in = new In("tests/small-digraph.txt");
		Digraph G = new Digraph(in);
		TarjanStronglyConnectedComponents tarjanSCC = new TarjanStronglyConnectedComponents(G);
		int m = tarjanSCC.getCount();

		System.out.println("\nTarjan's Strongly Connected Components\n");
		System.out.println(G);
		System.out.println(m + " components");
		
		LinkedList<Integer>[] components = new LinkedList[m];
		
		for (int i = 0; i < m; i++)
			components[i] = new LinkedList<>();
		
		for (int v = 0; v < G.getV(); v++)
			components[tarjanSCC.id(v)].add(v);
		
		for (int i = 0; i < m; i++) {
			for (int v : components[i])
				System.out.print(v + " ");
			
			System.out.println();
		}
	}
}