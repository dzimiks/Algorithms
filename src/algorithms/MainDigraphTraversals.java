package algorithms;

import algorithms.digraphTraversals.DirectedDFS;
import dataStructures.In;
import dataStructures.graphs.Digraph;

public class MainDigraphTraversals {

	public static void main(String[] args) {

		In in = new In("tests/small-digraph.txt");
		Digraph G = new Digraph(in);

		System.out.println(G);
	
		// Directed DFS
		System.out.println("Directed DFS\n");
		DirectedDFS directedDFS = new DirectedDFS(G, 0);
	}
}