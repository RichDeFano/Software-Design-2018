/***
 * enum Codon will set 3 letter names, and one letter names, to groups of 3 letter combinations of DNA.
 */
public enum Codon {
    UUU("Phe", 'F'),
    UUC("Phe", 'F'),
    UUA("Leu", 'L'),
    UUG("Leu", 'L'),

    UCU("Ser", 'S'),
    UCC("Ser", 'S'),
    UCA("Ser", 'S'),
    UCG("Ser", 'S'),

    CUU("Leu", 'L'),
    CUC("Leu", 'L'),
    CUA("Leu", 'L'),
    CUG("Leu",'L'),

    CCU("Pro", 'P'),
    CCC("Pro", 'P'),
    CCA("Pro", 'P'),
    CCG("Pro", 'P'),

    AUU("Ile", 'I'),
    AUC("Ile", 'I'),
    AUA("Ile", 'I'),
    AUG("Met", 'M'),

    ACU("Thr", 'T'),
    ACC("Thr", 'T'),
    ACA("Thr", 'T'),
    ACG("Thr", 'T'),

    GUU("Val", 'V'),
    GUC("Val", 'V'),
    GUA("Val", 'V'),
    GUG("Val", 'V'),

    GCU("Ala", 'A'),
    GCC("Ala", 'A'),
    GCA("Ala", 'A'),
    GCG("Ala", 'A');

    /***
     * String variable threeLetterCode will hold the 3 letter code for the amino acid.
     */
    private String threeLetterCode;
    /***
     * Char variable oneLetterCode will hold the 1 letter code for the amino acid.
     */
    private char oneLetterCode;

    /***
     * Constructor Codon will create an object to hold both the one letter and three letter code
     * @param threeLetter the 3 letter code inputted
     * @param oneLetter the 1 letter code inputted.
     */
    private Codon(String threeLetter, char oneLetter)
    {
        threeLetterCode = threeLetter;
        oneLetterCode = oneLetter;
    }

    /***
     * Method getThreeLetterCode will return an amino acids 3 letter code, assigned above.
     * @return the three letter code.
     */
    public String getThreeLetterCode(){
        return threeLetterCode;
    }

    /***
     * Method getOneLetterCode will return an amino acids 1 letter code, assigned above.
     * @return the one letter code.
     */
    public char getOneLetterCode(){
        return oneLetterCode;
    }

    /***
     * Method getCodon returns a codon object with the assigned string from the enum data set.
     * @param codon inputs the 3 letter data string to be converted to its codon name.
     * @return codon returns the codon and its letter codes
     */
    public static Codon getCodon(String codon)
    {
        codon = codon.toUpperCase();
        codon = codon.replace('T', 'U');
        return valueOf(codon);
    }

}