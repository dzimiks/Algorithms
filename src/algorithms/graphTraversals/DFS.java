package algorithms.graphTraversals;

import java.util.Iterator;
import java.util.Stack;

import dataStructures.graphs.Graph;

public class DFS {

	private boolean[] visited;
	private int count;
	
	public DFS(Graph G, int s) {
		visited = new boolean[G.getV()];
		validateVertex(s);
		dfs(G, s);
//		iterativeDFS(G, s);
	}
	
	private void dfs(Graph G, int v) {
		count++;
		visited[v] = true;
		System.out.print(v + " ");
		
		for (int w : G.adj(v)) {
			if (!visited[w])
				dfs(G, w);
		}
	}
	
	private void iterativeDFS(Graph G, int s) {
		visited = new boolean[G.getV()];
        validateVertex(s);
        Iterator<Integer>[] adj = (Iterator<Integer>[]) new Iterator[G.getV()];
        
        for (int v = 0; v < G.getV(); v++)
            adj[v] = G.adj(v).iterator();

        Stack<Integer> stack = new Stack<Integer>();
        visited[s] = true;
        stack.push(s);

        while (!stack.isEmpty()) {
            int v = stack.peek();

            if (adj[v].hasNext()) {
                int w = adj[v].next();

                if (!visited[w]) {
                	visited[w] = true;
                    stack.push(w);
                }
            }
            else 
                stack.pop();
        }
    }
	
	public boolean isMarked(int v) {
		validateVertex(v);
		return visited[v];
	}

	public int getCount() {
		return count;
	}
	
	private void validateVertex(int v) {
		int V = visited.length;
		
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
	}
}