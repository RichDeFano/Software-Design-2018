
import java.security.SecureRandom;

public class inputFilter implements Runnable{
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
    public inputFilter(Buffer sLocation)
    {
        this.sharedLocation = sLocation;
    }

    /***
     * controls the initial input, and creates the ArrayBlockingQueue with a test data set.
     * With larger data sets, the program would have to change to scan in the data and set it to the array.
     */
    public void run()
    {
        try
        {

            sharedLocation.blockingPut('A');
            sharedLocation.blockingPut('T');
            sharedLocation.blockingPut('A');
            sharedLocation.blockingPut('G');
            sharedLocation.blockingPut('A');
            sharedLocation.blockingPut(' ');
            sharedLocation.blockingPut('G');
            sharedLocation.blockingPut('T');
            sharedLocation.blockingPut('C');
            sharedLocation.blockingPut('A');
            sharedLocation.blockingPut('A');
            sharedLocation.blockingPut('N');

        }
        catch (Exception e)
        {e.printStackTrace();}

    }

}
