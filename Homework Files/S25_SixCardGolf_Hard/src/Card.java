
public class Card {
    private int cardNumber;
    private char cardFace;
    private CardSuite cardSuite;
    
    public Card(int numb,char face,CardSuite cS)
    {
        cardNumber = numb;
        cardFace = face;
        cardSuite = cS;
    }
    
    private String getCardSuite()
    {
        String tempCS = cardSuite.name();
        char firstLetter = tempCS.charAt(0);
    return (String.valueOf(firstLetter));
    }
    
    private String getCardNumber()
    {
        String tempNumbToString = String.valueOf(cardNumber);
        return tempNumbToString;
    }
    
    private String getCardFace()
    {
        String tempFaceToString = String.valueOf(cardFace);
        return tempFaceToString;
    }
   
    @Override
    public String toString()
    {
        if ((cardNumber > 10) || (cardFace != 'Z'))
        {
            return (getCardSuite() + getCardFace());
        }
        else
        {return (getCardSuite() + getCardNumber());}   
    }
}


