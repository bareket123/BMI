import javax.swing.*;
import java.awt.*;

public class UserWeight extends JPanel {
    private JLabel userWeightLabel;
    private JTextField enterUserWeight;


    public UserWeight(){
        this.setLayout(new FlowLayout());
        this.setBackground(Color.pink);
        this.setPreferredSize(new Dimension(Constants.USER_WEIGHT_PANEL_WIDTH,Constants.USER_WEIGHT_PANEL_HEIGHT));

        userWeightLabel =new JLabel("your weight is: ");
        userWeightLabel.setFont(new Font("Lucida Fax",Font.BOLD,24));
        userWeightLabel.setAlignmentY(Component.TOP_ALIGNMENT);
        userWeightLabel.setBackground(Color.PINK);

        enterUserWeight = new JTextField(Constants.TEXT_FILED_COLUMNS);
        enterUserWeight.setMaximumSize(new Dimension(100,25));
        enterUserWeight.setAlignmentY(Component.TOP_ALIGNMENT);
        enterUserWeight.setFont(userWeightLabel.getFont().deriveFont(Font.PLAIN, 18f));

        add(userWeightLabel);
        add(enterUserWeight);

    }

    public JLabel getUserWeightLabel() {
        return userWeightLabel;
    }

    public void setUserWeightLabel(JLabel userWeightLabel) {
        this.userWeightLabel = userWeightLabel;
    }

    public JTextField getEnterUserWeight() {
        return enterUserWeight;
    }

    public void setEnterUserWeight(JTextField enterUserWeight) {
        this.enterUserWeight = enterUserWeight;
    }


}
