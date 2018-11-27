
/***
 * @author Rich DeFano
 * Class Name: EditDistance
 * Class Function: Controlling the calculations to find the edit distance between two strings.
 */
public class EditDistance {
    /***
     * String variable comparedStringOne is the first inputted string to calculate edit distance with.
     */
    private final String comparedStringOne;

    /***
     * String variable comparedStringTwo is the second inputted string to calculate edit distance with.
     */
    private final String comparedStringTwo;

    /***
     * Constructor EditDistance sets the two strings to private
     * @param tempOne is the first string
     * @param tempTwo is the second string
     */
    public EditDistance(String tempOne, String tempTwo)
    {
        comparedStringOne = tempOne;
        comparedStringTwo = tempTwo;
    }

    /***
     * Function Name: levenshteinDistance
     * Function Job: To calculate the levenshtein distance between two strings, by using a 2D matrix
     */
    public void levenshteinDistance()
    {
        char[] wordOne = comparedStringOne.toLowerCase().toCharArray();
        char[] wordTwo = comparedStringTwo.toLowerCase().toCharArray();
        int wordOneLength = wordOne.length;
        int wordTwoLength = wordTwo.length;
        int[][] dataMatrix = new int[wordOneLength+1][wordTwoLength+1];
        //Create a matrix with each letter assigned for spots 1-X letters

        for (int i = 1; i< wordOneLength+1; i++) //Set the matrix to 0s, and number the columns
        {
            dataMatrix[i][0] = i;
        }

        for (int j = 1; j< wordTwoLength+1; j++) //Set the matrix to 0s, and number the rows
        {
            dataMatrix[0][j] = j;
        }


        //For each letter in each word, compare which move is the least changing and add that value to the array. The smallest number of changes for each letter
        //combination is held in the array,
        //the number belonging to the last spot in the array, or the bottom right number.
        for (int k = 1; k < wordTwoLength+1; k++)
        {
            for(int l = 1; l < wordOneLength+1; l++)
            {
                int substitutionCost;
                if (wordOne[l-1] == wordTwo[k-1])
                {
                    substitutionCost = 0;
                }
                else
                {
                    substitutionCost = 1;
                }
                //dataMatrix[l-1][k] is for deletion
                //dataMatrix[l][k-1] is for insertion
                //dataMatrix[l-1][k-1] is for substitution
                int tempValue = minimum((dataMatrix[l-1][k] + 1),(dataMatrix[l][k-1] + 1),(dataMatrix[l-1][k-1] + substitutionCost)); //find which move is the least changing
                dataMatrix[l][k] = tempValue;
            }
        }
        //System.out.print(Arrays.deepToString(dataMatrix));
        System.out.println("-----------------------------------------------");
        System.out.println("Word One: " + comparedStringOne + " | Word Two: " + comparedStringTwo);
        System.out.println("Edit Distance: " + dataMatrix[wordOneLength][wordTwoLength]);

    }


    /***
     * Function Name: minimum
     * Function Job: To return the smallest integer out of the three inputs
     * @param a, Integer number one
     * @param b, Integer number two
     * @param c, Integer number three
     * @return
     */
    public static int minimum(int a, int b, int c)
    {
        int tempMin = 999; //No value should be over 999, so it will be overwritten
        if (a < tempMin)
        {tempMin = a;}

        if (b < tempMin)
        {tempMin = b;}

        if (c < tempMin)
        {tempMin = c;}

        return tempMin; //return the minimum of the three values
    }
}
