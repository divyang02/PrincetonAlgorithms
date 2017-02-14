package binarySearchTree;

import java.security.Key;

import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>, Value> {
	private class Node {
		private Key key;
		private Value value;
		private Node left, right;
		private int count;
		
		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private Node root;
	
	/*puts a value in BST*/
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}
	
	private Node put(Node x, Key key, Value value) {
		if (x == null) return new Node(key, value);
		int cmp = key.compareTo(x.key);
		if (cmp < 0) x.left = put(x, key, value);
		else if (cmp > 0) x.right = put(x, key, value);
		else x.value = value;
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	/*gives size of any node x*/
	private int size(Node x) {
		if(x == null) return 0;
		else return x.count;
	}
	
	/*gives size of bst i.e. of root*/
	public int size() {
		return size(root);
	}
	
	/*gets the value of given key*/
	public Value get(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0) x = x.left;
			else if (cmp > 0) x = x.right;
			else return x.value;
		}
		return null;
	}
	
	/*gets the the key in bst which is just smaller than the key that is passed in it*/
	public Key floor(Key key) {
		Node x = floor(root, key);
		if(x == null) return null;
		return x.key;
	}
	
	private Node floor(Node x, Key key) {
		if (x == null) return null;
		int cmp = key.compareTo(x.key);
		if (cmp == 0) return x;
		if (cmp < 0) return floor(x.left, key);
		Node t = floor(x.right, key);
		if(t != null) return t;
		else return x;
		
	}
	
	/* gives the no of keys present in bst which are smaller than the key passed*/
	public int rank(Key key) {
		return rank(key, root);
	}
	
	private int rank(Key key, Node x) {
		if(x == null) return 0;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) return rank(key, x.left);
		else if(cmp > 0) return 1 + size(x.left) + rank(key, x.right);
		else return size(x.left);
	}
	
	/*gives the inorder that is ascending order of keys iterator*/
	public Iterable<Key> iterator() {
		Queue<Key> q = new Queue<>();
		inorder(root,q);
		return q;
	}
	
	private void inorder(Node x, Queue<Key> q) {
		if(x == null) return;
		inorder(x.left, q);
		q.enqueue(x.key);
		inorder(x.right, q);
	}
	
	/* finds the min element in the bst and delets it
	 * it goes to the leftmost branch and deletes it
	 * after deleting it it assigns the left of last left branch to right of the deleted node 
	 */
	public void delMin() {
		root = delMin(root);
	}
	
	private Node delMin(Node x) {
		if(x.left == null) return x.right;
		x.left = delMin(x.left);
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	/* takes a key and deletes it from bst
	 * To delete a node with key k: search for node t containing key k.
	 * Case 1. [1 child] Delete t by replacing parent link.
	 * Case 2. [2 children] find succesor x of t
	 * 			delete min in right sub tree of t
	 * 			put x in t's spot
 	 */
	public void delete(Key key) {
		root = delete(root, key);
	}
	
	private Node delete(Node x, Key key) {
		if(x == null) return null;
		int cmp = key.compareTo(x.key);
		if(cmp < 0) x.left = delete(x.left, key);
		if(cmp > 0) x.right = delete(x.right, key);
		else {
			if(x.left == null) return x.left;
			if(x.right == null) return x.right;
			
			Node t = x;
			x = min(t.right);
			x.right = delMin(t.right);
			x.left = t.left;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	//finds minimun that is leftmost node from given node
	private Node min(Node x) {
		while(x.left != null) {
			x = x.left;
		}
		return x;
	}

}
