package algorithms.graphTraversals;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import dataStructures.graphs.Graph;

public class TopologicalSort {

	private int V;
	private LinkedList<Integer>[] adj;
	
	public TopologicalSort(Graph G) {
		this.V = G.getV();
		this.adj = new LinkedList[V];
		
		for (int i = 0; i < G.getV(); i++)
			adj[i] = new LinkedList<Integer>();
		
		for (int i = 0; i < V; i++)
			adj[i] = (LinkedList<Integer>) G.adj(i);
	}
	
	public void topologicalSort() {
		
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V];
		
		for (int i = 0; i < V; i++)
			visited[i] = false;
		
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				topologicalSortUtil(i, visited, stack);
		
		while (!stack.isEmpty()) 
			System.out.print(stack.pop() + " ");
		
		System.out.println();
	}
	
	public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {

		visited[v] = true;
		int i;
		
		Iterator<Integer> it = adj[v].iterator();
		
		while (it.hasNext()) {
			i = it.next();
			
			if (!visited[i])
				topologicalSortUtil(i, visited, stack);
		}
		
		stack.push(v);
	}
}