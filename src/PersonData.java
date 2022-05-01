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
        //firstName.setFont(new Font("Ariel",Font.ITALIC,24));
        enterFirstName = new JTextField();
        enterFirstName.setBounds(80 ,20, 100,20);
        lastName = new JLabel("Last name:");
        lastName.setBounds(10,35,500,50);
        enterLastName =new JTextField(Constants.TEXT_FILED_COLUMNS);
        enterLastName.setBounds(80 ,50, 100,20);
        age = new JLabel("Age: ");
        age.setBounds(10,65,500,50);
        enterAge=new JTextField(Constants.TEXT_FILED_COLUMNS);
        enterAge.setBounds(80 ,80, 100,20);

        // e.addActionListener(new TempListener());
        add(firstName);
        add(enterFirstName);
        add(lastName);
        add(enterLastName);
        add(age);
        add(enterAge);
        setPreferredSize(new Dimension(Constants.PERSON_DATA_PANEL_WIDTH,Constants.PERSON_DATA_PANEL_HEIGHT));
        setBackground(Color.PINK);

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


