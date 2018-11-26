package graphEstructure;

import java.util.Comparator;

/**
 * VertexWeightComparator class, used only to compare a pair of vertexes.
 * 
 * @author Luis A. Rodriguez, Álvaro J. Escobar, Sebastián Correa.
 * @version 1.0
 * @since 2018-11-26
 * @param <T>
 *            vertex representation, bases on the kind of problem to solve.
 */
public class VertexWeightComparator<T extends Comparable<T>> implements Comparator<T> {
	@Override
	public int compare(T o1, T o2) {
		return o1.compareTo(o2);
	}

}
