package hashing;

public class SeperateChainingHashST<Key, Value> {
	private int M = 97;
	private Node[] st = new Node[M];
	
	private static class Node{
		private Object key;
		private Object value;
		private Node next;
		
		public Node(Object key, Object val, Node x) {
			this.key = key;
			this.value = val;
			
		}
	}
	
	private int hash(Key key) {
		return (Math.abs(key.hashCode()) % M);
	}
	
	public Value get(Key key) {
		int i = hash(key);
		for(Node x = st[i]; x != null; x = x.next) {
			if(key.equals(x.key)) return (Value)x.value;
		}
		return null;
	}
	
	public void put(Key key, Value val) {
		int i = hash(key);
		for(Node x = st[i]; x != null; x = x.next) {
			if(key.equals(x.key)) {x.value = val; return;}
		}
		st[i] = new Node(key, val, st[i]);
	}

}
