package dataStructures.graphs;


public class Edge implements Comparable<Edge> {

	private final int v;
    private final int w;
    private final int weight;

    public Edge() {
    	v = w = weight = 0;
    }
    
    public Edge(int v, int w, int weight) {
        if (v < 0) 
        	throw new IllegalArgumentException("Vertex index must be a nonnegative integer");
        if (w < 0) 
        	throw new IllegalArgumentException("Vertex index must be a nonnegative integer");
        
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public int either() {
        return v;
    }
    
    public int getV() {
    	return v;
    }

    public int getW() {
    	return w;
    }
    
    public int other(int vertex) {
        if (vertex == v)
        	return w;
        else if (vertex == w)
        	return v;
        else 
        	throw new IllegalArgumentException("Illegal endpoint");
    }

    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(this.weight, edge.weight);
    }

    @Override
    public String toString() {
        return String.format("%d -> %d (%d)", v, w, weight);
    }
}