package algorithms.mst;

import java.util.LinkedList;

import dataStructures.In;
import dataStructures.graphs.Edge;
import dataStructures.graphs.EdgeWeightedGraph;
import dataStructures.heaps.MinPriorityQueue;

public class Kruskal {

	public static void main(String[] args) {
		
		In in = new In("tests/small-ewg.txt");
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		Kruskal mst = new Kruskal(G);
		
		for (Edge e : mst.edges())
			System.out.println(e);
		
		System.out.println("\nWeight: " + mst.weight());
	}
	
	private int weight;                        
    private LinkedList<Edge> mst = new LinkedList<Edge>();  

    public Kruskal(EdgeWeightedGraph G) {
       
    	MinPriorityQueue<Edge> pq = new MinPriorityQueue<Edge>();
        
    	for (Edge e : G.edges()) {
            pq.insert(e);
        }

        UF uf = new UF(G.getV());
        
        while (!pq.isEmpty() && mst.size() < G.getV() - 1) {
            Edge e = pq.delMin();
            int v = e.either();
            int w = e.other(v);

            if (!uf.isConnected(v, w)) { 
                uf.union(v, w);  
                mst.add(e);  
                weight += e.getWeight();
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public int weight() {
        return weight;
    }
}