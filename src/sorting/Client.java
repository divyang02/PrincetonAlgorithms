package sorting;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdRandom;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = new Integer[20];
		for (int i = 0; i < a.length; i++) {
			a[i] = StdRandom.uniform(Integer.MAX_VALUE);
		}
		Insertion.sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
