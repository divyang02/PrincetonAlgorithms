package stacks;

import edu.princeton.cs.algs4.StdIn;

public class Client {

	public static void main(String[] args) {
		//LinkedStackOfStrings stack = new LinkedStackOfStrings();
		GenericStackArray<String> stack = new GenericStackArray<>();
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if(s.equals("_")) {
				System.out.println(stack.pop());
			} else {
				stack.push(s);
			}
		}
	}

}
