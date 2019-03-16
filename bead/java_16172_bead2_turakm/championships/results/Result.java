package championships.results;

import championships.results.ranking.Ranking;

import java.io.*;
import java.util.*;

public class Result implements Results, Ranking {

    private Map<String, List<Competitor>> resultsOfAll = new HashMap<>();

    @Override
    public void addResult(String event, String name, String nation, int place) throws IllegalArgumentException {

        illegalArgumentVerifier(event, name, nation, place);

        Competitor participant = new Competitor(name, nation);

        int size = this.resultsOfAll.get(event).size();

        generateNullValuesIntoList(event, place, size);

        addParticipant(event, place, participant);

    }

    @Override
    public void addResult(String event, Participant participant, int place) throws IllegalArgumentException {

        illegalArgumentVerifier(event, participant.getName(), participant.getNation(), place);

        Competitor realParticipant = new Competitor(participant.getName(), participant.getNation());

        int size = this.resultsOfAll.get(event).size();

        generateNullValuesIntoList(event, place, size);

        addParticipant(event, place, realParticipant);

    }

    @Override
    public List<Competitor> getResultsOf(String event) {

        if (this.resultsOfAll.get(event) != null) {
            return this.resultsOfAll.get(event);
        } else {
            return new ArrayList<Competitor>();
        }

    }

    @Override
    public Map<String, List<Competitor>> getResultsOfAll() {
        return this.resultsOfAll;
    }

    @Override
    public Set<String> getNations() {
        Set<String> nations = new HashSet<>();

        this.resultsOfAll.values()
                .forEach(event -> {
                    event.stream().filter(Objects::nonNull).forEach(participant -> {
                        nations.add(participant.getNation());
                    });
                });

        return nations;

    }

    @Override
    public Comparable getPointsOf(String nation) {
        int points = 0;

        for (Map.Entry<String, List<Competitor>> e : this.resultsOfAll.entrySet()) {
            List<Competitor> values = e.getValue();
            int size = 3;

            if (e.getValue().size() < 3) {
                size = e.getValue().size();
            }

            for (int i = 0; i < size; i++) {
                if (e.getValue().get(i) != null && e.getValue().get(i).getNation().equals(nation)) {
                    if (i == 0) {
                        points += 3;
                    } else if (i == 1) {
                        points += 2;
                    } else {
                        points += 1;
                    }
                }
            }
        }

        return points;
    }

    @Override
    public Map getPointsOfAll() {
        Map<String, Comparable> pointsOfAllNations = new HashMap<>();

        for (String nation : getNations()) {
            pointsOfAllNations.put(nation, getPointsOf(nation));
        }

        return pointsOfAllNations;

    }

    @Override
    public List<String> rankNationsByGoldFirst() {

        List<String> rankings = new ArrayList<>();
        Set<Map.Entry<String, Integer>> set = getPointsOfAll().entrySet();
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(set);

        Collections.sort(sortedList, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        for (Map.Entry<String, Integer> aSortedList : sortedList) {
            rankings.add(aSortedList.getKey());
        }
        return rankings;

    }

    @Override
    public List<String> rankNationsByTotalMedals() {
        List<String> rankings = new ArrayList<>();
        Set<Map.Entry<String, Integer>> set = getMedalsOfAll().entrySet();
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(set);

        Collections.sort(sortedList, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        for (Map.Entry<String, Integer> aSortedList : sortedList) {
            rankings.add(aSortedList.getKey());
        }

        return rankings;

    }

    @Override
    public List<String> getRanking() {
        if (rankNationsByGoldFirst().isEmpty()) {
            return new ArrayList<>();
        } else {
            return rankNationsByGoldFirst();
        }
    }

    @Override
    public List<String> getTop3() {
        if (rankNationsByGoldFirst().isEmpty()) {
            return new ArrayList<>();
        } else {
            return rankNationsByGoldFirst().subList(0, 3);
        }
    }

    @Override
    public void printRankingToFile(String filename) throws FileNotFoundException {
        try {
            PrintWriter writer = new PrintWriter(filename, "UTF-8");
            for (String nation : getRanking()) {
                writer.println(nation + ": " + getPointsOf(nation));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFromFile(String filename) throws FileNotFoundException {
        try {
            File f = new File(filename);
            String line = null;
            BufferedReader br = new BufferedReader(new FileReader(f));
            String[] tmp;
            while ((line = br.readLine()) != null) {
                tmp = line.split(";");
                boolean first = true;
                if (tmp.length == 4 && tmp[0].length() != 0
                        && tmp[1].length() != 0 && tmp[2].length() != 0 && tmp[3].matches("\\d+")) {

                    for (Map.Entry<String, List<Competitor>> data : this.resultsOfAll.entrySet()) {
                        data.getValue();
                        if (tmp[0].equals(data.getKey()) && data.getValue().size() == Integer.parseInt(tmp[3]) - 1) {
                            first = false;
                        }
                    }

                    if (Integer.parseInt(tmp[3]) >= 1 && first)
                        addResult(tmp[0], tmp[1], tmp[2], Integer.parseInt(tmp[3]));
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Comparable getMedalsOf(String nation) {
        int medals = 0;

        for (Map.Entry<String, List<Competitor>> e : this.resultsOfAll.entrySet()) {
            List<Competitor> values = e.getValue();
            int size = 3;

            if (e.getValue().size() < 3) {
                size = e.getValue().size();
            }

            for (int i = 0; i < size; i++) {
                if (e.getValue().get(i) != null && e.getValue().get(i).getNation().equals(nation)) {
                    if (i < 3) {
                        medals++;
                    }
                }
            }
        }

        return medals;
    }

    private Map getMedalsOfAll() {
        Map<String, Comparable> pointsOfAllNations = new HashMap<>();

        for (String nation : getNations()) {
            pointsOfAllNations.put(nation, getMedalsOf(nation));
        }

        return pointsOfAllNations;

    }

    private void illegalArgumentVerifier(String event, String name, String nation, int place) {
        if (event.isEmpty() || event == null) {
            throw new IllegalArgumentException("Nem lehet üres az esemény!");
        } else if (name.isEmpty() || name == null) {
            throw new IllegalArgumentException("Nem lehet üres az név!");
        } else if (nation.isEmpty() || nation == null) {
            throw new IllegalArgumentException("Nem lehet üres a nemzetiség!");
        } else if (place <= 0) {
            throw new IllegalArgumentException("Nem lehet kisebb nullánál a helyezés!");
        }
        if (this.resultsOfAll.get(event) == null) {
            this.resultsOfAll.put(event, new ArrayList<Competitor>());
        } else {
            if (this.resultsOfAll.get(event).size() == place) {
                throw new IllegalArgumentException("Ezt a helyezést már elérték ebben a kategóriában!");
            }
        }
    }

    private void addParticipant(String event, int place, Competitor participant) {
        if (this.resultsOfAll.get(event).size() != 0) {
            this.resultsOfAll.get(event).set(place - 1, participant);
        } else {
            this.resultsOfAll.get(event).add(0, participant);
        }
    }

    private void generateNullValuesIntoList(String event, int place, int size) {
        if (this.resultsOfAll.get(event).size() != 0) {
            for (int i = size; i < place; i++) {
                this.resultsOfAll.get(event).add(i, null);
            }
        }
    }

}
