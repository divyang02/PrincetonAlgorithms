package priorityQueues;

public class UnorderedMaxPQLL<Key extends Comparable<Key>> {
	private class Node{
		Key key;
		Node next;
	}
	
	private Node first;
	private int size = 0;
	
	public void insert(Key x) {
			Node oldFirst = first;
			first = new Node();
			first.key = x;
			first.next = oldFirst;
			size++;
	}
	
	public Key delMax() {
		if (size == 1) {
			Node temp = first;
			first = null;
			size--;
			return temp.key;
		} else {
			Key max = first.key;
			Node temp = first;
			Node temp2 = first.next;
			Node temp3 = temp;
			Node temp4 = temp2.next;
			while(temp2 != null) {
				if(temp2.key.compareTo(max) > 0) {
					max = temp2.key;
					temp3 = temp;
					temp4 = temp2.next;
				}
				temp = temp2;
				temp2 = temp2.next;
			}
			temp3.next = temp4;
			size--;
			return max;
		}
	}
	
	private boolean isEmpty() {
		return size == 0;
	}
}
