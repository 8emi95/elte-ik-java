package championship.results;

public class ImplementsParticipant implements Participant {
    private String name;
    private String nation;
	
    public ImplementsParticipant(String name, String nation){
	this.name = name;
	this.nation = nation;
    }
    
    public ImplementsParticipant makeParticipant(String name, String nation) {
        if(name == null || name.length() == 0 || nation == null || nation.length() == 0) {
            return null;
        }
        return new ImplementsParticipant(name, nation);
    }
	
    public String getName(){
	return this.name;
    }
	
    public String getNation(){
	return this.nation;
    }
    
}