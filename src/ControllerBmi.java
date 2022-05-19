
//represented the controller by mvc model,
// contain the listeners for all objets in the project

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerBmi {
    ViewBmi view;
    BmiCalculationsPanel bmiCalculationsPanel;


    public ControllerBmi(){
        view=new ViewBmi();

        //body structure listener
        ButtonListener listener = new ButtonListener();
        view.bodyStructure.getSmall().addActionListener(listener);
        view.bodyStructure.getMedium().addActionListener(listener);
        view.bodyStructure.getLarge().addActionListener(listener);

        //add height slider listener
        view.userHeightSlider.getHeightSlider().addChangeListener(e -> {

            int currentHeight = view.userHeightSlider.getHeightSlider().getValue();
            if (currentHeight!= Model.HEIGHT_SLIDER_MINIMUM_VALUE){
                view.userHeightSlider.getHeightLabel().setText("chosen height " + currentHeight);
                view.userHeightSlider.getHeightLabel().setForeground(Color.yellow);
            }

        });


      //add submit listener
     view.submit.addActionListener(e -> {
         setSubmitButtonOnClicked();
     });
        //add clear listener
     view.clear.addActionListener(e -> {
         setClearButtonOnClicked();
     });




    }
    //  Represents the listener for all body structure radio buttons
    private class ButtonListener implements ActionListener {

        //  Sets the slimness value depending on which radio
        //  button was pressed.
        public void actionPerformed(ActionEvent event) {
            Object source = event.getSource();
            if (source==view.bodyStructure.getSmall()) {
                view.bodyStructure.setSlimness(Model.SMALL_SLIMNESS);
            }else if (source==view.bodyStructure.getMedium()){
                view.bodyStructure.setSlimness(Model.MEDIUM_SLIMNESS);
            }else {
                view.bodyStructure.setSlimness(Model.LARGE_SLIMNESS);
            }


        }
    }

    //set up submit button
    private void setSubmitButtonOnClicked(){
        //create and add bmi calculate panel to weight panel for comparison
        bmiCalculationsPanel=new BmiCalculationsPanel(view.personData,view.userHeightSlider,view.bodyStructure);
        view.userHeightSlider.getUserWeightPanel().add(bmiCalculationsPanel);

        //repaint the weight panel with the new values
        view.userHeightSlider.getUserWeightPanel().revalidate();
        view.userHeightSlider.getUserWeightPanel().repaint();

        view.submit.setEnabled(false);
        view.clear.setEnabled(true);


    }

    //set up clear button
    private void setClearButtonOnClicked(){
        view.personData.getFirstNamePanel().getEnterFirstName().setText(null);
        view.personData.getLastNamePanel().getEnterLastName().setText(null);
        view.personData.getAgePanel().getEnterAge().setText(null);
        view.personData.getGenderPanel().getButtonGroup().clearSelection();

        view.userHeightSlider.getUserWeightPanel().getEnterUserWeight().setText(null);
        view.userHeightSlider.getHeightSlider().setValue(Model.HEIGHT_SLIDER_MINIMUM_VALUE);
        view.userHeightSlider.getHeightLabel().setText("height: ");
        view.bodyStructure.getButtonGroup().clearSelection();
        //reset the slimness to 0 when clear is pressed
        view.bodyStructure.setSlimness(0);

       bmiCalculationsPanel.setVisible(false);
       bmiCalculationsPanel.getIdealWeight().setVisible(false);


        view.submit.setEnabled(true);
        view.clear.setEnabled(false);
    }








}
