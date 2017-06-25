package garphs;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

public class MSTKruskal {
	private Queue<MSTEdge> mst = new Queue<>();
	
	public MSTKruskal(MSTEdgeWG g) {
		MinPQ<MSTEdge> pq = new MinPQ<>();
		for(MSTEdge e : g.edges()) {
			pq.insert(e);
		}
		
		UF uf = new UF(g.V());
		while (!pq.isEmpty() && mst.size() < g.V() - 1) {
			MSTEdge e = pq.delMin();
			int v = e.either(), w = e.other(v);
			if(!uf.connected(v, w)) {
				uf.union(v, w);
				mst.enqueue(e);
			}
		}
	}
	
	public Iterable<MSTEdge> edges() {
		return mst;
	}
}
