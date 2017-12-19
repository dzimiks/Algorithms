package algorithms.graphTraversals;

import dataStructures.graphs.Graph;

public class DFS {

	private boolean[] marked;
	private int count;
	
	public DFS(Graph G, int s) {
		marked = new boolean[G.getV()];
		validateVertex(s);
		dfs(G, s);
	}
	
	private void dfs(Graph G, int v) {
		count++;
		marked[v] = true;
		
		for (int w : G.adj(v)) {
			if (!marked[w])
				dfs(G, w);
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