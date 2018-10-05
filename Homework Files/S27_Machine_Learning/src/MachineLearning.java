import java.util.*;

public class MachineLearning {

    public static void main(String[] args) {
            LinkedList<String> listOne = new LinkedList<>();
            LinkedList<String> listTwo = new LinkedList<>();
            String binCode1 = "0110101";
            String binCode2 = "1110010";
            LinkedList<String> tempNewData;
            double printTotal = 0;

            listOne.add("1.0");
            listOne.add("2.0");
            listOne.add("3.0");
            listTwo.add("2.0");
            listTwo.add("6.0");
            listTwo.add("3.0");
                ///Easy
            System.out.println("---Easy Assignment Data Testing---");
            vectorMath vectors = new vectorMath(listOne,listTwo);
            printTotal = vectors.cosineSimilarity();
            System.out.println("Cosine Similarity = " + printTotal);
            printTotal = vectors.euclideanDistance();
            System.out.println("Euclidean Distance = " + printTotal);
            vectorMath code = new vectorMath(binCode1,binCode2);
            printTotal = code.hammingDistance();
            System.out.println("Hamming Distance = " + printTotal);
                ///Medium
            System.out.println("---Medium Assignment Data Testing---");
            tempNewData = createList();
            System.out.println("Your Dataset is " + tempNewData);
            kNearest newKNearest = new kNearest("S27-MLMedium.csv",tempNewData,5);
            newKNearest.findClass();
                ///Hard
            System.out.println("---Hard Assignment Data Testing---");
            kCluster newKCluster = new kCluster("S27-MLHard.csv",4);
            newKCluster.findClusters();



        }

        /***
         * Function Name: createList
         * Function Job: to create a new data point by user input, to be used with further KNearest calculations
         * @return the new data point.
         */
        private static LinkedList<String> createList()
        {
                LinkedList<String> newData = new LinkedList<>();
                for (int i=0;i<5;i++)
                {
                        Scanner sca = new Scanner(System.in);
                        System.out.println("Please input data point " + (i+1) + ".");
                        String name = sca.next();
                        newData.add(name);
                }
                return newData;
        }
    }


