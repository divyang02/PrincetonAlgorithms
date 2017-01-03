package unionfind;

import edu.princeton.cs.algs4.StdIn;

public class UnionfindClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = StdIn.readInt();
		
		UF uf = new UF(N);
		
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			
			if(!uf.connected(p, q)) {
				uf.union(p, q);
				System.out.println(p + " " + q);
			}
			
		}
	}

}
