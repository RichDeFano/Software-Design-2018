import java.util.UUID;

public class Request {
    /***
     * Variable counter will count how many time this class is called.
     */
    private static int counter;
    UUID uuid;

    public Request(UUID tempUuid)
    {
        setUUID(tempUuid);
        counter++;
    }

    private void setUUID(UUID tempUuid)
    {
        uuid = tempUuid;
    }
    private UUID getUUID()
    {return uuid;}
    /***
     * Get method for this classes count variable.
     * @return the counter
     */
    public static int returnCount()
    {return counter;}

    /***
     * toString method that is overrided, to print the UUID.
     * @return
     */
    @Override
    public String toString()
    {
        return super.toString() + "\nUUID = " + getUUID();}
    }

