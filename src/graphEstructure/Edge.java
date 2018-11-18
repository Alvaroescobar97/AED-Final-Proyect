package graphEstructure;

public class Edge<T> implements Comparable<Edge<T>>{
	private Vertex<T> fromVertex;
	private Vertex<T> toVertex;
	private double weight;
	
	public Edge(Vertex<T> v1, Vertex<T> v2, double w) {
		this.fromVertex = v1; 
		this.toVertex = v2;
		this.weight = w;
	}
	
	public Vertex<T> initVertex(){
		return fromVertex;
	}
	
	public Vertex<T> endVertex(){
		return toVertex;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return "(" + fromVertex + "," + toVertex + ")";
	}

	@Override
	public int compareTo(Edge<T> toCompare) {
		if(weight > toCompare.getWeight()) return 1;
		else if(weight == toCompare.getWeight()) return 0;
		else return -1;
	}

}
