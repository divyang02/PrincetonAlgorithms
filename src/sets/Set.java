package sets;

public class Set<Key extends Comparable<Key>> {
	private class Node {
		private Key key;
		private Node left, right;
		private int count;
		
		public Node(Key key) {
			this.key = key;
		}
	}
	
	private Node root;
	
	public Set() {
		root = null;
	}
	
	public void add(Key key) {
		root = add(root, key);
	}
	
	private Node add(Node x, Key key) {
		if(x == null) return new Node(key);
		int cmp = key.compareTo(x.key);
		if(cmp < 0) x.left = add(x.left, key);
		else if(cmp > 0) x.right = add(x.right, key);
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	private int size(Node x) {
		if(x == null) return 0;
		else return x.count;
	}
	
	public int size() {
		return size(root);
	}
	
	public boolean contains(Key key) {
		return contains(root, key);
	}
	
	private boolean contains(Node x, Key key) {
		if(x == null) return false;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return contains(x.left, key);
		else if(cmp > 0) return contains(x.right, key);
		else return true;
	}
	
	public void remove(Key key) {
		root = remove(root, key);
	}
	
	private Node remove(Node x, Key key) {
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) x.left = remove(x.left, key);
		if(cmp > 0) x.right = remove(x.right, key);
		else {
			if(x.right == null) return x.left;
			if(x.left == null) return x.right;
			
			Node t = x;
			x = min(t.right);
			x.right = delmin(t.right);
			x.left = t.left;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	private Node min(Node x) {
		while(x.left != null) {
			x = x.left;
		}
		return x;
	}
	
	private Node delmin(Node x) {
		if(x == null) return x.right;
		x.left = delmin(x.left);
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

}
