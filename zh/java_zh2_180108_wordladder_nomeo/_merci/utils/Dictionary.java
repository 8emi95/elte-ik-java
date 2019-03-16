package utils;

import java.util.*;
import java.util.TreeSet;
import java.lang.*;
import java.lang.Object;
import java.io.*;
import java.io.File;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.BufferedReader;


public class Dictionary{

	private TreeSet<String> wordList;
	BufferedReader reader;
	public Dictionary(String filePath) throws IOException{
	
        try {
            reader = new BufferedReader(new FileReader(new File(filePath)));
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
	
	private TreeSet<String> getWords(){
		return this.wordList;
	}
	
	/*@Override
	private boolean equals(Dictionary d, Dictionary d2) {
		if(d.getWords().equals(d2.getWords())){
			return true;
		} else {
			return false;
		}
	}*/
	
	/*@Override
	private boolean hashCode(Dictionary d, Dictionary d2) {}*/
	
}