import javax.swing.*;

/***
 * @author Rich Defano
 * Class Name: arabicMain
 * Class Description: Creating the GUI interface that will allow the user to convert values.
 */
public class arabicMain {
    public static void main(String[] args) {

        arabicTextFields textFieldFrame = new arabicTextFields();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setSize(640, 480);
        textFieldFrame.setVisible(true);

    }
}
