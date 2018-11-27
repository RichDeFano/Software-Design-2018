import java.security.SecureRandom;

public class reverseComplementor implements Runnable{
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
    public reverseComplementor(Buffer sLocation)
    {
        this.sharedLocation = sLocation;
    }

    /***
     * reverseComplementor will first flip the strand of data as to read it backwards, and then find the complement(A<->T,C<->G)
     * and pass those values on.
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
                gapFinderOutput = gapFinderOutput + (String.valueOf(charAt));
            }
            String gapFinderOutputOld = gapFinderOutput;
            char[] gReversed = gapFinderOutput.toCharArray();
            int size = gReversed.length;
            char[] gapFinderOutputReverse = new char[size];
            //System.out.println("Size = " + size);
            for (int j = 0; j<size;j++)
            {
                gapFinderOutputReverse[j] = gReversed[size-1-j];
            }

            String gapFinderOutputReversed = String.valueOf(gapFinderOutputReverse);
            //System.out.println("Reverse: " + gapFinderOutputReversed);
            String reverseComplementorOutput = "";
            char[] gFindOut = gapFinderOutputReversed.toCharArray();
            for (int i = 0; i<gFindOut.length; i++)
            {
                char letterAt = gFindOut[i];
                if (letterAt == 'A')
                {
                    reverseComplementorOutput = reverseComplementorOutput + 'T';
                }
                else if (letterAt == 'T')
                {
                    reverseComplementorOutput = reverseComplementorOutput + 'A';
                }
                else if (letterAt == 'C')
                {
                    reverseComplementorOutput = reverseComplementorOutput + 'G';
                }
                else if (letterAt == 'G')
                {
                    reverseComplementorOutput = reverseComplementorOutput + 'C';
                }
            }
            System.out.println("REVERSE COMPLEMENTOR OUTPUT, OLD STRING: " + gapFinderOutputOld);
            System.out.println("REVERSE COMPLEMENTOR OUTPUT, NEW STRING: " + reverseComplementorOutput);
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
