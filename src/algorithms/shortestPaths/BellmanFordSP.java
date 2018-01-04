package algorithms.shortestPaths;

import java.util.LinkedList;
import java.util.Stack;

import dataStructures.In;
import dataStructures.digraphs.DirectedEdge;
import dataStructures.digraphs.EdgeWeightedDigraph;
import dataStructures.digraphs.EdgeWeightedDirectedCycle;

public class BellmanFordSP {

	public static void main(String[] args) {
		
		In in = new In("tests/small-ewd.txt");
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
		int s = 0;
		BellmanFordSP sp = new BellmanFordSP(G, s);
		
		System.out.println(G);
		
		if (sp.hasNegativeCycle()) 
			for (DirectedEdge e : sp.negativeCycle())
				System.out.println(e);
		else {
			for (int v = 0; v < G.getV(); v++) {
				if (sp.hasPathTo(v)) {
					System.out.printf("%d - %d (%d) ", s, v, sp.distTo(v));
					
					for (DirectedEdge e : sp.pathTo(v))
						System.out.print(e + " ");
					
					System.out.println();
				}
				else
					System.out.printf("%d - %d no path\n", s, v);
			}
		}
	}
	
	private int[] distTo;               
    private DirectedEdge[] edgeTo;         
    private boolean[] onQueue;             
    private LinkedList<Integer> queue;     
    private int cost;                      
    private Iterable<DirectedEdge> cycle;  

    public BellmanFordSP(EdgeWeightedDigraph G, int s) {
     
    	distTo = new int[G.getV()];
        edgeTo = new DirectedEdge[G.getV()];
        onQueue = new boolean[G.getV()];
        
        for (int v = 0; v < G.getV(); v++)
            distTo[v] = Integer.MAX_VALUE;
        
        distTo[s] = 0;

        queue = new LinkedList<Integer>();
        queue.add(s);
        onQueue[s] = true;
        
        while (!queue.isEmpty() && !hasNegativeCycle()) {
            int v = queue.poll();
            onQueue[v] = false;
            relax(G, v);
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {

    	for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
        
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
            
                if (!onQueue[w]) {
                    queue.add(w);
                    onQueue[w] = true;
                }
            }
            
            if (cost++ % G.getV() == 0) {
                findNegativeCycle();
                
                if (hasNegativeCycle()) 
                	return;  
            }
        }
    }

    public boolean hasNegativeCycle() {
        return cycle != null;
    }

    public Iterable<DirectedEdge> negativeCycle() {
        return cycle;
    }

    private void findNegativeCycle() {

    	int V = edgeTo.length;
        EdgeWeightedDigraph spt = new EdgeWeightedDigraph(V);
        
        for (int v = 0; v < V; v++)
            if (edgeTo[v] != null)
                spt.addEdge(edgeTo[v]);

        EdgeWeightedDirectedCycle finder = new EdgeWeightedDirectedCycle(spt);
        cycle = finder.cycle();
    }

    public int distTo(int v) {
        validateVertex(v);

        if (hasNegativeCycle())
            throw new UnsupportedOperationException("Negative cost cycle exists");
        
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return distTo[v] < Integer.MAX_VALUE;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        validateVertex(v);
        
        if (hasNegativeCycle())
            throw new UnsupportedOperationException("Negative cost cycle exists");
        
        if (!hasPathTo(v)) 
        	return null;
        
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) 
            path.push(e);
        
        return path;
    }

    private void validateVertex(int v) {
        int V = distTo.length;

        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
    }
}