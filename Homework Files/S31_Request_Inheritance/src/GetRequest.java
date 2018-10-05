import java.util.UUID;


public class GetRequest extends Request{
    /***
     * Variable userURL is the randomly generated URL.
     */
    private String userURL;
    /***
     * Variable counter will count how many time this class is called.
     */
    private static int counter;

    /***
     * Constructor GetRequest will assign the initial variables.
     * @param tempUuid a randomly generated UUID.
     * @param tempURL a randomly generated URL.
     */
    public GetRequest(UUID tempUuid, String tempURL)
    {
        super(tempUuid);
        userURL = tempURL;
        counter++;
    }

    /***
     * Get method for this classes count variable.
     * @return the counter
     */
    public static int returnCount()
    {return counter;}

    /***
     * toString method that is overrided, to print the Request information and the URL.
     * @return
     */
    @Override
    public String toString()
    {
        return super.toString() + "\nUniversal Resource Locator (URL): " + userURL;
    }

}

//data.getRandUUID(), data.getRandURL()));