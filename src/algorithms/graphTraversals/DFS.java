package algorithms.graphTraversals;

import java.util.Iterator;
import java.util.Stack;

import dataStructures.graphs.Graph;

public class DFS {

	private boolean[] marked;
	private int count;
	
	public DFS(Graph G, int s) {
		marked = new boolean[G.getV()];
		validateVertex(s);
		dfs(G, s);
//		iterativeDFS(G, s);
	}
	
	private void dfs(Graph G, int v) {
		count++;
		marked[v] = true;
		
		for (int w : G.adj(v)) {
			if (!marked[w])
				dfs(G, w);
		}
	}
	
	private void iterativeDFS(Graph G, int s) {
        marked = new boolean[G.getV()];
        validateVertex(s);
        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.getV()];
        
        for (int v = 0; v < G.getV(); v++)
            adj[v] = G.adj(v).iterator();

        Stack<Integer> stack = new Stack<Integer>();
        marked[s] = true;
        stack.push(s);

        while (!stack.isEmpty()) {
            int v = stack.peek();

            if (adj[v].hasNext()) {
                int w = adj[v].next();

                if (!marked[w]) {
                    marked[w] = true;
                    stack.push(w);
                }
            }
            else 
                stack.pop();
        }
    }
	
	public boolean isMarked(int v) {
		validateVertex(v);
		return marked[v];
	}

	public int getCount() {
		return count;
	}
	
	private void validateVertex(int v) {
		int V = marked.length;
		
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
	}
}