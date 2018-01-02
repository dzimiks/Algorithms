package algorithms.digraphTraversals;

import java.util.Iterator;
import java.util.Stack;

import dataStructures.graphs.Digraph;

public class DirectedDFS {

	private boolean[] visited;  
	private int count;        
	
	public DirectedDFS(Digraph G, int s) {
		visited = new boolean[G.getV()];
		validateVertex(s);
		dfs(G, s);
//		iterativeDFS(G, s);
	}
	
	public DirectedDFS(Digraph G, Iterable<Integer> sources) {
		visited = new boolean[G.getV()];
		validateVertices(sources);

		for (int v : sources) 
			if (!visited[v]) 
				dfs(G, v);
	}
	
	private void dfs(Digraph G, int v) { 
		count++;
		visited[v] = true;
		System.out.print(v + " ");
		
		for (int w : G.adj(v)) 
			if (!visited[w]) 
				dfs(G, w);
	}
	
	private void iterativeDFS(Digraph G, int s) {
		visited = new boolean[G.getV()];
		validateVertex(s);

        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.getV()];

        for (int v = 0; v < G.getV(); v++)
            adj[v] = G.adj(v).iterator();

        Stack<Integer> stack = new Stack<Integer>();
        visited[s] = true;
        stack.push(s);
        System.out.print(s + " ");
        
        while (!stack.isEmpty()) {
            int v = stack.peek();
            
            if (adj[v].hasNext()) {
                int w = adj[v].next();
        
                if (!visited[w]) {
                    visited[w] = true;
                    stack.push(w);
                    System.out.print(w + " ");
                }
            }
            else 
                stack.pop();
        }
	}
	
	public boolean visited(int v) {
		validateVertex(v);
		return visited[v];
	}
	
	public int count() {
		return count;
	}
	
	private void validateVertex(int v) {
		int V = visited.length;

		if (v < 0 || v >= V)
			throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
	}
	
	private void validateVertices(Iterable<Integer> vertices) {
		if (vertices == null) 
			throw new IllegalArgumentException("Argument is null");
		
		int V = visited.length;
		
		for (int v : vertices) 
			if (v < 0 || v >= V) 
				throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
	}
}