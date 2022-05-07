import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonData extends JPanel {

    private JLabel firstName, lastName, age;
    private JTextField enterFirstName,enterLastName,enterAge  ;
//  Constructor: Sets up the main GUI components.

    public PersonData() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        firstName = new JLabel("First name:");
        firstName.setFont(new Font("Ariel",Font.BOLD,24));
        enterFirstName = new JTextField(Constants.TEXT_FILED_COLUMNS);
        enterFirstName.setMaximumSize( enterFirstName.getPreferredSize());
        lastName = new JLabel("Last name:");
        lastName.setFont(new Font("Ariel",Font.BOLD,24));
        enterLastName =new JTextField(Constants.TEXT_FILED_COLUMNS);
        enterLastName.setMaximumSize(enterLastName.getPreferredSize());
        age = new JLabel("Age: ");
        age.setFont(new Font("Ariel",Font.BOLD,24));
        enterAge=new JTextField(Constants.TEXT_FILED_COLUMNS);
        enterAge.setMaximumSize(enterAge.getPreferredSize());

        add(Box.createRigidArea(new Dimension(0, 300)));
        add(firstName);
        add(enterFirstName);
        add(lastName);
        add(enterLastName);
        add(age);
        add(enterAge);
        add(Box.createRigidArea(new Dimension(0, 20)));
        setPreferredSize(new Dimension(Constants.PERSON_DATA_PANEL_WIDTH,Constants.PERSON_DATA_PANEL_HEIGHT));
        setBackground(Color.GRAY);

    }

    public JLabel getFirstName() {
        return firstName;
    }

    public void setFirstName(JLabel firstName) {
        this.firstName = firstName;
    }

    public JLabel getLastName() {
        return lastName;
    }

    public void setLastName(JLabel lastName) {
        this.lastName = lastName;
    }

    public JLabel getAge() {
        return age;
    }

    public void setAge(JLabel age) {
        this.age = age;
    }

    public JTextField getEnterFirstName() {
        return enterFirstName;
    }

    public void setEnterFirstName(JTextField enterFirstName) {
        this.enterFirstName = enterFirstName;
    }

    public JTextField getEnterLastName() {
        return enterLastName;
    }

    public void setEnterLastName(JTextField enterLastName) {
        this.enterLastName = enterLastName;
    }

    public JTextField getEnterAge() {
        return enterAge;
    }

    public void setEnterAge(JTextField enterAge) {
        this.enterAge = enterAge;
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


