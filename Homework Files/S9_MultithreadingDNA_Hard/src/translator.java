import java.security.SecureRandom;
import java.util.Arrays;

public class translator implements Runnable{
    /***
     * SecureRandom randGen creates a securely generated random number.
     */
    private static final SecureRandom randGen = new SecureRandom();
    /***
     * Variable Buffer sharedLocation is the filters connecting buffer to share information.
     */
    private final Buffer sharedLocation;

    /***
     * Constructor frameBuilder sets the shared location to read/write data from.
     * @param sLocation
     */
    public translator(Buffer sLocation)
    {
        this.sharedLocation = sLocation;
    }

    /***
     * the translator will take a DNA squence and translate it into an Amino Acid sequence defined by the Codon enum.
     */
    @Override
    public void run()
    {
        try
        {
            String reverseComplementorOutput = "";
            int buffSize = sharedLocation.returnSize();
            for (int i = 0; i<buffSize; i++)
            {
                char charAt = sharedLocation.blockingGet();
                reverseComplementorOutput = reverseComplementorOutput + (String.valueOf(charAt));
            }
            char[] oldReverseComplementorOutput = reverseComplementorOutput.toCharArray();
            String translatedToU = "";
            while (oldReverseComplementorOutput.length >= 3)
            {
                char[] tempThree = new char [2];
                tempThree = Arrays.copyOfRange(oldReverseComplementorOutput,0,3);
                String newCodon = String.valueOf(tempThree);
                Codon c = Codon.getCodon(newCodon);
                translatedToU = translatedToU + (c.getOneLetterCode());
                int sizeMinus3 = oldReverseComplementorOutput.length;
                oldReverseComplementorOutput = Arrays.copyOfRange(oldReverseComplementorOutput,3,sizeMinus3);

            }
            System.out.println("TRANSLATOR OUTPUT: " + translatedToU);
            System.out.println("------------------------------------------");
            for (int j = 0; j< reverseComplementorOutput.length();j++)
            {
                char tempAt = reverseComplementorOutput.charAt(j);
                sharedLocation.blockingPut(tempAt);
            }

        }
        catch (Exception e)
        {e.printStackTrace();}

    }

}