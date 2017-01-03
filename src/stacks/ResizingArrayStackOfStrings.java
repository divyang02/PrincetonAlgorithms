package stacks;

public class ResizingArrayStackOfStrings {
	private String[] s;
	private int n = 0;
	public ResizingArrayStackOfStrings() {
		s = new String[1];
	}
	
	public void push(String item) {
		if(n == s.length) resize(2*s.length);
		s[n++] = item;
	}
	
	private void resize (int capacity) {
		String[] copy = new String[capacity];
		for (int i = 0; i < n; i++) {
			copy[i] = s[i];
		}
		s = copy;
	}
	
	public String pop() {
		String item = s[--n];
		s[n] = null;
		if (n > 0 && n == s.length/4) resize(s.length/2);
		return item;
	}

}
