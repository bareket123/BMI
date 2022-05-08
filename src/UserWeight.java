import javax.swing.*;
import java.awt.*;

public class UserWeight extends JPanel {
    private JLabel userWeight;
    private JTextField enterUserWeight;

    public UserWeight(){
        this.setLayout(new FlowLayout());

        userWeight=new JLabel("please enter your weight: ");
        userWeight.setFont(new Font("Ariel",Font.PLAIN,30));
        userWeight.setBackground(Color.PINK);
        enterUserWeight = new JTextField(5);
        enterUserWeight.setMaximumSize( enterUserWeight.getPreferredSize());
        Font bigFont = enterUserWeight.getFont().deriveFont(Font.PLAIN, 25f);
        enterUserWeight.setFont(bigFont);
        this.setBackground(Color.PINK);
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
