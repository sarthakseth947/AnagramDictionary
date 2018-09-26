
//Name: Sarthak Seth
//USC NetID: sethsart@usc.edu
//CS 455 PA4
//Spring 2018
import java.util.Map;
import java.util.HashMap;

/**
 * A score of Scrabble tiles
 */
public class ScoreTable {
	private Map<Character, Integer> scoreCount;

	public ScoreTable() {
		scoreCount = new HashMap<Character, Integer>();
		scoreCount.put('a', 1);
		scoreCount.put('A', 1);
		scoreCount.put('b', 3);
		scoreCount.put('B', 3);
		scoreCount.put('c', 3);
		scoreCount.put('C', 3);
		scoreCount.put('d', 2);
		scoreCount.put('D', 2);
		scoreCount.put('e', 1);
		scoreCount.put('E', 1);
		scoreCount.put('f', 4);
		scoreCount.put('F', 4);
		scoreCount.put('g', 2);
		scoreCount.put('G', 2);
		scoreCount.put('h', 4);
		scoreCount.put('H', 4);
		scoreCount.put('i', 1);
		scoreCount.put('I', 1);
		scoreCount.put('j', 8);
		scoreCount.put('J', 8);
		scoreCount.put('k', 5);
		scoreCount.put('K', 5);
		scoreCount.put('l', 1);
		scoreCount.put('L', 1);
		scoreCount.put('m', 3);
		scoreCount.put('M', 3);
		scoreCount.put('n', 1);
		scoreCount.put('N', 1);
		scoreCount.put('o', 1);
		scoreCount.put('O', 1);

	}

	/**
	 * finds the score of the string
	 * 
	 * @param string
	 *            whose score has to be found out
	 *
	 */

	public int findScore(String str) {
		scoreCount.put('p', 3);
		scoreCount.put('P', 3);
		scoreCount.put('q', 10);
		scoreCount.put('Q', 10);
		scoreCount.put('r', 1);
		scoreCount.put('R', 1);
		scoreCount.put('s', 1);
		scoreCount.put('S', 1);
		scoreCount.put('t', 1);
		scoreCount.put('T', 1);
		scoreCount.put('u', 1);
		scoreCount.put('U', 1);
		scoreCount.put('v', 4);
		scoreCount.put('V', 4);
		scoreCount.put('w', 4);
		scoreCount.put('W', 4);
		scoreCount.put('x', 8);
		scoreCount.put('X', 8);
		scoreCount.put('y', 4);
		scoreCount.put('Y', 4);
		scoreCount.put('z', 10);
		scoreCount.put('Z', 10);

		int score = 0;

		for (int i = 0; i < str.length(); i++) {
			score = score + scoreCount.get(str.charAt(i));
		}
		return score;

	}
}
