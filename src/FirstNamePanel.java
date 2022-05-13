import javax.swing.*;
import java.awt.*;

public class FirstNamePanel extends JPanel {

    private JLabel firstName;
    private JTextField enterFirstName;

    //Constructor: set up a panel with first name label and text filed for user input
    public FirstNamePanel(){
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setPreferredSize(new Dimension(Constants.NAME_PANEL_WIDTH,Constants.NAME_PANEL_HEIGHT));
        this.setBackground(Color.PINK);
        firstName = new JLabel("First name:");
        firstName.setBackground(Color.PINK);
        firstName.setFont(new Font("Lucida Fax",Font.BOLD,24));
        enterFirstName = new JTextField(Constants.TEXT_FILED_COLUMNS);
        enterFirstName.setMaximumSize(new Dimension(Constants.TEXT_FILED_WIDTH,Constants.TEXT_FILED_HEIGHT));
        //Set text filed font same as label
        enterFirstName.setFont(firstName.getFont().deriveFont(Font.PLAIN, 25f));

        this.add(firstName);
        add(Box.createRigidArea(new Dimension(30, 5)));
        this.add(enterFirstName);

    }

    //getters and setters
    public JLabel getFirstName() {
        return firstName;
    }

    public void setFirstName(JLabel firstName) {
        this.firstName = firstName;
    }

    public JTextField getEnterFirstName() {
        return enterFirstName;
    }

    public void setEnterFirstName(JTextField enterFirstName) {
        this.enterFirstName = enterFirstName;
    }
}
