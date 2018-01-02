package algorithms.digraphTraversals;

import java.util.Stack;

import dataStructures.digraphs.Digraph;

public class DirectedDFSPaths {

	private boolean[] visited;
    private int[] edgeTo;      
    private final int s;       

    public DirectedDFSPaths(Digraph G, int s) {
        visited = new boolean[G.getV()];
        edgeTo = new int[G.getV()];
        this.s = s;
        validateVertex(s);
        dfs(G, s);
    }

    private void dfs(Digraph G, int v) { 
        visited[v] = true;

        for (int w : G.adj(v)) {
            if (!visited[w]) {
                edgeTo[w] = v;
                dfs(G, w);
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
        
        for (int x = v; x != s; x = edgeTo[x])
            path.push(x);
        
        path.push(s);
        return path;
    }

    private void validateVertex(int v) {
        int V = visited.length;

        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
    }
}