package garphs;

import edu.princeton.cs.algs4.Queue;

public class BFS {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public BFS(AdjListGraph g, int v) {
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		s = v;
		bfs(g,s);
	}
	
	private void bfs(AdjListGraph g, int v) {
		Queue<Integer> q = new Queue<>();
		q.enqueue(v);
		marked[v] = true;
		while(!q.isEmpty()) {
			int p = q.dequeue();
			for(int w : g.adj(p)) {
				if(!marked[w]) {
					q.enqueue(w);
					marked[w] = true;
					edgeTo[w] = p;
				}
			}
		}
	}
}
