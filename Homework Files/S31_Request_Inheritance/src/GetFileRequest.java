import java.util.UUID;


public class GetFileRequest extends GetRequest{
    /***
     * Variable thisFile is the file assigned to this object.
     */
    private File thisFile;
    /***
     * Variable counter will count how many time this class is called.
     */
    private static int counter;

    /***
     * Constructor GetFileRequest will set the UUID, and File.
     * @param tempUuid randomly generated UUID
     * @param tempFile randomly generated File.
     */
    public GetFileRequest(UUID tempUuid, File tempFile)
    {
        super(tempUuid,tempFile.getFilePath());
        thisFile = tempFile;
        counter++;
    }

    /***
     * Get method for this classes count variable.
     * @return the counter
     */
    public static int returnCount()
    {return counter;}

    /***
     * toString method that is overrided, to print the GetRequest information and the File information.
     * @return
     */
    @Override
    public String toString()
    {
        return super.toString() + "\n" + thisFile;
    }

}

//(data.getRandUUID(), data.getRandFile()));