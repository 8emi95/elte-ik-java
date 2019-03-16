package championship.results.ranking;

import java.util.Objects;

public class ImplementsMedals implements Medals {

	private int golds;
	private int silvers;
	private int bronzes;
	
	public ImplementsMedals(int golds,  int silvers, int bronzes){
		this.golds = golds;
		this.silvers = silvers;
		this.bronzes = bronzes;
	}
	
	public int getGolds(){
		return this.golds;
	}
	
	public int getSilvers(){
		return this.silvers;
	}
	
	public int getBronzes(){
		return this.bronzes;
	}
	
	@Override
	public boolean equals(Object obj){
            if(this != null && obj != null && obj instanceof Medals) {
                Medals other = (Medals) obj;
                return (this.compareTo(other) == 0);
            }
            return false;
        }
	
	@Override
	public int hashCode(){
		return Objects.hash(golds, silvers, bronzes);
	}
	
        @Override
	public int compareTo(Medals other){
		int byGold = new Integer(this.golds).compareTo(new Integer(other.getGolds()));
		if(byGold == 0){
			int bySilver = new Integer(this.silvers).compareTo(new Integer(other.getSilvers()));
			if(bySilver == 0){
					return new Integer(this.bronzes).compareTo(new Integer(other.getBronzes()));
			}
			return bySilver;
		}
		return byGold;
	}
	
	public String toString(){
            return "<" + this.golds + ", " + this.silvers + ", " + this.bronzes + ">";
	}
}