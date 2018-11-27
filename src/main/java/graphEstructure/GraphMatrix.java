package graphEstructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Adjacency Matrix representation of the graph, includes the algorithms seen in
 * the AED course implemented with the adjacency matrix representation of the
 * graph.
 * 
 * @author Luis A. Rodriguez, �lvaro J. Escobar, Sebasti�n Correa.
 * @version 1.0
 * @since 2018-11-26
 * @param <T>
 *            vertex representation, based on the kind of problem to solve.
 */

public class GraphMatrix<T> implements GraphInterface<T> {

	private Map<T, Integer> vertices;
	private List<Vertex<T>> listVertex;
	private int[][] adjMatrix;
	private int[][] distMatrix;
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
		
		for(int i = 0; i < numVertex; i++) {
			adjMatrix[i][i] = 0;
		}

		distMatrix = adjMatrix.clone();
	}

	@Override
	public void addVertex(T element) {
		Vertex<T> vertex = new Vertex<>(element);
		addVertex(vertex);
	}

	private void addVertex(Vertex<T> vertex) throws IllegalArgumentException {
		if (vertices.containsKey(vertex.getValue()))
			throw new IllegalArgumentException("Vertex exist");
		vertices.put(vertex.getValue(), index);
		listVertex.add(vertex);
		index++;
	}

	@Override
	public void addEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException {
		if (!vertices.containsKey(from.getValue()) || !vertices.containsKey(to.getValue())) {
			throw new IllegalArgumentException("Vertex not found");
		}

		int indexVertex1 = vertices.get(from.getValue());
		int indexVertex2 = vertices.get(to.getValue());
		
		adjMatrix[indexVertex1][indexVertex2] = 1;
		if (!isDirected)
			adjMatrix[indexVertex2][indexVertex2] = 1;
	}

	@Override
	public void addEdge(Vertex<T> from, Vertex<T> to, int weight) throws IllegalArgumentException {
		if (!isWeighted)
			throw new IllegalArgumentException("The graph is not weighted");
		if (!vertices.containsKey(from.getValue()) || !vertices.containsKey(to.getValue())) {
			throw new IllegalArgumentException("Vertex not found");
		}

		int indexVertex1 = vertices.get(from.getValue());
		int indexVertex2 = vertices.get(to.getValue());

		adjMatrix[indexVertex1][indexVertex2] = weight;
		if (!isDirected)
			adjMatrix[indexVertex2][indexVertex2] = weight;

	}

	@Override
	public void removeVertex(Vertex<T> vertex) {

	}

	@Override
	public void removeEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException {
		if (!vertices.containsKey(from.getValue()) || !vertices.containsKey(to.getValue())) {
			throw new IllegalArgumentException("Vertex not found");
		}

		int indexVertex1 = vertices.get(from.getValue());
		int indexVertex2 = vertices.get(to.getValue());

		adjMatrix[indexVertex1][indexVertex2] = INF;
		
		if (!isWeighted)
			adjMatrix[indexVertex2][indexVertex1] = INF;

	}

	@Override
	public Vertex<T> getVertex(T element) throws IllegalArgumentException {
		if (vertices.containsKey(element))
			return listVertex.get(vertices.get(element));
		throw new IllegalArgumentException("Vertex not found");
	}

	@Override
	public Iterable<Vertex<T>> getVertices() {
		return this.listVertex;
	}

	@Override
	public Edge<T> getEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException {
		return null;
	}

	@Override
	public Iterable<Edge<T>> getEdges(Vertex<T> vertex) throws IllegalArgumentException {
		ArrayList<Edge<T>> edges = new ArrayList<>();
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[0].length; j++) {
				if (adjMatrix[i][j] == 1)
					edges.add(new Edge<T>(listVertex.get(i), listVertex.get(j), distMatrix[i][j]));
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

		if (adjMatrix[indexVertex1][indexVertex2] != INF)
			return true;
		else
			return false;
	}

	@Override
	public Set<Vertex<T>> adjacentVertices(Vertex<T> vertex) {
		return null;
	}

	@Override
	public ArrayList<Edge<T>> getEdges() {
		ArrayList<Edge<T>> edges = new ArrayList<>();
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[0].length; j++) {
				if (adjMatrix[i][j] == 1) {
					edges.add(new Edge<T>(listVertex.get(i), listVertex.get(j), distMatrix[i][j]));
				}
			}
		}
		return edges;
	}

	@Override
	public ArrayList<Vertex<T>> vertexPath(Vertex<T> startVertex, Vertex<T> endVertex) 
			throws IllegalArgumentException {
		return null;
	}

	@Override
	public void bfs(Vertex<T> startVertex) {
		if (!vertices.containsKey(startVertex.getValue())) {
			throw new IllegalArgumentException("Vertex not found");
		}
		for (Vertex<T> u : getVertices()) {
			if (!u.equals(startVertex)) {
				u.setColor(Vertex.WHITE);
				u.setD(INF);
				u.setPred(null);
			}
		}
		startVertex.setColor(Vertex.GRAY);
		startVertex.setD(0);
		startVertex.setPred(null);
		Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
		queue.offer(startVertex);
		while (!queue.isEmpty()) {
			Vertex<T> u = queue.poll();
			int index = vertices.get(u.getValue());
			for (int i = 0; i < vertices.size(); i++) {
				if (i != index) {
					if (adjMatrix[index][i] != INF) {
						Vertex<T> v = listVertex.get(i);
						if (v.getColor() == Vertex.WHITE) {
							v.setColor(Vertex.GRAY);
							v.setD(u.getD());
							v.setPred(u);
							queue.offer(v);
						}
					}
				}
			}
			u.setColor(Vertex.BLACK);
		}
	}

	@Override
	public void dfs() {
		for (Vertex<T> v : listVertex) {
			v.setColor(Vertex.WHITE);
		}
		for (Vertex<T> u : listVertex) {
			if (u.getColor() == Vertex.WHITE) {
				dfsVisit(u);
			}
		}
	}

	private void dfsVisit(Vertex<T> vertex) {
		vertex.setColor(Vertex.BLACK);
		int indexU = vertices.get(vertex);
		for (int i = 0; i < vertices.size(); i++) {
			if (i != indexU) {
				Vertex<T> v = listVertex.get(i);
				if (adjMatrix[indexU][i] != INF && v.getColor() == Vertex.WHITE) {
					v.setPred(vertex);
					dfsVisit(v);
				}
			}
		}
	}

	@Override
	public void dijkstra(Vertex<T> startVertex) {
		ShortestPath sp = new ShortestPath();
		int src = vertices.get(startVertex.getValue());
		sp.dijkstra(distMatrix, src);
	}

	@Override
	public boolean bellmanFord(Vertex<T> starVertex) {
		ShortestPath sp = new ShortestPath();
		int src = vertices.get(starVertex.getValue());
		return sp.bellmanford(distMatrix, src);
	}

	@Override
	public void initializeSingleSource(Vertex<T> vertex) {

	}

	@Override
	public void relax(Vertex<T> start, Vertex<T> finish) {

	}

	public ArrayList<Vertex<T>> getAdjacentVertices(Vertex<T> v) {
		int index = vertices.get(v.getValue());
		ArrayList<Vertex<T>> result = new ArrayList<Vertex<T>>();

		for (int i = 0; i < adjMatrix[index].length; i++) {
			if (adjMatrix[index][i] != INF && adjMatrix[index][i] != 0)
				result.add(listVertex.get(i));
		}
		return result;
	}

	@Override
	public void prim(Vertex<T> vertex) {
		for (Vertex<T> v : listVertex) {
			v.setD(INF);
			v.setPred(null);
			v.setColor(Vertex.WHITE);
		}
		vertex.setD(0);
		vertex.setPred(null);
		PriorityQueue<Vertex<T>> q = new PriorityQueue<>();
		q.offer(vertex);
		while (!q.isEmpty()) {
			Vertex<T> u = q.poll();
			ArrayList<Vertex<T>> adjVertices = getAdjacentVertices(u);
			for (Vertex<T> v : adjVertices) {
				int w = getEdgeWeight(u, v);
				if (v.getColor() == Vertex.WHITE && w < v.getD()) {
					v.setD(w);
					q.offer(v);
					v.setPred(u);

				}
				u.setColor(Vertex.BLACK);
			}
		}
	}

	@Override
	public int[][] floydWarshall() {
		int[][] weightMatrix = adjMatrix.clone();

		for (int k = 0; k < weightMatrix.length; k++) {
			for (int i = 0; i < weightMatrix.length; i++) {
				for (int j = 0; j < weightMatrix.length; j++) {
					if (weightMatrix[i][j] > weightMatrix[i][k] + weightMatrix[k][j]) {
						weightMatrix[i][j] = weightMatrix[i][k] + weightMatrix[k][j];
					}
				}
			}
		}
		distMatrix = weightMatrix;
		return weightMatrix;
	}

	@Override
	public ArrayList<Edge<T>> kruskal() {
		ArrayList<Edge<T>> res = new ArrayList<>();
		int a = 0;
		int i = 0;
		ArrayList<Edge<T>> edgesList = getEdges();
		Collections.sort(edgesList);
		UnionFind u = new UnionFind(listVertex.size());

		while (a < listVertex.size() - 1 && i < edgesList.size()) {
			Edge<T> edge = edgesList.get(i);
			i++;
			int x = u.find(listVertex.indexOf(edge.initVertex()));
			int y = u.find(listVertex.indexOf(edge.endVertex()));
			if (x != y) {
				res.add(edge);
				u.union(x, y);
			}
		}
		return res;
	}

	public int getEdgeWeight(Vertex<T> u, Vertex<T> v) {
		int posU = vertices.get(u.getValue());
		int posV = vertices.get(v.getValue());
		return distMatrix[posU][posV];
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

	protected class ShortestPath {

		private int minDistance(int[] dist, boolean sptSet[]) {
			int min = INF;
			int min_index = -1;
			for (int i = 0; i < listVertex.size(); i++) {
				if (sptSet[i] == false && dist[i] < min) {
					min = dist[i];
					min_index = i;
				}
			}

			return min_index;
		}

		private void dijkstra(int[][] graph, int src) {
			int[] dist = new int[listVertex.size()];
			boolean[] sptSet = new boolean[listVertex.size()];

			for (int i = 0; i < listVertex.size(); i++) {
				dist[i] = INF;
				sptSet[i] = false;
			}

			dist[src] = 0;
			int u = -1;
			for (int count = 0; count < listVertex.size() - 1; count++) {
				u = minDistance(dist, sptSet);
				sptSet[u] = true;
				for (int v = 0; v < listVertex.size(); v++) {
					if (!sptSet[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
						dist[v] = dist[u] + graph[u][v];
						listVertex.get(v).setD(dist[u] + graph[u][v]);
						listVertex.get(v).setPred(listVertex.get(u));
					}
				}
			}
			distMatrix[src] = dist;

		}

		private boolean bellmanford(int[][] graph, int src) {
			int[] dist = new int[listVertex.size()];
			boolean[] sptSet = new boolean[listVertex.size()];
			for (int i = 0; i < listVertex.size(); i++) {
				dist[i] = INF;
				sptSet[i] = false;
			}
			dist[src] = 0;
			int u = -1;
			for (int count = 0; count < listVertex.size() - 1; count++) {
				u = minDistance(dist, sptSet);
				sptSet[u] = true;
				for (int v = 0; v < listVertex.size(); v++) {
					if (!sptSet[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
						dist[v] = dist[u] + graph[u][v];
						listVertex.get(v).setD(dist[u] + graph[u][v]);
						listVertex.get(v).setPred(listVertex.get(u));
					}
				}
			}

			for (int v = 0; v < listVertex.size(); v++) {
				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
					return false;
				}
			}
			distMatrix[src] = dist;
			return true;

		}
	}

}
