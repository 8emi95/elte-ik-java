package championships.results;

import championships.results.ranking.*;

public final class Factory extends Object {
	private String event;
	private Participant participant;
	private int place;
	private String results;
	
	public static Results createResults() {
		Results results=new ResultFinal();
		return results;
	}
}