package stacks;

public class GenericStackArray<Item> {
	private Item[] s;
	private int n = 0;
	public GenericStackArray() {
		s = (Item[]) new Object[1];
	}
	
	public void push(Item item) {
		if(n == s.length) resize(2*s.length);
		s[n++] = item;
	}
	
	private void resize (int capacity) {
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			copy[i] = s[i];
		}
		s = copy;
	}
	
	public Item pop() {
		Item item = s[--n];
		s[n] = null;
		if (n > 0 && n == s.length/4) resize(s.length/2);
		return item;
	}
}
