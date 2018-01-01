package algorithms.graphTraversals;

import java.util.Stack;

import dataStructures.graphs.Graph;

public class AllPaths {

	private boolean[] onPath;       
    private Stack<Integer> path;     
    private int numberOfPaths;       

    public AllPaths(Graph G, int s, int t) {
        onPath = new boolean[G.getV()];
        path = new Stack<Integer>();
        dfs(G, s, t);
    }

    private void dfs(Graph G, int v, int t) {

        path.push(v);
        onPath[v] = true;

        if (v == t) {
            processCurrentPath();
            numberOfPaths++;
        }
        else {
            for (int w : G.adj(v)) {
                if (!onPath[w])
                    dfs(G, w, t);
            }
        }

        path.pop();
        onPath[v] = false;
    }

    private void processCurrentPath() {
        Stack<Integer> reverse = new Stack<Integer>();
        
        for (int v : path)
            reverse.push(v);
        
        if (reverse.size() >= 1)
            System.out.print(reverse.pop());
        
        while (!reverse.isEmpty())
        	System.out.print("-" + reverse.pop());
        
        System.out.println();
    }

    public int getNumberOfPaths() {
        return numberOfPaths;
    }
}