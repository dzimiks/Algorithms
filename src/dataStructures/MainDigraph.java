package dataStructures;

import dataStructures.digraphs.Digraph;
import dataStructures.digraphs.DirectedEdge;
import dataStructures.digraphs.EdgeWeightedDigraph;

public class MainDigraph {

	public static void main(String[] args) {

		Digraph G = new Digraph(5);
		EdgeWeightedDigraph ewd = new EdgeWeightedDigraph(5);
		
		// Digraph
		G.addEdge(0, 2);
		G.addEdge(0, 4);
		G.addEdge(1, 2);
		G.addEdge(2, 1);
		G.addEdge(3, 3);
		G.addEdge(4, 2);
		
		System.out.println(G);

		// Edge weighted digraph
		ewd.addEdge(new DirectedEdge(0, 1, 12));
		ewd.addEdge(new DirectedEdge(0, 2, 3));
		ewd.addEdge(new DirectedEdge(1, 2, 4));
		ewd.addEdge(new DirectedEdge(3, 1, 10));
		ewd.addEdge(new DirectedEdge(4, 3, 8));
		ewd.addEdge(new DirectedEdge(2, 4, 1));
		ewd.addEdge(new DirectedEdge(2, 0, 2));
		
		System.out.println(ewd);
	}
}