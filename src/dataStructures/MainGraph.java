package dataStructures;

import algorithms.graphTraversal.DFS;
import algorithms.graphTraversal.DFSPaths;
import dataStructures.graph.Graph;

public class MainGraph {

	public static void main(String[] args) {

		Graph graph = new Graph(7);
		int s = 4;
		
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
		DFS dfs = new DFS(graph, s);
		
		System.out.println(graph);
		
		for (int v = 0; v < graph.getV(); v++) {
			if (dfs.isMarked(v))
				System.out.print(v + " ");
		}
		
		System.out.println();
		
		if (dfs.getCount() != graph.getV())
			System.out.println("Graph is not connected!\n");
		else
			System.out.println("Graph is connected!\n");
		
		// DFS paths
		DFSPaths dfsPaths = new DFSPaths(graph, s);
		
		for (int v = 0; v < graph.getV(); v++) {
			if (dfsPaths.hasPathTo(v)) {
				System.out.format("%d to %d: ", s, v);
				
				for (int x : dfsPaths.pathTo(v)) {
					if (x == s)
						System.out.print(x);
					else
						System.out.print(x + "-");
				}
				
				System.out.println();
			}
			else 
				System.out.format("%d to %d: not connected!\n", s, v);
		}
	}
}