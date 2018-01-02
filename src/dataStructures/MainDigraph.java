package dataStructures;

import dataStructures.graphs.Digraph;
import dataStructures.graphs.DirectedEdge;

public class MainDigraph {

	public static void main(String[] args) {

		Digraph G = new Digraph(5);
		DirectedEdge directedEdge = new DirectedEdge(1, 3, 23);
		
		G.addEdge(0, 2);
		G.addEdge(0, 4);
		G.addEdge(1, 2);
		G.addEdge(2, 1);
		G.addEdge(3, 3);
		G.addEdge(4, 2);
		
		System.out.println(G);
		System.out.println(directedEdge);
	}
}