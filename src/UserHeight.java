import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class UserHeight extends JPanel{
    private JLabel heightLabel;
    private JSlider heightSlider;
    private UserWeight userWeightPanel;

    public UserHeight(){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(Constants.USER_HEIGHT_PANEL_WIDTH,Constants.USER_HEIGHT_PANEL_HEIGHT));
        userWeightPanel =new UserWeight();

        heightLabel =new JLabel("Height: ");
        heightLabel.setFont(new Font("Monospaced",Font.BOLD,24));
        heightLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        heightSlider = new JSlider(JSlider.VERTICAL,140,190,165);
        heightSlider.setMajorTickSpacing(10);
        heightSlider.setMinorTickSpacing(1);
        heightSlider.setPaintTicks(true);
        heightSlider.setPaintLabels(true);
        heightSlider.setFont(new Font("Monospaced",Font.BOLD,24));
        heightSlider.setBackground(Color.white);
        heightSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        heightSlider.setValue(Constants.HEIGHT_SLIDER_START_VALUE);
        heightSlider.setPreferredSize(new Dimension(100,700 ));

        SliderListener sliderListener=new SliderListener();
        heightSlider.addChangeListener(sliderListener);


        add(Box.createRigidArea(new Dimension(0, 50)));
        add(heightLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(heightSlider);
        add(Box.createRigidArea(new Dimension(100, 50)));
        add(userWeightPanel);
    }

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

//  Represents the listener for all three sliders.
private class SliderListener implements ChangeListener {
        private int currentHeight;

    public void stateChanged(ChangeEvent event) {
        this.currentHeight = heightSlider.getValue();
        if (currentHeight!=Constants.USER_HEIGHT_PANEL_HEIGHT)
        heightLabel.setText("chosen height " + currentHeight);
        heightLabel.setForeground(Color.yellow);

    }

}


}