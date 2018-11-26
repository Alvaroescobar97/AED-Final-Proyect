package graphEstructure;

import java.util.ArrayList;
import java.util.Set;

public class GraphMatrix<T> {

	private int numVertex;
	private int weight;
	private boolean isDirected;
	private boolean isWeighted;
	private ArrayList<ArrayList<Edge<T>>> matrix;
	private ArrayList<Vertex<T>> vertexs;
	
	public GraphMatrix() {
		matrix = new ArrayList<>();
		vertexs = new ArrayList<>();
	}

	 public GraphMatrix(int n) throws IllegalArgumentException {
	        if (n < 1) {
	            throw new IllegalArgumentException("Error al crear grafo: n < 1");
	        }
	        for (int i = 0; i < n; i++) {
	            if (i > 0) {
	                this.vertexs.add(new Vertex<T>(null));
	                this.numVertex++;
	                this.matrix.add(new ArrayList<Edge<T>>());
	            }
	            for (int j = 0; j < n; j++) {
	                if (!(i == 0 && j == 0)) {
	                    this.matrix.get(i).add(null);
	                }
	            }
	        }
	    }
	public void addVertex(Vertex v) throws IllegalArgumentException {
        if (this.vertexs.contains(v)) {
            throw new IllegalArgumentException("Error al añadir vértice: el vértice ya existe.");
        }
        this.vertexs.add(v);
        this.matrix.add(new ArrayList<Edge<T>>());
        this.numVertex++;
        for (int i = 0; i < this.numVertex; i++) {
            int dif = this.numVertex - this.matrix.get(i).size();
            for (int j = 0; j < dif; j++) {
                this.matrix.get(i).add(null);
            }
        }
    }
	
}
