package graphEstructure;

/**
 * Vertex class, represents a generic vertex of the graph.
 * 
 * @author Luis A. Rodriguez, Alvaro J. Escobar, Sebastian Correa.
 * @version 1.0
 * @since 2018-11-26
 * @param <T>
 *            vertex representation, based on the kind of problem to solve.
 */
public class Vertex<T> implements Comparable<Vertex<T>> {

	public final static int WHITE = 0;
	public final static int GRAY = 1;
	public final static int BLACK = 2;
	private T value;
	private double d;
	private int f;
	private int color;
	private Vertex<T> pred;

	/**
	 * This is the vertex class constructor, it is used to create a vertex.
	 * 
	 * @param type
	 *            the generic value of the vertex.
	 */
	public Vertex(T type) {
		value = type;
	}

	/**
	 * Returns the generic value of the vertex.
	 * 
	 * @return the generic value of the vertex.
	 */
	public T getValue() {
		return value;
	}

	/**
	 * This method is used to set or change the generic value of the vertex.
	 * 
	 * @param value
	 *            the generic value of the vertex.
	 */
	public void setValue(T value) {
		this.value = value;
	}

	/**
	 * Returns how far is the node, used for graph algorithms seen in the AED
	 * course.
	 * 
	 * @return how far is the node.
	 */
	public double getD() {
		return d;
	}

	/**
	 * This method is used to set or change the value of how far is the node.
	 * 
	 * @param d
	 *            the new value.
	 */
	public void setD(double d) {
		this.d = d;
	}

	/**
	 * 
	 * @return
	 */
	public int getF() {
		return f;
	}

	/**
	 * 
	 * @param f
	 */
	public void setF(int f) {
		this.f = f;
	}

	/**
	 * 
	 * @return
	 */
	public int getColor() {
		return color;
	}

	/**
	 * 
	 * @param color
	 */
	public void setColor(int color) {
		this.color = color;
	}

	/**
	 * 
	 * @return
	 */
	public Vertex<T> getPred() {
		return pred;
	}

	/**
	 * 
	 * @param pred
	 */
	public void setPred(Vertex<T> pred) {
		this.pred = pred;
	}

	/**
	 * Returns the vertex generic value as a String.
	 * 
	 * @return String the generic value of the vertex.
	 */
	@Override
	public String toString() {
		return "" + value;
	}

	/**
	 * This method is used to compare the distance of two vertexes.
	 * 
	 * @param toCompare
	 *            the vertex that will be compared to the vertex that uses the
	 *            method.
	 * @return 0 if both vertexes are equal, 1 if the parameter vertex has lower
	 *         distance, -1 if the parameter vertex has higher distance.
	 */
	@Override
	public int compareTo(Vertex<T> o) {
		if (d < o.getD()) {
			return -1;
		} else if (d > o.getD()) {
			return 1;
		} else
			return 0;
	}
}
