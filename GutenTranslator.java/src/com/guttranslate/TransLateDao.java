package com.guttranslate;

import java.io.*;
import java.util.ArrayList;

class TransLateDao {

	private ArrayList<String> language = new ArrayList<>();
	private int counter = 0;
	private String filePath = "--insert file path here-- to include text files for german and english";

	TransLateDao(String file) {
		// The name of the file to open.
		String fileName = filePath + file;

		// This will reference one line at a time.
		String line = null;

		try {
			// FileReader reads a text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader buffReader = new BufferedReader(fileReader);

			// Load words from file to the ArrayList
			while ((line = buffReader.readLine()) != null) {
				System.out.println(line);
				addWords(line);
				counter++;
			}
			System.out.println(counter);
			// Always close files.
			buffReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}

	void addWords(String word) {
		language.add(word);
	}

	int getIndex(String word) {
		int index = 0;
		if (language.contains(word)) {
			index = language.indexOf(word);
		}
		return index;
	}

	String getWord(int index) {
		return language.get(index);

	}

	boolean hasWord(String word) {
		if (language.contains(word)) {
			return true;
		} else {
			return false;
		}
	}

}
