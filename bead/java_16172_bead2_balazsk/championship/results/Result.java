package championship.results;

import championship.results.Participant;

public class Result {

	private String event;
	private String name;
	private String nation;
	private int place;
	
	public Result(String event, String name, String nation, int place){
		this.event = event;
		this.name = name
		this.nation = nation;
		this.place = place;
	}
	
	public Result(String event, Participant participant, int place){
		this.event = event;
		this.name = participant.getName();
		this.nation = participant.getNation();
		this.place = place;
	}
	
	public String getEvent(){
		return this.event;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getNation(){
		return this.nation;
	}
	
	public int getPlace(){
		return this.place;
	}

}