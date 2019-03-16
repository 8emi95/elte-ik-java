package tracker;

public class Label{
	private String name;
	
	public Label(String name){
		this.name=name;
	}
	
	public String getName(){
		return name;
	}
	
	public boolean isSame(Label l){
		return this.name.equals(l.getName());
	}
}