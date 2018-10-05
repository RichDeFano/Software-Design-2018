// Fig. 12.9: TextFieldFrame.java
// JTextFields and JPasswordFields.

import javax.swing.*;
import java.awt.*;                  //AWT used instead of swing as the knowledge gained of Event Handling from fig 12_09_10 was based in AWT.
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/***
 * @author Rich DeFano
 * Class Name: arabicTextFields
 * Class Description: Implimentation of JFrame and JTextFields to provide the user with a GUI to enter and see their
 * conversions.
 * @see JFrame
 */
public class arabicTextFields extends JFrame {
    /***
     * Variable textField1 is the text field where the user can input an Arabic number.
     */
    private final JTextField textField1;
    /***
     * Variable textField2 is the text field where the user will see their newly converted Roman number.
     */
    private final JTextField textField2;
    /***
     * Variable textField3 is the text field where the user can input a Roman number.
     */
    private final JTextField textField3;
    /***
     * Variable textField4 is the text field where the user will see their newly converted Arabic number.
     */
    private final JTextField textField4;


    /***
     * Constructor Name: arabicTextFields
     * Constructor Job: Creates the inital text fields and fills them with information useful to the user in order to see
     * where they need to input the conversions.
     */
    public arabicTextFields() {
        super("Converting between Roman and Arabic number systems.");
        setLayout(new FlowLayout());

        textField1 = new JTextField("Enter Arabic Number");
        add(textField1); // add textField1 to JFrame

        textField2 = new JTextField("*Arabic to Roman*");
        textField2.setEditable(false); // disable editing
        add(textField2); // add textField2 to JFrame

        textField3 = new JTextField("Enter Roman Number");
        add(textField3); // add textField3 to JFrame

        textField4 = new JTextField("*Roman to Arabic*");
        textField4.setEditable(false); //disable editing
        add (textField4); // add textField4 to JFrame



        TextFieldHandler handler = new TextFieldHandler();
        textField1.addActionListener(handler);
        textField2.addActionListener(handler);
        textField3.addActionListener(handler);
        textField4.addActionListener(handler);
    }

    /***
     * Class Name: TextFieldHandler
     * Class Job: A private class that will allow the text fields to act on the user pressing enter. This will also produce
     * Error messages if the user inputted values would provide for invalid conversions, such as digits or non roman letters.
     * @see ActionListener
     */
    private class TextFieldHandler implements ActionListener {
        /***
         * Function Name: actionPerformed
         * Function Job: As the user presses enter while typing in a text field, this will check for any errors in their submission.
         * if there are no formatting errors, the function will then use the arabicRomanConversions to convert from one number style
         * to the other.
         * @param event User inputted enter key.
         */
        @Override
        public void actionPerformed(ActionEvent event) {
            String string = "";
            // user pressed Enter in JTextField textField1
            if (event.getSource() == textField1)
            {

                String arToRoString = textField1.getText();
                if (arToRoString.matches("[0-9]+"))
                {
                    int arToRo = Integer.parseInt(arToRoString);
                    arabicRomanConversion calcArabic = new arabicRomanConversion(arToRo);
                    String finalRoman = calcArabic.toRoman();
                    textField2.setText(finalRoman);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Incorrect input. Please make sure your arabic number only has integers 0-9 in it");
                }
            }

            if (event.getSource() == textField3)
            {
                String roToArString = textField3.getText();
                if (roToArString.matches("[MDCLXVImdclxvi]+")) {
                    roToArString = roToArString.toUpperCase();
                    textField3.setText(roToArString);
                    arabicRomanConversion finalRoman = new arabicRomanConversion(roToArString);
                    int finalArabicInt = finalRoman.toArabic();
                    String finalArabic = String.valueOf(finalArabicInt);
                    textField4.setText(finalArabic);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect input. Please make sure your roman number only has the characters M,D,C,L,X,V, and I.");
                }
            }

        }
    }
}

