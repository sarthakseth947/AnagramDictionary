# AnagramDictionary

Implemented a project utilizing java, focusing on finding the anagrams of a word, via HashMap, by comparing it from a dictionary that is added by user.Aligned the anagrams in order of their scores (scoring technique can be decided by user by giving different scores to different alphabets).


# How it works?
This Program program have 4 classes-

- Wordfinder - This has the main method which checks if a file is entered otherwise use the file sow pods which will be present in the same directory as our program.After we get the file or dictionary file.We then send this file to the anagramDictionary class parameter
 constructor where it is preprocessed and is converted into a map where key is another map which is being used to divide string in the dictionary and put it in terms of the number of repetitions of its alphabets.for eg. a string "calm" in dictionary will be put into a map with key value pairs as  (a:1,l:1,m:1:c:1)->calm.this is done to all the words in the dictionary and they are stored in maps according to the multiplicity of their characters.After this we enter the word , which we have to find the scrabble names for. this word is agin put into a map with its characters and their repetitions as key value pairs . for eg "all" (a)->1 (l)->2. After this , this map is checked against the keys of the dictionary and if the key is matched . it returns the array list of anagrams its pointing to which are all the possible words that can be formed from the alphabets of given string. after that the same process takes place with the subsets of the words entered. After this the score is counted for each of the returned words(scores already given) and is printed out.

- AnagramDictionary-Have methods for finding the anagrams of a word as well as initialisation and pre-processing of dictionary in the constructor.I have used a lil bit of private helper methods to make the code fit in 30 lines in each method.I have used hashmap wherever possible along with array list for faster and more efficient programming.

- Rack- have a recursion method to find the subsets of words entered as well as a display method to display the result with scores.It also have a wrapper method for the recursion method provided ,so as to use it.

- ScoreTable.finds the score of each string according to the scores provide.I used a lil long but easy method where i Used a hashmap and put each character as key and its score as value and compared the characters to get their score.


# How to Use?

  - Just clone the files on a single folder.
  - Run the files ,under the same package, on a java IDE (with the dictionary that you are using as the argument).In our case we have different dictionaries.The biggest one is sowpods.txt
