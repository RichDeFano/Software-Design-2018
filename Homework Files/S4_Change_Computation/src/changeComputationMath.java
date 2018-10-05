import java.util.concurrent.ThreadLocalRandom;

/***
 * @author: Rich DeFano
 * Date: 10/4/18
 * Class Name: changeComputationMath
 * Class Description: a static class meant to do calculations and print statements to aid the user.
 * The class contains three static methods: subtractionMath, printInRegister, and changeBack.
 * This class has no constructor, as different objects of it are not needed.
 */
public class changeComputationMath {

    private static int numbOf20s = ThreadLocalRandom.current().nextInt(0, 15 + 1);
    private static int numbOf10s = ThreadLocalRandom.current().nextInt(0, 15 + 1);
    private static int numbOf5s = ThreadLocalRandom.current().nextInt(0, 15 + 1);
    private static int numbOf1s = ThreadLocalRandom.current().nextInt(0, 15 + 1);
    private static int numbOfQs = ThreadLocalRandom.current().nextInt(0, 15 + 1);
    private static int numbOfDs = ThreadLocalRandom.current().nextInt(0, 15 + 1);
    private static int numbOfNs = ThreadLocalRandom.current().nextInt(0, 15 + 1);
    private static int numbOfPs = ThreadLocalRandom.current().nextInt(0, 15 + 1);
    private static int x20sUsed = 0;
    private static int x10sUsed = 0;
    private static int x5sUsed = 0;
    private static int x1sUsed = 0;
    private static int xQsUsed = 0;
    private static int xDsUsed = 0;
    private static int xNsUsed = 0;
    private static int xPsUsed = 0;

    /***
     * Function Name: subtractionMath
     * Function Job: This function will take in the cost of the product the customer wishes to buy.
     * it will then calculate how much money is in the register, and the most efficient way to pay change back.
     * If the register cannot make change, it will output an error message to inform the cashier that they will need to
     * refill the register. This function has no return statements, and is a static method.
     * @param costOfProduct is the (user inputted) cost of the product that the customer wishes to buy.
     */
    public static void subtractionMath(double costOfProduct) {

        while (costOfProduct > 0.00) {
            if ((costOfProduct > 20) && (numbOf20s > 0)) {
                costOfProduct = costOfProduct - 20;
                x20sUsed += 1;
                numbOf20s--;
            } else if ((costOfProduct > 10) && (numbOf10s > 0)) {
                costOfProduct = costOfProduct - 10;
                x10sUsed += 1;
                numbOf10s--;
            } else if ((costOfProduct > 5) && (numbOf5s > 0)) {
                costOfProduct = costOfProduct - 5;
                x5sUsed += 1;
                numbOf5s--;
            } else if ((costOfProduct > 1) && (numbOf1s > 0)) {
                costOfProduct = costOfProduct - 1;
                x1sUsed += 1;
                numbOf1s--;
            } else if ((costOfProduct > 0.25) && (numbOfQs > 0)) {
                costOfProduct = costOfProduct - 0.25;
                xQsUsed += 1;
                numbOfQs--;
            } else if ((costOfProduct > 0.10) && (numbOfDs > 0)) {
                costOfProduct = costOfProduct - 0.10;
                xDsUsed += 1;
                numbOfDs--;
            } else if ((costOfProduct > 0.05) && (numbOfNs > 0)) {
                costOfProduct = costOfProduct - 0.05;
                xNsUsed += 1;
                numbOfNs--;
            } else if ((costOfProduct > 0.01) && (numbOfPs > 0)) {
                costOfProduct = costOfProduct - 0.01;
                xPsUsed += 1;
                numbOfPs--;
            } else {
                if (costOfProduct > 0.01) {
                    System.out.println("ERROR: Register does not have sufficient funds to make change.");
                }
                costOfProduct = 0;
            }

        }
    }

    /***
     * Function Name: printInRegister
     * Function Job: A series of print statements to inform the user of the money still in the register, broken up
     * into each bill or coin. This allows the users to see how or why change could or could not be made efficiently,
     * or at all. This function has no return statements, no input parameters, and is a static method.
     */
    public static void printInRegister()
    {
        System.out.println("------------------------Money In Register---------------------");
        System.out.println("20s in Register: " + numbOf20s);
        System.out.println("10s in Register: " + numbOf10s);
        System.out.println("5s in Register: " + numbOf5s);
        System.out.println("1s in Register: " + numbOf1s);
        System.out.println("Quarters in Register: " + numbOfQs);
        System.out.println("Dimes in Register: " + numbOfDs);
        System.out.println("Nickels in Register: " + numbOfNs);
        System.out.println("Pennies in Register: " + numbOfPs);
        System.out.println("-------------------------------------------------------------");

    }

    /***
     * Function Name: changeBack
     * Function Job: A series of print statements to inform the user how they will get their change back, in terms of
     * the amount of coins or bills in the register. This will use the variables defined for the function subtractionMath
     * in order to print how many of each coin or bill was used.  This function has no return statements, no input parameters,
     * and is a static method.
     */
    public static void changeBack()
    {
        System.out.println("-------------------------Change Back-------------------------");
        System.out.println("20 Dollar Bills Back: " + x20sUsed);
        System.out.println("10 Dollar Bills Back: " + x10sUsed);
        System.out.println("5 Dollar Bills Back: " + x5sUsed);
        System.out.println("1 Dollar Bills Back: " + x1sUsed);
        System.out.println("Quarters Back: " + xQsUsed);
        System.out.println("Dimes Back: " + xDsUsed);
        System.out.println("Nickels Back: " + xNsUsed);
        System.out.println("Pennies Back: " + xPsUsed);
        System.out.println("-------------------------------------------------------------");
    }
}
