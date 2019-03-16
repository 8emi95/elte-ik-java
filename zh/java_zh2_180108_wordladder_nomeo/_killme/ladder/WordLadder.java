package ladder;

import java.io.*;
import java.util.*;

import javax.management.RuntimeErrorException;

public class WordLadder {
    private static boolean isNeighbour(String first, String second) {
        if (first.length() == second.length()) {
            int same = 0;
            for (int i = 0; i < first.length(); ++i) {
                if (first.charAt(i) == second.charAt(i)) {
                    same++;
                }
            }
            return (same == first.length() - 1);
        } else {
            return false;
        }
    }

    private static List<String> readInput(String fileName) {
        try (Scanner sc = new Scanner(new FileReader(new File(fileName)))) {
            String[] words = sc.nextLine().split(",");
            if (words.length != 2) {
                throw new RuntimeException("The number of words in the input file in a line differs from two.");
            }
            if (words[0].length() != words[1].length()) {
                throw new RuntimeException("Words have different lengths.");
            }
            if (sc.hasNext()) {
                throw new RuntimeException("The input file does not consist of one line.");
            }
            List<String> wordList = Arrays.asList(words);
            return wordList;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private static void writePath(String fileName, String output) {
        //
    }

    public static void buildLadder(String input, String dictionary, String output) {
        //
    }
}