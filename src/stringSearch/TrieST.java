package stringSearch;

public class TrieST<Value> {
	private static int R = 256;
	private node root = new node();
	
	private static class node {
		private Object value;
		private node[] next = new node[R];
	}
	
	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}
	
	private node put(node x, String key, Value val, int d) {
		if(x == null) x  = new node();
		if(d == key.length()) {
			x.value = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d+1);
		return x;
	}
	
	public boolean contains(String key) {
		return get(key) != null;
	}
	
	public Value get(String key) {
		node x = get(root,key,0);
		if(x == null) return null;
		return (Value) x.value;
	}
	
	private node get(node x, String key, int d) {
		if(x == null) return null;
		if(d == key.length()) return x;
		char c = key.charAt(d);
		return get(x.next[c], key, d+1);
	}

}
