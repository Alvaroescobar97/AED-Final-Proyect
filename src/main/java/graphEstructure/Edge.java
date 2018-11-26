package graphEstructure;

/**
 * Edge class, represents the edge of the graph.
 * 
 * @author Luis A. Rodriguez, Álvaro J. Escobar, Sebastián Correa.
 * @version 1.0
 * @since 2018-11-26
 * @param <T>
 *            edge representation, based on the kind of problem to solve.
 */
public class Edge<T> implements Comparable<Edge<T>> {
	private Vertex<T> fromVertex;
	private Vertex<T> toVertex;
	private int weight;

	/**
	 * This is the edge class constructor, used to create an edge between a pair of
	 * vertexes.
	 * 
	 * @param v1
	 *            the vertex where the edge starts.
	 * @param v2
	 *            the vertex where the edge ends.
	 * @param w
	 *            the cost of using the edge.
	 */
	public Edge(Vertex<T> v1, Vertex<T> v2, int w) {
		this.fromVertex = v1;
		this.toVertex = v2;
		this.weight = w;
	}

	/**
	 * Returns the vertex where the edge starts.
	 * 
	 * @return Vertex<T> the vertex where the edge starts.
	 */
	public Vertex<T> initVertex() {
		return fromVertex;
	}

	/**
	 * Returns the vertex where the edge ends.
	 * 
	 * @return Vertex<T> the vertex where the edge ends.
	 */
	public Vertex<T> endVertex() {
		return toVertex;
	}

	/**
	 * Returns the cost of using the edge.
	 * 
	 * @return int the cost of using the edge.
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * This method is used to set/change the cost of an edge.
	 * 
	 * @param weight
	 *            the weight of an edge.
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * Returns the pair of vertexes connected by the edge.
	 * 
	 * @return String the pair of vertexes connected by the edge.
	 */
	@Override
	public String toString() {
		return "(" + fromVertex + "," + toVertex + ")";
	}

	/**
	 * This method is used to compare the weight of two edges.
	 * 
	 * @param toCompare
	 *            the edge that will be compared to te edge that uses the method.
	 * @return 0 if both edges are equal, 1 if the parameter edge has lower weight,
	 *         -1 if the parameter edge has higher weight.
	 */
	@Override
	public int compareTo(Edge<T> toCompare) {
		if (weight > toCompare.getWeight())
			return 1;
		else if (weight == toCompare.getWeight())
			return 0;
		else
			return -1;
	}

}
