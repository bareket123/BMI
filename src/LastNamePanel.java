import javax.swing.*;
import java.awt.*;

public class LastNamePanel extends JPanel {
    private JLabel lastName;
    private JTextField enterLastName;

   // Constructor: set up a panel with last name label and text filed for user input
    public LastNamePanel(){
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(Model.NAME_PANEL_WIDTH, Model.NAME_PANEL_HEIGHT));

        lastName = new JLabel("Last name:");
        lastName.setFont(new Font("Lucida Fax",Font.BOLD,24));
        enterLastName =new JTextField(Model.TEXT_FILED_COLUMNS);
        enterLastName.setMaximumSize(new Dimension(Model.TEXT_FILED_WIDTH, Model.TEXT_FILED_HEIGHT));
        //set text filed font the same as label font
        enterLastName.setFont(lastName.getFont().deriveFont(Font.PLAIN, 25f));

        this.add(lastName);
        add(Box.createRigidArea(new Dimension(30, 0)));
        this.add(enterLastName);


    }
    //getters and setters

    public JLabel getLastName() {
        return lastName;
    }

    public void setLastName(JLabel lastName) {
        this.lastName = lastName;
    }

    public JTextField getEnterLastName() {
        return enterLastName;
    }

    public void setEnterLastName(JTextField enterLastName) {
        this.enterLastName = enterLastName;
    }
}
