package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graphEstructure.Edge;
import graphEstructure.GraphList;
import graphEstructure.GraphMatrix;
import graphEstructure.Vertex;


class AdjMatrixGraphTest {

	public static final int LENGTH = 10;
	
	GraphMatrix<Integer> graph;
	
	void setUpNoDirected() {
		graph = new GraphMatrix<Integer>(LENGTH,false, false);
	}
	
	void setUpDirected() {
		graph = new GraphMatrix<Integer>(LENGTH,true, false);
	}
	
	void setUpWeight() {
		graph = new GraphMatrix<Integer>(LENGTH,true, true);
	}
	
	void setUp2Weight() {
		setUpWeight();
		
		Vertex<Integer> v1 = new Vertex<Integer>(1);
		Vertex<Integer> v2 = new Vertex<Integer>(2);
		Vertex<Integer> v3 = new Vertex<Integer>(3);
		Vertex<Integer> v4 = new Vertex<Integer>(4);
		Vertex<Integer> v5 = new Vertex<Integer>(5);
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		
		graph.addEdge(v1, v2, 3);
		graph.addEdge(v2, v4, 4);
		graph.addEdge(v2, v3, 4);
		graph.addEdge(v3, v5, 2);
		graph.addEdge(v1, v3, 1);
	}
	
	void setUp2Directed() {
		setUpDirected();
		
		Vertex<Integer> v1 = new Vertex<Integer>(1);
		Vertex<Integer> v2 = new Vertex<Integer>(2);
		Vertex<Integer> v3 = new Vertex<Integer>(3);
		Vertex<Integer> v4 = new Vertex<Integer>(4);
		Vertex<Integer> v5 = new Vertex<Integer>(5);
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		
		graph.addEdge(v1, v2);
		graph.addEdge(v2, v4);
		graph.addEdge(v2, v3);
		graph.addEdge(v3, v5);
		graph.addEdge(v1, v3);
	}
	
	void setUp2NoDirected() {
		setUpNoDirected();
		
		Vertex<Integer> v1 = new Vertex<Integer>(1);
		Vertex<Integer> v2 = new Vertex<Integer>(2);
		Vertex<Integer> v3 = new Vertex<Integer>(3);
		Vertex<Integer> v4 = new Vertex<Integer>(4);
		Vertex<Integer> v5 = new Vertex<Integer>(5);
		
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		
		graph.addEdge(v1, v2);
		graph.addEdge(v2, v4);
		graph.addEdge(v2, v3);
		graph.addEdge(v3, v5);
		graph.addEdge(v1, v3);	
	}
	
	@Test
	void addVertexTest() {
		setUpNoDirected();
		
		graph.addVertex(6);
		
		assertTrue(graph.getListVertex().contains(graph.getVertex(6))&& graph.getVertex(6).getValue() == 6);

	}
	
	@Test
	void addVertexTest2() {
		setUpDirected();
		
		graph.addVertex(7);
		
		assertTrue(graph.getListVertex().contains(graph.getVertex(7)));
	}
	
	@Test
	void addVertexTest3() {
		setUpWeight();
		
		graph.addVertex(5);
		
		assertTrue(graph.getListVertex().contains(graph.getVertex(5)));
	}
	
	@Test
	void getVertexTest() {
		setUpWeight();
		
		Vertex<Integer> v1 = new Vertex<Integer>(4);
		Vertex<Integer> v2 = new Vertex<Integer>(5);

		
		graph.addVertex(4);
		graph.addVertex(5);
		
		graph.addEdge(v1, v2, 3);
		
		
		assertTrue(graph.getAdjMatrix()[0][0]==0 && graph.getWeightEdge(v1, v2)==3 );
	}
	
	@Test
	void addEdgeTest() {
		
	}
	
}