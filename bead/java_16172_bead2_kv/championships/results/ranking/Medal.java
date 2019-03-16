package championships.results.ranking;

import championships.results.*;
import java.util.*;

class Medal implements Medals{
	private int golds;
	private int silvers;
	private int bronzes;
	private List<ResultFinal.Result> results;
	
	public Medal(String nation, List<ResultFinal.Result> results){
		for (int i=0; i<results.size();i++) {
			if (results.get(i).getParticipant().getNation().equals(nation))
			if (results.get(i).getPlace()==1){
				golds++;
			} else {
				if (results.get(i).getPlace()==2){
					silvers++;
				} else {
					if (results.get(i).getPlace()==3){
						bronzes++;
					}
				}
			}
		}
	}
	
	@Override
	public int getGolds(){
		return golds;
	}
		
	@Override
	public int getSilvers(){
		return silvers;
	}
		
	@Override
	public int getBronzes(){
		return bronzes;
	}
		
	@Override
	public boolean equals(Object obj) {
		if (this!=null && obj!=null && getClass()==obj.getClass() && compareTo((Medals)obj)==0) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getGolds(), getSilvers(), getBronzes());
	}
		
	@Override
	public int compareTo(Medals obj){
		if (golds<obj.getGolds()) {
			return -1;
		} else if (golds>obj.getGolds()) {
			return 1;
		} else if (silvers<obj.getSilvers()) {
			return -1;
		} else if (silvers>obj.getSilvers()) {
			return 1;
		} else if (bronzes<obj.getBronzes()) {
			return -1;
		} else if (bronzes>obj.getBronzes()) {
			return 1;
		}
		return 0;
	}
		
	@Override
	public String toString(){
		return "<"+golds+", "+silvers+", "+bronzes+">";
	}
}