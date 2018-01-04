package dataStructures.digraphs;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class AdjMatrixEdgeWeightedDigraph {

	private final int V;
    private int E;
    private DirectedEdge[][] adj;
    
    public AdjMatrixEdgeWeightedDigraph(int V) {
        if (V < 0) 
        	throw new IllegalArgumentException("Number of vertices must be nonnegative");

        this.V = V;
        this.E = 0;
        this.adj = new DirectedEdge[V][V];
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        int v = e.from();
        int w = e.to();

        validateVertex(v);
        validateVertex(w);
        
        if (adj[v][w] == null) {
            E++;
            adj[v][w] = e;
        }
    }

    public Iterable<DirectedEdge> adj(int v) {
        validateVertex(v);
        return new AdjIterator(v);
    }

    private class AdjIterator implements Iterator<DirectedEdge>, Iterable<DirectedEdge> {

    	private int v;
        private int w = 0;

        public AdjIterator(int v) {
            this.v = v;
        }

        public Iterator<DirectedEdge> iterator() {
            return this;
        }

        public boolean hasNext() {
            while (w < V) {
                if (adj[v][w] != null) 
                	return true;
 
                w++;
            }
            
            return false;
        }

        public DirectedEdge next() {
            if (!hasNext()) 
                throw new NoSuchElementException();
            
            return adj[v][w++];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public String toString() {
    	
    	StringBuilder sb = new StringBuilder();
		sb.append(V + " vertices, " + E + " edges\n\n");
		
		for (int v = 0; v < V; v++) {
			sb.append(v + ": ");
			
			for (DirectedEdge e : adj(v)) 
				sb.append(e + " ");
			
			sb.append("\n");
		}
		
		return sb.toString();
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
    }
}