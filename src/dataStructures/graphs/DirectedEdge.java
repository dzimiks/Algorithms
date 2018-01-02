package dataStructures.graphs;

public class DirectedEdge {

	private final int v;
    private final int w;
    private final int weight;

    public DirectedEdge(int v, int w, int weight) {
        if (v < 0) 
        	throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        
        if (w < 0) 
        	throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }

    public String toString() {
        return String.format("%d -> %d (%d)", v, w, weight);
    }
}