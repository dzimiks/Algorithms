package algorithms.mst;

import java.util.LinkedList;

import dataStructures.In;
import dataStructures.graphs.Edge;
import dataStructures.graphs.EdgeWeightedGraph;
import dataStructures.heaps.IndexMinPriorityQueue;

public class Prim {

	public static void main(String[] args) {
		
		In in = new In("tests/small-ewg.txt");
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		Prim mst = new Prim(G);
		
		for (Edge e : mst.edges())
			System.out.println(e);
		
		System.out.println("\nWeight: " + mst.weight());
	}
	
	private Edge[] edgeTo;        
    private int[] distTo;      
    private boolean[] visited;     
    private IndexMinPriorityQueue<Integer> pq;

    public Prim(EdgeWeightedGraph G) {
        edgeTo = new Edge[G.getV()];
        distTo = new int[G.getV()];
        visited = new boolean[G.getV()];
        pq = new IndexMinPriorityQueue<Integer>(G.getV());
        
        for (int v = 0; v < G.getV(); v++)
            distTo[v] = Integer.MAX_VALUE;

        for (int v = 0; v < G.getV(); v++)      
            if (!visited[v])
            	prim(G, v);    
    }

    private void prim(EdgeWeightedGraph G, int s) {
        distTo[s] = 0;
        pq.insert(s, distTo[s]);
        
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            scan(G, v);
        }
    }

    private void scan(EdgeWeightedGraph G, int v) {
        visited[v] = true;
        
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            
            if (visited[w])
            	continue;         
            
            if (e.getWeight() < distTo[w]) {
                distTo[w] = e.getWeight();
                edgeTo[w] = e;
                
                if (pq.contains(w)) 
                	pq.decreaseKey(w, distTo[w]);
                else                
                	pq.insert(w, distTo[w]);
            }
        }
    }

    public Iterable<Edge> edges() {
        LinkedList<Edge> mst = new LinkedList<Edge>();
       
        for (int v = 0; v < edgeTo.length; v++) {
            Edge e = edgeTo[v];
        
            if (e != null) 
                mst.add(e);
        }
        
        return mst;
    }

    public int weight() {
        int weight = 0;
        
        for (Edge e : edges())
            weight += e.getWeight();

        return weight;
    }
}