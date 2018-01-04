package dataStructures;

import java.util.LinkedList;

import dataStructures.graphs.AdjMatrixGraph;
import dataStructures.graphs.Biconnected;
import dataStructures.graphs.Bridge;
import dataStructures.graphs.ConnectedComponents;
import dataStructures.graphs.Cycle;
import dataStructures.graphs.Edge;
import dataStructures.graphs.EdgeWeightedGraph;
import dataStructures.graphs.Graph;

public class MainGraph {

	public static void main(String[] args) {

		In in = new In("tests/small-graph.txt");
//		In in = new In("tests/medium-graph.txt");
		Graph G = new Graph(in);
		AdjMatrixGraph adjMatrixGraph = new AdjMatrixGraph(5);
		EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(4);
		ConnectedComponents cc = new ConnectedComponents(G);
		Cycle cycle = new Cycle(G);
		int m = cc.getCount();
		LinkedList<Integer>[] components = new LinkedList[m];
		
		// Adjency matrix graph
		adjMatrixGraph.addEdge(0, 2);
		adjMatrixGraph.addEdge(1, 2);
		adjMatrixGraph.addEdge(1, 4);
		adjMatrixGraph.addEdge(2, 0);
		adjMatrixGraph.addEdge(2, 3);
		adjMatrixGraph.addEdge(3, 3);
		adjMatrixGraph.addEdge(4, 0);
		
		// Edge weighted graph
		edgeWeightedGraph.addEdge(new Edge(0, 2, 23));
		edgeWeightedGraph.addEdge(new Edge(1, 2, 2));
		edgeWeightedGraph.addEdge(new Edge(3, 1, 7));
		edgeWeightedGraph.addEdge(new Edge(2, 0, 15));
		edgeWeightedGraph.addEdge(new Edge(1, 3, 5));
		
		System.out.print("Graph: ");
		System.out.println(G);
		System.out.print("Adjency matrix graph: ");
		System.out.println(adjMatrixGraph);
		System.out.print("Edge weighted graph: ");
		System.out.println(edgeWeightedGraph);
		
		// Connected components
		System.out.println("Connected components: " + m);
		System.out.println();
		
		for (int i = 0; i < m; i++)
			components[i] = new LinkedList<>();
		
		for (int v = 0; v < G.getV(); v++) 
			components[cc.getId(v)].add(v);
		
		for (int i = 0; i < m; i++) {
			for (int v : components[i])
				System.out.print(v + " ");
			
			System.out.println();
		}
		
		// Bridge
		System.out.println("\nBridge\n");
		Bridge bridge = new Bridge(G);
		System.out.println("\nEdge connected components = " + bridge.components());
		
		// Cycle
		System.out.println("\nCycle");
		
		if (cycle.hasCycle()) {
			for (int v : cycle.cycle())
				System.out.print(v + " ");
			System.out.println();
		}
		else 
			System.out.println("Graph is acyclic");
		
		// Articulation points in graph
		Biconnected bic = new Biconnected(G);
		System.out.println("\nArticulation points\n");
		
		for (int v = 0; v < G.getV(); v++)
			if (bic.isArticulation(v))
				System.out.println(v); 
	}
}