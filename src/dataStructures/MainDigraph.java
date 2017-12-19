package dataStructures;

import dataStructures.graphs.Digraph;

public class MainDigraph {

	public static void main(String[] args) {

		Digraph G = new Digraph(5);
		
		G.addEdge(0, 2);
		G.addEdge(0, 4);
		G.addEdge(1, 2);
		G.addEdge(2, 1);
		G.addEdge(3, 3);
		G.addEdge(4, 2);
		
		System.out.println(G);
	}
}