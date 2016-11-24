/*  This Software is a simple english to german translator used as
    an experiment
    Copyright (C) 2016  Christopher Truebig
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

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
