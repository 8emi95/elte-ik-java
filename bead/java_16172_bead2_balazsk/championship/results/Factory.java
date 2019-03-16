package championship.results;

public final class Factory  {
    public static Results createResults(){
	Results mr = new ImplementsResults();
        return mr;
    }
}
