import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class UserHeight extends JPanel{
    private JLabel heightLabel;
    private JSlider heightSlider;

    public UserHeight(){
        heightSlider = new JSlider(140, 190);
        heightSlider.setMajorTickSpacing(10);
        heightSlider.setMinorTickSpacing(4);
        heightSlider.setPaintTicks(true);
        heightSlider.setPaintLabels(true);
        heightLabel =new JLabel("Height: ");
        heightLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(Constants.USER_HEIGHT_PANEL_WIDTH,Constants.USER_HEIGHT_PANEL_HEIGHT));
        add(heightLabel);
        add(heightSlider);

    }




//  Represents the listener for all three sliders.
private class SliderListener implements ChangeListener {
        private int currentHeight;

    public void stateChanged(ChangeEvent event) {
        currentHeight = heightSlider.getValue();

    }
}
}