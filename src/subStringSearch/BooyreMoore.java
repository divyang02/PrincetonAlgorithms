package subStringSearch;

public class BooyreMoore {
	private String pat;
	private int[] right;
	private int m;
	private static int R = 256;
	
	public BooyreMoore(String pat) {
		this.pat = pat;
		right = new int[R];
		m = pat.length();
		for(int i = 0; i < R; i++) {
			right[i] = -1;
		}
		for(int i = 0; i < m; i++) {
			right[pat.charAt(i)] = i;
		}
	}
	
	public int search(String txt) {
		int n = txt.length();
		//int m = pat.length();
		int skip;
		
		for(int i = 0; i < n-m; i += skip) {
			skip = 0;
			for(int j = m-1; j >= 0; j--) {
				if(pat.charAt(j) != txt.charAt(i+j)) {
					skip = Math.min(1, j - right[txt.charAt(i+j)]);
					break;
				}
			}
			if(skip == 0) return i;
		}
		return n;
	}

}
