import java.util.HashMap;

public class Form {
    /***
     * Variable formFields contains favorite color, encryption scheme, and name.
     */
    private HashMap<String, String> formFields;
    /***
     * Variable counter will count how many time this class is called.
     */
    private static int counter;

    /***
     * Constructor Form will set the fields for this object.
     * @param tempFields sets the fields of color, encryption scheme, and name.
     */
    public Form(HashMap<String, String> tempFields)
    {
       formFields = tempFields;
        counter++;
    }


    /***
     * Get method for this classes count variable.
     * @return the counter
     */
    public static int returnCount()
    {return counter;}

    /***
     * toString method that is overrided, to print the form data.
     * @return
     */
    @Override
    public String toString()
    {
        return "Form Data: " + formFields;
    }
}

