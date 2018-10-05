import java.util.UUID;


public class GetVideoRequest extends GetRequest{
    /***
     * Variable thisVideo will contain the data for the objects Video.
     */
    private Video thisVideo;
    /***
     * Variable counter will count how many time this class is called.
     */
    private static int counter;

    /***
     * Constructor GetVideoRequest will assign the objects initial variables.
     * @param tempUuid a randomly generated UUID.
     * @param tempVideo a randomly generated Video.
     */
    public GetVideoRequest(UUID tempUuid,Video tempVideo)
    {
        super(tempUuid,tempVideo.getVideoURL());
        thisVideo = tempVideo;
        counter++;
    }

    /***
     * Get method for this classes count variable.
     * @return the counter
     */
    public static int returnCount()
    {return counter;}

    /***
     * toString method that is overrided, to print GetRequest information and the video information.
     * @return
     */
    @Override
    public String toString()
    {
        return super.toString() + "\n" + thisVideo;
    }

}

//(data.getRandUUID(), data.getRandFile()));