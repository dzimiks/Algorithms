package algorithms;

import algorithms.shortestPaths.BellmanFord;
import algorithms.shortestPaths.Dijkstra;
import algorithms.shortestPaths.FloydWarshall;
import dataStructures.In;
import dataStructures.graphs.Edge;
import dataStructures.graphs.EdgeWeightedGraph;

public class MainShortestPaths {

	public static void main(String[] args) {
		
		In in = new In("tests/small-ewg.txt");
		int[][] graph = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
			             {4, 0, 8, 0, 0, 0, 0, 11, 0},
			             {0, 8, 0, 7, 0, 4, 0, 0, 2},
			             {0, 0, 7, 0, 9, 14, 0, 0, 0},
			             {0, 0, 0, 9, 0, 10, 0, 0, 0},
			             {0, 0, 4, 14, 10, 0, 2, 0, 0},
			             {0, 0, 0, 0, 0, 2, 0, 1, 6},
			             {8, 11, 0, 0, 0, 0, 1, 0, 7},
			             {0, 0, 2, 0, 0, 0, 6, 7, 0}};
		
		// Dijkstra
		System.out.println("Dijkstra\n");
		Dijkstra djikstra = new Dijkstra();
		djikstra.djikstra(9, graph, 0);

		// Bellman-Ford
		System.out.println("\nBellman-Ford\n");
		EdgeWeightedGraph G = new EdgeWeightedGraph(in);
		BellmanFord bellmanFord = new BellmanFord();

//		G.addEdge(new Edge(0, 1, -1));
//		G.addEdge(new Edge(0, 2, 4));
//		G.addEdge(new Edge(1, 2, 3));
//		G.addEdge(new Edge(1, 3, 2));
//		G.addEdge(new Edge(1, 4, 2));
//		G.addEdge(new Edge(3, 2, 5));
//		G.addEdge(new Edge(3, 1, 1));
//		G.addEdge(new Edge(4, 3, -3));
	
		bellmanFord.bellmanFord(G, 1);
		
		// Floyd-Warshall
		/* 
	           10
	     (0)------->(3)
	      |         /|\
	   5  |          |
	      |          | 1
	     \|/         |
	     (1)------->(2)
	           3     
	    */
		System.out.println("\nFloyd-Warshall\n");
		FloydWarshall floydWarshall = new FloydWarshall();
		final int INF = Integer.MAX_VALUE;
		int graphFW[][] = {{0,  5,   INF, 10},
		                  {INF, 0,   3,   INF},
		                  {INF, INF, 0,   1},
		                  {INF, INF, INF, 0}};
		
		floydWarshall.floydWarshall(graphFW, 4);
	}
}