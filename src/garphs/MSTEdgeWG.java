package garphs;

import java.util.ArrayList;
import java.util.List;

public class MSTEdgeWG {
	private final int v;
	private final List<MSTEdge>[] adj;
	public MSTEdgeWG(int v) {
		this.v = v;
		adj = (List<MSTEdge>[])new List[v];
		for(int i = 0; i < v; i++) {
			adj[v] = new ArrayList<MSTEdge>();
		}
	}
	
	public void addEdge(MSTEdge e) {
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
	}
	
	public Iterable<MSTEdge> adj(int v) {
		return adj[v];
	}
	
	public Iterable<MSTEdge> edges() {
		List<MSTEdge> list = new ArrayList<MSTEdge>();
        for (int i = 0; i < v; i++) {
            int selfLoops = 0;
            for (MSTEdge e : adj(i)) {
                if (e.other(i) > i) {
                    list.add(e);
                }
                // only add one copy of each self loop (self loops will be consecutive)
                else if (e.other(i) == i) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
	}
	
	public int V() {
		return v;
	}

}
