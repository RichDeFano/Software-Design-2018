import java.util.UUID;

public class Payment {
    /***
     * Variable counter will count how many time this class is called.
     */
    private static int counter;
    /***
     * Variable PaymentSender will contain the name of the person sending the payment.
     */
    private String PaymentSender;
    /***
     * Variable PaymentReciever will contain the name of the person recieving the payment.
     */
    private String PaymentReciever;
    private int moneyAmount;

    /***
     * Constructor Payment will assign the initial object values.
     * @param tempName1 a randomly generated senders name.
     * @param tempInt a randomly generated money total.
     * @param tempName2 a randomly generated recievers name.
     */
    public Payment(String tempName1, int tempInt, String tempName2) {
        PaymentSender = tempName1;
        moneyAmount = tempInt;
        PaymentReciever = tempName2;
        counter++;
    }


    /***
     * Get method for this classes count variable.
     * @return the counter
     */
    public static int returnCount()
    {return counter;}

    /***
     * toString method that is overrided, to print the payment sender, payment reciever, and the amount paid.
     * @return
     */
    @Override
    public String toString() {
        return "\nPayment Data" + "\nPayment Sender: " + PaymentSender + "\nPayment Amount: " + moneyAmount + "\nPayment Reciever: " + PaymentReciever;
    }
}



//this.getRandName(), this.rand.nextInt(10000), this.getRandName());