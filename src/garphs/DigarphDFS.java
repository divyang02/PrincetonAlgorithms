package garphs;

import java.util.Stack;

public class DigarphDFS {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	
	public DigarphDFS(Digraph g, int s) {
		this.s = s;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		dfs(g,s);
	}
	
	private void dfs(Digraph g, int s) {
		marked[s] = true;
		for(int w : g.adj(s)) {
			if(!marked[w]) {
				dfs(g,w);
				edgeTo[w] = s;
			}
		}
	}
	
	public boolean hasPathTo(int w) {
		return marked[w];
	}
	
	public Iterable<Integer> path(int v) {
		if(!hasPathTo(v)) return null;
		Stack<Integer> path = new Stack<>();
		for(int x = v; x != s; x = edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
	}

}
