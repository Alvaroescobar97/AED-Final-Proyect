package graphEstructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class GraphList<T> implements GraphInterface<T>{
	
	private int numVertices;
	private int numEdges;
	private HashMap<Vertex<T>,Set<Edge<T>>> adjList;
	private boolean isDirected;
	private boolean isWeighted;
	private Vertex<T> refVertex;
	private int time;
	
	public GraphList(boolean isDirected, boolean isWeighted) {
		adjList = new HashMap<>();
		numVertices = 0;
		numEdges = 0;
		this.isDirected = isDirected;
		this.isWeighted = isWeighted;
	}
	
	public void addVertex(T element) {
		addVertex(new Vertex<T>(element));
	}
	
	@Override
	public void addVertex(Vertex<T> vertex) throws IllegalArgumentException {
		if(!adjList.containsKey(vertex)) {
			this.adjList.put(vertex, new HashSet<Edge<T>>());
			numVertices++;
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public void addEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException{
		if(adjList.containsKey(from) && adjList.containsKey(to)) {
			if(!isDirected) {
				adjList.get(to).add(new Edge<T>(to,from, 1.0));
			}
			adjList.get(from).add(new Edge<T>(from,to, 1.0));
			numEdges++;
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public void addEdge(Vertex<T> from, Vertex<T> to, double weight) throws IllegalArgumentException{
		if(!isWeighted) throw new IllegalArgumentException();
		
		if(adjList.containsKey(from) && adjList.containsKey(to)) {
			if(!isDirected) {
				adjList.get(to).add(new Edge<T>(to,from, weight));
			}
			adjList.get(from).add(new Edge<T>(from,to, weight));
			numEdges++;
		}else {
			throw new IllegalArgumentException();
		}
		
	}
	
	public void removeVertex(Vertex<T> vertex) throws IllegalArgumentException{
		if(adjList.containsKey(vertex)) {
			for(Edge<T> edge: getEdges()) {
				if(edge.initVertex().getValue().equals(vertex.getValue()) || edge.endVertex().getValue().equals(vertex.getValue())) {
					removeEdge(edge.initVertex(), edge.endVertex());
				}
			}
			adjList.remove(vertex);
		}else {
			throw new IllegalArgumentException();
		}
	}
	
	@Override
	public void removeEdge(Vertex<T> from, Vertex<T> to) {
		if(adjList.containsKey(from) && adjList.containsKey(to)) {
			for(Edge<T> edge: adjList.get(from)) {
				if(edge.endVertex().equals(to)) {
					adjList.get(from).remove(edge);
					return;
				}
			}
		}else{
			throw new IllegalArgumentException();
		}
		
	}
	
	@Override
	public Vertex<T> getVertex(T element) throws IllegalArgumentException{
		
		for(Vertex<T> vertex: getVertices()) {
			if(vertex.getValue().equals(element)) {
				return vertex;
			}
		}
		throw new IllegalArgumentException();
	}
	
	@Override
	public Iterable<Vertex<T>> getVertices() {
		return adjList.keySet();
	}
	
	@Override
	public Edge<T> getEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException{
		for(Edge<T> edge: adjList.get(from)) {
			if(edge.endVertex().equals(to)) {
				return edge;
			}
		}
		throw new IllegalArgumentException();
	}
	
	@Override
	public Iterable<Edge<T>> getEdges(Vertex<T> vertex) throws IllegalArgumentException{
		return adjList.get(vertex);
	}
	
	@Override
	public double getWeightEdge(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException {
		if(adjList.containsKey(from)) {
			for(Edge<T> edge: adjList.get(from)) {
				if(edge.endVertex().equals(to)){
					return edge.getWeight();
				}
			}
		}
		throw new IllegalArgumentException();
	}
	@Override
	public void setWeightEdge(Vertex<T> from, Vertex<T> to, double weight)throws IllegalArgumentException {
		if(adjList.containsKey(from) && adjList.containsKey(to)) {
			Edge<T> e1 = getEdge(from,to);
			e1.setWeight(weight);
			if(!isDirected) {
				Edge<T> e2 = getEdge(to,from);
				e2.setWeight(weight);
			}
			return;
		}
		
		throw new IllegalArgumentException();
	}
	
	@Override
	public boolean isAdjacent(Vertex<T> from, Vertex<T> to) throws IllegalArgumentException {
		if(!adjList.containsKey(from) || !adjList.containsKey(to)) throw new IllegalArgumentException();
		
		for(Edge<T> edge: adjList.get(from)) {
			if(edge.endVertex().equals(to)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public Set<Vertex<T>> adjacentVertices(Vertex<T> vertex) throws IllegalArgumentException{
		if(!adjList.containsKey(vertex)) throw new IllegalArgumentException();
		
		Set<Vertex<T>> adjVertices = new HashSet<Vertex<T>>();
		
		for(Edge<T> tempEdge: adjList.get(vertex)) {
			adjVertices.add(tempEdge.endVertex());
		}
		
		return adjVertices;
	}
	
	@Override
	public Iterable<Edge<T>> getEdges(){
		ArrayList<Edge<T>> edgesList = new ArrayList<Edge<T>>();
		
		for(Vertex<T> v:getVertices()) {
			for(Edge<T> e: adjList.get(v)) {
				edgesList.add(e);
			}
		}
		
		return edgesList;
	}
	
	@Override
	public ArrayList<Vertex<T>> vertexPath(Vertex<T> startVertex, Vertex<T> endVertex) throws IllegalArgumentException {
		
		if(!adjList.containsKey(endVertex)) throw new IllegalArgumentException();
		
		Vertex<T> tempVertex = endVertex;
		ArrayList<Vertex<T>> path = new ArrayList<>();
		
		while(tempVertex.getD() != 0) {
			path.add(tempVertex);
			tempVertex = tempVertex.getPred();
		}
		
		path.add(tempVertex);
		return path;
	}
	
	@Override
	public String toString() {
		String data = "";
		
		for(Vertex<T> vertex: getVertices()) {
			data+= "Vertex " + vertex + "={";
			
			for(Edge<T> edge: adjList.get(vertex)) {
				data += edge;
			}
			
			data += "}\n";
		}
		
		return data;
	}
	
	public Vertex<T> getRefVertex(){
		return refVertex;
	}
	
	public int getNumVertices() {
		return numVertices;
	}
	
	public int getNumEdges() {
		return numEdges;
	}
	
	public HashMap<Vertex<T>, Set<Edge<T>>> getAdjList() {
		return adjList;
	}
	
	public boolean isDirected() {
		return isDirected;
	}
	
	public boolean isWeighted() {
		return isWeighted;
	}
	
	@Override
	public void bfs(Vertex<T> startVertex) throws IllegalArgumentException{
		if(!adjList.containsKey(startVertex)) throw new IllegalArgumentException();
		
		for(Vertex<T> vertex: getVertices()) {
			if(!vertex.equals(startVertex)) {
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
		
		while(!queue.isEmpty()) {
			Vertex<T> actualVertex = queue.poll();
			
			for(Edge<T> tempEdge: adjList.get(actualVertex)) {
				
				Vertex<T> tempVertex = tempEdge.endVertex();
				
				if(tempVertex.getColor() == Vertex.WHITE) {
					tempVertex.setColor(Vertex.GRAY);
					tempVertex.setD(actualVertex.getD()+1);
					tempVertex.setPred(actualVertex);
					queue.offer(tempVertex);
				}
			}
			
			actualVertex.setColor(Vertex.BLACK);
		}
		
	}
	
	@Override
	public void dfs() {
		for(Vertex<T> u: getVertices()) {
			u.setColor(Vertex.WHITE);
			u.setPred(null);
		}
		
		for(Vertex<T> u: getVertices()) {
			if(u.getColor() == Vertex.WHITE) {
				dfsVisit(u);
			}
		}
	}
	
	private void dfsVisit(Vertex<T> u){
		time++;
		u.setD(time);
		u.setColor(Vertex.GRAY);
		
		for(Edge<T> e: adjList.get(u)) {
			Vertex<T> v = e.endVertex();
			if(v.getColor() == Vertex.WHITE) {
				v.setPred(u);
				dfsVisit(v);
			}
		}
		
		u.setColor(Vertex.BLACK);
		time++;
		u.setF(time);
	}
	
	@Override
	public void dijkstra(Vertex<T> startVertex) throws IllegalArgumentException {
		if(!adjList.containsKey(startVertex)) throw new IllegalArgumentException();
		
		initializeSingleSource(startVertex);
		Queue<Vertex<T>> priorityQ = new PriorityQueue<>(new VertexWeightComparator<Vertex<T>>());
		priorityQ.addAll(adjList.keySet());
		Set<Vertex<T>> vertexSet = new HashSet<Vertex<T>>();
		
		while(!priorityQ.isEmpty()) {
			Vertex<T> tempVertex = priorityQ.poll();
			
			if(!vertexSet.contains(tempVertex)) {
				for(Edge<T> tempEdge: adjList.get(tempVertex)) {
					relax(tempVertex,tempEdge.endVertex());
				}
				vertexSet.add(tempVertex);
			}
		}
	}
	
	@Override
	public boolean bellmanFord(Vertex<T> startVertex) throws IllegalArgumentException{
		if(!adjList.containsKey(startVertex)) throw new IllegalArgumentException();
		
		refVertex = startVertex;
		initializeSingleSource(startVertex);
		
		for(int i = 0; i < adjList.size(); i++) {
			for(Edge<T> edge: getEdges()) {
				relax(edge.initVertex(),edge.endVertex());
			}
		}
		
		for(Edge<T> tempEdge: getEdges()) {
			if(tempEdge.endVertex().getD() > tempEdge.initVertex().getD() + tempEdge.getWeight()) {
				return false;
			}
		}
		
		return true;
	}
	
	@Override
	public void initializeSingleSource(Vertex<T> vertex) {
		for(Vertex<T> tempVertex: getVertices()) {
			tempVertex.setD(INF);
			tempVertex.setPred(null);
		}
		vertex.setD(0);
	}
	
	@Override
	public void relax(Vertex<T> start,Vertex<T> finish) {
		double tempDistance = start.getD() + getEdge(start,finish).getWeight();
		
		if(finish.getD() > tempDistance) {
			finish.setD(tempDistance);
			finish.setPred(start);
		}
	}

	@Override
	public void prim(Vertex<T> vertex) {
		for(Vertex<T> u :getVertices()) {
			u.setD(INF);
			u.setColor(Vertex.WHITE);
		}
		
		vertex.setD(0);
		vertex.setPred(null);
		
		Queue<Vertex<T>> priorityQ = new PriorityQueue<Vertex<T>>();
		priorityQ.offer(vertex);
		
		while(!priorityQ.isEmpty()) {
			
			Vertex<T> tempVertex = priorityQ.poll();
			for(Edge<T> tempEdge: adjList.get(tempVertex)) {
				
				Vertex<T> v = tempEdge.endVertex();
				
				if(v.getColor() == Vertex.WHITE && (tempEdge.getWeight() < v.getD())) {
					v.setD(tempEdge.getWeight());
					priorityQ.offer(v);
					v.setPred(tempVertex);
				}
				
				tempVertex.setColor(Vertex.BLACK);
			}
		}
	}

	@Override
	public void kruskal() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void floydWarshall() {
		// TODO Auto-generated method stub
		
	}
}
