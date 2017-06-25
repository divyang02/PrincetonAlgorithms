package garphs;

import java.util.ArrayList;
import java.util.List;

public class AdjListGraph {
	private final int v;
	private List<Integer>[] adj;
	
	public AdjListGraph(int v) {
		this.v = v;
		adj = (List<Integer>[])new List[v];
		for(int i = 0; i < v; i++) {
			adj[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
	
	public int V() {
		return v;
	}

}
