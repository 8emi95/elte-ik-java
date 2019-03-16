package graph;

public interface Graph<V> {
    boolean hasEdge(V node1, V node2);
    void addNode(V node);
    void addEdge(V node1, V node2);
}