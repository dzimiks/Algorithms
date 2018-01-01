package dataStructures.graphs;

public class ConnectedComponents {

	private boolean[] marked;   
    private int[] id;         
    private int[] size;       
    private int count;         

    public ConnectedComponents(Graph G) {
        marked = new boolean[G.getV()];
        id = new int[G.getV()];
        size = new int[G.getV()];
        
        for (int v = 0; v < G.getV(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    public ConnectedComponents(EdgeWeightedGraph G) {
        marked = new boolean[G.getV()];
        id = new int[G.getV()];
        size = new int[G.getV()];
        
        for (int v = 0; v < G.getV(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        
        for (int w : G.adj(v)) 
            if (!marked[w]) 
                dfs(G, w);
    }

    private void dfs(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            
            if (!marked[w]) 
                dfs(G, w);
        }
    }

    public int getId(int v) {
        validateVertex(v);
        return id[v];
    }

    public int size(int v) {
        validateVertex(v);
        return size[id[v]];
    }

    public int getCount() {
        return count;
    }

    public boolean isConnected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return getId(v) == getId(w);
    }

    private void validateVertex(int v) {
        int V = marked.length;
        
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
    }
}