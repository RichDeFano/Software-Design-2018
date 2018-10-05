import javax.swing.*;
import java.io.File;
import java.util.*;

public class baseChangeMain {
    public static void main(String[] args) {

    boolean keepLooping = true;
    while (keepLooping)
    {
        // obtain user input from JOptionPane input dialogs
        String firstBase = JOptionPane.showInputDialog("Enter the base of the number you wish to convert.");
        String firstNumber = JOptionPane.showInputDialog("Enter the number you wish to convert.");
        String secondBase = JOptionPane.showInputDialog("Enter the base you wish to convert your number to.");
        int oldB = Integer.parseInt(firstBase);
        int newB = Integer.parseInt(secondBase);

        changeFormula userSelections = new changeFormula(firstNumber,oldB,newB);
        String output = userSelections.executeConversion();
        JOptionPane.showMessageDialog(null, output, "Converted Number", JOptionPane.PLAIN_MESSAGE);
        boolean keepSecondLoop = true;
        while (keepSecondLoop)
        {
        String shouldLoop = JOptionPane.showInputDialog("Would you like to convert another number?");
        if (shouldLoop.equalsIgnoreCase("yes"))
            {
            keepLooping = true;
            keepSecondLoop = false;
            }
        else if (shouldLoop.equalsIgnoreCase("no"))
            {
            keepLooping = false;
            keepSecondLoop = false;
            JOptionPane.showMessageDialog(null,"The program has been ended.", "Closing Software", JOptionPane.PLAIN_MESSAGE);
            }
        else
            {
            JOptionPane.showMessageDialog(null,"Please input either yes or no to continue converting or to quit.", "Error:", JOptionPane.PLAIN_MESSAGE);
            keepSecondLoop = true;
            }
        }
    }
        //testCases();
    }

    /***
     * Function Name: testCases
     * Function Job: to test each conversion and print out the correct new value and base.
     * Unused in final program as the user will be inputting bases and numbers.
     */
    public static void testCases()
    {
        ///////////////To Base 10 Tests////////////////////////
        System.out.println("***********************To Base 10 Testing*******************");
        changeFormula testToBinaryConversion = new changeFormula("10101101",2,10);
        String output = testToBinaryConversion.toBaseTen();
        System.out.println("The Binary number 10101101 is equal to " + output + " in base 10.");

        changeFormula testToOctalConversion = new changeFormula("374",8,10);
        String output2 = testToOctalConversion.toBaseTen();
        System.out.println("The Octal number 374 is equal to " + output2 + " in base 10.");

        changeFormula testToHexConversion = new changeFormula("32A",16,10);
        String output3 = testToHexConversion.toBaseTen();
        System.out.println("The Hexedecimal number 32A is equal to " + output3 + " in base 10.");

        changeFormula testToBase32Conversion = new changeFormula("2VE",32,10);
        String output4 = testToBase32Conversion.toBaseTen();
        System.out.println("The Base 32 number 2VE is equal to " + output4 + " in base 10.");

        changeFormula testToDecimalConversion = new changeFormula("1234662",10,10);
        String output5 = testToDecimalConversion.toBaseTen();
        System.out.println("The Decimal number 1234662 is equal to " + output5 + " in base 10.");
        ///////////////////////From Base 10 Tests/////////////////////////////////////////
        System.out.println("***********************To Base 10 Testing*******************");
        changeFormula testToBinaryConversionD = new changeFormula("173",10,2);
        String output6 = testToBinaryConversionD.fromBaseTen();
        System.out.println("The Decimal number 173 is equal to " + output6 + " in Binary.");

        changeFormula testToOctalConversionD = new changeFormula("252",10,8);
        String output7 = testToOctalConversionD.fromBaseTen();
        System.out.println("The Decimal number 252 is equal to " + output7 + " in Octal.");

        changeFormula testToHexConversionD = new changeFormula("810",10,16);
        String output8 = testToHexConversionD.fromBaseTen();
        System.out.println("The Decimal number 810 is equal to " + output8 + " Hexidecimal.");

        changeFormula testToBase32ConversionD = new changeFormula("3054",10,32);
        String output9 = testToBase32ConversionD.fromBaseTen();
        System.out.println("The Decimal number 3054 is equal to " + output9 + " in base 32.");

        changeFormula testToDecimalConversionD = new changeFormula("1234662",10,10);
        String output10 = testToDecimalConversionD.fromBaseTen();
        System.out.println("The Decimal number 1234662 is equal to " + output10 + " in base 10.");
        /////////////////////To Any Base Tests/////////////////////
        System.out.println("*****************************Any Base Testing**********************");
        changeFormula fromBinaryToOctal = new changeFormula("010101101",2,8);
        fromBinaryToOctal.executeConversion();
        testToBinaryConversion.executeConversion();
        testToOctalConversion.executeConversion();
        testToHexConversion.executeConversion();
        testToBase32Conversion.executeConversion();
        testToDecimalConversion.executeConversion();
        /////////////////////////////////////////////////////////////////////////////////////////////
    }

}


