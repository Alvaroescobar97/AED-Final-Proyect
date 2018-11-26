package test;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graphEstructure.Edge;
import graphEstructure.GraphList;
import graphEstructure.Vertex;

class AdjListGraphTest {
	
	GraphList<Integer> graph;
	
	void setUpNoDirected() {
		graph = new GraphList<>(false, false);
	}
	
	void setUpDirected() {
		graph = new GraphList<>(true, false);
	}
	
	void setUpWeight() {
		graph = new GraphList<>(true, true);
	}
	
	void setUp2Weight() {
		setUpWeight();
		
		Vertex<Integer> v1 = new Vertex<>(0);
		Vertex<Integer> v2 = new Vertex<>(1);
		
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addEdge(v1, v2, 3);
	}
	
	void setUp2Directed() {
		setUpDirected();
		
		Vertex<Integer> v1 = new Vertex<>(63);
		Vertex<Integer> v2 = new Vertex<>(29);
		
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addEdge(v1, v2);
	}
	
	void setUp2NoDirected() {
		setUpNoDirected();
		
		graph.addVertex(new Vertex<Integer>(50));
		graph.addVertex(new Vertex<Integer>(20));
	}
	
	@Test
	void addVertexTest() {
		setUpNoDirected();
		
		Vertex<Integer> vertex = new Vertex<Integer>(18);
		graph.addVertex(vertex);
		
		assertTrue(graph.getAdjList().keySet().contains(vertex));
	}
	
	@Test
	void addVertexTest2() {
		setUpNoDirected();
		
		graph.addVertex(10);
		graph.addVertex(25);
		graph.addVertex(15);
		graph.addVertex(48);
		
		assertTrue(graph.getAdjList().size() == 4 && graph.getAdjList().containsKey(graph.getVertex(48)));
	}
	
	@Test
	void getVertexTest() {
		setUpNoDirected();
		
		Vertex<Integer> vertex = new Vertex<Integer>(1);
		vertex.setColor(Vertex.BLACK);
		vertex.setD(4);
		vertex.setPred(null);
		graph.addVertex(vertex);
		Vertex<Integer> v = graph.getVertex(1);
		
		assertTrue(v.getColor() == Vertex.BLACK && v.getD() == 4 && v.getPred() == null && v.equals(vertex));
	}
	
	@Test
	void RemoveVertexTest() {
		setUpNoDirected();
		
		graph.addVertex(4);
		graph.removeVertex(graph.getVertex(4));
		
		assertTrue(graph.getAdjList().isEmpty());
	}
	
	@Test
	void addEdgeTest() {
		setUp2NoDirected();
		
		Vertex<Integer> v1 = graph.getVertex(50);
		Vertex<Integer> v2 = graph.getVertex(20);
		graph.addEdge(v1, v2);
		Edge<Integer> e = graph.getEdge(v1, v2);
		
		assertTrue(e.endVertex().getValue() == 20);
	}
	
	@Test
	void removeEdgeTest() {
		setUp2NoDirected();
		
		Vertex<Integer> v1 = graph.getVertex(50);
		Vertex<Integer> v2 = graph.getVertex(20);
		graph.addEdge(v1, v2);
		Edge<Integer> edge = graph.getEdge(v1, v2);
		
		graph.removeEdge(v1, v2);
	
		assertFalse(graph.getAdjList().get(v1).contains(edge));
	}
	
	@Test
	void directedAddEdgeTest() {
		setUp2Directed();
		
		Vertex<Integer> v1 = graph.getVertex(63);
		Vertex<Integer> v2 = graph.getVertex(29);
		
		Edge<Integer> edge = graph.getEdge(v1, v2);
		
		assertTrue(graph.getAdjList().get(v2).isEmpty() && edge.endVertex().getValue() == 29 && edge.initVertex().getValue() == 63);
	}
	
	@Test
	void addEdgeWeightTest() {
		setUp2Weight();
		
		Vertex<Integer> v1 = graph.getVertex(0);
		Vertex<Integer> v2 = graph.getVertex(1);
		
		Edge<Integer> edge = graph.getEdge(v1, v2);
		
		assertTrue(graph.getAdjList().get(v2).isEmpty() && edge.endVertex().getValue() == 1 &&
				edge.initVertex().getValue() == 0 && edge.getWeight() == 3);
	}

}
