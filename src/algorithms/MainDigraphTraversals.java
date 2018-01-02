package algorithms;

import algorithms.digraphTraversals.DirectedBFS;
import algorithms.digraphTraversals.DirectedBFSPaths;
import algorithms.digraphTraversals.DirectedDFS;
import algorithms.digraphTraversals.DirectedDFSPaths;
import dataStructures.In;
import dataStructures.digraphs.Digraph;

public class MainDigraphTraversals {

	public static void main(String[] args) {

		In in = new In("tests/small-digraph.txt");
		Digraph G = new Digraph(in);
		int s = 7;

		System.out.println(G);
	
		// Directed DFS
		System.out.println("============");
		System.out.println("Directed DFS");
		System.out.println("============\n");
		
		DirectedDFS directedDFS = new DirectedDFS(G, s);
		
		System.out.println("\n");
		
		// Directed DFS paths
		System.out.println("==================");
		System.out.println("Directed DFS paths");
		System.out.println("==================\n");
		DirectedDFSPaths directedDFSPaths = new DirectedDFSPaths(G, s);
		
		for (int v = 0; v < G.getV(); v++) {
            if (directedDFSPaths.hasPathTo(v)) {
                System.out.printf("%d to %d:  ", s, v);
                
                for (int x : directedDFSPaths.pathTo(v)) {
                    if (x == s) 
                    	System.out.print(x);
                    else        
                    	System.out.print(x + "-");
                }
                
                System.out.println();
            }
            else 
            	System.out.printf("%d to %d:  not connected\n", s, v);
        }
		
		// Directed BFS
		System.out.println("\n============");
		System.out.println("Directed BFS");
		System.out.println("============\n");
		
		DirectedBFS directedBFS = new DirectedBFS(G, s);
		
		// Directed BFS paths
		System.out.println("\n==================");
		System.out.println("Directed BFS paths");
		System.out.println("==================\n");
		
		DirectedBFSPaths directedBFSPaths = new DirectedBFSPaths(G, s);
		
		for (int v = 0; v < G.getV(); v++) {
			if (directedBFSPaths.hasPathTo(v)) {
				System.out.format("%d to %d: ", s, v);
				
				for (int x : directedBFSPaths.pathTo(v)) {
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