package dataStructures;

import java.util.LinkedList;

import dataStructures.graphs.AdjMatrixGraph;
import dataStructures.graphs.Bridge;
import dataStructures.graphs.ConnectedComponents;
import dataStructures.graphs.Edge;
import dataStructures.graphs.EdgeWeightedGraph;
import dataStructures.graphs.Graph;

public class MainGraph {

	public static void main(String[] args) {

		In in = new In("tests/small-graph.txt");
//		In in = new In("tests/medium-graph.txt");
		Graph graph = new Graph(in);
		AdjMatrixGraph adjMatrixGraph = new AdjMatrixGraph(5);
		EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(4);
		Bridge bridge = new Bridge(graph);
		ConnectedComponents cc = new ConnectedComponents(graph);
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
		System.out.println(graph);
		System.out.print("Adjency matrix graph: ");
		System.out.println(adjMatrixGraph);
		System.out.print("Edge weighted graph: ");
		System.out.println(edgeWeightedGraph);
		
		// Connected components
		System.out.println("Connected components: " + m);
		System.out.println();
		
		for (int i = 0; i < m; i++)
			components[i] = new LinkedList<>();
		
		for (int v = 0; v < graph.getV(); v++) 
			components[cc.getId(v)].add(v);
		
		for (int i = 0; i < m; i++) {
			for (int v : components[i])
				System.out.print(v + " ");
			
			System.out.println();
		}
		
		System.out.println("\nBridge");
		System.out.println("Edge connected components = " + bridge.components());
	}
}