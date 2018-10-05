import java.util.UUID;


public class PostPaymentRequest extends PostRequest{
    private Payment payment;
    /***
     * Variable counter will count how many time this class is called.
     */
    private static int counter;

    public PostPaymentRequest(UUID uuid, String userIP, Payment tempPayment)
    {
        super(uuid,userIP);
        payment = tempPayment;
        counter++;
    }

    /***
     * Get method for this classes count variable.
     * @return the counter
     */
    public static int returnCount()
    {return counter;}

    /***
     * toString method that is overrided, to print PostRequest data as well as the payment data.
     * @return
     */
    @Override
    public String toString()
    {
        return super.toString() + payment.toString();
    }
}
