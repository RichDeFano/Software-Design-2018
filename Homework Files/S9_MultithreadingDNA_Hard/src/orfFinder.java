import java.security.SecureRandom;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
/**
 *
 * @author Rich Laptop
 */
public class orfFinder implements Runnable{
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
    public orfFinder(Buffer sLocation)
    {
        this.sharedLocation = sLocation;
    }

    /***
     * orfFinder will look for all frames between two stops that are larger than 21 strands between stops.
     */
    @Override
    public void run()
    {
        try
        {
            String translatedToU = "";
            int buffSize = sharedLocation.returnSize();
            for (int i = 0; i<buffSize; i++)
            {
                char charAt = sharedLocation.blockingGet();
                translatedToU = translatedToU + (String.valueOf(charAt));
            }
            char[] orfInput = translatedToU.toCharArray();
            String orfOutput = "";
            for(int q = 0; q< orfInput.length; q++)
            {
                char tempOrf = orfInput[q];
                if (tempOrf == '*')
                {
                    if (orfOutput.length() >= 21)
                    {
                        System.out.println("ORF FINDER OUTPUT: " + orfOutput);
                    }
                    orfOutput = "";
                }
                else
                {
                    orfOutput = orfOutput + (String.valueOf(tempOrf));
                }
            }
            System.out.println("ORF FINDER OUTPUT: " + orfOutput);
            System.out.println("------------------------------------------");


        }
        catch (Exception e)
        {e.printStackTrace();}

    }

}