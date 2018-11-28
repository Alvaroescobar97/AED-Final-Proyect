package graphEstructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Adjacency List representation of the graph, includes the algorithms seen in
 * the AED course implemented with the adjacency list representation of the
 * graph.
 * 
 * @author Luis A. Rodriguez, Alvaro J. Escobar, Sebastian Correa.
 * @version 1.0
 * @since 2018-11-26
 * @param <T>
 *            vertex representation, based on the kind of problem to solve.
 */
public class GraphList<T> implements GraphInterface<T> {

	private int numVertices;
	private int numEdges;
	private HashMap<Vertex<T>, Set<Edge<T>>> adjList;
	private boolean isDirected;
	private boolean isWeighted;
	private Vertex<T> refVertex;
	private int time;

	/**
	 * This is the Graph constructor, represented as an Adjacency list. The graph
	 * can be directed and weighted.
	 * 
	 * @param isDirected
	 *            this parameter specifies if the graph has directed edges.
	 * @param isWeighted
	 *            this parameter specifies if the graph has weighted edges.
	 */
	public GraphList(boolean isDirected, boolean isWeighted) {
		adjList = new HashMap<>();
		numVertices = 0;
		numEdges = 0;
		this.isDirected = isDirected;
		this.isWeighted = isWeighted;
	}

	/**
	 * This method uses another method of this same class to add a vertex.
	 */
	@Override
	public void addVertex(T element) {
		addVertex(new Vertex<T>(element));
	}

	/**
	 * This method is used by another method of this same class. This method adds a
	 * vertex to the list representation of the graph.
	 * 
	 * @param vertex
	 *            the generic vertex to add.
	 * 
	 *            <b>pre:</b> vertex != null <b>post:</b> the vertex is succesfully
	 *            added, if the graph doesn't contain it.
	 * 
	 * @throws IllegalArgumentException
	 *             if the vertex to add is already an existent vertex of the graph.
	 */
	public void addVertex(Vertex<T> vertex) throws IllegalArgumentException {
		if (!adjList.containsKey(vertex)) {
			this.adjList.put(vertex, new HashSet<Edge<T>>());
			numVertices++;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * This method uses another method of this same class to add an edge.
	 */
	@Override
	public void addEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException {
		if (adjList.containsKey(from) && adjList.containsKey(to)) {
			if (!isDirected) {
				adjList.get(to).add(new Edge<T>(to, from, 1));
			}
			adjList.get(from).add(new Edge<T>(from, to, 1));
			numEdges++;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * This method is used by another of this same class to add a weighted edge from
	 * one starting vertex to an ending vertex.
	 * 
	 * @param from
	 *            is the generic vertex where the edge starts.
	 * @param to
	 *            is the generic vertex where the edge ends.
	 * @param weight
	 *            is the cost of using the edge.
	 * 
	 *            <b>pre:</b> from != null && to !=null <b>post:</b> the edge
	 *            between the vertexes from and to is succesfully created with its
	 *            weight, if from and to are vertexes of the graph.
	 * 
	 * 
	 * @throws IllegalArgumentException
	 *             if the edge isn't weighted or if the start and end vertexes
	 *             doesn't exist.
	 */
	@Override
	public void addEdge(Vertex<T> from, Vertex<T> to, int weight) throws IllegalArgumentException {
		if (!isWeighted)
			throw new IllegalArgumentException();

		if (adjList.containsKey(from) && adjList.containsKey(to)) {
			if (!isDirected) {
				adjList.get(to).add(new Edge<T>(to, from, weight));
			}
			adjList.get(from).add(new Edge<T>(from, to, weight));
			numEdges++;
		} else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * This method removes a vertex from the graph.
	 * 
	 * @param vertex
	 *            is the generic vertex that will be removed.
	 * 
	 *            <b>pre:</b> vertex != null <b>post:</b> the vertex is succesfully
	 *            removed, if the graph contains it.
	 * 
	 * @throws IllegalArgumentException
	 *             if the parameter vertex isn't a vertex of the graph.
	 * 
	 * 
	 */
	public void removeVertex(Vertex<T> vertex) throws IllegalArgumentException {
		if (adjList.containsKey(vertex)) {
			for (Edge<T> edge : getEdges()) {
				if (edge.initVertex().getValue().equals(vertex.getValue())
						|| edge.endVertex().getValue().equals(vertex.getValue())) {
					removeEdge(edge.initVertex(), edge.endVertex());
				}
			}
			adjList.remove(vertex);
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * This method removes an edge between two vertexes.
	 * 
	 * @param from
	 *            is the generic vertex where the edge to remove starts.
	 * @param to
	 *            is the generic vertex where the edge to remove ends. <b>pre:</b>
	 *            from != null && to != null <b>post:</b> the vertex between the
	 *            pair of vertexes from and to has been removed.
	 */
	@Override
	public void removeEdge(Vertex<T> from, Vertex<T> to) {
		if (adjList.containsKey(from) && adjList.containsKey(to)) {
			for (Edge<T> edge : adjList.get(from)) {
				if (edge.endVertex().equals(to)) {
					adjList.get(from).remove(edge);
					return;
				}
			}
		} else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * This method is used to get a vertex from the graph.
	 * 
	 * @param element
	 *            is the generic element used as vertex.
	 * 
	 *            <b>pre:</b> element != null <b>post:</b> returns the vertex if the
	 *            graph contains it.
	 * 
	 * @throws IllegalArgumentException
	 *             if the graph doesn't contain the parameter vertex.
	 */
	@Override
	public Vertex<T> getVertex(T element) throws IllegalArgumentException {

		for (Vertex<T> vertex : getVertices()) {
			if (vertex.getValue().equals(element)) {
				return vertex;
			}
		}
		throw new IllegalArgumentException();
	}

	/**
	 * This method returns all the vertexes from the graph.
	 */
	@Override
	public Iterable<Vertex<T>> getVertices() {
		return adjList.keySet();
	}

	/**
	 * This method returns the edge between two vertexes.
	 * 
	 * @param from
	 *            is the generic vertex where the edge starts.
	 * @param to
	 *            is the generic vertex where the edge ends. <b>pre:</b> from !=
	 *            null && to != null <b>post:</b> the method returns the edge
	 *            between from and to if they are vertexes from the graph.
	 * 
	 * @throws IllegalArgumentException
	 *             if the graph doesn't contain the vertexes from and to.
	 */
	@Override
	public Edge<T> getEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException {
		for (Edge<T> edge : adjList.get(from)) {
			if (edge.endVertex().equals(to)) {
				return edge;
			}
		}
		throw new IllegalArgumentException();
	}

	/**
	 * This method returns the edges of a vertex.
	 * 
	 * @param vertex
	 *            is the generic vertex where the starts. <b>pre:</b> vertex != null
	 *            <b>post:</b> the method returns the edges that start in the vertex
	 *            from.
	 * 
	 * @throws IllegalArgumentException
	 *             if the graph doesn't contain the vertex.
	 */
	@Override
	public Iterable<Edge<T>> getEdges(Vertex<T> vertex) throws IllegalArgumentException {
		return adjList.get(vertex);
	}

	/**
	 * This method returns the weight of a specific edge.
	 * 
	 * @param from
	 *            is the generic vertex where the edge starts.
	 * @param to
	 *            is the generic vertex where the edge ends.
	 * 
	 *            <b>pre:</b> from != null && to != null <b>post:</b> the method
	 *            returns the weight of the edge, if the graph contains the vertexes
	 *            from and to.
	 * @return int the weight of the edge.
	 * @throws IllegalArgumentException
	 *             if the graph doesn't contain the vertexes.
	 */
	@Override
	public int getWeightEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException {
		if (adjList.containsKey(from)) {
			for (Edge<T> edge : adjList.get(from)) {
				if (edge.endVertex().equals(to)) {
					return edge.getWeight();
				}
			}
		}
		throw new IllegalArgumentException();
	}

	/**
	 * This method is used to set or change the weight of an edge.
	 * 
	 * @param from
	 *            is the generic vertex where the edge starts.
	 * @param to
	 *            is the generic vertex where the edge ends.
	 * 
	 * @param weight
	 *            is the value to set as weight of the edge.
	 * 
	 *            <b>pre:</b> from != null && to != null <b>post:</b> the weight of
	 *            the edge is set or changed.
	 * @throws IllegalArgumentException
	 *             if the graph doesn't contain the vertexes.
	 */
	@Override
	public void setWeightEdge(Vertex<T> from, Vertex<T> to, int weight) throws IllegalArgumentException {
		if (adjList.containsKey(from) && adjList.containsKey(to)) {
			Edge<T> e1 = getEdge(from, to);
			e1.setWeight(weight);
			if (!isDirected) {
				Edge<T> e2 = getEdge(to, from);
				e2.setWeight(weight);
			}
			return;
		}

		throw new IllegalArgumentException();
	}

	/**
	 * @param from
	 *            is the generic vertex where the edge starts.
	 * @param to
	 *            is the generic vertex where the edge ends.
	 * 
	 *            <b>pre:</b> from != null && to != null <b>post:</b> the method
	 *            returns true if between the vertex from starts an edge that ends
	 *            in the vertex to.
	 * @throws IllegalArgumentException
	 *             if the graph doesn't contain the vertexes.
	 */
	@Override
	public boolean isAdjacent(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException {
		if (!adjList.containsKey(from) || !adjList.containsKey(to))
			throw new IllegalArgumentException();

		for (Edge<T> edge : adjList.get(from)) {
			if (edge.endVertex().equals(to)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 */
	@Override
	public Set<Vertex<T>> adjacentVertices(Vertex<T> vertex) throws IllegalArgumentException {
		if (!adjList.containsKey(vertex))
			throw new IllegalArgumentException();

		Set<Vertex<T>> adjVertices = new HashSet<Vertex<T>>();

		for (Edge<T> tempEdge : adjList.get(vertex)) {
			adjVertices.add(tempEdge.endVertex());
		}

		return adjVertices;
	}

	/**
	 * This method returns the edges of the graph as an ArrayList.
	 */
	@Override
	public Iterable<Edge<T>> getEdges() {
		ArrayList<Edge<T>> edgesList = new ArrayList<Edge<T>>();

		for (Vertex<T> v : getVertices()) {
			for (Edge<T> e : adjList.get(v)) {
				edgesList.add(e);
			}
		}

		return edgesList;
	}

	/**
	 * 
	 */
	@Override
	public ArrayList<Vertex<T>> vertexPath(Vertex<T> startVertex, Vertex<T> endVertex) throws IllegalArgumentException {

		if (!adjList.containsKey(endVertex))
			throw new IllegalArgumentException();

		Vertex<T> tempVertex = endVertex;
		ArrayList<Vertex<T>> path = new ArrayList<>();

		while (tempVertex.getD() != 0) {
			path.add(tempVertex);
			tempVertex = tempVertex.getPred();
		}

		path.add(tempVertex);
		return path;
	}

	/**
	 * This method returns the adjacencies of every vertex. The method returns the
	 * adjacency list as a String.
	 */
	@Override
	public String toString() {
		String data = "";

		for (Vertex<T> vertex : getVertices()) {
			data += "Vertex " + vertex + "={";

			for (Edge<T> edge : adjList.get(vertex)) {
				data += edge;
			}

			data += "}\n";
		}

		return data;
	}

	public Vertex<T> getRefVertex() {
		return refVertex;
	}

	/**
	 * This method returns the number of vertexes of the graph.
	 * 
	 * @return int the number of vertexes of the graph.
	 */
	public int getNumVertices() {
		return numVertices;
	}

	/**
	 * This method returns the number of edges of the graph
	 * 
	 * @return
	 */
	public int getNumEdges() {
		return numEdges;
	}

	/**
	 * This method returns the adjacency list.
	 * 
	 * @return HashMap the adjacency list.
	 */
	public HashMap<Vertex<T>, Set<Edge<T>>> getAdjList() {
		return adjList;
	}

	/**
	 * This method returns the state of the direction of the graph.
	 * 
	 * @return boolean the method returns true if the graph is directed.
	 */
	public boolean isDirected() {
		return isDirected;
	}

	/**
	 * This method returns the state of the edges of the graph.
	 * 
	 * @return boolean the method returns true if the graph has weighted edges.
	 */
	public boolean isWeighted() {
		return isWeighted;
	}

	/**
	 * This method explores all of the adjacencies of a vertex before exploring the
	 * adjacencies of the next level.
	 */
	@Override
	public void bfs(Vertex<T> startVertex) throws IllegalArgumentException {
		if (!adjList.containsKey(startVertex))
			throw new IllegalArgumentException();

		for (Vertex<T> vertex : getVertices()) {
			if (!vertex.equals(startVertex)) {
				vertex.setColor(Vertex.WHITE);
				vertex.setD(INF);
				vertex.setPred(null);
			}
		}

		startVertex.setColor(Vertex.GRAY);
		startVertex.setD(0);
		startVertex.setPred(null);

		Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
		queue.offer(startVertex);

		while (!queue.isEmpty()) {
			Vertex<T> actualVertex = queue.poll();

			for (Edge<T> tempEdge : adjList.get(actualVertex)) {

				Vertex<T> tempVertex = tempEdge.endVertex();

				if (tempVertex.getColor() == Vertex.WHITE) {
					tempVertex.setColor(Vertex.GRAY);
					tempVertex.setD(actualVertex.getD() + 1);
					tempVertex.setPred(actualVertex);
					queue.offer(tempVertex);
				}
			}

			actualVertex.setColor(Vertex.BLACK);
		}

	}

	/**
	 * This method explores from one vertex considered the root vertex as far as
	 * possible before backtracking.
	 */
	@Override
	public void dfs() {
		for (Vertex<T> u : getVertices()) {
			u.setColor(Vertex.WHITE);
			u.setPred(null);
		}

		for (Vertex<T> u : getVertices()) {
			if (u.getColor() == Vertex.WHITE) {
				dfsVisit(u);
			}
		}
	}

	/**
	 * This method is used by another method of this same class. It's used to mark
	 * which vertexes are visited.
	 * 
	 * @param u
	 *            the visited vertex.
	 */
	private void dfsVisit(Vertex<T> u) {
		time++;
		u.setD(time);
		u.setColor(Vertex.GRAY);

		for (Edge<T> e : adjList.get(u)) {
			Vertex<T> v = e.endVertex();
			if (v.getColor() == Vertex.WHITE) {
				v.setPred(u);
				dfsVisit(v);
			}
		}

		u.setColor(Vertex.BLACK);
		time++;
		u.setF(time);
	}

	/**
	 * This method is used to find the shortest path from one vertex to the other
	 * vertexes.
	 */
	@Override
	public void dijkstra(Vertex<T> startVertex) throws IllegalArgumentException {
		if (!adjList.containsKey(startVertex))
			throw new IllegalArgumentException();

		initializeSingleSource(startVertex);
		Queue<Vertex<T>> priorityQ = new PriorityQueue<>(new VertexWeightComparator<Vertex<T>>());
		priorityQ.addAll(adjList.keySet());
		Set<Vertex<T>> vertexSet = new HashSet<Vertex<T>>();

		while (!priorityQ.isEmpty()) {
			Vertex<T> tempVertex = priorityQ.poll();

			if (!vertexSet.contains(tempVertex)) {
				for (Edge<T> tempEdge : adjList.get(tempVertex)) {
					relax(tempVertex, tempEdge.endVertex());
				}
				vertexSet.add(tempVertex);
			}
		}
	}

	/**
	 * This method is used to find the shortest path from one vertex to other
	 * vertexes, it can work with negative weighted edges.
	 */
	@Override
	public boolean bellmanFord(Vertex<T> startVertex) throws IllegalArgumentException {
		if (!adjList.containsKey(startVertex))
			throw new IllegalArgumentException();

		refVertex = startVertex;
		initializeSingleSource(startVertex);

		for (int i = 0; i < adjList.size(); i++) {
			for (Edge<T> edge : getEdges()) {
				relax(edge.initVertex(), edge.endVertex());
			}
		}

		for (Edge<T> tempEdge : getEdges()) {
			if (tempEdge.endVertex().getD() > tempEdge.initVertex().getD() + tempEdge.getWeight()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public void initializeSingleSource(Vertex<T> vertex) {
		for (Vertex<T> tempVertex : getVertices()) {
			tempVertex.setD(INF);
			tempVertex.setPred(null);
		}
		vertex.setD(0);
	}

	/**
	 * This method is used by other methods that find the shortest path.
	 */
	@Override
	public void relax(Vertex<T> start, Vertex<T> finish) {
		double tempDistance = start.getD() + getEdge(start, finish).getWeight();

		if (finish.getD() > tempDistance) {
			finish.setD(tempDistance);
			finish.setPred(start);
		}
	}

	/**
	 * This method is used to find the minimum spanning tree for a connected graph.
	 */
	@Override
	public void prim(Vertex<T> vertex) {
		for (Vertex<T> u : getVertices()) {
			u.setD(INF);
			u.setColor(Vertex.WHITE);
		}

		vertex.setD(0);
		vertex.setPred(null);

		Queue<Vertex<T>> priorityQ = new PriorityQueue<Vertex<T>>();
		priorityQ.offer(vertex);

		while (!priorityQ.isEmpty()) {

			Vertex<T> tempVertex = priorityQ.poll();
			for (Edge<T> tempEdge : adjList.get(tempVertex)) {

				Vertex<T> v = tempEdge.endVertex();

				if (v.getColor() == Vertex.WHITE && (tempEdge.getWeight() < v.getD())) {
					v.setD(tempEdge.getWeight());
					priorityQ.offer(v);
					v.setPred(tempVertex);
				}

				tempVertex.setColor(Vertex.BLACK);
			}
		}
	}

	/**
	 * This method is used to find the minimum spanning tree for a connected or
	 * disconnected graph.
	 */
	@Override
	public ArrayList<Edge<T>> kruskal() {
		return null;
	}

	/**
	 * This method is used to find the shortest path from any vertex to any other
	 * vertex.
	 */
	@Override
	public int[][] floydWarshall() {
		return null;
	}
}// * <b>pre:</b> vertex != null
	// * <b>post:</b> the vertex is succesfully removed, if the graph contains it.
