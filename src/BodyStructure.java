import javafx.scene.control.RadioButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BodyStructure extends JPanel {
    private JLabel bodyStructureTitle;
    private JRadioButton small, medium, large;

    public BodyStructure() {
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        bodyStructureTitle = new JLabel("body structure:");
        bodyStructureTitle.setFont(new Font("Ariel", Font.PLAIN, 24));
        small = new JRadioButton("Small");
        small.setBackground(Color.PINK);
        small.setFont(new Font("David",Font.BOLD,20));
        medium = new JRadioButton("Medium");
        medium.setBackground(Color.PINK);
        medium.setFont(new Font("David",Font.BOLD,20));
        large = new JRadioButton("Large");
        large.setBackground(Color.PINK);
        large.setFont(new Font("David",Font.BOLD,20));
        ButtonGroup group = new ButtonGroup();
        group.add(small);
        group.add(medium);
        group.add(large);

        QuoteListener listener = new QuoteListener();
        small.addActionListener(listener);
        medium.addActionListener(listener);
        large.addActionListener(listener);

        add(bodyStructureTitle);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(small);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(medium);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(large);
        setBackground(Color.PINK);
        setPreferredSize(new Dimension(Constants.BODY_STRUCTURE_PANEL_WIDTH, Constants.BODY_STRUCTURE_PANEL_HEIGHT));
    }

    //  Represents the listener for all radio buttons
    private class QuoteListener implements ActionListener {

        //  Sets the text of the label depending on which radio
        //  button was pressed.
        public void actionPerformed(ActionEvent event) {

            Object source = event.getSource();

        }
    }
}



