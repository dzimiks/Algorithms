package dataStructures;

import dataStructures.graphs.Graph;

public class MainGraph {

	public static void main(String[] args) {

		Graph graph = new Graph(7);
		
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
		
		System.out.println(graph);
	}
}