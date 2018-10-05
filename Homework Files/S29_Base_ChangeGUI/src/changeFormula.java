import java.lang.Character;
import java.util.*;

public class changeFormula {

    /***
     * Variable oldBase is the base from the number to be converted.
     */
    private int oldBase;
    /***
     * Variable newBase is the base that the number should be converted to.
     */
    private int newBase;
    /***
     * Variable oldNumber is the number that needs to be converted to a new base.
     */
    private String oldNumber;

    /***
     * Constructor changeFormula will set the user inputted values of the newly created object.
     * @param oldN is the old number.
     * @param oldB is the old base.
     * @param newB is the new base.
     */
    public changeFormula(String oldN, int oldB, int newB)
    {
        setOldNumber(oldN);
        setOldBase(oldB);
        setNewBase(newB);
    }

    /***
     * Set method for the old number.
     * @param oldN user inputted old number.
     */
    private void setOldNumber(String oldN)
    {oldNumber = oldN;}

    /***
     * Set method for the old base.
     * @param oldB user inputted old base.
     */
    private void setOldBase(int oldB)
    {oldBase = oldB;}

    /***
     * Set method for the new base.
     * @param newB user inputted new base.
     */
    private void setNewBase(int newB)
    {newBase = newB;}

    /***
     * Get method for the old number.
     * @return the old number.
     */
    public String getOldNumber()
    {return oldNumber;}

    /***
     * Get method for the old base.
     * @return the old base.
     */
    public int getOldBase()
    {return oldBase;}

    /***
     * Get method for the new base.
     * @return the new base.
     */
    public int getNewBase()
    {return newBase;}


    /***
     * Function Name: toBaseTen
     * Function Job: To convert the old number to base 10(decimal) to create a standard conversion alogrithm no matter
     * the old base.
     * @return a String of the newly converted number in base 10.
     */
    public String toBaseTen()
    {
        String tempOld = getOldNumber();
        int oldNumbLength = tempOld.length();
        int newNumb = 0;
        for(int i=0; i<oldNumbLength;i++)
        {
            char digitAtChar = tempOld.charAt(i);
            double digitAt;
            if (Character.isDigit(digitAtChar)) {
                digitAt = Character.getNumericValue(digitAtChar);
            }
            else
            {
                String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                char[] charArray = alphabet.toCharArray();
                int count = 0;
                for (int j = 0; j<charArray.length;j++)
                {
                    if (digitAtChar == charArray[j])
                    {break;}
                    else
                    {count++;}
                }
                digitAt = 10 + count;
            }
            digitAt = (digitAt)*(Math.pow(getOldBase(),oldNumbLength-i-1));
            newNumb += digitAt;

        }
        return Integer.toString(newNumb);
    }

    /***
     * Function Name: fromBaseTen
     * Function Job: To convert a base 10 number to a new base, allowing for one algorithm no matter the new base.
     * @return a String of the newly converted number in the new base.
     */
    public String fromBaseTen()
    {
        int toBase = getNewBase();
        String oldDecimal = getOldNumber();
        String newNumber = "";
        int oldDecimalInt = Integer.parseInt(oldDecimal);
        int result = 0;
        int remainder = 0;


        while (oldDecimalInt > 0)
        {
            String addToEnd;
            result = (oldDecimalInt/toBase);
            remainder = (oldDecimalInt%toBase);
            if (remainder >=10)
            {
                String alphabet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                char[] charArray = alphabet.toCharArray();
                char Lremainder = charArray[remainder-10];
                addToEnd = Character.toString(Lremainder);
            }
            else
            {
                addToEnd = String.valueOf(remainder);
            }
            newNumber = addToEnd + newNumber;
            oldDecimalInt = result;
        }
        return newNumber;
    }

    /***
     * Function Name: executeConversion
     * Function Job: to control the conversions. Default converts a number to base 10, and then converts that base 10 number
     * to the newly defined base. Also controls situations such as starting in base 10(skipping toBaseTen) and user inputted
     * errors.
     * @return a completed message of the old to new base to display to the user.
     */
    public String executeConversion()
    {
        String outputString;
        if ((getOldBase() != 10) && (getNewBase() != getOldBase()))
        {
            String inBase10 = toBaseTen();
            if (getNewBase() == 10)
            {
                outputString = ("The Base " + getOldBase() + " number " + getOldNumber() + " is " + inBase10 + " in Base 10 Format.");
            }
            else
            {
                String oldOldNumber = getOldNumber();
                setOldNumber(inBase10);
                String inNewBase = fromBaseTen();
                outputString = ("The Base " + getOldBase() + " number " + oldOldNumber + " is " + inNewBase + " in Base " + getNewBase() + " Format.");
            }
        }
        else if (getOldBase() == 10) {
            String inNewBase = fromBaseTen();
            outputString = ("The Base " + getOldBase() + " number " + getOldNumber() + " is " + inNewBase + " in Base " + getNewBase() + " Format.");
        }
        else if (getNewBase() == getOldBase())
        {
            outputString = ("The Bases entered are the same. The number will not change. The number is " + getOldNumber() + " in base " + getOldBase());
        }
        else
        {
            outputString = ("There was an error with your entered values. Please Try again.");
        }
        return outputString;
    }



}
