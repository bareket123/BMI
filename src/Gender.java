import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Gender extends JPanel {
    private JCheckBox female, male;
    private JLabel genderLabel;

    public Gender () {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        female = new JCheckBox ("female");
        female.setFont(new Font("Ariel",Font.PLAIN,24));
        male = new JCheckBox ("male");
        male.setFont(new Font("Ariel",Font.PLAIN,24));
        genderLabel=new JLabel("Gender: ");
        genderLabel.setFont(new Font("Ariel",Font.BOLD,24));

        genderLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        ButtonListener listener = new ButtonListener();
        female.addItemListener (listener);
        male.addItemListener (listener);
        this.add(genderLabel);
        this.add (female);
        this.add (male);
        this.setPreferredSize (new Dimension(Constants.GENDER_PANEL_WIDTH, Constants.GENDER_PANEL_HEIGHT));
        this.setBackground(Color.MAGENTA);

    }

    public JCheckBox getFemale() {
        return female;
    }

    public void setFemale(JCheckBox female) {
        this.female = female;
    }

    public JCheckBox getMale() {
        return male;
    }

    public void setMale(JCheckBox male) {
        this.male = male;
    }

    public JLabel getGenderLabel() {
        return genderLabel;
    }

    public void setGenderLabel(JLabel genderLabel) {
        this.genderLabel = genderLabel;
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




