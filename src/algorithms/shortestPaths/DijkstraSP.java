package algorithms.shortestPaths;

import java.util.Stack;

import dataStructures.In;
import dataStructures.digraphs.DirectedEdge;
import dataStructures.digraphs.EdgeWeightedDigraph;
import dataStructures.heaps.IndexMinPriorityQueue;

public class DijkstraSP {

	public static void main(String[] args) {
		
		In in = new In("tests/small-ewd.txt");
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(in);
		int s = 0;
		DijkstraSP sp = new DijkstraSP(G, s);
		
		for (int i = 0; i < G.getV(); i++) {
			if (sp.hasPathTo(i)) {
				System.out.format("%d to %d (%d) ", s, i, sp.distTo(i));
				
				for (DirectedEdge e : sp.pathTo(i))
					System.out.print(e + " ");
				
				System.out.println();
			}
			else 
				System.out.printf("%d to %d no path\n", s, i);
		}
	}
	
	private int[] distTo;          
    private DirectedEdge[] edgeTo;    
    private IndexMinPriorityQueue<Integer> pq;    

    public DijkstraSP(EdgeWeightedDigraph G, int s) {

    	for (DirectedEdge e : G.edges()) 
            if (e.weight() < 0)
                throw new IllegalArgumentException("Edge " + e + " has negative weight");

        distTo = new int[G.getV()];
        edgeTo = new DirectedEdge[G.getV()];

        validateVertex(s);

        for (int v = 0; v < G.getV(); v++)
            distTo[v] = Integer.MAX_VALUE;

        distTo[s] = 0;

        pq = new IndexMinPriorityQueue<Integer>(G.getV());
        pq.insert(s, distTo[s]);
        
        while (!pq.isEmpty()) {
            int v = pq.delMin();
        
            for (DirectedEdge e : G.adj(v))
                relax(e);
        }
    }

    private void relax(DirectedEdge e) {
        int v = e.from();
        int w = e.to();
        
        if (distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            
            if (pq.contains(w))
            	pq.decreaseKey(w, distTo[w]);
            else 
            	pq.insert(w, distTo[w]);
        }
    }

    public int distTo(int v) {
        validateVertex(v);
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        validateVertex(v);
        return distTo[v] < Integer.MAX_VALUE;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        validateVertex(v);

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