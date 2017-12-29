package algorithms.mst;

public class PrimMST {

	public int minKey(int V, int[] key, boolean[] mstSet) {
		
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for (int v = 0; v < V; v++) {
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				minIndex = v;
			}
		}
		
		return minIndex;
	}
	
	public void primMST(int[][] graph, int V) {
		
		int[] parent = new int[V];
		int[] key = new int[V];
		boolean[] mstSet = new boolean[V];
		
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		
		key[0] = 0;
		parent[0] = -1;
		
		for (int cnt = 0; cnt < V - 1; cnt++) {
			int u = minKey(V, key, mstSet);
			mstSet[u] = true;
			
			for (int v = 0; v < V; v++) {
				if (graph[u][v] != 0 && mstSet[v] == false &&
					graph[u][v] < key[v]) {
					
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}
		
		int minWeight = 0;
		System.out.println("Edge   Weight");
		
		for (int i = 1; i < V; i++) {
        	minWeight += graph[i][parent[i]];
        	System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
        }
		
		System.out.println("\nMin weight: " + minWeight);
	}
}