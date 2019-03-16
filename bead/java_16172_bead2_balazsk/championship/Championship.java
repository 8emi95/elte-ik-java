package championship;

import championship.results.Factory;
import championship.results.Results;
import championship.results.ranking.Medals;
import championship.results.ranking.Ranking;

import java.io.FileNotFoundException;

public class Championship {

    public static void main(String[] args) throws FileNotFoundException {
        Results results = Factory.createResults();
        results.readFromFile("input.txt");
        Ranking <Integer> ranking = results.rankNationsByTotalMedals();

        System.out.println(ranking.getRanking()); // []
 
       results.addResult("gyors 50m", "x", "Magyarország", 1);

        System.out.println(ranking.getRanking()); // [Magyarország]
 
       results.addResult("gyors 50m", "y", "USA", 2);
        results.addResult("gyors 50m", "z", "USA", 3);
        results.addResult("gyors 100m", "y", "Kína", 1);
        results.addResult("gyors 100m", "z", "Kína", 3);
 
        System.out.println(ranking.getPointsOf("Kína")); //  <1, 0, 1>
        System.out.println(ranking.getPointsOf("Magyarország")); //  <1, 0, 0>
        System.out.println(ranking.getPointsOf("USA")); //  <0, 1, 1>
        System.out.println(ranking.getRanking()); // [Kína, Magyarország, USA]
        ranking.printRankingToFile("output.txt");
    }
}
