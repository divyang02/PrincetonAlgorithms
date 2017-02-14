package priorityQueues;

public class UnorderedMaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N;
	
	public UnorderedMaxPQ(int capacity) {
		pq = (Key[])new Comparable[capacity];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void insert(Key x) {
		pq[N++] = x;
	}
	
	public Key delMax() {
		int max = 0;
		for (int i = 1; i < N; i++) {
			if (less(max, i)) max = i;
		}
		exch(max, N-1);
		return pq[--N];
	}
	
	private boolean less(int u, int v) {
		return pq[u].compareTo(pq[v]) < 0;
	}
	
	private void exch(int u, int v) {
		Key swap = pq[u];
		pq[u] = pq[v];
		pq[v] = swap;
	}
}
