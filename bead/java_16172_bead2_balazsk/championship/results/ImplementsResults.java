package championship.results;

import championship.results.ranking.ImplementsIntegerRanking;
import championship.results.ranking.ImplementsMedalsRanking;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import championship.results.ranking.Medals;
import championship.results.ranking.Ranking;

public class ImplementsResults implements Results {
	
    private List<Result> results = new ArrayList<>();

    public void addResult(String event, String name, String nation, int place) throws IllegalArgumentException {
	if(null == event || event.length() == 0 || name == null || name.length() == 0 || nation == null || nation.length() == 0 || place <= 0) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < this.results.size(); i++) {
            if(event.equals(this.results.get(i).getEvent()) && place == this.results.get(i).getPlace()) {
                throw new IllegalArgumentException();
            }
        }
        Result result = new Result(event, name, nation, place);
		results.add(result);
    }
	
    public void addResult(String event, Participant participant, int place) throws IllegalArgumentException{
	if(event == null || event.length() == 0 || participant == null || place <= 0) {
            throw new IllegalArgumentException();
        }
        for(int i = 0; i < this.results.size(); i++) {
            if(event.equals(this.results.get(i).getEvent()) && place == this.results.get(i).getPlace()) {
                throw new IllegalArgumentException();
            }
        }
        Result result = new Result(event, participant, place);
	results.add(result);
    }
	
    public List<Participant> getResultsOf(String event) {
        List<Participant> p;
        //megfelelő helyezések kigyűjtése
        List<Result> tmp = new ArrayList<>();
		for(Result r : results){
			if(r.getEvent().equals(event)){
				String name = r.getName();
				String nation = r.getNation();
				String ev = r.getEvent();
				int place = r.getPlace();
				Result res = new Result(ev, name, nation, place);
				tmp.add(res);
			}
		}
        if(tmp.size() > 0) {
        //maximum keresés
            int max = tmp.get(0).getPlace();
            for(int i = 1; i < tmp.size(); i++) {
                if(tmp.get(i).getPlace() > max) {
                    max = tmp.get(i).getPlace();
                }
            }
        //tömbbe helyezés megfelelő indexeléssel
            Participant[] par = new Participant[max];
            for(int i = 0; i < tmp.size(); i++) {
                String name = tmp.get(i).getName();
                String nation = tmp.get(i).getNation();
                par[tmp.get(i).getPlace() - 1] = new ImplementsParticipant(name, nation);
            }
            p = new ArrayList<>(Arrays.asList(par));
        } else {
            p = new ArrayList<>();
        }
        return p;
    }
	
    public Map<String, List<Participant>> getResultsOfAll(){
	Map<String, List<Participant>> map = new HashMap<>();
	List<Participant> p = new ArrayList<>();
	Set<String> eventsName = new HashSet<>();
        for(int i = 0; i < this.results.size(); i++){
            eventsName.add(results.get(i).getEvent());
        }
        Iterator<String> it = eventsName.iterator();
        while(it.hasNext()) {
            String eName = it.next();
            map.put(eName, getResultsOf(eName) );
        }
	return map;
    }
	
    public Ranking<Integer> rankNationsByTotalMedals(){
	return new ImplementsIntegerRanking(this);
    }
	
    public Ranking<Medals> rankNationsByGoldFirst(){
	    return new ImplementsMedalsRanking(this);
    }
	
    public void readFromFile(String filename) throws FileNotFoundException {
		
        try (Scanner sc = new Scanner(new File(filename))){
            while(sc.hasNextLine()){
                addIfValid(sc.nextLine());
            }
        }catch (FileNotFoundException e) {
                System.err.println("Hiba a fajl megnyitasakor!");
        }
    }

    private void addIfValid(String line){
        if(!line.isEmpty()){
            String[] data = line.split(";");
            try{
                Result result = createResult(data);
                if(result != null){
                    results.add(result);
                }
            }catch (NumberFormatException e){
                //ignore line
            }
        }
    }

    private Result createResult(String[] rawData){
        if(rawData.length == 4 && noOneComponentIsEmpty(rawData) && isStartWithCapital(rawData[1]) &&
                isStartWithCapital(rawData[2])){
            return new Result(rawData[0], rawData[1], rawData[2], Integer.parseInt(rawData[3]));
        }
        return null;
    }

    private boolean noOneComponentIsEmpty(String[] rawData){
        return !rawData[0].isEmpty() && !rawData[1].isEmpty() && !rawData[2].isEmpty()
                && !rawData[3].isEmpty();
    }

    private boolean isStartWithCapital(String name){
        return Character.isUpperCase(name.charAt(0));
    }
	
    public List<Result> getList(){
		return this.results;
    }
	
}