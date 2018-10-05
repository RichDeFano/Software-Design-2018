import java.util.UUID;


public class PostEncryptedPaymentRequest extends PostPaymentRequest{
    /***
     * Variable encryptScheme will contain the name of the type of encryption used.
     */
    private String encryptionScheme;
    /***
     * Variable counter will count how many time this class is called.
     */
    private static int counter;

    /***
     * Constructor PostEncryptedPaymentRequest will assign variables inherited from PostPaymentRequest, as well as its own.
     * @param uuid a randomly generated UUID.
     * @param userIP a randomly generated IP.
     * @param tempPayment a randomly generated Payment.
     * @param tempEncryptionScheme a randomly generated Encryption Scheme.
     */
    public PostEncryptedPaymentRequest(UUID uuid, String userIP, Payment tempPayment, String tempEncryptionScheme)
    {
        super(uuid,userIP,tempPayment);
        encryptionScheme = tempEncryptionScheme;
        counter++;
    }

    /***
     * Get method for this classes count variable.
     * @return the counter
     */
    public static int returnCount()
    {return counter;}

    /***
     * toString method that is overrided, to print PstPaymentRequest data as well as the encryption scheme.
     * @return
     */
    @Override
    public String toString()
    {
        return super.toString() + "\n This form was encrypted using: " + encryptionScheme;
    }
}
//(data.getRandUUID(), data.getRandIP(), data.getRandPayment(), data.getRandEncryptionScheme()));