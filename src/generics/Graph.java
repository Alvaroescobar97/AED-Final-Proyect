package generics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Graph<T> implements GraphInterface<T> {
	
	 // add vertex name as key, and neighbors as values in set
	private HashMap<String, HashSet<T>> adjList = new HashMap<String, HashSet<T>>();

    public void addVertex(T element) {
        if (adjList.containsKey(element.toString())) {
            throw new IllegalArgumentException();
        }
        adjList.put(element.toString(), new HashSet<T>());
    }

    public void addEdge(T source, T destination) {
        // are both vertexes already in the graph?
        if (!adjList.containsKey(source.toString()) || !adjList.containsKey(destination.toString())) {
            throw new IllegalArgumentException();
        }

        // does edge already exist?
        if (adjList.get(source.toString()).contains(destination)) {
            throw new IllegalArgumentException();
        } else {
            adjList.get(source.toString()).add(destination);
        }
    }

    public HashSet<T> getEdges(T element) {
        return adjList.get(element.toString());
    }

    // return true if there is an edge from source -> destination
    public boolean isEdge(T source, T destination) {
        if (!adjList.containsKey(source.toString()) || !adjList.containsKey(destination.toString())) {
            throw new IllegalArgumentException();
        }
        return adjList.get(source.toString()).contains(destination);
    }
    
    public boolean containsVertex(T element) {
    	return adjList.containsKey(element.toString());
    }

    public void removeEdge(T source, T destination) {
        if (!adjList.containsKey(source.toString()) || !adjList.containsKey(destination.toString())) {
            throw new IllegalArgumentException();
        }
        adjList.get(source.toString()).remove(destination);
    }

    public void removeVertex(T element) {
        if (!adjList.containsKey(element.toString())) {
            throw new IllegalArgumentException();
        }
        // remove vertex and its neighbors, if any
        adjList.remove(element.toString());

        // remove vertex as a neighbors from other vertexes
        Set<String> vertexes = adjList.keySet();
        Iterator<String> i = vertexes.iterator();
        while (i.hasNext()) {
            String vertex = (String) i.next();
            if (adjList.get(vertex).contains(element)) {
                adjList.get(vertex).remove(element);
            }
        }
    }

    // removes all vertexes/edges from graph
    public void clear() {
        adjList = new HashMap<String, HashSet<T>>();
    }

    // returns the number of vertexes
    public int size() {
        return adjList.size();
    }

    public boolean isEmpty() {
        return adjList.isEmpty();
    }
    
    

}
