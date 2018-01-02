package dataStructures.graphs;

import java.util.LinkedList;
import java.util.Stack;

import dataStructures.In;

public class EdgeWeightedGraph {

	private final int V;
    private int E;
    private LinkedList<Edge>[] adj;
    
    public EdgeWeightedGraph(int V) {
        if (V < 0) 
        	throw new IllegalArgumentException("Number of vertices must be nonnegative");
        
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Edge>[]) new LinkedList[V];
        
        for (int v = 0; v < V; v++) 
            adj[v] = new LinkedList<Edge>();
    }

    public EdgeWeightedGraph(EdgeWeightedGraph G) {
        this(G.getV());
        this.E = G.getE();

        for (int v = 0; v < G.getV(); v++) {
            Stack<Edge> reverse = new Stack<Edge>();
            for (Edge e : G.adj[v]) 
                reverse.push(e);
            
            for (Edge e : reverse) 
                adj[v].add(e);
        }
    }
    
    public EdgeWeightedGraph(In in) {
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
            Edge e = new Edge(v, w, weight);
            addEdge(e);
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

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        
        validateVertex(v);
        validateVertex(w);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    public Iterable<Edge> edges() {
    	
    	LinkedList<Edge> list = new LinkedList<Edge>();
    	
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
        
            for (Edge e : adj(v)) {
                if (e.other(v) > v) 
                    list.add(e);
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) 
                    	list.add(e);
                    
                    selfLoops++;
                }
            }
        }
        
        return list;
    }

    public String toString() {
    	
    	StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges\n\n");
		
		for (int v = 0; v < V; v++) {
			sb.append(v + ": ");
			
			for (Edge e : adj[v]) 
				sb.append(e + " ");
			
			sb.append("\n");
		}
		
		return sb.toString();
    }
}