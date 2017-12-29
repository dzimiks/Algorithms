package algorithms;

import algorithms.mst.PrimMST;

public class MainMST {

	public static void main(String[] args) {
		
		PrimMST primMST = new PrimMST();
		int[][] graph = {{0, 2, 0, 6, 0},
		                 {2, 0, 3, 8, 5},
		                 {0, 3, 0, 0, 7},
		                 {6, 8, 0, 0, 9},
		                 {0, 5, 7, 9, 0}};
		
		primMST.primMST(graph, 5);
	}
}