package bead;

import bead.championships.results.Results;
import bead.championships.results.Participant;
import bead.championships.results.Ranking;
import bead.championships.results.Factory;
import bead.championships.results.Return;
import bead.championships.results.ranking.Medals;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Results results = Factory.createResults();
        results.readFromFile("input.txt");
        results.rankNationsByGoldFirst().printRankingToFile("goldFirstOutput.txt");
        results.rankNationsByTotalMedals().printRankingToFile("totalMedalsOutput.txt");
    }
}
