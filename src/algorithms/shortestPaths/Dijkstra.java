package algorithms.shortestPaths;

public class Dijkstra {

	public int minDistance(int V, int[] dist, boolean[] sptSet) {
		
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for (int v = 0; v < V; v++) {
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				minIndex = v;
			}
		}
				
		return minIndex;
	}
	
	public void djikstra(int V, int[][] graph, int source) {
		
		int[] dist = new int[V];
		boolean[] sptSet = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		dist[source] = 0;
		
		for (int cnt = 0; cnt < V - 1; cnt++) {
			int u = minDistance(V, dist, sptSet);
			
			sptSet[u] = true;
			
			for (int v = 0; v < V; v++) {
				if (!sptSet[v] && graph[u][v] != 0 && 
					dist[u] != Integer.MAX_VALUE &&
					dist[u] + graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
			}
		}
		
		System.out.println("Vertex  Distance");
		for (int v = 0; v < V; v++) 
			System.out.println("  " + v + " ----- " + dist[v]);
	}
}