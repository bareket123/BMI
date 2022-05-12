import javax.swing.*;
import java.awt.*;

public class LastNamePanel extends JPanel {
    private JLabel lastName;
    private JTextField enterLastName;

    public LastNamePanel(){
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        lastName = new JLabel("Last name:");
        lastName.setFont(new Font("Lucida Fax",Font.BOLD,24));
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(50,40));
        enterLastName =new JTextField(Constants.TEXT_FILED_COLUMNS);
        enterLastName.setMaximumSize(new Dimension(200,25));
        enterLastName.setFont(lastName.getFont().deriveFont(Font.PLAIN, 25f));

        this.add(lastName);
        add(Box.createRigidArea(new Dimension(30, 0)));
        this.add(enterLastName);


    }

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
