import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Random;


/***
 * @author Rich DeFano
 * Class Name: kCluster
 * Class Function: To calculate the kCluster for an inputted vector, and then assign it to the closest cluster.
 */
class kCluster {
    /***
     * Variable filePath is the user directory to find the S27-MLHard.csv
     */
    private String filePath;
    /***
     * Variable K is the user input for the amount of random generated clusters to create.
     */
    private int k;
    /***
     * Constructor kCluster sets the file path and the K value.
     * @param fp the file path.
     * @param kAt the user inputted K value.
     */
    kCluster(String fp, int kAt) {
        setFilePath(fp);
        setK(kAt);

    }
    /***
     * Set method for file path variable.
     * @param temp1 user inputted file path.
     */
    private void setFilePath(String temp1) {
        filePath = temp1;
    }
    /***
     * Set method for K value.
     * @param tempK user inputted K value.
     */
    private void setK(int tempK) {
        k = tempK;
    }

    /***
     * Get method for File Path.
     * @return the file path for s27-MLHard.csv.
     */
    private String getFilePath() {
        return filePath;
    }

    /***
     * Get method for K value.
     * @return the assigned K value.
     */
    private Integer getK() {
        return k;
    }


    /***
     * Function Name: findClusters
     * Function Job: This will read in the data from the provided data sheet(default of S27-MLHard.csv)
     * after reading in all the data, it will assign each point to a hashmap. After this is complete, it will create
     * K number of random clusters. With these clusters, it will start assigning data points to the closest found cluster average.
     * After each data point is assigned to a cluster, the new clusters average point will be calculated and set,for further
     * sorting. After the clusters are fully formed, it will output how many data points are in each cluster.
     */
    void findClusters() {
        LinkedList<LinkedList<Double>> outsideList = new LinkedList<>();
        LinkedList<LinkedList<Double>> randomGenList = new LinkedList<>();
        HashMap<LinkedList<LinkedList<Double>>, Integer> fullHMap = new HashMap<>();
        LinkedList<LinkedList<Double>> averages = new LinkedList<>();
        ////////////////////////////Reading the Data inputs
        String returnClass = "_";
        while (returnClass.equals("_")) {
            try {
                String cwd = System.getProperty("user.dir");
                Scanner scanner = new Scanner(new File(cwd + "/" + getFilePath()));
                scanner.useDelimiter(",|\\n");
                while (scanner.hasNext()) {
                    LinkedList<Double> tempDataPoint = new LinkedList<>();
                    for (int i = 0; i < 2; i++) {
                        String temp = scanner.next();
                        Double s2D = Double.parseDouble(temp);
                        tempDataPoint.add(s2D);
                        if (i == 1) {
                            outsideList.add(tempDataPoint);
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
        ////////////////////////////Generating random Clusters
        for (int i = getK(); i > 0; i--) {
            LinkedList<Double> singlePoint = new LinkedList<>();
            Random r = new Random();
            Random r2 = new Random();
            double random1 = r.nextInt(10);
            double random2 = r2.nextInt(10);
            singlePoint.add(random1);
            singlePoint.add(random2);
            randomGenList.add(singlePoint);
        }
        ///////////////////////////////////Assign values to clusters
        int i = 1;
        while (!randomGenList.isEmpty()) {
            LinkedList<Double> tempList = randomGenList.remove();
            LinkedList<LinkedList<Double>> tempList2 = new LinkedList<>();
            tempList2.add(tempList);
            averages.add(tempList);
            fullHMap.put(tempList2, i);
            i++;
        }
        Iterator fullListItr = outsideList.iterator();
        while (fullListItr.hasNext())
        {
            LinkedList<Double> atData = (LinkedList<Double>)fullListItr.next();
            Iterator avgChecker = averages.iterator();
            double smallesteuDi = 999;
            int count = 0;
            int countAt = 0;
            LinkedList<Double> smallestAv = new LinkedList<>();
            while (avgChecker.hasNext())
            {
                LinkedList<Double> atDataAvg = (LinkedList<Double>)avgChecker.next();
                double euDi = euclideanDistance(atData,atDataAvg);
                if (euDi < smallesteuDi)
                {
                    smallesteuDi = euDi;
                    smallestAv = atDataAvg;
                    countAt = count;
                }
                count++;
            }
            LinkedList<LinkedList<Double>> tempAdd = new LinkedList<>();
            tempAdd.add(atData);
            fullHMap.put(tempAdd,countAt+1);
            LinkedList<Double> newAvg = findAverageOfTwo(atData,smallestAv);
            averages.set(countAt,newAvg);
        }
        //////////////////////////////////////Calculate each cluster size
        for (int j = getK(); j >0; j--) {
            Iterator mapItr = fullHMap.entrySet().iterator();
            int numbOfClusterContains = 0;
            while (mapItr.hasNext()) {
                Map.Entry pair = (Map.Entry) mapItr.next();
                int value = (Integer) pair.getValue();
                if (value == j)
                {numbOfClusterContains++;}
            }
            System.out.println("Cluster " + j + " contains " + numbOfClusterContains + " data points.");
        }


    }

    /***
     * Function Name: euclideanDistance
     * Function Job: to calculate the euclidean distance between two data points.
     * @param aOne First data point
     * @param aTwo Second data point
     * @return the calculated euclidean distance
     */
    double euclideanDistance(LinkedList<Double> aOne,LinkedList<Double> aTwo) {
            Iterator<Double> itr = aOne.iterator();
            Iterator<Double> itr2 = aTwo.iterator();
            double uvSum2 = 0;
            double total = 0;
            while (itr.hasNext() && itr2.hasNext()) {
                double valueSDV1 = itr.next();
                double valueSDV2 = itr2.next();
                uvSum2 = uvSum2 + (Math.pow((valueSDV2 - valueSDV1), 2));
            }
            total = Math.sqrt(uvSum2);
            return total;
        }

    /***
     * Function Name: findAverageOfTwo
     * Function Job: To find the average between a new point being added to the list, as well as the lists old average.
     * As it calculates this new average, it will set the old average to this new average.
     * @param input1 value for the old cluster average.
     * @param input2 value of the new data point being added to a cluster.
     * @return the list of averages, updated with the new point.
     */
    LinkedList<Double> findAverageOfTwo(LinkedList<Double> input1, LinkedList<Double> input2) {
            double input1X = input1.get(0);
            double input1Y = input1.get(1);
            double input2X = input2.get(0);
            double input2Y = input2.get(1);

            double sumX = ((input2X + input1X)/2);
            double sumY = ((input2Y + input1Y)/2);
            LinkedList<Double> newListAverage = new LinkedList<>();
            newListAverage.add(sumX);
            newListAverage.add(sumY);

            return newListAverage;

        }
}