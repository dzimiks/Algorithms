package algorithms;

import algorithms.graphTraversals.AllPaths;
import algorithms.graphTraversals.BFSPaths;
import algorithms.graphTraversals.DFS;
import algorithms.graphTraversals.DFSPaths;
import dataStructures.In;
import dataStructures.graphs.Graph;

public class MainGraphTraversals {

	public static void main(String[] args) {

		In in = new In("tests/small-graph.txt");
		Graph graph = new Graph(in);
		int source = 0;
		
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
		
		// All paths
		System.out.println("\nAll simple paths beetween 0 and 4:\n");
		AllPaths allPaths = new AllPaths(graph, 0, 4);
		System.out.println("Number of paths = " + allPaths.getNumberOfPaths());
	}
}