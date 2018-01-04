package dataStructures;

import dataStructures.digraphs.AdjMatrixEdgeWeightedDigraph;
import dataStructures.digraphs.Digraph;
import dataStructures.digraphs.DirectedEdge;
import dataStructures.digraphs.EdgeWeightedDigraph;

public class MainDigraph {

	public static void main(String[] args) {

		int V = 5;
		Digraph G = new Digraph(V);
		EdgeWeightedDigraph ewd = new EdgeWeightedDigraph(V);
		AdjMatrixEdgeWeightedDigraph adjMatrixEWD = new AdjMatrixEdgeWeightedDigraph(V);
		
		// Digraph
		G.addEdge(0, 2);
		G.addEdge(0, 4);
		G.addEdge(1, 2);
		G.addEdge(2, 1);
		G.addEdge(3, 3);
		G.addEdge(4, 2);
		
		System.out.println(G);

		// Edge Weighted Digraph
		ewd.addEdge(new DirectedEdge(0, 1, 12));
		ewd.addEdge(new DirectedEdge(0, 2, 3));
		ewd.addEdge(new DirectedEdge(1, 2, 4));
		ewd.addEdge(new DirectedEdge(3, 1, 10));
		ewd.addEdge(new DirectedEdge(4, 3, 8));
		ewd.addEdge(new DirectedEdge(2, 4, 1));
		ewd.addEdge(new DirectedEdge(2, 0, 2));
		
		System.out.println(ewd);
		
		// Adjency Matrix Edge Weighted Digraph
		adjMatrixEWD.addEdge(new DirectedEdge(0, 1, 2));
		adjMatrixEWD.addEdge(new DirectedEdge(1, 2, 43));
		adjMatrixEWD.addEdge(new DirectedEdge(3, 1, 30));
		adjMatrixEWD.addEdge(new DirectedEdge(4, 3, 15));
		adjMatrixEWD.addEdge(new DirectedEdge(2, 4, 4));
		adjMatrixEWD.addEdge(new DirectedEdge(2, 3, 9));
		
		System.out.println(adjMatrixEWD);
	}
}