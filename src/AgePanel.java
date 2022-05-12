import javax.swing.*;
import java.awt.*;

public class AgePanel extends JPanel {

    private JLabel ageLabel;
    private JTextField enterAge;


    public AgePanel(){
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setPreferredSize(new Dimension(50,40));
        this.setBackground(Color.PINK);
        ageLabel = new JLabel("Age: ");
        ageLabel.setFont(new Font("Lucida Fax",Font.BOLD,24));
        ageLabel.setBackground(Color.PINK);
        enterAge=new JTextField(Constants.TEXT_FILED_COLUMNS);
        enterAge.setMaximumSize(new Dimension(50,25));
        enterAge.setFont(ageLabel.getFont().deriveFont(Font.PLAIN, 18f));



        this.add(ageLabel);
        this.add(enterAge);


    }

    public JLabel getAge() {
        return ageLabel;
    }

    public void setAge(JLabel age) {
        this.ageLabel = age;
    }

    public JTextField getEnterAge() {
        return enterAge;
    }

    public void setEnterAge(JTextField enterAge) {
        this.enterAge = enterAge;
    }



}
