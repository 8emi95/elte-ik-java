package championships.results;

import java.util.*;
import java.io.*;
import championships.results.ranking.*;

public class ResultFinal implements Results{
	private String golds;
	private String silvers;
	private String bronzes;
	private List<Result> results=new ArrayList<>();
	
	public static class Result {
		String event;
		Participant participant;
		int place;
		
		Result(String event, Participant participant, int place){
			this.event=event;
			this.participant=participant;
			this.place=place;
		}
		
		public int getPlace(){
			return place;
		}
	
		public String getEvent() {
			return event;
		}
	
		public Participant getParticipant(){
			return participant;
		}
	}
	
	@Override
	public void addResult(String event, Participant participant, int place) throws IllegalArgumentException{
		if (event.length()>0 && event!=null && participant.getName()!=null && participant.getName()!="" && participant.getNation()!=null && participant.getNation()!="" && place>0) {
			boolean samePlace=false;
			for (int i=0; i<results.size(); i++) {
				if (event.equals(results.get(i).getEvent()) && place==results.get(i).getPlace()) {
					samePlace=true;
				}
			}
			//System.out.println(event+" "+participant.getName()+" "+participant.getNation()+" "+place);
			if (!samePlace) {
				results.add(new Result(event, participant, place));
			}
		}
	}
	
	@Override
	public void addResult(String event, String name, String nation, int place) throws IllegalArgumentException{
		if (event.length()>0 && event!=null && name!=null && name!="" && nation!=null && nation!="" && place>0) {
			for (int i=0; i<results.size(); i++) {
				if (event.equals(results.get(i).getEvent()) && place == this.results.get(i).getPlace()) {
					throw new IllegalArgumentException();
				}
			}
			results.add(new Result(event, new Participant(name, nation), place));
		}
	}
	
	@Override
	public List<Participant> getResultsOf(String event){
		int max=0;
        for (int i=0; i<results.size(); i++) {
            if (event.equals(results.get(i).event) && results.get(i).place>max) {
                max=results.get(i).place;
            }
        }
        List<Participant> res=new ArrayList<>(max);
        for (int j=0; j<results.size(); j++) {
            if (event.equals(results.get(j).event)) {
                res.set(results.get(j).place-1, results.get(j).participant);
            }
        }
        return res;
	}
	
	public List<Result> getResults(){
		return results;
	}
	
	@Override
	public Map<String,List<Participant>> getResultsOfAll(){
		Map<String, List<Participant>> map=new HashMap<>();
		List<String> events=new ArrayList<>();
		for (int i=0; i<results.size(); ++i) {
			if (!events.contains(results.get(i).event)) {
				events.add(results.get(i).event);
			}
		}
		for (int i=0; i<events.size(); ++i) {
			map.put(events.get(i), getResultsOf(events.get(i)));
		}
		return map;
	}
	
	@Override
	public Rankings<Integer> rankNationsByTotalMedals(){
		return new RankingInt(this);
	}
	
	@Override
	public Rankings<Medals> rankNationsByGoldFirst(){
		return new RankingMed(this);
	}
	
	@Override
	public void readFromFile(String filename) throws FileNotFoundException {
		File file = new File(filename);
		Scanner sc=null;
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine() && sc.hasNext())
			{
				String[] parts=sc.nextLine().split(";");
				if (parts.length==4)
				{
					boolean bool=true;
					for (int i=0; i<4; i++) {
						if (parts[i]=="") {
							bool=false;
						}
					}
					if (bool)
					{
						Participant participant=new Participant(parts[1], parts[2]);
						try
						{
							int place=Integer.parseInt(parts[3]);
							addResult(parts[0], participant, place);
						} catch (NumberFormatException nfe) {
							System.out.println("Nem szam volt a helyezes!!");
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Nem talalom a fajlt!");
		} finally {
			if (sc!=null) sc.close();
		}
    }
}