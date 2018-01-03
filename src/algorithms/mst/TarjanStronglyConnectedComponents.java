package algorithms.mst;

import java.util.Stack;

import dataStructures.digraphs.Digraph;

public class TarjanStronglyConnectedComponents {

	private boolean[] visited;        
    private int[] id;                
    private int[] low;               
    private int pre;                 
    private int count;               
    private Stack<Integer> stack;

    public TarjanStronglyConnectedComponents(Digraph G) {
        visited = new boolean[G.getV()];
        stack = new Stack<Integer>();
        id = new int[G.getV()]; 
        low = new int[G.getV()];
        
        for (int v = 0; v < G.getV(); v++) 
            if (!visited[v]) dfs(G, v);
    }

    private void dfs(Digraph G, int v) { 
    	
        visited[v] = true;
        low[v] = pre++;
        int min = low[v];
        stack.push(v);
        
        for (int w : G.adj(v)) {
            if (!visited[w]) 
            	dfs(G, w);
            
            if (low[w] < min) 
            	min = low[w];
        }
        
        if (min < low[v]) {
            low[v] = min;
            return;
        }
        
        int w;
        
        do {
            w = stack.pop();
            id[w] = count;
            low[w] = G.getV();
        } while (w != v);
        
        count++;
    }

    public int getCount() {
        return count;
    }

    public boolean isStronglyConnected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id[v] == id[w];
    }

    public int id(int v) {
        validateVertex(v);
        return id[v];
    }

    private void validateVertex(int v) {
        int V = visited.length;

        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
    }
}