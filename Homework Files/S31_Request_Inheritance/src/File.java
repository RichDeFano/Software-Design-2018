
public class File{
    /***
     * Variable filePath is the randomly generated file path
     */
    private String filePath;
    /***
     * Variable fileType is the extension on the end of the file (ex: .txt)
     */
    private String fileType;
    /***
     * Variable counter will count how many time this class is called.
     */
    private static int counter;

    /***
     * Constructor File will set the file path and file type variables.
     * @param tempFilePath randomly generated file path
     * @param tempFileType randomly generated file type
     */
    public File(String tempFilePath, String tempFileType)
    {
        filePath = tempFilePath;
        fileType = tempFileType;
        counter++;
    }

    /***
     * Get method for the Files path
     * @return the file path
     */
    public String getFilePath()
    {return filePath;}

    /***
     * Get method for this classes count variable.
     * @return the counter
     */
    public static int returnCount()
    {return counter;}

    /***
     * toString method that is overrided, to print the file path and file type.
     * @return
     */
    @Override
    public String toString()
    {
        return "File Path: " + filePath + "\nFile Type: " + fileType;
    }
}




//(this.getRandFilePath(), this.getRandFileType());
//    }

