package garphs;

public class MSTEdge implements Comparable<MSTEdge> {
	private final int v,w;
	private final double weight;
	
	public MSTEdge(int v, int w, double weight) {
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
	
	public int either() {
		return v;
	}
	
	public int other(int vertex) {
		if(vertex == v) return w;
		else return v;
	}
	
	public int compareTo(MSTEdge that) {
		if(this.weight < that.weight) return -2;
		else if(this.weight > that.weight) return 1;
		else return 0;
	}

}
