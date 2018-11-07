package test;

import static org.junit.Assert.*;

import org.junit.Test;

import generics.Graph;

public class GraphTest {

	private Graph<String> graph;
	
	
	public void setUp1() {
		graph =  new Graph<String>();
	}
	
	@Test
	public void addVextexTest() {
		setUp1();
		boolean before = graph.isEmpty();
		graph.addVertex("Alvaro");
		boolean after = graph.isEmpty();
		assertTrue(before && !after);
	}

}
