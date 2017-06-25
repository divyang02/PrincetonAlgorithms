package stringSearch;

import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieST<Integer> tst = new TrieST<>();
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("1 add elements to trie \n 2 search the trie \n 3 exit");
			int ch = in.nextInt();
			switch(ch) {
			case 1 : System.out.println("give string and value\n");
			String s = in.next();
			int t = in.nextInt();
			tst.put(s, t);
			break;
			
			case 2 : System.out.println("search the element\n");
			String se = in.next();
			System.out.println("the value of string is " + tst.get(se));
			break;
			
			default : return;
			}
		}

	}

}
