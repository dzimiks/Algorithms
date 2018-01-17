package algorithms.shortestPaths;

public class FloydWarshall {

	public void floydWarshall(int[][] graph, int V) {
		
		int[][] dist = new int[V][V];
		
		for (int i = 0; i < V; i++)
			for (int j = 0; j < V; j++)
				dist[i][j] = graph[i][j];
		
		for (int i = 0; i < V; i++) 
			for (int j = 0; j < V; j++)
				for (int k = 0; k < V; k++)
					if (dist[j][i] != Integer.MAX_VALUE && 
						dist[i][k] != Integer.MAX_VALUE && 
					    dist[j][i] + dist[i][k] < dist[j][k])
						dist[j][k] = dist[j][i] + dist[i][k];
		
		System.out.println("Following matrix shows the shortest " +
                		   "distances between every pair of vertices\n");
	
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (dist[i][j] == Integer.MAX_VALUE)
					System.out.print("INF ");
				else
					System.out.printf("%3d ", dist[i][j]);
		   }
		   
		   System.out.println();
		}
	}
}