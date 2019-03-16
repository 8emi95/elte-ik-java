package graph;

public interface Graph<V> {
	
	boolean hasEdge(V value1, V value2);
	void addNode(V value);
	void addEdge (V value1, V value2);
	
}