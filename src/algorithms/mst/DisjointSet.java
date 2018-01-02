package algorithms.mst;


public class DisjointSet {
	
	private int[] set;

	public DisjointSet(int numOfElements) {
		set = new int[numOfElements];
		
		for (int i = 0; i < set.length; i++)
			set[i] = -1;
	}

	public int[] getSet() {
		return set;
	}
	
	public void union(int root1, int root2) {
		
		if (set[root2] < set[root1])
			set[root1] = root2;
		else {
			if (set[root1] == set[root2])
				set[root1]--;
			
			set[root2] = root1;
		}
	}
	
	public int find(int x) {
		
		if (set[x] < 0)
			return x;
		
		return set[x] = find(set[x]);
	}
}