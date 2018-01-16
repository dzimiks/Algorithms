package algorithms.mst;

import java.util.ArrayList;
import java.util.Collections;

import dataStructures.graphs.Edge;
import dataStructures.graphs.EdgeWeightedGraph;

public class KruskalMST {

	private int nodeCount;
	private ArrayList<Edge> graphEdges;
	
	public KruskalMST() {
		nodeCount = 0;
		graphEdges = new ArrayList<>();
	}
	
	public KruskalMST(EdgeWeightedGraph G) {
		nodeCount = G.getV();
		graphEdges = new ArrayList<>();
		
		for (Edge edge : G.edges()) 
			graphEdges.add(new Edge(edge.getV(), edge.getW(), edge.getWeight()));
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
			int root1 = nodeSet.find(currEdge.getV());
			int root2 = nodeSet.find(currEdge.getW());
			outputMessage += "find(" + currEdge.getV() + ") returns " + root1 + 
						   ", find(" + currEdge.getW() + ") returns " + root2;
			
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