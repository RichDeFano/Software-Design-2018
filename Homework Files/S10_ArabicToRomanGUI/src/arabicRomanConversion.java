import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.ListIterator;

/***
 * @author Rich DeFano
 * Class Name: arabicRomanConversion
 * Class Description: this class will handle all of the backend math and searching to switch between the two number bases.
 */
public class arabicRomanConversion {
    /***
     * Variable arabicToRoman is a static TreeMap containing the arabic number as a key, and the roman letter associated
     * with each key as its value.
     */
    private final static TreeMap<Integer, String> arabicToRoman = new TreeMap<>();
    /***
     * Variable romanToArabic is a static Treemap containing the roman letter as a key, and the arabic number associated
     * with each key as its value.
     */
    private final static TreeMap<String, Integer> romanToArabic = new TreeMap<>();
    /***
     * Variable arabicNumber is the user inputted integer of the arabic number they wish to convert.
     */
    private int arabicNumber;
    /***
     * Variable romanNumber is the user inputted string of the roman number they wish to convert.
     */
    private String romanNumber;

    /***
     * Constructor arabicRomanConversion will build the TreeMap arabicToRoman, as well as set the private variable for
     * the arabicNumber to the integer that the user inputted.
     * @param aNumb is the user inputted integer that will be assigned to the object for its arabicNumber.
     */
    public arabicRomanConversion(int aNumb) {
        setArabicNumber(aNumb);
        arabicToRoman.put(1000, "M");
        arabicToRoman.put(900, "CM");
        arabicToRoman.put(500, "D");
        arabicToRoman.put(400, "CD");
        arabicToRoman.put(100, "C");
        arabicToRoman.put(90, "XC");
        arabicToRoman.put(50, "L");
        arabicToRoman.put(40, "XL");
        arabicToRoman.put(10, "X");
        arabicToRoman.put(9, "IX");
        arabicToRoman.put(5, "V");
        arabicToRoman.put(4, "IV");
        arabicToRoman.put(1, "I");
    }

    /***
     * Constructor arabicRomanConversion will build the TreeMap romanToArabic, as well as set the private variable for
     * the romanNumber to the string that the user inputted.
     * @param rNumb is the user inputted string that will be assinged to the object for its romanNumber.
     */
    public arabicRomanConversion(String rNumb) {
        setRomanNumber(rNumb);
        romanToArabic.put("M", 1000);
        romanToArabic.put("D", 500);
        romanToArabic.put("C", 100);
        romanToArabic.put("L", 50);
        romanToArabic.put("X", 10);
        romanToArabic.put("V", 5);
        romanToArabic.put("I", 1);
    }

    /***
     * Set method for private variable arabicNumber.
     * @param aNumb is the user inputted integer.
     */
    private void setArabicNumber(int aNumb) {
        arabicNumber = aNumb;
    }

    /***
     * Set method for private variable romanNumber.
     * @param rNumb is the user inputted string.
     */
    private void setRomanNumber(String rNumb) {
        romanNumber = rNumb;
    }

    /***
     * Get method for private variable arabicNumber
     * @return the integer value assigned to arabicNumber.
     */
    private int getArabicNumber() {
        return arabicNumber;
    }
    /***
     * Get method for private variable romanNumber
     * @return the string value assigned to romanNumber.
     */
    private String getRomanNumber() {
        return romanNumber;
    }


    /***
     * Function Name: toRoman
     * Function Job: Using itself and the recursive function toRomanHelper, this function will search for the lowest
     * match in the TreeMap arabicToRoman, and will recursively add them with all other values achieved through the helper.
     * it will then add them to a String to be outputted.
     * @return a final String representation of the user inputted arabic number, converted into a roman number.
     */
    public String toRoman() {
        int number = getArabicNumber();
        int l = arabicToRoman.floorKey(number);
        if (number == l) {
            return arabicToRoman.get(number);
        }
        return arabicToRoman.get(l) + toRomanHelper(number - l);
    }

    /***
     * Function Name: toRomanHelper
     * Function Job: A recursive helper to the function toRoman.
     * @param number is the changing variable that starts as your arabic number. As the recursive function loops, this
     *               number will slowly shrink by each matching key.
     * @return a String representation of the user inputted arabic number, converted into a roman number.
     */
    public String toRomanHelper(int number) {
        int l = arabicToRoman.floorKey(number);
        if (number == l) {
            return arabicToRoman.get(number);
        }
        return arabicToRoman.get(l) + toRomanHelper(number - l);
    }

    /***
     * Function Name: toArabic
     * Function Job: Converting the user inputted Roman number to an Arabic number. It will complete this task by checking
     * each character, and using the TreeMap romanToArabic to determine the matching value. After assigning each character
     * to a value, it checks the order. If any value is less than the one to the right of it, the two values are replaced with
     * the difference, solving cases like IV = 4, and not 1,5.
     * @return a final integer representation of the user inputted roman number, converted into an arabic number.
     */
    public int toArabic() {
        char[] eachChar = getRomanNumber().toCharArray();
        LinkedList<Integer> eachArabic = new LinkedList<>();
        for (int i = 0; i < eachChar.length; i++) {
            char atCharacter = eachChar[i];
            Iterator itr = romanToArabic.entrySet().iterator();
            while (itr.hasNext()) {
                    Map.Entry mapPair = (Map.Entry) itr.next();
                    String tempAt = (String)mapPair.getKey();
                    if (atCharacter == tempAt.charAt(0))
                    {
                        int tempValue = (Integer)mapPair.getValue();
                        eachArabic.add(tempValue);
                    }
            }

        }
        int totalSum = 0;
        for (int k = 0; k<eachArabic.size();k++)
        {
            int tempValue = eachArabic.get(k);
            int tempValueAhead = 0;
            if (k+1 < eachArabic.size())
            {
                tempValueAhead = eachArabic.get(k+1);
                if (tempValue < tempValueAhead)
                {
                    int replaceSubtraction = (tempValueAhead-tempValue);
                    int placeAt = eachArabic.indexOf(tempValueAhead);
                    eachArabic.add(placeAt,replaceSubtraction);
                    eachArabic.remove(eachArabic.indexOf(tempValueAhead));
                    eachArabic.remove(eachArabic.indexOf(tempValue));
                }
            }
        }
        while (!eachArabic.isEmpty())
        {
            totalSum = totalSum + eachArabic.remove();
        }
        return totalSum;

    }

}









