package championships.results;

import championships.results.Participant;
import championships.results.ParticipantImpl;
import championships.results.ranking.Medals;
import championships.results.ranking.Ranking;
import championships.results.ranking.RankingInteger;
import championships.results.ranking.RankingMedals;

import java.util.*;
import java.io.*;
import java.lang.*;

public class ResultsImpl implements Results {
	public static class Result {
		private String event;
		private Participant participant;
		private int place;

		Result(String event, Participant participant, int place) {
			this.event = event;
			this.participant = participant;
			this.place = place;
		}

		public String getResultEvent() {
			return event;
		}

		public String getResultName() {
			return participant.getName();
		}

		public String getResultNation() {
			return participant.getNation();
		}

		public int getResultPlace() {
			return place;
		}
	}

	private List<Result> resultList = new ArrayList<>();

	public List<Result> getList() {
		List<Result> copy = new ArrayList<Result>(resultList);
		return copy;
	}

	public void addResult(String event, String name, String nation, int place) throws IllegalArgumentException {
		if (event != null || !event.equals("") || 
			name != null || !name.equals("") || 
			nation != null || !nation.equals("") || 
			place > 0) {

			for (int i = 0; i < resultList.size(); ++i) {
				if (event.equals(resultList.get(i).getResultEvent()) && place == resultList.get(i).getResultPlace()) {
					throw new IllegalArgumentException();
				}
			}

			ParticipantImpl participant = new ParticipantImpl(name, nation);
			Result r = new Result(event, participant, place);
			resultList.add(r);
		}
	}

	public void addResult(String event, Participant participant, int place) throws IllegalArgumentException {
		if (event != null || 
			!event.equals("") || 
			participant != null || 
			place > 0) {

			for (int i = 0; i < resultList.size(); ++i) {
				if (event.equals(resultList.get(i).getResultEvent()) && place == resultList.get(i).getResultPlace()) {
					throw new IllegalArgumentException();
				}
			}

			Result r = new Result(event, participant, place);
			resultList.add(r);
		}
	}

	public List<Participant> getResultsOf(String event) {
		int numberOfParticipants = 0;
		for (int i = 0; i < resultList.size(); ++i) {
			if (event.equals(resultList.get(i).event) && resultList.get(i).place > numberOfParticipants) {
				numberOfParticipants = resultList.get(i).place;
			}
		}

		List<Participant> participantList = new ArrayList<>(numberOfParticipants);
		for (int i = 0; i < resultList.size(); ++i) {
			if (event.equals(resultList.get(i).event)) {
				participantList.set(resultList.get(i).place - 1, resultList.get(i).participant);
			}
		}

		return participantList;
	}

	public Map<String,List<Participant>> getResultsOfAll() {
		Map<String, List<Participant>> map = new HashMap<>();
		List<String> events = new ArrayList<>();

		for (int i = 0; i < resultList.size(); ++i) {
			if (!events.contains(resultList.get(i).event)) {
				events.add(resultList.get(i).event);
			}
		}

		for (int i = 0; i < events.size(); ++i) {
			map.put(events.get(i), getResultsOf(events.get(i)));
		}

		return map;
	}

	public Ranking<Integer> rankNationsByTotalMedals() {
		return new RankingInteger(this);
	}

	public Ranking<Medals> rankNationsByGoldFirst() {
		return new RankingMedals(this);
	}

	public void readFromFile(String filename) throws FileNotFoundException {
		Scanner s = new Scanner(new File(filename));
		while (s.hasNextLine()) {
			String[] splitted = s.nextLine().split(";");
			if (splitted.length == 4 && 
				!splitted[0].equals("") && 
				!splitted[1].equals("") && 
				!splitted[2].equals("") && 
				Integer.parseInt(splitted[3]) > 0) {
				addResult(splitted[0], splitted[1], splitted[2], Integer.parseInt(splitted[3]));
			}
		}
		s.close();
	}
}