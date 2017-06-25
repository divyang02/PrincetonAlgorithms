package stringSearch;


public class TST<Value> {
	private node root;
	
	private class node {
		private char c;
		private Value val;
		private node left,mid,right;
	}
	
	public void put(String key, Value val) {
		root = put(root,key,val,0);
	}
	
	private node put(node x ,String key, Value val, int d) {
		char c = key.charAt(d);
		if(x == null) {
			x = new node();
			x.c = c;
		}
		if(c < x.c) x.left = put(x.left, key, val, d);
		else if(c > x.c) x.right = put(x.right, key, val, d);
		else if(d < key.length() - 1) x.mid = put(x.mid, key, val, d+1);
		else x.val = val;
		return x;
	}
	
	public boolean contains(String key) {
		return get(key) != null;
	}
	
	public Value get(String key) {
		node x = get(root,key,0);
		if(x == null) return null;
		return x.val;
	}
	
	private node get(node x, String key, int d) {
		if(x == null) return null;
		char c = key.charAt(d);
		if(c < x.c) return get(x.left, key, d);
		else if(c > x.c) return get(x.right, key, d);
		else if(d < key.length() - 1) return get(x.mid, key, d+1);
		else return x;
	}

}
