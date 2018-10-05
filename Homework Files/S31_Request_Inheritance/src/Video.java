public class Video {
    private String URL;
    private String videoTitle;
    private String videoCreator;
    /***
     * Variable counter will count how many time this class is called.
     */
    private static int counter;

    public Video(String tempURL, String tempVideoTitle, String tempName)
    {
        URL = tempURL;
        videoTitle = tempVideoTitle;
        videoCreator = tempName;
        counter++;
    }

    public String getVideoURL()
    {return URL;}

    /***
     * Get method for this classes count variable.
     * @return the counter
     */
    public static int returnCount()
    {return counter;}

    /***
     * toString method that is overrided, to print the Video title and video creator.
     * @return
     */
    @Override
    public String toString()
    {
        return "Video: " + videoTitle + "\nCreated By: " + videoCreator;
    }
}




//Video(this.getRandURL(), this.getRandVideoTitle(), this.getRandName());
//    }
