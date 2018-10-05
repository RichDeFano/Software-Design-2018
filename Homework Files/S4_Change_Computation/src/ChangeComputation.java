import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;



public class ChangeComputation {
    public static void main(String[] args) {
        double costOfProduct = 0;
        boolean stillPurchasing = true;
        while (stillPurchasing == true) {
            changeComputationMath.printInRegister();

            System.out.println("Enter the price of the product the customer wishes to purchase.");
            Scanner scanner = new Scanner(System.in);
            String price = scanner.nextLine();
            System.out.println("Enter the amount of money given to you by the customer.");
            Scanner scanner2 = new Scanner(System.in);
            String paid = scanner2.nextLine();

            double dPrice = Double.parseDouble(price);
            double dPaid = Double.parseDouble(paid);

            if (dPrice > dPaid) {
                System.out.println("ERROR: Register does not have sufficient funds to complete this purchase.");
            } else {
                costOfProduct = dPaid - dPrice;
            }
            changeComputationMath.subtractionMath(costOfProduct);
            changeComputationMath.changeBack();

            System.out.println("Enter 'done' if you are finished making purchases. Otherwise, enter anything else.");
            Scanner scanner3 = new Scanner(System.in);
            String areDone = scanner3.nextLine();
            if (areDone.equalsIgnoreCase("Done"))
            {
                stillPurchasing = false;
            }
        }

    }
}


