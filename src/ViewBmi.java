import javax.swing.*;
import java.awt.*;


public class ViewBmi extends JPanel {
     TitlePanel titlePanel;
     JButton submit, clear;
     JPanel buttonPanel;
     PersonData personData;
     BodyStructure bodyStructure;
     UserHeight userHeightSlider;

    //Constructor: set up the main panel which contains all the other panels ordered in border layout and submit and clear buttons.
    public ViewBmi() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Model.BMI_PANEL_WIDTH, Model.BMI_PANEL_HEIGHT-10));
         titlePanel=new TitlePanel();
         personData = new PersonData();
         bodyStructure = new BodyStructure();
         userHeightSlider = new UserHeight();

        submit = new JButton("Submit");
        submit.setFont(new Font("Ariel",Font.BOLD,20));
        submit.setBackground(Color.WHITE);
        submit.setPreferredSize(new Dimension(Model.BUTTON_WIDTH, Model.BUTTON_HEIGHT));
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);

        clear =new JButton("Clear");
        clear.setFont(new Font("Ariel",Font.BOLD,20));
        clear.setPreferredSize(new Dimension(Model.BUTTON_WIDTH, Model.BUTTON_HEIGHT));
        clear.setBackground(Color.WHITE);
        clear.setAlignmentX(Component.CENTER_ALIGNMENT);


        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setPreferredSize (new Dimension(Model.BUTTON_PANEL_WIDTH, Model.BUTTON_PANEL_HEIGHT));
        buttonPanel.setBackground (Color.WHITE);
        buttonPanel.add (submit);
        buttonPanel.add (clear);

        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
        add(personData, BorderLayout.WEST);
        add(userHeightSlider, BorderLayout.EAST);
        add(bodyStructure, BorderLayout.CENTER);


    }

}

