package main;

import ladder.WordLadder;
import utils.Dictionary;
import utils.DisconnectedException;

import java.util.List;
import java.io.*;

public class Main {

	public static void main(String[] args){
		if (args.length != 3) {
			System.err.println("Three arguments are required.");
			return;
		}

		String wordsFile = args[0]; // a ket szot (a letra aljat es tetejet) tartalmazo fajl
		String dictionaryFile = args[1]; // a szotart tartalmazo fajl
		String outputFile = args[2]; // a kimeneti fajl
		
		try {
			WordLadder wL = new WordLadder();
			WordLadder.buildLadder(args[0],args[1],args[2]);
		} catch (DisconnectedException e) {
		} catch (IOException e) {} 
		
	}

}