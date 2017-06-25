package subStringSearch;

public class RabinKarp {
	private long patHash;
	private int m;
	private int q; // modulous
	private int R; //radix
	private long rm; //R^(m-1)%q
	
	public RabinKarp(String pat) {
		m = pat.length();
		q = 997;
		rm = 1;
		for(int i = 1; i <= m-1; i++) 
			rm = (R*rm)%q;
		patHash = hash(pat,m);
	}
	
	public int search(String txt) {
		int n = txt.length();
		int txtHash = hash
		if(patHash == txtHash) return 0;
		for(int i = m; i < n; i++) 
			txtHash = (txtHash + q - rm*txt.charAt(i-m)%q) % q;
		if(patHash == txtHash) return i - m + 1;
	}
	return n;

}
