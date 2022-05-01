import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Gender extends JPanel {
    private JCheckBox female, male;
    private JLabel genderLabel;

    public Gender () {
        //this.setLayout(new GridLayout());
        female = new JCheckBox ("female");
        male = new JCheckBox ("male");
        genderLabel=new JLabel("Gender: ");

        genderLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        ButtonListener listener = new ButtonListener();
        female.addItemListener (listener);
        male.addItemListener (listener);
        this.add(genderLabel);
        this.add (female);
        this.add (male);
        this.setPreferredSize (new Dimension(Constants.GENDER_PANEL_WIDTH, Constants.GENDER_PANEL_HEIGHT));
        this.setBackground(Color.PINK);
    }

    //  Represents the listener for both check boxes.
    private class ButtonListener implements ItemListener {

        //  Updates the style of the label font style.
        public void itemStateChanged (ItemEvent event) {
            if (male.isSelected()){
                female.setEnabled(false);
            }

           else if(female.isSelected()) {
               male.setEnabled(false);
            }
        }
    }
}




