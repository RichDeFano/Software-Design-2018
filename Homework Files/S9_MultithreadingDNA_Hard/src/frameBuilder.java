import java.security.SecureRandom;


/***
 * Class frameBuilder outputs three different filtered string inputs. one with the first base missing, and one with the second base missing.
 */
public class frameBuilder implements Runnable{
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
    public frameBuilder(Buffer sLocation)
    {
        this.sharedLocation = sLocation;
    }


    /***
     * Overrided function run will parse the string at its input, and output three different versions of the string.
     * One as is, one minus the first base it finds, and one minus the second base it finds.
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
            char firstBase =  reverseComplementorOutput.charAt(0);
            char secondBase =  reverseComplementorOutput.charAt(1);
            String frameBuilderFB = "";
            String frameBuilderFSB = "";

            for (int k = 0; k< reverseComplementorOutput.length(); k++)
            {
                char tempBaseAt = reverseComplementorOutput.charAt(k);
                if ((tempBaseAt != firstBase) && (tempBaseAt != secondBase))
                {
                    frameBuilderFB = frameBuilderFB + tempBaseAt;
                    frameBuilderFSB = frameBuilderFSB + tempBaseAt;
                }
                else if (tempBaseAt == secondBase)
                {
                    frameBuilderFB = frameBuilderFB + tempBaseAt;
                }
            }

            System.out.println("FRAME BUILDER OUTPUT, OLD STRING: " + reverseComplementorOutput);
            System.out.println("FRAME BUILDER OUTPUT, FIRST BASE REMOVED: " + frameBuilderFB);
            System.out.println("FRAME BUILDER OUTPUT, FIRST AND SECOND BASE REMOVED: " + frameBuilderFSB);
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
