import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BodyStructure extends JPanel {

    private JLabel bodyStructureTitle;
    private JRadioButton small, medium, large;
    private ButtonGroup buttonGroup;
    private double slimness;

    //Constructor: sets up panel with bodyStructure label and some radio buttons.
    public BodyStructure() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(Color.PINK);
        setPreferredSize(new Dimension(Constants.BODY_STRUCTURE_PANEL_WIDTH, Constants.BODY_STRUCTURE_PANEL_HEIGHT));

        bodyStructureTitle = new JLabel("body structure:");
        bodyStructureTitle.setFont(new Font("Lucida Fax", Font.BOLD, 24));

        small = new JRadioButton("Small");
        small.setBackground(Color.PINK);
        small.setFont(new Font("Lucida Fax",Font.BOLD,20));

        medium = new JRadioButton("Medium");
        medium.setBackground(Color.PINK);
        medium.setFont(new Font("Lucida Fax",Font.BOLD,30));

        large = new JRadioButton("Large");
        large.setBackground(Color.PINK);
        large.setFont(new Font("Lucida Fax",Font.BOLD,50));

        this.buttonGroup = new ButtonGroup();
        buttonGroup.add(small);
        buttonGroup.add(medium);
        buttonGroup.add(large);

        //add listener
        ButtonListener listener = new ButtonListener();
        small.addActionListener(listener);
        medium.addActionListener(listener);
        large.addActionListener(listener);

        add(Box.createRigidArea(new Dimension(170, 170)));
        add(bodyStructureTitle);
        add(Box.createRigidArea(new Dimension(100, 20)));
        add(small);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(medium);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(large);


    }

    //getters and setters

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

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public void setButtonGroup(ButtonGroup buttonGroup) {
        this.buttonGroup = buttonGroup;
    }

    //  Represents the listener for all radio buttons
    private class ButtonListener implements ActionListener {

        //  Sets the slimness value depending on which radio
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



