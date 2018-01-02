package algorithms.graphTraversals;

import java.util.LinkedList;
import java.util.Stack;

import dataStructures.graphs.Graph;


public class BFSPaths {

	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] visited;
	private int[] edgeTo;
	private int[] distTo;
	
	public BFSPaths(Graph G, int source) {
		visited = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		distTo = new int[G.getV()];
		validateVertex(source);
		bfs(G, source);
	}
	
	public BFSPaths(Graph G, Iterable<Integer> sources) {
		visited = new boolean[G.getV()];
        distTo = new int[G.getV()];
        edgeTo = new int[G.getV()];
        
        for (int v = 0; v < G.getV(); v++)
            distTo[v] = INFINITY;
        
        validateVertices(sources);
        bfs(G, sources);
    }
	
	private void bfs(Graph G, int source) {

		LinkedList<Integer> q = new LinkedList<>();
		
		for (int v = 0; v < G.getV(); v++)
			distTo[v] = INFINITY;
		
		distTo[source] = 0;
		visited[source] = true;
		q.add(source);
		
		while (!q.isEmpty()) {
			int v = q.poll();
			
			for (int w : G.adj(v)) {
				if (!visited[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					visited[w] = true;
					q.add(w);
				}
			}
 		}
	}
	
	private void bfs(Graph G, Iterable<Integer> sources) {
        
		LinkedList<Integer> q = new LinkedList<Integer>();
        
		for (int s : sources) {
			visited[s] = true;
            distTo[s] = 0;
            q.add(s);
        }
        
        while (!q.isEmpty()) {
            int v = q.poll();
            
            for (int w : G.adj(v)) {
                if (!visited[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    visited[w] = true;
                    q.add(w);
                }
            }
        }
    }
	
	public boolean hasPathTo(int v) {
        validateVertex(v);
        return visited[v];
    }
	
	public Iterable<Integer> pathTo(int v) {
		validateVertex(v);
		
		if (!hasPathTo(v))
			return null;
		
		Stack<Integer> path = new Stack<Integer>();
		
		int x;
		for (x = v; distTo[x] != 0; x = edgeTo[x])
			path.push(x);
		
		path.push(x);
		return path;
	}
	
	public int distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }
	
	private void validateVertex(int v) {
        int V = visited.length;
        
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
    }
	
	private void validateVertices(Iterable<Integer> vertices) {
        if (vertices == null) 
            throw new IllegalArgumentException("argument is null");
        
        int V = visited.length;
        
        for (int v : vertices) 
            if (v < 0 || v >= V) 
                throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
    }
}