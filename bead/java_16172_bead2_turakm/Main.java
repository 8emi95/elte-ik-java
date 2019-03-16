import championships.results.*;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Result results = Factory.createResults();

        results.addResult("mell", "Roland", "angol", 1);
        results.addResult("mell", "Béla", "magyar", 2);
        results.addResult("mell", "Józsi", "angol", 3);
        results.addResult("mell", "Márk", "angol", 4);

        results.addResult("pillangó", "Valaki", "magyar", 1);

        results.readFromFile("src/input.txt");
        results.printRankingToFile("src/output.txt");
        Comparable englishMedals = results.getPointsOf("angol");
    }
}
