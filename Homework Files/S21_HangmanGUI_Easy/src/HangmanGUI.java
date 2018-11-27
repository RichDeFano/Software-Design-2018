
import javax.swing.*;

/***
 * Class HangmanGUI holds the main program to run, as well as a few variables to control before/after the game ends.
 */
public class HangmanGUI {

    /***
     * Char[] variable wordToGuess contains the word that the player must guess.
     */
    private static char[] wordToGuess;
    /***
     * Boolean variable gameHasntStarted contains the status of the game beginning
     */
    private static boolean gameHasntStarted = true;
    /***
     * boolean gameIsPlayed contains the status of the game finishing.
     */
    private static boolean gameIsPlayed = true;


    public static void main(String[] args) {
        GUIControl textFieldFrame = new GUIControl();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setSize(640, 480);
        textFieldFrame.setVisible(true);


        while(gameHasntStarted)
        {
            boolean chosenWord = textFieldFrame.ifChosen();
            wordToGuess = textFieldFrame.getWord();
            if (chosenWord == true)
            {
                System.out.println("DEBUG: Word to guess: " + String.valueOf(wordToGuess));
                gameHasntStarted = false;
                gameIsPlayed = true;
            }
        }


    }

}
