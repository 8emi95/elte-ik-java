package nodes.base;

public abstract class AbstractNode implements Node{
	private static int count = 0;
	private int id;
	
	public AbstractNode() {
		id = count;
		count += 1;
	}
	
	@Override
	public int getId() {
		int returnId = id;
		return returnId;
	}
	
	public static void resetCount() {
		count = 0;
	}
	
	@Override
	public String toString() {
		return this.getType() + "_" + id;
	}
}