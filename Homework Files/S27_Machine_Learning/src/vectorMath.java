
import java.util.*;

public class vectorMath {
    /***
     * Variable arrayOne is the first data point to be compared.
     */
    private List<Double> arrayOne;
    /***
     * Variable arrayTwo is the second data point to be compared.
     */
    private List<Double> arrayTwo;
    /***
     * codeOne is the first binary code to be compared.
     */
    private String codeOne;
    /***
     * codeTwo is the second binary code to be compared.
     */
    private String codeTwo;


    /***
     * Constructor for a list of data points, and converts them to doubles for math functions.
     * @param temp1 List of data points as a string.
     * @param temp2 List of second data points as a string.
     */
    vectorMath(List<String> temp1,List<String>temp2)
    {
        List<Double> newList1 = new LinkedList<>();
        List<Double> newList2 = new LinkedList<>();
        Iterator<String> itr = temp1.iterator();
        Iterator<String> itr2 = temp2.iterator();
        while (itr.hasNext() && itr2.hasNext())
        {
            double tempV = Double.valueOf(itr.next());
            double tempV2 = Double.valueOf(itr2.next());
            newList1.add(tempV);
            newList2.add(tempV2);
            //System.out.println("List 1: " + newList1);
            //System.out.println("List 2: " + newList1);
            setArrayOne(newList1);
            setArrayTwo(newList2);
        }

    }

    /***
     * Constructor for the strings of binary codes, keeps them as strings for hamming distance calculations.
     * @param temp1 Binary code 1
     * @param temp2 Binary code 2
     */
    vectorMath(String temp1,String temp2)
    {
        setCodeOne(temp1);
        setCodeTwo(temp2);
    }

    /***
     * Set method for binary code 1.
     * @param temp1 binary code 1.
     */
    private void setCodeOne(String temp1)
    {codeOne = temp1;}

    /***
     * Set method for binary code 2
     * @param temp2 binary code 2.
     */
    private void setCodeTwo(String temp2)
    {codeTwo = temp2;}

    /***
     * Set method for Array one
     * @param temp1 array one
     */
    private void setArrayOne(List<Double> temp1)
    {arrayOne = temp1;}

    /***
     * Set method for Array Two
     * @param temp2 array two.
     */
    private void setArrayTwo(List<Double> temp2)
    {arrayTwo = temp2;}

    /***
     * Get method for array one.
     * @return array one.
     */
    public List<Double> getArrayOne()
    {return arrayOne;}

    /***
     * Get method for array two.
     * @return array two.
     */
    public List<Double> getArrayTwo()
    {return arrayTwo;}


    /***
     * Function Name: cosineSimilarity
     * Function Job: calculate the cosine similarity between two data points
     * @return the cosine similarity of the inputted data points.
     */
    double cosineSimilarity()
    {
        if (arrayOne.size() != arrayTwo.size())
        {
            System.out.println("Cosine Similarity cannot be calculated, arrays are not of equal size.");
            return -1;
        }
        else {
            double uvSum = 0;
            double uAbs = 0;
            double vAbs = 0;
            double total = 0;
            Iterator<Double> itr = arrayOne.iterator();
            Iterator<Double> itr2 = arrayTwo.iterator();

            while (itr.hasNext() && itr2.hasNext()) {
                double valueSDV1 = itr.next();
                double valueSDV2 = itr2.next();
                uvSum = (uvSum + (valueSDV1 * valueSDV2));
                uAbs = (uAbs + (valueSDV1 * valueSDV1));
                vAbs = (vAbs + (valueSDV2 * valueSDV2));
            }
            total = (uvSum) / (Math.sqrt(uAbs * vAbs));
            return total;
        }
    }

    /***
     * Function Name: euclideanDistance
     * Functoin Job: Calculates the euclidean distance between two data points.
     * @return the euclidean distance as a decimal value.
     */
    double euclideanDistance() {
        if (arrayOne.size() != arrayTwo.size()) {
            System.out.println("Euclidean Distance cannot be calculated, arrays are not of equal size.");
            return -1;
        } else {
            Iterator<Double> itr3 = arrayOne.iterator();
            Iterator<Double> itr4 = arrayTwo.iterator();
            double uvSum2 = 0;
            double total = 0;
            while (itr3.hasNext() && itr4.hasNext()) {
                double valueSDV1 = itr3.next();
                double valueSDV2 = itr4.next();
                uvSum2 = uvSum2 + (Math.pow((valueSDV2 - valueSDV1), 2));
            }
            total = Math.sqrt(uvSum2);
            return total;
        }
    }

    /***
     * Function Name: hammingDistance
     * Function Job: to calculate the hamming distance between two binary codes
     * @return an integer of the minimum amount of changes needed(the hamming distance)
     */
    int hammingDistance() {
        int total = 0;
        if (codeOne.length() != codeTwo.length()) {
            System.out.println("Hamming Distance cannot be assessed, strings are of different length.");
            return -1;
        } else {
            for (int i = 0; i < codeOne.length(); i++) {
                char c = codeOne.charAt(i);
                char d = codeTwo.charAt(i);
                if (c != d) {
                    total += 1;
                }
            }

            return total;
        }
    }



}




