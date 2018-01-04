package algorithms.mst;

import dataStructures.In;

public class UnionFind {

	public static void main(String[] args) {
		
		In in = new In("tests/medium-uf.txt");
		int n = in.readInt();
		UnionFind uf = new UnionFind(n);
		
		while (!in.isEmpty()) {
			int p = in.readInt();
			int q = in.readInt();
			
			if (uf.isConnected(p, q))
				continue;
			
			uf.union(p, q);
			System.out.format("%3d <-> %3d\n", p, q);
		}
		
		System.out.println("\nNumber of components: " + uf.getCount());
	}
	
	private int[] parent;  
    private byte[] rank;  
    private int count;    

    public UnionFind(int n) {
        if (n < 0) 
        	throw new IllegalArgumentException();
        
        count = n;
        parent = new int[n];
        rank = new byte[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int p) {
        validate(p);
        
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];    
            p = parent[p];
        }
        
        return p;
    }

    public int getCount() {
        return count;
    }
  
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
  
    public void union(int p, int q) {
    	
        int rootP = find(p);
        int rootQ = find(q);
        
        if (rootP == rootQ) 
        	return;

        if (rank[rootP] < rank[rootQ]) 
        	parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ])
        	parent[rootQ] = rootP;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        
        count--;
    }

    private void validate(int p) {
        int n = parent.length;

        if (p < 0 || p >= n) 
            throw new IllegalArgumentException("Index " + p + " is not between 0 and " + (n - 1));  
    }
}