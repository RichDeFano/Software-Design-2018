
import javax.swing.*;
import java.awt.*;                  //AWT used instead of swing as the knowledge gained of Event Handling from fig 12_09_10 was based in AWT.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Iterator;

/**
 * Class Name: GUIControl
 * Class Job: to create the GUI for the project and to hold some variables for internal calculations.
 * @author Rich Laptop
 */
public class GUIControl extends JFrame{
    /***
     * JTextFields textField1, and textField2 are 2 swing components for inputting text.
     */
    private final JTextField textField1;
    private final JTextField textField2;
    /***
     * JLabels label1, and label2, are two swing GUI components for text.
     */
    private JLabel label1;
    private JLabel label2;
    /***
     * Linked list of characters variable correctGuesses stores all of the correct letter choices.
     */
    private LinkedList<Character> correctGuesses = new LinkedList<>();
    /***
     * Linked list of characters variable incorrectGuesses stores all of the incorrect letter choices.
     */
    private LinkedList<Character> incorrectGuesses = new LinkedList<>();
    /***
     * Integer variable correctGuessNumber stores the amount of correct guesses.
     */
    private int correctGuessNumber = 0;
    /***
     * Integer variable incorrectGuessNumber stores the amount of incorrect guesses.
     */
    private int incorrectGuessNumber = 0;
    /***
     * Integer variable wordLength stores the words length in letters
     */
    private int wordLength = 0;
    /***
     * Boolean variable wordChosen is a temporary check variable
     */
    private boolean wordChosen;


    /***
     * Constructor GUIControl creates the various text fields and GUI and adds it to the main panel.
     */
    public GUIControl(){
        super("Welcome to the game of Hangman!");
        setLayout(new FlowLayout());
        wordChosen = false;
        textField1 = new JTextField("Enter the word to be guessed.");
        add(textField1);

        textField2 = new JTextField("Enter a Letter or Guess.");
        textField2.setEditable(false);
        add(textField2);

        TextFieldHandler handler2 = new TextFieldHandler();
        textField2.addActionListener(handler2);
        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);


        label1 = new JLabel("Number of guesses left: " + (6-incorrectGuessNumber),JLabel.LEFT);
        add(label1);
        label2 = new JLabel("Incorrect Guesses: " + incorrectGuessNumber,JLabel.LEFT);
        add(label2);
        drawingText wordBoxes = new drawingText();
        add(wordBoxes);
        wordBoxes.repaint();
    }

    /***
     * Function getWord returns a character array of the inputted word
     * @return a character array of the inputted word
     */
    public char[] getWord()
    {
        char[] tempArray = textField1.getText().toCharArray();
        return tempArray;
    }

    /***
     * checks to see if a word has been inputted by player one.
     * @return boolean variable wordChosen
     */
    public boolean ifChosen()
    {
        return wordChosen;
    }


    /***
     * Method calculations takes in a human guess, and a word that is being guessed. it will check it with the previous incorrect guesses and correct guesses and see which it belongs to.
     * @param humanGuess the humans inputted guess.
     * @param tempWTG the word that is trying to be guessed.
     */
    private void calculations(String humanGuess,String tempWTG)
    {
        Iterator checkIfGuessedWrong = incorrectGuesses.iterator();
        Iterator checkIfGuessedRight = correctGuesses.iterator();
        boolean haveGuessedWrong = false;
        boolean haveGuessedRight = false;
        while (checkIfGuessedRight.hasNext())
        {
            char charInList = (char)checkIfGuessedRight.next();
            if (humanGuess.contains(String.valueOf(charInList)))
            {
                haveGuessedRight = true;
            }
        }

        while (checkIfGuessedWrong.hasNext())
        {
            char charInList = (char)checkIfGuessedWrong.next();
            if (humanGuess.contains(String.valueOf(charInList)))
            {
                haveGuessedWrong = true;
            }
        }
        if ((haveGuessedRight == true) || (haveGuessedWrong == true))
        {
            JOptionPane.showMessageDialog(null,"You have already guessed this. please try a new letter!");
        }

        if ((haveGuessedRight == false) && (haveGuessedWrong == false))
        {
            int count = 0;
            for (int i = 0; i<tempWTG.length();i++)
            {
                if (tempWTG.charAt(i) == humanGuess.charAt(0))
                {
                    count++;
                }
            }

            if (count == 0)
            {
                char[] tempChar = humanGuess.toCharArray();
                char toAdd = tempChar[0];
                incorrectGuesses.add(toAdd);
                JOptionPane.showMessageDialog(null,"Incorrect guess, one time." + incorrectGuesses);
                incorrectGuessNumber++;
            }

            if (count == 1)
            {
                char[] tempChar = humanGuess.toCharArray();
                char toAdd = tempChar[0];
                correctGuesses.add(toAdd);
                JOptionPane.showMessageDialog(null,"Correct guess, one time."+ correctGuesses);
                correctGuessNumber++;
                System.out.println("Debug: CGN = " + correctGuessNumber);
            }
            else if (count > 1)
            {
                char[] tempChar = humanGuess.toCharArray();
                char toAdd = tempChar[0];
                correctGuesses.add(toAdd);
                JOptionPane.showMessageDialog(null,"Correct guess, " + count + " times."+ correctGuesses);
                correctGuessNumber = (correctGuessNumber + count);
                System.out.println("Debug: CGN = " + correctGuessNumber);
            }
        }
    }

    /***
     * GUI class containing commands for hitting the enter key, such as the user inputting a guess or the initial word being typed in.
     */
    private class TextFieldHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String string = "";
            if (event.getSource() == textField1)
            {
                String tempWTG = textField1.getText().toUpperCase();
                if (tempWTG.chars().allMatch(Character::isLetter))
                {
                    textField1.setText(tempWTG);
                    textField1.setEditable(false);
                    textField1.setVisible(false);
                    textField2.setEditable(true);
                    wordChosen = true;
                    wordLength = tempWTG.length();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect input. Please make sure your word only contains letters A-Z.");
                }
            }
            ////////////
            if (event.getSource() == textField2)
            {
                String humanGuess = textField2.getText().toUpperCase();
                String tempWTG = textField1.getText().toUpperCase();
                if (humanGuess.chars().allMatch(Character::isLetter))
                {
                    if (humanGuess.length() == 1)
                    {
                        calculations(humanGuess,tempWTG);
                        label1.setText("Number of guesses left: " + (6-incorrectGuessNumber));
                        label2.setText("Incorrect Guesses: " + incorrectGuessNumber);
                        repaint();
                        if (incorrectGuessNumber >= 6)
                        {
                            JOptionPane.showMessageDialog(null,"Too many incorrect guesses. You Lose!");
                        }

                        if (correctGuessNumber >= wordLength)
                        {
                            JOptionPane.showMessageDialog(null,"You guessed the word! You Win!");
                            System.out.println("DEBUG WIN");
                        }
                    }

                    else if ((humanGuess.length() > 1) && (humanGuess.length() < tempWTG.length()))
                    {
                        JOptionPane.showMessageDialog(null,"Incorrect input. Please make sure your words length is equal to the hidden word!");
                    }

                    else if (humanGuess.length() <= tempWTG.length())
                    {
                        if (humanGuess.equals(tempWTG))
                        {
                            JOptionPane.showMessageDialog(null,"Correct! You win!");
                            System.exit(0);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Incorrect guess.");
                            incorrectGuessNumber++;
                            label1.setText("Number of guesses left: " + (6-incorrectGuessNumber));
                            label2.setText("Incorrect Guesses: " + incorrectGuessNumber);
                            if (incorrectGuessNumber >= 6)
                            {
                                JOptionPane.showMessageDialog(null,"Too many incorrect guesses. You Lose!");
                            }

                            if (correctGuessNumber >= wordLength)
                            {
                                JOptionPane.showMessageDialog(null,"You guessed the word! You Win!");
                                System.exit(0);
                            }
                        }
                    }

                    else
                    {
                        JOptionPane.showMessageDialog(null,"Incorrect input. Please make sure your words length is equal!");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect input. Please make sure your word only contains letters A-Z.");
                }
            }
        }
    }

    /***
     * GUI class to control the drawing of the word, as well as _ _ _ where letters have not been guessed.
     */
    private class drawingText extends JPanel{
        drawingText()
        {
            //setBackground(Color.red);
            setPreferredSize(new Dimension(200,200));
        }

        @Override
        public void paint(Graphics g)
        {
            super.paint(g);
            if (wordChosen == true)
            {
                String guessingWord = textField1.getText();
                String blankSpace = "";
                for (int i = 0; i<guessingWord.length();i++)
                {
                    Iterator thruGuesses = correctGuesses.iterator();
                    boolean hidden = true;
                    while (thruGuesses.hasNext())
                    {
                        char nextChar = (char)thruGuesses.next();
                        if (guessingWord.charAt(i) == nextChar)
                        {
                            hidden = false;
                        }
                    }
                    if (hidden == false)
                    {
                        blankSpace = blankSpace + String.valueOf(guessingWord.charAt(i));
                    }
                    else
                    {
                        blankSpace = blankSpace + " _ ";
                    }
                }
                g.drawString(blankSpace,50,50);
            }
        }

        public void redraw()
        {
            repaint();
        }
    }

}