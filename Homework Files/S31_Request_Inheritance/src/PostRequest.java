import java.util.UUID;


public class PostRequest extends Request{
    private String userIP;
    /***
     * Variable counter will count how many time this class is called.
     */
    private static int counter;

    public PostRequest(UUID tempUuid, String tempUserIP)
    {
        super(tempUuid);
        userIP = tempUserIP;
        counter++;
    }

    /***
     * Get method for this classes count variable.
     * @return the counter
     */
    public static int returnCount()
    {return counter;}

    /***
     * toString method that is overrided, to print the Request data as well as the IP address.
     * @return
     */
    @Override
    public String toString()
    {
        return super.toString() + "\nPost Request to server with an IP address of " + userIP;
    }

}
