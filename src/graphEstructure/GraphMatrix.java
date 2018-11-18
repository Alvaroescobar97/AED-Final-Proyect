package graphEstructure;

import java.util.ArrayList;
import java.util.Set;

public class GraphMatrix<V extends Number> {

	private V numNodes;
	private V[][] adjMatrix;
	private boolean isDirected;
	private boolean isWeighted;

	public GraphMatrix(V numNodes,boolean isDirected,boolean isWeighted) {
		this.numNodes = numNodes;
		this.isWeighted = isWeighted;
		this.isDirected = isDirected;
		adjMatrix = (V[][])new Object [(int) numNodes][(int) numNodes];
	}

	public void addVertex(V i) throws IllegalArgumentException {
		addVertex(adjMatrix,i);
	}

	public void addVertex(Object obj[][],V i){
        if((int)i > obj.length){
            Object[][] tempVar = new Object[(int) i][(int) i];
            if (obj != null)
                    System.arraycopy(obj, 0, tempVar, 0, Math.min(obj.length, tempVar.length));
            obj = tempVar;
        }
    }
	
	public void addEdge(V from, V to) throws IllegalArgumentException{
		
	}
	
}
