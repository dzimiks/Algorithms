package algorithms.graphTraversals;

import java.util.LinkedList;
import java.util.Stack;

import dataStructures.graphs.Graph;


public class BFSPaths {

	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	
	public BFSPaths(Graph G, int source) {
		marked = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		distTo = new int[G.getV()];
		validateVertex(source);
		bfs(G, source);
	}
	
	private void bfs(Graph G, int source) {

		LinkedList<Integer> q = new LinkedList<>();
		
		for (int v = 0; v < G.getV(); v++)
			distTo[v] = INFINITY;
		
		distTo[source] = 0;
		marked[source] = true;
		q.add(source);
		
		while (!q.isEmpty()) {
			int v = q.poll();
			
			for (int w : G.adj(v)) {
				if (!marked[w]) {
					edgeTo[w] = v;
					distTo[w] = distTo[v] + 1;
					marked[w] = true;
					q.add(w);
				}
			}
 		}
	}
	
	public boolean hasPathTo(int v) {
        validateVertex(v);
        return marked[v];
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
        int V = marked.length;
        
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
    }
}