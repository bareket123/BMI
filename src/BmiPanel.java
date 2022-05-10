import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BmiPanel extends JPanel {
    private JLabel titleLabel;
    private JButton submit, clear;
    private JPanel buttonPanel;
    private PersonData personData;
    private Gender gender;
    private BodyStructure bodyStructure;
    private UserHeight userHeightSlider;
    private UserWeight userWeight;
    private BmiCalculationsPanel bmiCalculationsPanel;

    public BmiPanel() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Constants.BMI_PANEL_WIDTH, Constants.BMI_PANEL_HEIGHT));
        titleLabel=new JLabel("Bmi Calculator\nplease complete this form. Press the submit button when completed");
        titleLabel.setFont(new Font("Ariel",Font.BOLD,26));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
         personData = new PersonData();
         gender=new Gender();
         personData.add(gender);
         bodyStructure = new BodyStructure();
         userHeightSlider = new UserHeight();
         userWeight = new UserWeight();
         userHeightSlider.add(userWeight);
       //defied submit and clear button
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

            SubmitAndClearListener listener =new SubmitAndClearListener();
            submit.addActionListener(listener);
            clear.addActionListener(listener);

            this.add(buttonPanel, BorderLayout.SOUTH);
            this.add(personData, BorderLayout.WEST);
            this.add(userHeightSlider, BorderLayout.EAST);
            this.add(bodyStructure, BorderLayout.CENTER);
            this.add(titleLabel, BorderLayout.NORTH);


    }
    private void setSubmitButtonOnClicked(){
        //create and add bmi calculate panel to weight panel for comparison
        this.bmiCalculationsPanel=new BmiCalculationsPanel(personData,userWeight,userHeightSlider,bodyStructure);
        userWeight.add(bmiCalculationsPanel);
        //repaint the weight panel with the new values
        userWeight.revalidate();
        userWeight.repaint();
       submit.setEnabled(false);
       clear.setEnabled(true);


    }
    private void setClearButtonOnClicked(){
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
        bmiCalculationsPanel.setVisible(false);
        bmiCalculationsPanel.getIdealWeight().setVisible(false);
        submit.setEnabled(true);
        clear.setEnabled(false);
    }


    private class SubmitAndClearListener implements ActionListener{


        @Override
        public void actionPerformed(ActionEvent e) {
            Object source=e.getSource();
            if (source==submit){
                setSubmitButtonOnClicked();

            }else if (source==clear){
                setClearButtonOnClicked();
                setSubmitButtonOnClicked();

            }

        }
    }

}
