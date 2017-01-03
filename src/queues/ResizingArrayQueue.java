package queues;

public class ResizingArrayQueue {
	private int tail = 0;
	private int head = 0;
	
	private String[] s;
	
	public ResizingArrayQueue() {
		s = new String[1];
	}
	
	public void enqueue(String item) {
		if(tail == s.length) {
			resize(2 * s.length);
		}
		s[tail++] = item; 
	}
	
	public String dequeue() {
		if (isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		
		String item = s[head];
		s[head++] = null;
		if(tail - head > 0 && tail - head == s.length/4) resize(s.length/2);
		return item;
	}
	
	public boolean isEmpty() {
		return head == tail;
	}
	
	private void resize(int capacity) {
		String[] copy = new String[capacity];
		if (capacity > s.length) {
			for (int i = 0; i < tail; i++) {
				copy[i] = s[i];
			}	
		} else {
			int j = 0;
			for (int i = head; i < tail; i++) {
				copy[j] = s[i];
				j++;
			}
			tail = j;
			head = 0;
		}
		s = copy;
	}

}
