/** run dfs for vertices and put them on stack when done with vertex
 * when we are done with all vertex and putted them on stack that order is postOrder
 * return in reverse post order
 */

package garphs;

import edu.princeton.cs.algs4.Stack;

public class TopologicalSort {
	private boolean marked[];
	private Stack<Integer> revPost;
	
	public TopologicalSort(Digraph g) {
		revPost = new Stack<>();
		marked = new boolean[g.V()];
		for (int v = 0; v < g.V(); v++) {
			if(!marked[v]) dfs(g,v);
		}
	}
	
	private void dfs(Digraph g, int s) {
		marked[s] = true;
		for(int w : g.adj(s)) {
			if(!marked[w]) {
				dfs(g,w);
			}
		}
		revPost.push(s);
	}
	
	public Iterable<Integer> reversePost() {
		return revPost;
	}
}
