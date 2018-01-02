package dataStructures.digraphs;

import java.util.LinkedList;
import java.util.Stack;

import dataStructures.In;

public class EdgeWeightedDigraph {

	private final int V;                
    private int E;                      
    private LinkedList<DirectedEdge>[] adj;    
    private int[] indegree;             
    
    public EdgeWeightedDigraph(int V) {
        if (V < 0) 
        	throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");
        
        this.V = V;
        this.E = 0;
        this.indegree = new int[V];
        adj = (LinkedList<DirectedEdge>[]) new LinkedList[V];
        
        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<DirectedEdge>();
    }

    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        
        if (E < 0) 
        	throw new IllegalArgumentException("Number of edges must be nonnegative");
        
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            validateVertex(v);
            validateVertex(w);
            int weight = in.readInt();
            addEdge(new DirectedEdge(v, w, weight));
        }
    }

    public EdgeWeightedDigraph(EdgeWeightedDigraph G) {
        this(G.getV());
        this.E = G.getE();
        
        for (int v = 0; v < G.getV(); v++)
            this.indegree[v] = G.indegree(v);
        
        for (int v = 0; v < G.getV(); v++) {
            Stack<DirectedEdge> reverse = new Stack<DirectedEdge>();

            for (DirectedEdge e : G.adj[v]) 
                reverse.push(e);

            for (DirectedEdge e : reverse) 
                adj[v].add(e);
        }
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();

        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        indegree[w]++;
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
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

    public Iterable<DirectedEdge> edges() {
        LinkedList<DirectedEdge> list = new LinkedList<DirectedEdge>();
        
        for (int v = 0; v < V; v++) 
            for (DirectedEdge e : adj(v)) 
                list.add(e);

        return list;
    } 

    @Override
    public String toString() {
    	
    	StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges\n\n");
		
		for (int v = 0; v < V; v++) {
			sb.append(v + ": ");
			
			for (DirectedEdge e : adj[v]) 
				sb.append(e + " ");
			
			sb.append("\n");
		}
		
		return sb.toString();
    }
}