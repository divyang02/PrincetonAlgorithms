package garphs;

public class ConnComp {
	private boolean[] marked;
	private int[] id;
	private int count;
	
	public ConnComp(AdjListGraph g, int v) {
		marked = new boolean[g.V()];
		id = new int[g.V()];
		for(int i = 0; i < g.V(); i++) {
			if(!marked[i]) {
				dfs(g,i);
				count++;
			}
		}
	}
	
	private void dfs(AdjListGraph g, int v) {
		marked[v] = true;
		id[v] = count;
		for(int w : g.adj(v)) {
			if(!marked[w]) dfs(g,w);
		}
	}
	
	public int count() {
		return count;
	}
	
	public int id(int v) {
		return id[v];
	}
	
	public boolean isConnecte(int v, int w) {
		return id[v] == id[w];
	}

}
