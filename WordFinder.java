
//Name: Sarthak Seth
//USC NetID: sethsart@usc.edu
//CS 455 PA4
//Spring 2018
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "";

		try {

			if (args.length < 1) {
				fileName = "sowpods.txt";
				mainProgram(fileName);
			} else {
				fileName = args[0];
				mainProgram(fileName);
			}
		}

		catch (FileNotFoundException exc) {
			System.out.println("ERROR: File not found: " + fileName);
		} catch (IOException exc) {
			exc.printStackTrace();
		}
	}

	/**
	 * reads the dictionary file given and preprocess it. Prompts for the word and
	 * outputs the no. of possible results
	 * 
	 * @param fileName
	 *            the name of a file to read from (file format shown in class
	 *            comments, above)
	 * 
	 * @throws FileNotFoundException
	 *             if there's no such file (subclass of IOException)
	 * @throws IOException
	 *             (hook given in case you want to do more error-checking -- that
	 *             would also involve changing main to catch other exceptions)
	 */

	private static void mainProgram(String fileName) throws IOException {

		System.out.println("Type . to quit.");

		Scanner in = new Scanner(System.in);

		AnagramDictionary preProcessed = new AnagramDictionary(fileName);

		Rack stringEntered = new Rack();

		int tester = 1;
		String wordEntered = "";
		while (tester == 1) {

			System.out.print("Rack? ");
			wordEntered = in.nextLine();

			String onlyLetters = wordEntered.replaceAll("[^a-zA-Z]", "");

			if (!(wordEntered.equals("."))) {
				ArrayList<String> subsets = stringEntered.allSubsetsHelper(onlyLetters);
				ArrayList<String> finalList = new ArrayList<String>();
				for (int a = 0; a < subsets.size(); a++) {

					ArrayList<String> temperaryArray = new ArrayList<String>();

					temperaryArray = preProcessed.getAnagramsOf(subsets.get(a));

					for (int b = 0; b < temperaryArray.size(); b++) {

						finalList.add(temperaryArray.get(b));

					}

				}
				System.out.println("We can make " + finalList.size() + " words from \"" + wordEntered + "\"");
				if (finalList.size() == 0) {
					System.out.println("All of the words with their scores (sorted by score):");
				}
				stringEntered.showList(finalList);
			}

			else {
				tester = 0;

			}
		}

	}

}
