package sorting;

public class MergeSort {
	
	private static void merge (Comparable[] a,Comparable[] aux, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = a[i];
		}
		int j = lo, k = mid + 1;
		for (int i = lo; i <= hi; i++) {
			if (i > mid) {
				a[i] = aux[k++];
			} else if (j > hi){
				a[i] = aux[j++];
			} else if (less(aux[k], aux[j])) {
				a[i] = a[k++];
			} else {
				a[i] = a[j++];
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		//Improvement
		if(!less(a[mid+1], a[mid])) return;
		merge(a, aux, lo, mid, hi);
	}
	
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
}
