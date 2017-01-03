package unionfind;

public class QuickUnion {
	private int[] id;
	
	public QuickUnion(int N) {
		
		id = new int[N];
		for (int i = 0; i < id.length ; i++) {
			id[i] = i;
		}
	}
	
	public void union(int p, int q) {
		int rootp = findRoot(p);
		int rootq = findRoot(q);
		id[rootp] = rootq;
	}
	
	public boolean connected(int p, int q) {
		return findRoot(p) == findRoot(q);
	}
	
	private int findRoot(int a) {
		while (a != id[a]) {
			id[a] = a;
		}
		return a;
	}
}
