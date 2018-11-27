import java.io.File;
import java.util.*;



/***
 * Class Title: GraphAlgosMain
 * Class Job: to calculate the number of nodes with 0 edges, to calculate the average number of edges, and the word with the highest edges.
 * it will also print out each word with the number of nodes.
 * @author Rich Laptop
 */
public class GraphAlgosMain {
    /***
     * Linked List of Strings, containing every word of the datasheet the user wishes to scan.
     */
    public static LinkedList<String> fullList;

    public static void main(String[] args) {
        createFullList();

        TreeMap<String,LinkedList<String>> fullMap = new TreeMap<>();
        Iterator fullListIterator = fullList.iterator();
        while (fullListIterator.hasNext())
        {
            String wordOn = (String)fullListIterator.next(); //Set each word in the list to a temporary variable, one at a time.
            wordObject tempWord = new wordObject(wordOn);
            LinkedList<String> tempVert = tempWord.calculateConnections(fullList);  //Calculate the connections for each word in the list.
            fullMap.put(wordOn,tempVert);

        }

        Iterator finalItr = fullMap.entrySet().iterator();
        int numbOfZeroes = 0;
        double avgVerts = 0;
        int maxVerts = 0;
        ///Loop through the words, and calculate the number of zeroes, and the average.
        while (finalItr.hasNext())
        {
            Map.Entry pair = (Map.Entry) finalItr.next();
            LinkedList<String> tempValue = (LinkedList<String>) pair.getValue();
            int value = tempValue.size();

            if (value == 0)
            {
                numbOfZeroes++;
            }

            avgVerts= avgVerts + value;
            if (value > maxVerts)
            {
                maxVerts = value;
            }
        }
        double finavgVerts = (avgVerts/(fullMap.size()));
        LinkedList<String> highCount = new LinkedList<>();
        Iterator highItr = fullMap.entrySet().iterator();
        //Looping through the words again
        while (highItr.hasNext())
        {
            Map.Entry pair = (Map.Entry) highItr.next();
            String word = (String) pair.getKey();
            LinkedList<String> tempValue = (LinkedList<String>) pair.getValue();
            int value = tempValue.size();

            if (value == maxVerts)
            {
                highCount.add(word); //If it has the highest verticies, add it to the list
            }
        }

        //Print out all the data, and the extra needed information about the edges.
        for (String key : fullMap.keySet()) {
            System.out.println(key + " = " + fullMap.get(key));
        }
        System.out.println("----------------------END OF DATA----------------");
        System.out.println("Number of Nodes with zero edges: " + numbOfZeroes);
        System.out.println("Average number of edges: " + finavgVerts);
        System.out.println("Word(s) with the highest edge count: " + highCount + " with " + maxVerts + " edges.");


    }

    //Creating the full list from a local file words.dat
    public static void createFullList() {
        String cwd = System.getProperty("user.dir");
        File data = new File(cwd + "/" + "words.dat");
        try {
            LinkedList<String> allWords = new LinkedList<>();
            Scanner scanner = new Scanner(data);
            scanner.useDelimiter(",|\\n");
            while (scanner.hasNext()) {
                allWords.add(scanner.next());
            }
            fullList = allWords;

        } catch (Exception FileNotFoundException) {
            System.out.println("Error: File not found.");
        }
    }


}


