package binarySearchTree;

public class RedBlackBST<Key extends Comparable<Key>, Value> {
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node {
		Key key;
		Value val;
		Node left, right;
		boolean color;
		
		public Node(Key key, Value val, boolean color) {
			this.key = key;
			this.val = val;
			this.color = color;
		}
	}
	
	private Node root;
	
	private boolean isRed(Node x) {
		if(x == null) return false;
		return x.color == RED;
	}
	
	public Value get(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if(cmp < 0) x = x.left;
			if(cmp > 0) x = x.right;
			else return x.val;
		}
		return null;
	}
	
	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}
	
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}
	
	private Node put(Node h, Key key, Value value) {
		if(h == null) return new Node(key, value, RED);
		int cmp = key.compareTo(h.key);
		if(cmp < 0) h.left = put(h.left, key, value);
		if(cmp > 0) h.right = put(h.right, key, value);
		else h.val = value;
		
		if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
		if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
		if(isRed(h.left) && isRed(h.right)) flipColors(h);
		
		return h;
	}

}
