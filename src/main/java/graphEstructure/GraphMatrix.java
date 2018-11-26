package graphEstructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class GraphMatrix<T> implements GraphInterface<T>{

	private Map<T, Integer> vertices;
	private List<Vertex<T>> listVertex;
	private int[][] adjMatrix;
	private int index;
	private int numVertex;
	private boolean isDirected;
	private boolean isWeighted;
	
	public GraphMatrix(int numVertex, boolean isDirected, boolean isWeighted) {
		this.numVertex = numVertex;
		this.isDirected = isDirected;
		this.isWeighted = isWeighted;
		this.vertices = new HashMap<T, Integer>();
		this.listVertex = new ArrayList<Vertex<T>>();
		this.index = 0;
		adjMatrix = new int[numVertex][numVertex];
		
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[0].length; j++) {
				adjMatrix[i][j] = INF;
			}
		}
	}

	@Override
	public void addVertex(T element) {
		Vertex<T> vertex = new Vertex<>(element);
		addVertex(vertex);
	}
	
	private void addVertex(Vertex<T> vertex) throws IllegalArgumentException{
		if(vertices.containsKey(vertex.getValue())) throw new IllegalArgumentException("Vertex exist");
		vertices.put(vertex.getValue(), index);
		listVertex.add(vertex);
		index++;
	}

	@Override
	public void addEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException {
		if(!vertices.containsKey(from.getValue()) || !vertices.containsKey(to.getValue())) {
			throw new IllegalArgumentException("Vertex not found");
		}
		
		int indexVertex1 =  vertices.get(from.getValue());
		int indexVertex2 =  vertices.get(to.getValue());
		
		adjMatrix[indexVertex1][indexVertex2] = 1;
		if(!isDirected) adjMatrix[indexVertex2][indexVertex2] = 1;
	}

	@Override
	public void addEdge(Vertex<T> from, Vertex<T> to, int weight) throws IllegalArgumentException {
		if(!isWeighted) throw new IllegalArgumentException("The graph is not weighted");
		if(!vertices.containsKey(from.getValue()) || !vertices.containsKey(to.getValue())) {
			throw new IllegalArgumentException("Vertex not found");
		}
		
		int indexVertex1 =  vertices.get(from.getValue());
		int indexVertex2 =  vertices.get(to.getValue());
		
		adjMatrix[indexVertex1][indexVertex2] = weight;
		if(!isDirected) adjMatrix[indexVertex2][indexVertex2] = weight;
		
	}

	@Override
	public void removeVertex(Vertex<T> vertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException {
		if(!vertices.containsKey(from.getValue()) || !vertices.containsKey(to.getValue())) {
			throw new IllegalArgumentException("Vertex not found");
		}
		
		int indexVertex1 = vertices.get(from.getValue());
		int indexVertex2 =  vertices.get(to.getValue());
		
		adjMatrix[indexVertex1][indexVertex2] = INF;
		if(!isWeighted) adjMatrix[indexVertex2][indexVertex1] = INF;
		
	}

	@Override
	public Vertex<T> getVertex(T element) throws IllegalArgumentException {
		if(vertices.containsKey(element)) return listVertex.get(vertices.get(element));
		throw new IllegalArgumentException("Vertex not found");
	}

	@Override
	public Iterable<Vertex<T>> getVertices() {
		return this.listVertex;
	}

	@Override
	public Edge<T> getEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Edge<T>> getEdges(Vertex<T> vertex) throws IllegalArgumentException {
		ArrayList<Edge<T>> edges = new ArrayList<>();
		for(int i = 0; i < adjMatrix.length; i++) {
			for(int j = 0; j < adjMatrix[0].length; j++) {
				if(adjMatrix[i][j] == 1)
					edges.add(new Edge<T>(listVertex.get(i), listVertex.get(j), adjMatrix[i][j]));
			}
		}
		return edges;
	}

	@Override
	public int getWeightEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException {
		return this.adjMatrix[vertices.get(from.getValue())][vertices.get(to.getValue())];
	}

	@Override
	public void setWeightEdge(Vertex<T> from, Vertex<T> to, int weight) throws IllegalArgumentException {
		this.adjMatrix[vertices.get(from.getValue())][vertices.get(to.getValue())] = weight;
	}

	@Override
	public boolean isAdjacent(Vertex<T> from, Vertex<T> to) {
		int indexVertex1 = vertices.get(from.getValue());
		int indexVertex2 = vertices.get(to.getValue());
		
		if(adjMatrix[indexVertex1][indexVertex2] != INF) return true;
		else return false;
	}

	@Override
	public Set<Vertex<T>> adjacentVertices(Vertex<T> vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Edge<T>> getEdges() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Vertex<T>> vertexPath(Vertex<T> startVertex, Vertex<T> endVertex) 
			throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bfs(Vertex<T> startVertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dfs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dijkstra(Vertex<T> startVertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean bellmanFord(Vertex<T> starVertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void initializeSingleSource(Vertex<T> vertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void relax(Vertex<T> start, Vertex<T> finish) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prim(Vertex<T> vertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void floydWarshall() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kruskal() {
		// TODO Auto-generated method stub
		
	}

	public List<Vertex<T>> getListVertex() {
		return listVertex;
	}

	public void setListVertex(List<Vertex<T>> listVertex) {
		this.listVertex = listVertex;
	}

	public int[][] getAdjMatrix() {
		return adjMatrix;
	}

	public void setAdjMatrix(int[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}

	public int getNumVertex() {
		return numVertex;
	}

	public void setNumVertex(int numVertex) {
		this.numVertex = numVertex;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public boolean isWeighted() {
		return isWeighted;
	}

	public void setWeighted(boolean isWeighted) {
		this.isWeighted = isWeighted;
	}

	public void setVertices(Map<T, Integer> vertices) {
		this.vertices = vertices;
	}
}
