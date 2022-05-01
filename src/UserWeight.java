import javax.swing.*;
import java.awt.*;

public class UserWeight extends JPanel {
    private JLabel userWeight;
    private JTextField enterUserWeight;

    public UserWeight(){

        userWeight=new JLabel("your weight is: ");
        userWeight.setBackground(Color.PINK);
        enterUserWeight=new JTextField(5);
        this.setBackground(Color.PINK);
        add(userWeight);
        add(enterUserWeight);

    }

}
