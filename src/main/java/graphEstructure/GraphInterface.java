package graphEstructure;

import java.util.ArrayList;
import java.util.Set;

public interface GraphInterface<T> {
	
	public static final int INF = 150000000;
	
	public void addVertex(T element);
	public void addEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException;
	public void addEdge(Vertex<T> from, Vertex<T> to, int weight)throws IllegalArgumentException;
	public void removeVertex(Vertex<T> vertex);
	public void removeEdge(Vertex<T> from, Vertex<T> to)throws IllegalArgumentException;
	public Vertex<T> getVertex(T element) throws IllegalArgumentException;
	public Iterable<Vertex<T>> getVertices();
	public Edge<T> getEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException;
	public Iterable<Edge<T>> getEdges(Vertex<T> vertex) throws IllegalArgumentException;
	public int getWeightEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException;
	public void setWeightEdge(Vertex<T> from, Vertex<T> to, int weight) throws IllegalArgumentException;
	public boolean isAdjacent(Vertex<T> from, Vertex<T> to);
	public Set<Vertex<T>> adjacentVertices(Vertex<T> vertex);
	public Iterable<Edge<T>> getEdges();
	public ArrayList<Vertex<T>> vertexPath(Vertex<T> startVertex, Vertex<T> endVertex) throws IllegalArgumentException;
	public void bfs(Vertex<T> startVertex);
	public void dfs();
	public void dijkstra(Vertex<T> startVertex);
	public boolean bellmanFord(Vertex<T> starVertex);
	public void initializeSingleSource(Vertex<T> vertex);
	public void relax(Vertex<T> start, Vertex<T> finish);
	public void prim(Vertex<T> vertex);	
	public int[][] floydWarshall();
	public void kruskal();
}
