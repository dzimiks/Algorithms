package dataStructures.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Graph {

	private int V;
	private int E;
	private List<Integer>[] adj;

	public Graph(int V) {
		this.V = V;
		adj = new LinkedList[V];
		
		for (int i = 0; i < V; i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	public Graph(Graph G) {
		this(G.getV());
		this.E = G.getE();
		
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
			throw new IllegalArgumentException("Vertex " + v + " is not betweeen 0 and " + (V - 1));
	}
	
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		E++;
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v) {
		validateVertex(v);
		return adj[v];
	}
	
	public int degree(int v) {
		validateVertex(v);
		return adj[v].size();
	}
	
	@Override
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

	public void setV(int v) {
		V = v;
	}

	public int getE() {
		return E;
	}

	public void setE(int e) {
		E = e;
	}
}