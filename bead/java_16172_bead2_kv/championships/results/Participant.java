package championships.results;

public class Participant implements Participants{
	private String name;
	private String nation;
	
	public Participant(String name, String nation) {
		if (name!=null && name.length()!=0 && nation!=null && nation.length()!=0) {
			this.name=name;
			this.nation=nation;
		}
	}
	
	@Override
	public String getName(){
		return name;
	}
	
	@Override
	public String getNation(){
		return nation;
	}
}