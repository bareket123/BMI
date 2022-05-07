import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BodyStructure extends JPanel {
    private JLabel bodyStructureTitle;
    private JRadioButton small, medium, large;
    private double slimness;


    public BodyStructure() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        bodyStructureTitle = new JLabel("body structure:");
        bodyStructureTitle.setFont(new Font("Ariel", Font.BOLD, 24));
        small = new JRadioButton("Small");
        small.setBackground(Color.PINK);
        small.setFont(new Font("David",Font.BOLD,20));
        medium = new JRadioButton("Medium");
        medium.setBackground(Color.PINK);
        medium.setFont(new Font("David",Font.BOLD,30));
        large = new JRadioButton("Large");
        large.setBackground(Color.PINK);
        large.setFont(new Font("David",Font.BOLD,50));
        ButtonGroup group = new ButtonGroup();
        add(Box.createRigidArea(new Dimension(0, 30)));
        group.add(small);
        add(Box.createRigidArea(new Dimension(0, 100)));
        group.add(medium);
        add(Box.createRigidArea(new Dimension(0, 100)));
        group.add(large);

        QuoteListener listener = new QuoteListener();
        small.addActionListener(listener);
        medium.addActionListener(listener);
        large.addActionListener(listener);

        add(Box.createRigidArea(new Dimension(300, 30)));
        add(bodyStructureTitle);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(small);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(medium);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(large);

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(Constants.BODY_STRUCTURE_PANEL_WIDTH, Constants.BODY_STRUCTURE_PANEL_HEIGHT));
    }

    public JLabel getBodyStructureTitle() {
        return bodyStructureTitle;
    }

    public void setBodyStructureTitle(JLabel bodyStructureTitle) {
        this.bodyStructureTitle = bodyStructureTitle;
    }

    public JRadioButton getSmall() {
        return small;
    }

    public void setSmall(JRadioButton small) {
        this.small = small;
    }

    public JRadioButton getMedium() {
        return medium;
    }

    public void setMedium(JRadioButton medium) {
        this.medium = medium;
    }

    public JRadioButton getLarge() {
        return large;
    }


    public void setLarge(JRadioButton large) {
        this.large = large;
    }

    public double getSlimness() {
        return slimness;
    }

    public void setSlimness(double slimness) {
        this.slimness = slimness;
    }

    //  Represents the listener for all radio buttons
    private class QuoteListener implements ActionListener {

        //  Sets the text of the label depending on which radio
        //  button was pressed.
        public void actionPerformed(ActionEvent event) {
            Object source = event.getSource();
            if (source==small) {
                slimness=Constants.SMALL_SLIMNESS;
            }else if (source==medium){
                slimness=Constants.MEDIUM_SLIMNESS;
            }else {
                slimness=Constants.LARGE_SLIMNESS;
            }


        }
    }

}



