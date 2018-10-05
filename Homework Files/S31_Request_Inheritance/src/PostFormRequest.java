import java.util.UUID;


public class PostFormRequest extends PostRequest{
    /***
     * Variable userForm will hold the contents of the
     */
    private Form userForm;
    /***
     * Variable counter will count how many time this class is called.
     */
    private static int counter;

    public PostFormRequest(UUID tempUuid, String tempUserIP, Form tempForm)
    {
        super(tempUuid,tempUserIP);
        userForm = tempForm;
        counter++;
    }

    /***
     * Get method for this classes count variable.
     * @return the counter
     */
    public static int returnCount()
    {return counter;}

    /***
     * toString method that is overrided, to print PostRequest data as well as the form data.
     * @return
     */
    @Override
    public String toString()
    {
        return super.toString() + "\n" + userForm;
    }

}




///(data.getRandUUID(), data.getRandIP(), data.getRandForm()));