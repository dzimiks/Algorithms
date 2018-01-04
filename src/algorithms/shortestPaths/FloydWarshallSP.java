package algorithms.shortestPaths;

import java.util.Stack;

import dataStructures.digraphs.AdjMatrixEdgeWeightedDigraph;
import dataStructures.digraphs.DirectedEdge;
import dataStructures.digraphs.EdgeWeightedDigraph;
import dataStructures.digraphs.EdgeWeightedDirectedCycle;

public class FloydWarshallSP {
	
	private boolean hasNegativeCycle;  
    private int[][] distTo;         
    private DirectedEdge[][] edgeTo;   

    public FloydWarshallSP(AdjMatrixEdgeWeightedDigraph G) {

    	int V = G.getV();
        distTo = new int[V][V];
        edgeTo = new DirectedEdge[V][V];

        for (int v = 0; v < V; v++) 
            for (int w = 0; w < V; w++) 
                distTo[v][w] = Integer.MAX_VALUE;

        for (int v = 0; v < G.getV(); v++) {
            for (DirectedEdge e : G.adj(v)) {
                distTo[e.from()][e.to()] = e.weight();
                edgeTo[e.from()][e.to()] = e;
            }

            if (distTo[v][v] >= 0) {
                distTo[v][v] = 0;
                edgeTo[v][v] = null;
            }
        }

        for (int i = 0; i < V; i++) {
            for (int v = 0; v < V; v++) {
                if (edgeTo[v][i] == null) 
                	continue;  
                
                for (int w = 0; w < V; w++) {
                    if (distTo[v][w] > distTo[v][i] + distTo[i][w]) {
                        distTo[v][w] = distTo[v][i] + distTo[i][w];
                        edgeTo[v][w] = edgeTo[i][w];
                    }
                }

                if (distTo[v][v] < 0) {
                    hasNegativeCycle = true;
                    return;
                }
            }
        }
    }

    public boolean hasNegativeCycle() {
        return hasNegativeCycle;
    }

    public Iterable<DirectedEdge> negativeCycle() {
        for (int v = 0; v < distTo.length; v++) {
            if (distTo[v][v] < 0.0) {
                int V = edgeTo.length;
                EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);

                for (int w = 0; w < V; w++)
                    if (edgeTo[v][w] != null)
                        spt.addEdge(edgeTo[v][w]);
                
                EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(spt);
                assert finder.hasCycle();
                return finder.cycle();
            }
        }
        
        return null;
    }

    public boolean hasPath(int s, int t) {
        validateVertex(s);
        validateVertex(t);
        return distTo[s][t] < Integer.MAX_VALUE;
    }

    public int dist(int s, int t) {
        validateVertex(s);
        validateVertex(t);
        
        if (hasNegativeCycle())
            throw new UnsupportedOperationException("Negative cost cycle exists");
        
        return distTo[s][t];
    }

    public Iterable<DirectedEdge> path(int s, int t) {
        validateVertex(s);
        validateVertex(t);
        
        if (hasNegativeCycle())
            throw new UnsupportedOperationException("Negative cost cycle exists");
        
        if (!hasPath(s, t)) 
        	return null;
        
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        
        for (DirectedEdge e = edgeTo[s][t]; e != null; e = edgeTo[s][e.from()]) 
            path.push(e);
        
        return path;
    }

    private void validateVertex(int v) {
        int V = distTo.length;

        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
    }
}