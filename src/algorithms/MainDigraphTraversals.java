package algorithms;

import algorithms.digraphTraversals.DirectedDFS;
import algorithms.digraphTraversals.DirectedDFSPaths;
import dataStructures.In;
import dataStructures.graphs.Digraph;

public class MainDigraphTraversals {

	public static void main(String[] args) {

		In in = new In("tests/small-digraph.txt");
		Digraph G = new Digraph(in);
		int s = 2;

		System.out.println(G);
	
		// Directed DFS
		System.out.println("Directed DFS\n");
		DirectedDFS directedDFS = new DirectedDFS(G, s);
		
		// Directed DFS paths
		System.out.println("\n\nDirected DFS paths\n");
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
	}
}