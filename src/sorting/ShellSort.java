package sorting;

public class ShellSort {
	
	private static boolean less(Comparable u, Comparable v) {
		return u.compareTo(v) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static void sort(Comparable a[]) {
		int N = a.length;
		int h = 1;
		
		while (h < h/3) {
			h = 3*h + 1;
		}
		
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j < N && less(a[j], a[j-h]); j -= h) {
					exch(a, j, j-h);
				}
			}
			h = h/3;
		}
	}

}
