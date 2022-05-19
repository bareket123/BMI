import javax.swing.*;
import java.awt.*;

public class AgePanel extends JPanel {

    private JLabel ageLabel;
    private JTextField enterAge;

//Constructor: sep up a panel with age label and text filed for user input
    public AgePanel(){
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setPreferredSize(new Dimension(Model.AGE_PANEL_WIDTH, Model.AGE_PANEL_HEIGHT));
        this.setBackground(Color.PINK);

        ageLabel = new JLabel("Age: ");
        ageLabel.setFont(new Font("Lucida Fax",Font.BOLD,24));
        ageLabel.setBackground(Color.PINK);

        enterAge=new JTextField(Model.TEXT_FILED_COLUMNS);
        enterAge.setMaximumSize(new Dimension(Model.TEXT_FILED_WIDTH/4, Model.TEXT_FILED_HEIGHT));
        //set text filed font the same as label font
        enterAge.setFont(ageLabel.getFont().deriveFont(Font.PLAIN, 18f));

       add(ageLabel);
       add(enterAge);


    }

    //getters and setters

    public JLabel getAgeLabel() {
        return ageLabel;
    }

    public void setAgeLabel(JLabel ageLabel) {
        this.ageLabel = ageLabel;
    }

    public JTextField getEnterAge() {
        return enterAge;
    }

    public void setEnterAge(JTextField enterAge) {
        this.enterAge = enterAge;
    }
}
