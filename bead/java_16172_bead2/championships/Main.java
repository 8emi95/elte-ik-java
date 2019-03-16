package championships;

import championships.results.Factory;
import championships.results.Results;
import championships.results.ranking.Medals;
import championships.results.ranking.Ranking;

import java.io.FileNotFoundException;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		Results results = Factory.createResults();
		results.readFromFile("input.txt");
		results.rankNationsByGoldFirst().printRankingToFile("goldFirstOutput.txt");
		results.rankNationsByTotalMedals().printRankingToFile("totalMedalsOutput.txt");
	}
}