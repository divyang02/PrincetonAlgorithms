package queues;

import edu.princeton.cs.algs4.StdIn;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResizingArrayQueue queue = new ResizingArrayQueue();
		
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			if(s.equals("_")) {
				System.out.println(queue.dequeue());
			} else {
				queue.enqueue(s);
			}
		}
	}

}
