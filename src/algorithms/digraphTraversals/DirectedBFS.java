package algorithms.digraphTraversals;

import java.util.LinkedList;

import dataStructures.digraphs.Digraph;


public class DirectedBFS {

private boolean[] visited;
	
	public DirectedBFS(Digraph G, int source) {
		visited = new boolean[G.getV()];
		validateVertex(source);
		bfs(G, source);
	}
	
	private void bfs(Digraph G, int source) {

		LinkedList<Integer> q = new LinkedList<>();
		
		visited[source] = true;
		q.add(source);
		
		while (!q.isEmpty()) {
			int v = q.poll();
			System.out.print(v + " ");
			
			for (int w : G.adj(v)) {
				if (!visited[w]) {
					visited[w] = true;
					q.add(w);
				}
			}
 		}
		
		System.out.println();
	}
	
	private void validateVertex(int v) {
        int V = visited.length;
        
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
    }
}