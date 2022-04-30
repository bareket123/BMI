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
        this.setPreferredSize (new Dimension(50, 50));
        this.setBackground(Color.PINK);

        /*
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        female = new JCheckBox ("female");
        male = new JCheckBox ("male");
        ButtonListener listener = new ButtonListener();
        female.addActionListener (listener);
        male.addActionListener (listener);
        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize (new Dimension(30,40));
        buttonPanel.setBackground (Color.pink);
        buttonPanel.add (female);
        buttonPanel.add (male);
        this.setPreferredSize (new Dimension(200, 80));
        setBackground (Color.PINK);
        add (buttonPanel);

         */
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
    /*
    //  Represents a listener for both buttons.
    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == female){
                male.setEnabled(false);
            }else {
                female.setEnabled(false);
            }


    }

     */
}




