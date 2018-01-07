package algorithms.digraphTraversals;

import java.util.LinkedList;
import java.util.Stack;

import dataStructures.digraphs.Digraph;
import dataStructures.digraphs.DirectedEdge;
import dataStructures.digraphs.EdgeWeightedDigraph;

public class DepthFirstOrder {

	private boolean[] visited;          
    private int[] pre;                 
    private int[] post;                
    private LinkedList<Integer> preorder;   
    private LinkedList<Integer> postorder;  
    private int preCounter;            
    private int postCounter;           

    public DepthFirstOrder(Digraph G) {
        pre = new int[G.getV()];
        post = new int[G.getV()];
        postorder = new LinkedList<Integer>();
        preorder = new LinkedList<Integer>();
        visited = new boolean[G.getV()];
        
        for (int v = 0; v < G.getV(); v++)
            if (!visited[v]) 
            	dfs(G, v);
    }

    public DepthFirstOrder(EdgeWeightedDigraph G) {
        pre = new int[G.getV()];
        post = new int[G.getV()];
        postorder = new LinkedList<Integer>();
        preorder = new LinkedList<Integer>();
        visited = new boolean[G.getV()];
        
        for (int v = 0; v < G.getV(); v++)
            if (!visited[v]) 
            	dfs(G, v);
    }

    private void dfs(Digraph G, int v) {
        visited[v] = true;
        pre[v] = preCounter++;
        preorder.add(v);
        
        for (int w : G.adj(v)) 
            if (!visited[w]) 
                dfs(G, w);

        postorder.add(v);
        post[v] = postCounter++;
    }

    private void dfs(EdgeWeightedDigraph G, int v) {
        visited[v] = true;
        pre[v] = preCounter++;
        preorder.add(v);
        
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
        
            if (!visited[w]) 
                dfs(G, w);
        }
        
        postorder.add(v);
        post[v] = postCounter++;
    }

    public int pre(int v) {
        validateVertex(v);
        return pre[v];
    }

    public int post(int v) {
        validateVertex(v);
        return post[v];
    }

    public Iterable<Integer> post() {
        return postorder;
    }

    public Iterable<Integer> pre() {
        return preorder;
    }

    public Iterable<Integer> reversePost() {
        Stack<Integer> reverse = new Stack<Integer>();
        
        for (int v : postorder)
            reverse.push(v);
        
        return reverse;
    }

    private void validateVertex(int v) {
        int V = visited.length;

        if (v < 0 || v >= V)
            throw new IllegalArgumentException("Vertex " + v + " is not between 0 and " + (V - 1));
    }
}