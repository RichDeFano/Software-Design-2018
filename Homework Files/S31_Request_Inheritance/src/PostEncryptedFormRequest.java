import java.util.UUID;


public class PostEncryptedFormRequest extends PostFormRequest{
    /***
     * Variable encryptScheme will contain the name of the type of encryption used.
     */
    private String encryptScheme;
    /***
     * Variable counter will count how many time this class is called.
     */
    private static int counter;

    /***
     * Constructor PostEncryptedFormRequest will assign variables to a PostFormRequest, as well as its own.
     * @param tempUuid a randomly generated UUID.
     * @param tempUserIP a randomly generated IP.
     * @param tempForm a randomly generated Form.
     * @param tempEncryptScheme a randomly generated Encryption Scheme.
     */
    public PostEncryptedFormRequest(UUID tempUuid, String tempUserIP, Form tempForm, String tempEncryptScheme)
    {
        super(tempUuid,tempUserIP,tempForm);
        encryptScheme = tempEncryptScheme;
        counter++;
    }

    /***
     * Get method for this classes count variable.
     * @return the counter
     */
    public static int returnCount()
    {return counter;}

    /***
     * toString method that is overrided, to print PostFormRequest data as well as the encryption scheme.
     * @return
     */
    @Override
    public String toString()
    {
        return super.toString() + "\nThis form was encrypted using: " + encryptScheme;
    }

}
//(data.getRandUUID(), data.getRandIP(), data.getRandForm(), data.getRandEncryptionScheme()));

