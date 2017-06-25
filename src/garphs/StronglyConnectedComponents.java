package garphs;

public class StronglyConnectedComponents {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public StronglyConnectedComponents(Digraph g) {
		marked = new boolean[g.V()];
		id = new int[g.V()];
		TopologicalSort dfs = new TopologicalSort(g.reverse());
		for(int v : dfs.reversePost()) {
			if(!marked[v]) {
				dfs(g,v);
				count++;
			}
		}
	}
	
	private void dfs(Digraph g, int v) {
		marked[v] = true;
		id[v] = count;
		for(int w : g.adj(v)) {
			if(!marked[w]) dfs(g,w);
		}
	}
	
	public boolean stringlyConnected(int v, int w) {
		return id[v] == id[w];
	}

}
