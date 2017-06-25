package subStringSearch;

public class KMP {
	private String pat;
	private int[][] dfa;
	private int R = 256;
	private int m;
	
	public KMP(String pat) {
		this.pat = pat;
		m = pat.length();
		dfa = new int[R][m];
		
		dfa[pat.charAt(0)][0] = 1;
		
		for(int x = 0, j = 1; j < m; j++) {
			for(int c = 0; c < R; c++) {
				dfa[c][j] = dfa[c][x];
			}
			dfa[pat.charAt(j)][j] = j+1;
			x = dfa[pat.charAt(j)][x];
		}
	}
	
	public int search(String txt) {
		int i,j,n= txt.length();
		for(i = 0, j = 0; j < n && j < m; j++)
			j = dfa[pat.charAt(i)][j];
		if(j==m) return i-m;
		else return n;
	}

}
