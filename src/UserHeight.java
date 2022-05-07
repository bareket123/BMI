import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class UserHeight extends JPanel{
    private JLabel heightLabel;
    private JSlider heightSlider;

    public UserHeight(){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        heightSlider = new JSlider(JSlider.VERTICAL,140,190,165);
        heightLabel =new JLabel("Height: ");
        heightLabel.setFont(new Font("Ariel",Font.BOLD,24));
        heightLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);

        heightSlider.setMajorTickSpacing(10);
        heightSlider.setMinorTickSpacing(1);
        heightSlider.setPaintTicks(true);
        heightSlider.setPaintLabels(true);
        heightSlider.setFont(new Font("Ariel",Font.PLAIN,24));
        heightSlider.setBackground(Color.green);
        heightSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        heightSlider.setPreferredSize(new Dimension(30,400));

        this.setBackground(Color.YELLOW);
        this.setPreferredSize(new Dimension(Constants.USER_HEIGHT_PANEL_WIDTH,Constants.USER_HEIGHT_PANEL_HEIGHT));
        add(Box.createRigidArea(new Dimension(0, 300)));
        add(heightLabel);
        add(heightSlider);
        add(Box.createRigidArea(new Dimension(0, 100)));

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

    //  Represents the listener for all three sliders.
private class SliderListener implements ChangeListener {
        private int currentHeight;

    public void stateChanged(ChangeEvent event) {
        currentHeight = heightSlider.getValue();

    }
}
}