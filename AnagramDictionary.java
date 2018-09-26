
//Name: Sarthak Seth

//USC NetID: sethsart@usc.edu
//CS 455 PA4
//Spring 2018

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * A dictionary of all anagram sets. Note: the processing is case-sensitive; so
 * if the dictionary has all lower case words, you will likely want any string
 * you test to have all lower case letters too, and likewise if the dictionary
 * words are all upper case.
 */

public class AnagramDictionary {
	private Map<Map<Character, Integer>, ArrayList<String>> checkDictionary;
	private String Word;
	private Map<Character, Integer> alphabetsValue;
	private ArrayList<String> checkWords;

	/**
	 * Create an anagram dictionary from the list of words given in the file
	 * indicated by fileName. PRE: The strings in the file are unique.
	 * 
	 * @param fileName
	 *            the name of the file to read from
	 * @throws FileNotFoundException
	 *             if the file is not found
	 */
	public AnagramDictionary(String fileName) throws FileNotFoundException {
		File inputFile = new File(fileName);
		Scanner in = new Scanner(inputFile);
		checkDictionary = new HashMap<Map<Character, Integer>, ArrayList<String>>();
		checkWords = new ArrayList<String>();
		while (in.hasNext()) {
			Word = in.next();

			alphabetsValue = new TreeMap<Character, Integer>();
			int loophelper = 0;
			while (loophelper < Word.length()) {

				char alphabet = Word.charAt(loophelper);
				int repetitions;
				if (alphabetsValue.containsKey(alphabet)) {
					repetitions = alphabetsValue.get(alphabet);

				} else {
					repetitions = 0;
				}
				repetitions = repetitions + 1;
				alphabetsValue.put(alphabet, repetitions);
				loophelper++;
			}

			if (checkDictionary.containsKey(alphabetsValue)) {
				checkWords = checkDictionary.get(alphabetsValue);
			}

			else {
				checkWords = new ArrayList<String>();
			}

			checkWords.add(Word);

			checkDictionary.put(alphabetsValue, checkWords);
		}
	}

	/**
	 * Get all anagrams of the given string. This method is case-sensitive. E.g.
	 * "CARE" and "race" would not be recognized as anagrams.
	 * 
	 * @param s
	 *            string to process
	 * @return a list of the anagrams of s
	 * 
	 */
	public ArrayList<String> getAnagramsOf(String s) {
		int repetitions1;

		Map<Character, Integer> stringMap = new HashMap<Character, Integer>();
		int loophelper = 0;
		while (loophelper < s.length()) {
			char alphabet1 = s.charAt(loophelper);
			if (stringMap.containsKey(alphabet1)) {
				repetitions1 = stringMap.get(alphabet1);

			} else {
				repetitions1 = 0;
			}
			repetitions1 = repetitions1 + 1;
			stringMap.put(alphabet1, repetitions1);
			loophelper++;
		}

		return helperGetAnagrams(stringMap);
	}

	/**
	 * Helper Method to get all anagrams of the given string. This method is
	 * case-sensitive. E.g. "CARE" and "race" would not be recognized as anagrams.
	 * 
	 * @param Map
	 *            having info about the contents of the string and its multiplicity
	 * @return a list of the anagrams of s
	 * 
	 */
	private ArrayList<String> helperGetAnagrams(Map<Character, Integer> stringMap) {
		ArrayList<String> response;
		if (checkDictionary.containsKey(stringMap)) {
			response = checkDictionary.get(stringMap);
		}

		else {
			response = new ArrayList<String>();
		}

		return response;
	}

}
