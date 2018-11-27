import java.io.File;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.*;


/***
 * @author Rich DeFano
 * Class Name: wordObject
 * Class Function: Controlling the calculations for each word, finding if it has more than four edges.
 */
public class wordObject {
    /***
     * Character Array variable word will store the inputted word for later usage.
     */
    private char[] word;

    /***
     * Constructor wordObject will set the variable word[] to a lower case char array version of the inputted word.
     * @param letters is the String of the inputted word.
     */
    public wordObject(String letters) {
        word = letters.toLowerCase().toCharArray(); //Create an object with the word
    }

    /***
     * Function Name: calculateConnections
     * Function Job: to calculate the list of successful words that pass the barrier of 4 or more edges.
     * @param fullList is the full list of words to be scanned.
     * @return a LinkedList containing the words that passed with 4 or more edges.
     */
    public LinkedList<String> calculateConnections(LinkedList<String> fullList)
    {
        Iterator fullListIterator = fullList.iterator();
        char[] tempSet = word;

        LinkedList<String> listOfEdges = new LinkedList<>();
        while (fullListIterator.hasNext()) //Iterating over the full list of words
        {
            int tempEdges = 0;
            String nextWord = (((String)fullListIterator.next()).toLowerCase());
            char[] cNextWord = nextWord.toCharArray(); //have an array for each letter for the temporary word you are at

            List<Character> cList = new ArrayList<>();  //create two temporary lists for storing the letters as you iterate through
            for(int i = 0; i<cNextWord.length; i++) {
                cList.add(cNextWord[i]);
            }

            List<Character> cList2 = new ArrayList<>(); //two separate lists will control the counting of duplicate numbers
            for(int j = 0; j<tempSet.length; j++) {
                cList2.add(tempSet[j]);
            }

            for (int i = 0; i<cList2.size();i++)
            {
                char letterAt = cList2.get(i);
                char letterAt2 = cList.get(i);
                if (letterAt == letterAt2)      //for every value in the large list, compare the letters. if the letter is equal then add one to  the edge counter
                {
                    tempEdges++;
                }
            }


            if (tempEdges == 4)
            {
                listOfEdges.add(nextWord);      //add it to the list of successful words
            }



        }
        return listOfEdges;
    }
}


