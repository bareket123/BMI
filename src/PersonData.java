import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonData extends JPanel {

    private JLabel firstName, lastName, age;
    private JTextField enterFirstName,enterLastName,enterAge  ;


    public PersonData() {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        firstName = new JLabel("First name:");
        firstName.setFont(new Font("Ariel",Font.BOLD,24));
        enterFirstName = new JTextField(Constants.TEXT_FILED_COLUMNS);
        enterFirstName.setMaximumSize( enterFirstName.getPreferredSize());
        Font bigFont = enterFirstName.getFont().deriveFont(Font.PLAIN, 25f);
        enterFirstName.setFont(bigFont);
        lastName = new JLabel("Last name:");
        lastName.setFont(new Font("Ariel",Font.BOLD,24));
        enterLastName =new JTextField(Constants.TEXT_FILED_COLUMNS);
        enterLastName.setMaximumSize(enterLastName.getPreferredSize());
        enterLastName.setFont(bigFont);
        age = new JLabel("Age: ");
        age.setFont(new Font("Ariel",Font.BOLD,24));
        enterAge=new JTextField(Constants.TEXT_FILED_COLUMNS);
        enterAge.setMaximumSize(enterAge.getPreferredSize());
        enterAge.setFont(bigFont);


        add(Box.createRigidArea(new Dimension(0, 200)));
        add(firstName);
        add(enterFirstName);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(lastName);
        add(enterLastName);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(age);
        add(enterAge);
        add(Box.createRigidArea(new Dimension(20, 100)));
        setPreferredSize(new Dimension(Constants.PERSON_DATA_PANEL_WIDTH,Constants.PERSON_DATA_PANEL_HEIGHT));
        setBackground(Color.PINK);

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


    }


