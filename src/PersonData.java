import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonData extends JPanel {

    private JLabel firstName, lastName, age;
    private JTextField enterFirstName,enterLastName,enterAge  ;

//  Constructor: Sets up the main GUI components.

    public PersonData() {
        this.setLayout(null);
        firstName = new JLabel("First name:");
        firstName.setBounds (10,0,500,50);
        enterFirstName = new JTextField();
        enterFirstName.setBounds(80 ,20, 100,20);
        lastName = new JLabel("Last name:");
        lastName.setBounds(10,35,500,50);
        enterLastName =new JTextField(5);
        enterLastName.setBounds(80 ,50, 100,20);
        age = new JLabel("Age: ");
        age.setBounds(10,65,500,50);
        enterAge=new JTextField(5);
        enterAge.setBounds(80 ,80, 100,20);

        // e.addActionListener(new TempListener());
        add(firstName);
        add(enterFirstName);
        add(lastName);
        add(enterLastName);
        add(age);
        add(enterAge);
        setPreferredSize(new Dimension(800,700));
        setBackground(Color.PINK);
        /*




       // setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setBackground(Color.pink);

         */
    }
/*
    // Represents an action listener for the first and last name,age input field.
    private class DataListener implements ActionListener {
        // Performs conversion when the enter key is pressed in text field.
        public void actionPerformed(ActionEvent event) {
            int fahrenheitTemp, celsiusTemp;
            String text = enterFirstName.getText();
            fahrenheitTemp = Integer.parseInt (text);
            celsiusTemp = (fahrenheitTemp-32) * 5/9;
            resultLabel.setText (Integer.toString (celsiusTemp));

        }

 */
    }


