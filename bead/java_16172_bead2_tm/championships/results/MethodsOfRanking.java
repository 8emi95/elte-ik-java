package bead.championships.results;

import bead.championships.results.Return.Read;
import bead.championships.results.ranking.MethodsOfMedalsClass;

import java.io.FileNotFoundException;

import java.util.*;

public class MethodsOfRanking implements Ranking {
    Return r = new Return();
    List<Read> data = r.getList();

    @Override
    public Set<String> getNations() {

        Set<String> resultSet = new HashSet<>();

        for (int i = 0; i < data.size(); i++) {
            if (!resultSet.contains(data.get(i).competition)) {
                resultSet.add(data.get(i).competition);
            }
        }
        return resultSet;
    }

    @Override
    public Comparable getPointsOf(String nation) {

        int golds = 0;
        int silvers = 0;
        int bronzes = 0;

        for (int i = 0; i < data.size(); i++) {
            if (nation.equals(data.get(i).participant.getNation())) {
                if (data.get(i).result == 1) {
                    golds++;
                } else if (data.get(i).result == 2) {
                    silvers++;
                } else if (data.get(i).result == 3) {
                    bronzes++;
                }
            }
        }
        MethodsOfMedalsClass m = new MethodsOfMedalsClass(golds, silvers, bronzes);
        m.toString();
        return m;
    }

    @Override
    public Map getPointsOfAll() {

        Map<String, Comparable> pointsOfAll = new HashMap<>();
        for (String str : getNations()) {
            pointsOfAll.put(str, getPointsOf(str));
        }
        return pointsOfAll;
    }

    @Override
    public List<String> getRanking() {
        List<String> ranking = new ArrayList<>();

        return null;
    }

    @Override
    public List<String> getTop3() {
      /*  List<String> tipTop = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tipTop.add()
        }*/
        return null;
    }

    @Override
    public void printRankingToFile(String filename) throws FileNotFoundException {

    }
}
