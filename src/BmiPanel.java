import javax.swing.*;
import java.awt.*;

public class BmiPanel extends JPanel {
    private JButton submit, clear;
    private JPanel buttonPanel;
    private BmiCalculationsPanel bmiCalculationsPanel;

    public BmiPanel() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Constants.BMI_PANEL_WIDTH, Constants.BMI_PANEL_HEIGHT));
       PersonData personData = new PersonData();
       Gender gender=new Gender();
       personData.add(gender);
        BodyStructure bodyStructure = new BodyStructure();
        UserHeight userHeightSlider = new UserHeight();
        UserWeight userWeight = new UserWeight();
        userHeightSlider.add(userWeight);
        submit = new JButton("Submit");
        submit.setFont(new Font("Ariel",Font.BOLD,20));
        submit.setBackground(Color.WHITE);
        submit.setPreferredSize(new Dimension(100,50));
        clear =new JButton("Clear");
        clear.setFont(new Font("Ariel",Font.BOLD,20));
        clear.setPreferredSize(new Dimension(100,50));
        clear.setBackground(Color.WHITE);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setPreferredSize (new Dimension(Constants.BUTTON_PANEL_WIDTH, Constants.BUTTON_PANEL_HEIGHT));
        buttonPanel.setBackground (Color.PINK);
        buttonPanel.add (submit);
        buttonPanel.add (clear);
        add (buttonPanel,BorderLayout.SOUTH);
        submit.addActionListener (e -> {
           this.bmiCalculationsPanel=new BmiCalculationsPanel(personData,userWeight,userHeightSlider,bodyStructure);
            userWeight.add(bmiCalculationsPanel);
            userWeight.revalidate();
            userWeight.repaint();
            submit.setEnabled(false);

        });
        clear.addActionListener (e -> {

          personData.getEnterFirstName().setText(null);
          personData.getEnterLastName().setText(null);
          personData.getEnterAge().setText(null);
          userWeight.getEnterUserWeight().setText(null);
          bodyStructure.getButtonGroup().clearSelection();
         if (gender.getFemale().isSelected()){
             gender.getFemale().setSelected(false);
             gender.getMale().setEnabled(true);

         } else {
             gender.getMale().setSelected(false);
             gender.getFemale().setEnabled(true);

         }
         userHeightSlider.getHeightSlider().setValue(Constants.HEIGHT_SLIDER_START_VALUE);
         submit.setEnabled(true);
         bmiCalculationsPanel.getBmiResult().setText(null);
         bmiCalculationsPanel.getIdealWeight().setText(null);
         bmiCalculationsPanel.getBmiStatus().setText(null);

        });



        add(personData,BorderLayout.WEST);
       add(userHeightSlider, BorderLayout.EAST);
       add(bodyStructure, BorderLayout.CENTER);

    }


}