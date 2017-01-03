package unionfind;

public class WeightedQUwithPC {
	private int[] id;
	private int[] sizes;
	
	public WeightedQUwithPC(int N) {
		
		id = new int[N];
		sizes = new int[N];
		for (int i = 0; i < id.length ; i++) {
			id[i] = i;
			sizes[i] = 1;
		}
	}
	
	public void union(int p, int q) {
		int rootp = findRoot(p);
		int rootq = findRoot(q);
		if (rootp == rootq) return;
		if (sizes[rootp] > sizes[rootq]) {
			id[rootq] = rootp;
			sizes[rootp] += sizes[rootq];
		} else {
			id[rootp] = rootq;
			sizes[rootq] += sizes[rootp];
		}
	}
	
	public boolean connected(int p, int q) {
		return findRoot(p) == findRoot(q);
	}
	
	private int findRoot(int a) {
		while (a != id[a]) {
			id[a] = id[id[a]];
			id[a] = a;
		}
		return a;
	}
}
