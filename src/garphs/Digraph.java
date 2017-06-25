package garphs;

import java.util.ArrayList;
import java.util.List;

public class Digraph {
	private final int v;
	private final List<Integer>[] adj;
	
	public Digraph(int v) {
		this.v = v;
		adj = (List<Integer>[])new List[v];
		for(int i = 0; i < v; i++) {
			adj[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public int V() {
		return v;
	}

}
