import java.security.SecureRandom;

public class gapFilter implements Runnable{
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
    public gapFilter(Buffer sLocation)
    {
        this.sharedLocation = sLocation;
    }

    /***
     * Overrided function run will parse the string at its input, and output an ArrayBlockingQueue containing the original
     * Dataset minus all blank spaces, and unbroken by Ns.
     */
    @Override
    public void run()
    {
        try
        {
            String gapFinderOutput = "";
            int buffSize = sharedLocation.returnSize();
            for (int i = 0; i<buffSize; i++)
            {
                char charAt = sharedLocation.blockingGet();
                if (charAt==('N'))
                {
                    System.out.println("Current String is: " + gapFinderOutput);
                }
                else if ((charAt==('A')) || (charAt==('T')) || (charAt==('C')) || (charAt==('G')))
                {
                    gapFinderOutput = gapFinderOutput + charAt;
                }
                else if (charAt==(' '))
                {
                    // System.out.println("DEBUG: Blank space skipped.");
                }
                else
                {
                    System.out.println("ERROR: Unknown character found.");
                }
            }
            System.out.println("GAP FINDER OUTPUT: " + gapFinderOutput);
            System.out.println("------------------------------------------");
            for (int j = 0; j< gapFinderOutput.length();j++)
            {
                char tempAt = gapFinderOutput.charAt(j);
                sharedLocation.blockingPut(tempAt);
            }

        }
        catch (Exception e)
        {e.printStackTrace();}

    }

}