package priorityQueues;

import edu.princeton.cs.algs4.StdIn;

public class ClientPQ {
	
	public static void main(String[] args) {
		UnorderedMaxPQLL<String> pq = new UnorderedMaxPQLL<>();
		while(!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if(s.equals("-")) {
				System.out.println(pq.delMax());
			}
			else {
				pq.insert(s);
			}
		}
	}

}
