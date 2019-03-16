package bead.championships.results;

import bead.championships.results.ranking.Medals;

import java.io.*;
import java.util.*;

public class Return implements Results {

    public class Read {
        String competition;
        Participant participant;
        int result;

        Read(String competition, Participant participant, int result) {
            this.competition = competition;
            this.participant = participant;
            this.result = result;
        }
    }

    private List<Read> data = new ArrayList<>();


    public List<Read> getList() {

        return data;
    }


    @Override
    public void addResult(String event, Participant participant, int place) throws IllegalArgumentException {
        //List<Read> tmp = new ArrayList<>();

        try {
            Read r = new Read(event, participant, place);
           /* tmp.add(r);
            for (int i = 0; i < tmp.size(); i++) {
                if ()  ){
                    data.add(r);
                    tmp.remove(i);
                } else {

                }
            }*/
            data.add(r);

        } catch (IllegalArgumentException i) {
        }

    }

    @Override
    public void addResult(String event, String name, String nation, int place) throws IllegalArgumentException {
        try {
            Participant p = new Participant() {
                @Override
                public String getName() {
                    return name;
                }

                @Override
                public String getNation() {
                    return nation;
                }
            };
            Read r = new Read(event, p, place);
            data.add(r);

        } catch (IllegalArgumentException i) {
        }

    }

    @Override
    public List<Participant> getResultsOf(String event) {

        int maximum = 0;
        for (int i = 0; i < data.size(); i++) {
            if (event.equals(data.get(i).competition) && data.get(i).result > maximum) {
                maximum = data.get(i).result;
            }
        }
        List<Participant> part = new ArrayList<>(maximum);
        for (int j = 0; j < data.size(); j++) {
            if (event.equals(data.get(j).competition)) {
                part.set(data.get(j).result - 1, data.get(j).participant);
            }
        }
        return part;
    }

    @Override
    public Map<String, List<Participant>> getResultsOfAll() {
        Map<String, List<Participant>> resultMap = new HashMap<>();
        List<String> allEvents = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            if (!allEvents.contains(data.get(i).competition)) {
                allEvents.add(data.get(i).competition);
            }
        }
        for (int j = 0; j < allEvents.size(); j++) {
            resultMap.put(allEvents.get(j), getResultsOf(allEvents.get(j)));
        }
        return resultMap;
    }

    @Override
    public Ranking<Medals> rankNationsByGoldFirst() {

        return null;
    }

    @Override
    public Ranking<Integer> rankNationsByTotalMedals() {

        return null;
    }

    @Override
    public void readFromFile(String filename) throws FileNotFoundException, NumberFormatException {
        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader(filename)));

            while (s.hasNext()) {
                String[] data = s.nextLine().split(";");
                if (data.length == 4) {
                    try {
                        if (!(data[0].equals("") || data[1].equals("") || data[2].equals("")) || Integer.parseInt(data[3]) > 0) {
                            addResult(data[0], data[1], data[2], Integer.parseInt(data[3]));
                        }
                    } catch (NumberFormatException e) {

                    }
                }
            }
        } finally {
            if (s != null)
                s.close();
        }
    }

}
