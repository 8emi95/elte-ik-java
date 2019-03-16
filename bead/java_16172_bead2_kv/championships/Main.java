package championships;

import championships.*;
import championships.results.*;
import championships.results.ranking.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
		System.out.println("I can't do anything. :(");
        Results results=Factory.createResults();
		System.out.println("I made the Factory thing");
        results.readFromFile("input.txt");
		System.out.println("I see input.txt");
        results.rankNationsByGoldFirst().printRankingToFile("goldFirstOutput.txt");
		System.out.println("I am lost without you while making goldFirstOutput.txt");
        results.rankNationsByTotalMedals().printRankingToFile("totalMedalsOutput.txt");
		System.out.println("I made it all!! ^^");
    }
}
