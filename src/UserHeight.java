import javax.swing.*;
import java.awt.*;

public class UserHeight extends JPanel{
    private JLabel heightLabel;
    private JSlider heightSlider;
    private UserWeight userWeightPanel;

    //Constructor: set up a panel with height label and slider for user input
    public UserHeight(){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(Model.USER_HEIGHT_PANEL_WIDTH, Model.USER_HEIGHT_PANEL_HEIGHT));
        userWeightPanel =new UserWeight();

        heightLabel =new JLabel("Height: ");
        heightLabel.setFont(new Font("Monospaced",Font.BOLD,24));
        heightLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        heightSlider = new JSlider(JSlider.VERTICAL,Model.HEIGHT_SLIDER_MINIMUM_VALUE,Model.HEIGHT_SLIDER_MAXIMUM_VALUE,165);
        heightSlider.setMajorTickSpacing(10);
        heightSlider.setMinorTickSpacing(1);
        heightSlider.setPaintTicks(true);
        heightSlider.setPaintLabels(true);
        heightSlider.setFont(new Font("Monospaced",Font.BOLD,24));
        heightSlider.setBackground(Color.white);
        heightSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        heightSlider.setValue(Model.HEIGHT_SLIDER_MINIMUM_VALUE);
        heightSlider.setPreferredSize(new Dimension(Model.SLIDER_WIDTH, Model.SLIDER_HEIGHT ));



        add(Box.createRigidArea(new Dimension(0, 50)));
        add(heightLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(heightSlider);
        add(Box.createRigidArea(new Dimension(100, 50)));
        add(userWeightPanel);
    }

    //getters and setters
    public JLabel getHeightLabel() {
        return heightLabel;
    }

    public void setHeightLabel(JLabel heightLabel) {
        this.heightLabel = heightLabel;
    }

    public JSlider getHeightSlider() {
        return heightSlider;
    }

    public void setHeightSlider(JSlider heightSlider) {
        this.heightSlider = heightSlider;
    }
    public UserWeight getUserWeightPanel() {
        return userWeightPanel;
    }

    public void setUserWeightPanel(UserWeight userWeightPanel) {
        this.userWeightPanel = userWeightPanel;
    }




}