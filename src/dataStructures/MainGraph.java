package dataStructures;

import dataStructures.graphs.AdjMatrixGraph;
import dataStructures.graphs.Graph;

public class MainGraph {

	public static void main(String[] args) {

		Graph graph = new Graph(7);
		AdjMatrixGraph adjMatrixGraph = new AdjMatrixGraph(5);
		
		// Graph
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 6);
		graph.addEdge(1, 2);
		graph.addEdge(1, 5);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);
		graph.addEdge(4, 0);
		graph.addEdge(4, 3);
		graph.addEdge(4, 2);
		graph.addEdge(5, 2);
		graph.addEdge(6, 3);
		
		// Adjency matrix graph
		adjMatrixGraph.addEdge(0, 2);
		adjMatrixGraph.addEdge(1, 2);
		adjMatrixGraph.addEdge(1, 4);
		adjMatrixGraph.addEdge(2, 0);
		adjMatrixGraph.addEdge(2, 3);
		adjMatrixGraph.addEdge(3, 3);
		adjMatrixGraph.addEdge(4, 0);
		
		System.out.print("Graph: ");
		System.out.println(graph);
		System.out.print("Adjency matrix graph: ");
		System.out.println(adjMatrixGraph);
	}
}