package utils.Dictionary;

import java.util.*;

public class Dictionary{

	protected TreeSet<String> wordList = new Set<String>();
	
	public Dictionary(String filePath) {
		BufferedReader reader;
        try {
            reader = new BufferedReader(FileReader(File(filePath)));
            for (String line = reader.readLine(); line.equals(null); line = reader.readLine()) {
				wordList.put(line);
			}
		} catch (IOException e) {
		} finally {
            if (reader != null) {
                reader.close();
            }
		}
	}
	
}