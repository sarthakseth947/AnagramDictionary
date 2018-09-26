

//Name: Sarthak Seth
//USC NetID: sethsart@usc.edu
//CS 455 PA4
//Spring 2018

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * A Rack of Scrabble tiles
 */

public class Rack {

	private String distinct = "";

	/**
	 * Provide values to the allSubsets method and work as a helper
	 * 
	 * @param distinct
	 *            a string of unique letters
	 *
	 * @return all subsets of the indicated multiset
	 * 
	 */

	public ArrayList<String> allSubsetsHelper(String distinct) {

		Map<Character, Integer> helper = new HashMap<Character, Integer>();
		int loophelper = 0;
		while (loophelper < distinct.length()) {

			char alphabet2 = distinct.charAt(loophelper);
			int repetitions2;
			if (helper.containsKey(alphabet2)) {
				repetitions2 = helper.get(alphabet2);

			} else {
				repetitions2 = 0;
			}
			repetitions2 = repetitions2 + 1;
			helper.put(alphabet2, repetitions2);
			loophelper++;
		}
		return allSubsetsHelper2(helper, distinct);
	}

	/**
	 * Provide values to the allSubsets method and work as a helper
	 * 
	 * @param distinct
	 *            a string of unique letters
	 *
	 * @return all subsets of the indicated multiset
	 * 
	 */
	private ArrayList<String> allSubsetsHelper2(Map<Character, Integer> helper, String distinct) {
		int position = 0;

		int[] multiset = new int[helper.size()];

		String distinct1 = "";

		for (Map.Entry<Character, Integer> mapEntry : helper.entrySet()) {

			distinct1 = distinct1 + mapEntry.getKey();
			multiset[position] = mapEntry.getValue();
			position++;
		}
		int startPos = 0;

		return allSubsets(distinct1, multiset, startPos);

	}

	/**
	 * Finds all subsets of the multiset starting at position k in unique and mult.
	 * unique and mult describe a multiset such that mult[i] is the multiplicity of
	 * the char unique.charAt(i). PRE: mult.length must be at least as big as
	 * unique.length() 0 <= k <= unique.length()
	 * 
	 * @param unique
	 *            a string of unique letters
	 * @param mult
	 *            the multiplicity of each letter from unique.
	 * @param k
	 *            the smallest index of unique and mult to consider.
	 * @return all subsets of the indicated multiset
	 * @author Claire Bono
	 */
	private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
		ArrayList<String> allCombos = new ArrayList<>();

		if (k == unique.length()) { // multiset is empty
			allCombos.add("");
			return allCombos;
		}

		// get all subsets of the multiset without the first unique char
		ArrayList<String> restCombos = allSubsets(unique, mult, k + 1);

		// prepend all possible numbers of the first char (i.e., the one at position k)
		// to the front of each string in restCombos. Suppose that char is 'a'...

		String firstPart = ""; // in outer loop firstPart takes on the values: "", "a", "aa", ...
		for (int n = 0; n <= mult[k]; n++) {
			for (int i = 0; i < restCombos.size(); i++) { // for each of the subsets
															// we found in the recursive call
				// create and add a new string with n 'a's in front of that subset
				allCombos.add(firstPart + restCombos.get(i));
			}
			firstPart += unique.charAt(k); // append another instance of 'a' to the first part
		}

		return allCombos;
	}

	/**
	 * Display the list of possible strings that can be made
	 * 
	 * @param list
	 *            of string which has to be displaced
	 */
	public void showList(ArrayList<String> list) {

		ScoreTable score = new ScoreTable();
		ArrayList<String> temperaryList = new ArrayList<String>();

		Map<Integer, ArrayList<String>> listResult = new TreeMap<Integer, ArrayList<String>>(
				Collections.reverseOrder());

		for (int d = 0; d < list.size(); d++) {
			int scoreGet = score.findScore(list.get(d));
			if (listResult.containsKey(scoreGet)) {
				temperaryList = listResult.get(scoreGet);
			}

			else {
				temperaryList = new ArrayList<String>();

			}
			temperaryList.add(list.get(d));
			listResult.put(scoreGet, temperaryList);
		}
		PrintList(listResult);
	}

	/**
	 * Helper method to display list in a sorted order
	 * 
	 * @param list
	 *            of string which has to be displaced
	 */

	private void PrintList(Map<Integer, ArrayList<String>> listResult) {
		for (Map.Entry<Integer, ArrayList<String>> entry : listResult.entrySet()) {
			ArrayList<String> wholeList = entry.getValue();

			Collections.sort(wholeList);

			for (int i = 0; i < wholeList.size(); i++) {

				System.out.println(entry.getKey() + ": " + wholeList.get(i));
			}
		}
	}
}
