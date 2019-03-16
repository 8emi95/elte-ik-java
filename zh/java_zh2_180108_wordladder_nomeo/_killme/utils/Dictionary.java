package utils;

import java.util.*;
import java.io.*;

public class Dictionary {
    private TreeSet<String> wordList = new TreeSet<String>();

    public Dictionary(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)));
        try {
            // reader = new BufferedReader(FileReader(File(filePath)));
            for (String line = reader.readLine(); line.equals(null); line = reader.readLine()) {
                wordList.add(line);
            }
        } catch (IOException e) {
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    public TreeSet<String> getWords() {
        // return (TreeSet<String>) wordList.clone(); // -Xlint:unchecked
        // return wordList;
        return new TreeSet<String>(wordList);
    }

    @Override
    public boolean equals(Object other) {
        if (this != null && other != null && this.getClass() == other.getClass()) {
            Dictionary temp = (Dictionary) other;
            if (this.getWords().size() == temp.getWords().size()) {
                for (String word : this.getWords()) {
                    if (!temp.getWords().contains(word)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getWords());
    }
}