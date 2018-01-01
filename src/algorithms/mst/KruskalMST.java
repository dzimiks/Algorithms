package algorithms.mst;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalMST {

	private int nodeCount;
	private ArrayList<Edge> graphEdges;
	
	public KruskalMST() {
		graphEdges = new ArrayList<Edge>();
		nodeCount = 0;
	}

	public void add(Edge edge) {
		graphEdges.add(edge);
		nodeCount++;
	}
	
	public int getNodeCount() {
		return nodeCount;
	}

	public ArrayList<Edge> getGraphEdges() {
		return graphEdges;
	}

	public void kruskalMST() {
		
		String outputMessage = "";
		Collections.sort(graphEdges);
		ArrayList<Edge> mstEdges = new ArrayList<Edge>();
		DisjointSet nodeSet = new DisjointSet(nodeCount + 1);
		
		for (int i = 1; i < graphEdges.size() && mstEdges.size() < (nodeCount - 1); i++) {
			Edge currEdge = graphEdges.get(i);
			int root1 = nodeSet.find(currEdge.getVertex1());
			int root2 = nodeSet.find(currEdge.getVertex2());
			outputMessage += "find(" + currEdge.getVertex1() + ") returns " + root1 + 
						   ", find(" + currEdge.getVertex2() + ") returns " + root2;
			
			String unionMessage = ",\tNo union performed\n";	
			
			if (root1 != root2) {			
				mstEdges.add(currEdge);	
				nodeSet.union(root1, root2);	
				unionMessage = ",\tUnion(" + root1 + ", " + root2 + ") done\n";		
			}
			
			outputMessage += unionMessage;
		}
		
		outputMessage += "\nFinal Minimum Spanning Tree (" + mstEdges.size() + " edges)\n";
		int mstTotalEdgeWeight = 0;

		for (Edge edge: mstEdges) {
			outputMessage += edge + "\n";		
			mstTotalEdgeWeight += edge.getWeight();
		}
		
		outputMessage += "\nTotal weight of all edges in MST: " + mstTotalEdgeWeight;
		System.out.println(outputMessage);
	}
}