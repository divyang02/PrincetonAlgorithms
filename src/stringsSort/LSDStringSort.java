package stringsSort;

public class LSDStringSort {
	//keys length are fixed that is length 'w'
	public static void sort(String[] a, int w) {
		int R = 256;
		int n = a.length;
		String aux[] = new String[n];
		
		for(int d = w-1; d >= 0; d--) {
			int[] count = new int[R+1];
			for(int i = 0;i < n; i++) {
				//offset by 1
				//count frequencies
				count[a[i].charAt(d) + 1]++;
			}
			
			for (int r = 0; r < R; r++) {
				//compute cumules
				count[r+1] += count[r];
			}
			
			for(int i = 0; i< n; i++) {
				//move items
				aux[count[a[i].charAt(d)]++] = a[i];
			}
			
			for(int i = 0; i < n; i++) {
				//copy array
				a[i] = aux[i];
			}
		}
	}

}
