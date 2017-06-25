package garphs;

import java.util.Stack;

public class DFS {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public DFS(AdjListGraph g, int v) {
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		s = v;
		dfs(g,s);
	}
	
	private void dfs(AdjListGraph g, int v) {
		marked[v] = true;
		for(int w : g.adj(v)) {
			if(!marked[w]) {
				dfs(g,w);
				edgeTo[w] = v;
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v) {
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<>();
		for(int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}
}
