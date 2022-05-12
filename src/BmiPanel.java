import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BmiPanel extends JPanel {
    private TitlePanel titlePanel;
    private JButton submit, clear;
    private JPanel buttonPanel;
    private PersonData personData;
    private BodyStructure bodyStructure;
    private UserHeight userHeightSlider;
    private BmiCalculationsPanel bmiCalculationsPanel;

    public BmiPanel() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(Constants.BMI_PANEL_WIDTH, Constants.BMI_PANEL_HEIGHT-10));
         titlePanel=new TitlePanel();
         personData = new PersonData();
         bodyStructure = new BodyStructure();
         userHeightSlider = new UserHeight();



         //defied submit and clear button
        submit = new JButton("Submit");
        submit.setFont(new Font("Ariel",Font.BOLD,20));
        submit.setBackground(Color.WHITE);
        submit.setPreferredSize(new Dimension(100,30));
        submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        clear =new JButton("Clear");
        clear.setFont(new Font("Ariel",Font.BOLD,20));
        clear.setPreferredSize(new Dimension(100,30));
        clear.setBackground(Color.WHITE);
        clear.setAlignmentX(Component.CENTER_ALIGNMENT);
        SubmitAndClearListener listener =new SubmitAndClearListener();
        submit.addActionListener(listener);
        clear.addActionListener(listener);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setPreferredSize (new Dimension(Constants.BUTTON_PANEL_WIDTH, Constants.BUTTON_PANEL_HEIGHT));
        buttonPanel.setBackground (Color.WHITE);
        buttonPanel.add (submit);
        buttonPanel.add (clear);



            this.add(titlePanel, BorderLayout.NORTH);
            this.add(buttonPanel, BorderLayout.SOUTH);
            this.add(personData, BorderLayout.WEST);
            this.add(userHeightSlider, BorderLayout.EAST);
            this.add(bodyStructure, BorderLayout.CENTER);



    }
    private void setSubmitButtonOnClicked(){
        //create and add bmi calculate panel to weight panel for comparison
        this.bmiCalculationsPanel=new BmiCalculationsPanel(personData,userHeightSlider,bodyStructure);
        userHeightSlider.getUserWeightPanel().add(bmiCalculationsPanel);

        //repaint the weight panel with the new values
        userHeightSlider.getUserWeightPanel().revalidate();
        userHeightSlider.getUserWeightPanel().repaint();
        submit.setEnabled(false);
        clear.setEnabled(true);


    }
    private void setClearButtonOnClicked(){
        personData.getFirstNamePanel().getEnterFirstName().setText(null);
        personData.getLastNamePanel().getEnterLastName().setText(null);
        personData.getAgePanel().getEnterAge().setText(null);
        userHeightSlider.getUserWeightPanel().getEnterUserWeight().setText(null);
        userHeightSlider.getHeightSlider().setValue(Constants.HEIGHT_SLIDER_START_VALUE);
        userHeightSlider.getHeightLabel().setText("height: ");
        bodyStructure.getButtonGroup().clearSelection();
        personData.getGenderPanel().getButtonGroup().clearSelection();
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


            }

        }
    }

}
