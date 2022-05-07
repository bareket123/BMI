import javax.swing.*;
import java.awt.*;

public class UserWeight extends JPanel {
    private JLabel userWeight;
    private JTextField enterUserWeight;

    public UserWeight(){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        userWeight=new JLabel("your weight is: ");
        userWeight.setFont(new Font("Ariel",Font.PLAIN,30));
        userWeight.setBackground(Color.PINK);
        enterUserWeight = new JTextField(Constants.TEXT_FILED_COLUMNS);
        enterUserWeight.setMaximumSize( enterUserWeight.getPreferredSize());
        this.setBackground(Color.RED);
        this.setPreferredSize(new Dimension(Constants.USER_WEIGHT_PANEL_WIDTH,Constants.USER_WEIGHT_PANEL_HEIGHT));
        add(userWeight);
        add(enterUserWeight);

    }

    public JLabel getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(JLabel userWeight) {
        this.userWeight = userWeight;
    }

    public JTextField getEnterUserWeight() {
        return enterUserWeight;
    }

    public void setEnterUserWeight(JTextField enterUserWeight) {
        this.enterUserWeight = enterUserWeight;
    }
}
