import java.io.File;
import java.io.FileNotFoundException;
//import java.util.Arrays;
import java.util.List;
//import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Iterator;
//import java.util.Set;
import java.util.LinkedList;
import java.util.Scanner;

//"S27-MLMedium.csv"

/***
 * @author Rich DeFano
 * Class Name: kNearest
 * Class Function: To calculate the k nearest data points of a newly inputted data point, and then assign it to one of
 * two classes.
 */
class kNearest {
    /***
     * Variable filePath is the path to the data(default of S27-MLMedium.csv
     */
    private String filePath;
    /***
     * Variable K is the amount of data points to find nearest of the inputted data point.
     */
    private int k;
    /***
     * Variable newData is the user inputted data point
     */
    private List<String> newData;
    /***
     * Variable finalSortC1 is the full list of data points in class one.
     */
    private TreeMap<String,LinkedList<String>> finalSortC1 = new TreeMap<>();
    /***
     * Variable finalSortC2 is the full list of data points in class two.
     */
    private TreeMap<String,LinkedList<String>> finalSortC2 = new TreeMap<>();

    /***
     * Constructor kNearest sets each parameter to a private variable for further use.
     * @param fp the file path of the csv file.
     * @param nD the new data point inputted by the user.
     * @param kAt the K value of how many similar points to find.
     */
    kNearest(String fp,List<String> nD,int kAt)
    {
        setFilePath(fp);
        setK(kAt);
        setNewData(nD);
    }

    /***
     * Set method for the file path
     * @param temp1 string of the file path
     */
    private void setFilePath(String temp1)
    {filePath = temp1;}

    /***
     * Get method for file path
     * @return the file path
     */
    private String getFilePath()
    {return filePath;}

    /***
     * Set method for K
     * @param tempK the K value assigned
     */
    private void setK(int tempK)
    {k = tempK;}

    /***
     * Get method for K
     * @return K
     */
    private Integer getK()
    {return k;}

    /***
     * Set method for new Data
     * @param tempData the user inputted data point
     */
    private void setNewData(List<String> tempData)
    {newData = tempData;}

    /***
     * Get method for new data
     * @return new data point
     */
    private List<String> getNewData()
    {return newData;}

    /***
     * Function Name: findClass
     * Function Job: reading in a file, and assign each data point to class1 or class2 based on a string at the end of the data point.
     */
    void findClass() {
        String returnClass ="_";
        LinkedList<LinkedList<String>> listOfClosest1 = new LinkedList<>();
        LinkedList<LinkedList<String>> listOfClosest2 = new LinkedList<>();
        int count = 0;
        int scoreL1 = 0;
        int scoreL2 = 0;
        while (returnClass.equals("_")) {
            try {
                String cwd = System.getProperty("user.dir");
                Scanner scanner = new Scanner(new File(cwd + "/" + getFilePath()));
                scanner.useDelimiter(",|\\n");

                while (scanner.hasNext()) {
                    LinkedList<String> tempFive = new LinkedList<>();
                    for (int i = 0; i < 6; i++) {
                        String temp = scanner.next();
                        temp = temp.replaceAll("\"", "");
                        if (temp.equals("class1")) {
                            vectorMath kMeans = new vectorMath(getNewData(), tempFive);
                            double dis = kMeans.euclideanDistance();
                            finalSortC1.put(Double.toString(dis), tempFive);
                        } else if (temp.equals("class2")) {
                            vectorMath kMeans = new vectorMath(getNewData(), tempFive);
                            double dis = kMeans.euclideanDistance();
                            finalSortC2.put(Double.toString(dis), tempFive);
                        } else {
                            tempFive.add(temp);
                        }
                    }
                }
                scanner.close();
                returnClass = "class1";
            } catch (FileNotFoundException e) {
                Scanner sca = new Scanner(System.in);
                System.out.println("File not found. Please recheck the path for errors and type the new path.");
                String name = sca.next();
                setFilePath(name);

            }
        }
            //System.out.println("DEBUG: List of closest(Class1) == " + finalSortC1);
            //System.out.println("DEBUG: List of closest(Class2) == " + finalSortC2);
            Iterator itr2 = finalSortC1.entrySet().iterator();
            Iterator itr3 = finalSortC2.entrySet().iterator();
            if ((itr2.hasNext() && (itr3.hasNext())) && (count < getK()))
            {
                Map.Entry pair2 = (Map.Entry)itr2.next();
                Map.Entry pair3 = (Map.Entry)itr3.next();
                double n2 = Double.parseDouble((String)pair2.getKey());
                double n3 = Double.parseDouble((String)pair3.getKey());
                LinkedList<String> tempStr = (LinkedList<String>)pair2.getValue();
                LinkedList<String> tempStr2 = (LinkedList<String>)pair3.getValue();
                listOfClosest1.add(tempStr);
                listOfClosest2.add(tempStr2);

                if (n2 < n3)
                {
                    scoreL1 += 1;
                    scoreL2 -= 1;
                }
                else
                {
                    scoreL1 -= 1;
                    scoreL2 += 1;
                }


            }



        if (scoreL1 > scoreL2)
        {System.out.println("New data point belongs in Class 1.");}
        else
        {System.out.println("New data point belongs in Class 2.");}

    }



}
