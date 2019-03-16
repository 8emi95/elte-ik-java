import java.util.*;

abstract public class Graph {
    abstract public boolean hasEdge(int p, int q);
    abstract public Set<Integer> neighboursOf(int p);
    abstract public void addEdge(int p, int q);

    public List<Integer> depthFirstTraversal(int root) {
	List<Integer> visited = new LinkedList<>();
	LinkedList<Integer> notVisited = new LinkedList<>();
	notVisited.add(root);
	while (!notVisited.isEmpty()) {
	    int p = notVisited.pop();
	    visited.add(p);
	    Set<Integer> neighbours = neighboursOf(p);
	    for (int q : neighbours)
		if (!visited.contains(q) && !notVisited.contains(q))
		    notVisited.push(q);
	}
	return visited;
    }
}
