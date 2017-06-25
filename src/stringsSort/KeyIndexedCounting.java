package stringsSort;

public class KeyIndexedCounting {
	public KeyIndexedCounting(char[] a, int R, char[] aux) {
		int n = a.length;
		aux = new char[n];
		int[] count = new int[R+1];
		
		for(int i = 0;i < n; i++) {
			//offset by 1
			//count frequencies
			//a  = 0, b = 1, c = 2..... for simplicity
			count[a[i] + 1]++;
		}
		
		for (int r = 0; r < R; r++) {
			//compute cumules
			count[r+1] += count[r];
		}
		
		for(int i = 0; i< n; i++) {
			//move items
			aux[count[a[i]]++] = a[i];
		}
		
		for(int i = 0; i < n; i++) {
			//copy array
			a[i] = aux[i];
		}
	}

}