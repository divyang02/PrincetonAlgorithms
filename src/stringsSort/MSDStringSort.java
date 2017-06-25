package stringsSort;

public class MSDStringSort {
	public static void sort(String[] a) {
		String[] aux = new String[a.length];
		sort(a,aux,0,a.length,0);
	}
	
	private static void sort(String[] a, String[] aux, int lo, int hi, int d) {
		int R = 256;
		if(hi <= lo) return;
		int count[] = new int[R+2];
		for(int i = lo;i <= hi; i++) {
			//offset by 1
			//count frequencies
			count[charAt(a[i], d) + 2]++;
		}
		
		for (int r = 0; r < R+1; r++) {
			//compute cumules
			count[r+1] += count[r];
		}
		
		for(int i = lo; i <= hi; i++) {
			//move items
			aux[count[charAt(a[i], d) + 1]++] = a[i];
		}
		
		for(int i = lo; i <= hi; i++) {
			//copy array
			a[i] = aux[i-lo];
		}
		
		for(int r = 0; r < R; r++) {
			sort(a, aux, lo+count[r], lo+count[r+1] - 1, d+1);
		}
	}
	
	private static int charAt(String s, int d) {
		if(d < s.length()) return s.charAt(d);
		else return -1;
	}

}
