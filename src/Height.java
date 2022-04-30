import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Height  extends JPanel{
    private JLabel heightLabel;
    private JSlider heightSlider;

    public Height(){
        heightSlider = new JSlider(JSlider.VERTICAL, 0, 200,0);
        heightSlider.setMajorTickSpacing(50);
        heightSlider.setMinorTickSpacing(15);
        heightSlider.setPaintTicks(true);
        heightSlider.setPaintLabels(true);
        heightLabel =new JLabel("Height: ");
        heightLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(100,100));
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