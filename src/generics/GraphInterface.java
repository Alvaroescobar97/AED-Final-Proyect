package generics;

public interface GraphInterface<T> {
	
	public void addVertex(T element);
	public void addEdge(T source, T element);
	public boolean isEmpty();
	public int size();
	public void clear();
	public void removeVertex(T element);
	public void removeEdge(T source, T destination);
	public boolean isEdge(T source, T destination);
	public boolean containsVertex(T element);
}
