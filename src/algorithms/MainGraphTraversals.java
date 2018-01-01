package algorithms;

import algorithms.graphTraversals.BFSPaths;
import algorithms.graphTraversals.DFS;
import algorithms.graphTraversals.DFSPaths;
import dataStructures.graphs.Graph;

public class MainGraphTraversals {

	public static void main(String[] args) {

		Graph graph = new Graph(7);
		int source = 4;
		
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
		
		// DFS
		DFS dfs = new DFS(graph, source);
		
		System.out.println(graph);
		System.out.println("===");
		System.out.println("DFS");
		System.out.println("===\n");
		
		for (int v = 0; v < graph.getV(); v++) 
			if (dfs.isMarked(v))
				System.out.print(v + " ");
		
		System.out.println("\n");
		
		if (dfs.getCount() != graph.getV())
			System.out.println("Graph is not connected!\n");
		else
			System.out.println("Graph is connected!\n");
		
		System.out.println("=========");
		System.out.println("DFS paths");
		System.out.println("=========\n");
		
		// DFS paths
		DFSPaths dfsPaths = new DFSPaths(graph, source);
		
		for (int v = 0; v < graph.getV(); v++) {
			if (dfsPaths.hasPathTo(v)) {
				System.out.format("%d to %d: ", source, v);
				
				for (int x : dfsPaths.pathTo(v)) {
					if (x == source)
						System.out.print(x);
					else
						System.out.print(x + "-");
				}
				
				System.out.println();
			}
			else 
				System.out.format("%d to %d: not connected!\n", source, v);
		}
		
		System.out.println("\n=========");
		System.out.println("BFS paths");
		System.out.println("=========\n");
		
		// BFS paths
		BFSPaths bfsPaths = new BFSPaths(graph, source);
		
		for (int v = 0; v < graph.getV(); v++) {
			if (bfsPaths.hasPathTo(v)) {
				System.out.format("%d to %d: ", source, v);
				
				for (int x : bfsPaths.pathTo(v)) {
					if (x == source)
						System.out.print(x);
					else
						System.out.print(x + "-");
				}
				
				System.out.println();
			}
			else 
				System.out.format("%d to %d: not connected!\n", source, v);
		}
	}
}