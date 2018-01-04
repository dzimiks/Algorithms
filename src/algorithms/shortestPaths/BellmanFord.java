package algorithms.shortestPaths;

import dataStructures.graphs.Edge;
import dataStructures.graphs.EdgeWeightedGraph;

public class BellmanFord {

	public void bellmanFord(EdgeWeightedGraph graph, int src) {
		
		int V = graph.getV();
		int E = graph.getE();
	    int[] dist = new int[V];
	    Edge[] edges = new Edge[E];
	    int cnt = 0;

	    for (Edge edge : graph.edges()) {
	    	edges[cnt] = new Edge(edge.getV(), edge.getW(), edge.getWeight());
	  		cnt++;
	    }
	    
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
   
        dist[src] = 0;
	 
        for (int i = 1; i < V; i++) {
            for (int j = 0; j < E; j++) {
            	int u = edges[j].getV();
            	int v = edges[j].getW();
            	int weight = edges[j].getWeight();
            	
                if (dist[u] != Integer.MAX_VALUE &&
                    dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }
	 
        for (int j = 0; j < E; j++) {
        	int u = edges[j].getV();
        	int v = edges[j].getW();
        	int weight = edges[j].getWeight();
            
            if (dist[u] != Integer.MAX_VALUE &&
                dist[u] + weight < dist[v])
            	System.out.println("Graph contains negative weight cycle");
        }
        
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + "\t\t" + dist[i]);
	}
}