package dataStructures.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Digraph {

	private int V;
	private int E;
	private List<Integer>[] adj;
	private int[] indegree;
	
	public Digraph(int V) {
		this.V = V;
		this.E = 0;
		indegree = new int[V];
		adj = new LinkedList[V];
		
		for (int v = 0; v < V; v++)
			adj[v] = new LinkedList<Integer>();
	}
	
	public Digraph(Digraph G) {
		this(G.getV());
		this.E = G.getE();
		
		for (int v = 0; v < V; v++)
			this.indegree[v] = G.getIndegree(v);
		
		for (int v = 0; v < G.getV(); v++) {
			Stack<Integer> reverse = new Stack<Integer>();
			
			for (int w : G.adj[v])
				reverse.push(w);
			
			for (int w : reverse)
				adj[v].add(w);
		}
	}

	private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
    }
	
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		adj[v].add(w);
		indegree[w]++;
		E++;
	}
	
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}
	
	public int outdegree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
	
	public int indegree(int v) {
		validateVertex(v);
		return indegree[v];
	}
	
	public Digraph reverse() {
		Digraph reverse = new Digraph(V);
		
		for (int v = 0; v < V; v++) {
			for (int w : adj(v))
				reverse.addEdge(w, v);
		}
		
		return reverse;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges\n");
		
		for (int v = 0; v < V; v++) {
			sb.append(v + ": ");
			
			for (int w : adj[v]) 
				sb.append(w + " ");
			
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public int getV() {
		return V;
	}

	public int getE() {
		return E;
	}

	public int getIndegree(int v) {
		validateVertex(v);
		return indegree[v];
	}
}