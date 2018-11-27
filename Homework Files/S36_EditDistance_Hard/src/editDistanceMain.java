
/***
 * @author Rich DeFano
 * Class Name: EditDistanceMain
 * Class Function: Run the EditDistance method between various strings
 */
public class editDistanceMain {
    public static void main(String[] args) {
        String comparedString1 = "Sunday";
        String comparedString2 = "Saturday";

        String comparedString3 = "Kitten";
        String comparedString4 = "Sitting";

        String comparedString5 = "Software";
        String comparedString6 = "Science";

        //Run each pair of two strings to calculate the edit distance
        EditDistance testOne = new EditDistance(comparedString1,comparedString2);
        testOne.levenshteinDistance();
        EditDistance testTwo = new EditDistance(comparedString3,comparedString4);
        testTwo.levenshteinDistance();
        EditDistance testThree = new EditDistance(comparedString5,comparedString6);
        testThree.levenshteinDistance();

    }
}
