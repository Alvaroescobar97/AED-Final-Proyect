package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import graphEstructure.GraphMatrix;


class AdjMatrixGraphTest {

	GraphMatrix<Integer> graph;
	
	void setUpNoDirected() {
		graph = new GraphMatrix<>(10, false, false);
	}
	
	@Test
	void addVertexTest() {
		setUpNoDirected();
		
		graph.addVertex(15);
		graph.addVertex(20);
		
		assertTrue(graph.getListVertex().size() == 2);
	}

}
