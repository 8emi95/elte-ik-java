import java.util.*;

public class DenseGraph extends Graph {
	private boolean[][] adjacencyMatrix;

	public DenseGraph(int n) {
		adjacencyMatrix = new boolean[n][n];
	}

	@Override
	public boolean hasEdge(int p, int q) {
		return adjacencyMatrix[p][q];
	}
    
	@Override
	public Set<Integer> neighboursOf(int p) {
		Set<Integer> neighbours = new HashSet<>();
		for (int i = 0; i < adjacencyMatrix.length; i++)
			if (adjacencyMatrix[p][i])
				neighbours.add(i);
		return neighbours;
	}

	@Override
	public void addEdge(int p, int q) {
		adjacencyMatrix[p][q] = true;
		adjacencyMatrix[q][p] = true;
	}
}
