import javax.swing.*;
import java.awt.*;

public class FirstNamePanel extends JPanel {

    private JLabel firstName;
    private JTextField enterFirstName;

    public FirstNamePanel(){
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setPreferredSize(new Dimension(50,40));
        this.setBackground(Color.PINK);
        firstName = new JLabel("First name:");
        firstName.setBackground(Color.PINK);
        firstName.setFont(new Font("Lucida Fax",Font.BOLD,24));
        enterFirstName = new JTextField(Constants.TEXT_FILED_COLUMNS);
        enterFirstName.setMaximumSize(new Dimension(200,25));
        enterFirstName.setFont(firstName.getFont().deriveFont(Font.PLAIN, 25f));

        this.add(firstName);
        add(Box.createRigidArea(new Dimension(30, 5)));
        this.add(enterFirstName);

    }

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
