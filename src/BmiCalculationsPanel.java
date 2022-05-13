import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BmiCalculationsPanel extends JPanel {
    private JLabel bmiResult;
    private JLabel bmiStatus;
    private JLabel idealWeight;

    //Constructor: sets up panel with labels of the result of user bmi.
    public BmiCalculationsPanel(PersonData personData,UserHeight userHeightSlider,BodyStructure bodyStructure){

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(Constants.BMI_CALCULATE_PANEL_WIDTH,Constants.BMI_CALCULATE_PANEL_HEIGHT));

        bmiResult=new JLabel();
        bmiResult.setForeground(Color.BLUE);
        bmiResult.setFont(new Font("Ink Free",Font.BOLD,24));

        idealWeight=new JLabel();
        idealWeight.setForeground(Color.MAGENTA);
        idealWeight.setFont(new Font("Ink Free",Font.BOLD,24));

        bmiStatus=new JLabel();
        bmiStatus.setForeground(Color.RED);
        bmiStatus.setFont(new Font("Ink Free",Font.BOLD,24));

        double finalBmi=calculateBmiResult(userHeightSlider);
        JTextField userAgeTextFiled=personData.getAgePanel().getEnterAge();
        double idealWeightForUser=calculateIdealWeight(userHeightSlider.getHeightSlider().getValue(),personData.getAgePanel().getEnterAge(),bodyStructure.getSlimness());

        if (checkIfInputValid(idealWeightForUser,finalBmi,userHeightSlider,userAgeTextFiled)){
            //set 3 digit after decimal point
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(3);

            bmiResult.setText("your bmi is: " +df.format(finalBmi));
            bmiStatus.setText("you are: "+setBmiStatusLabel(finalBmi));
            bmiStatus.setAlignmentX(Component.LEFT_ALIGNMENT);
            idealWeight.setText("the ideal weight for you is: " + df.format(idealWeightForUser));

            idealWeight.setAlignmentX(Component.LEFT_ALIGNMENT);
            idealWeight.setAlignmentX(Component.LEFT_ALIGNMENT);
        }


        add(Box.createRigidArea(new Dimension(0, 10)));
        add(idealWeight);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(bmiResult);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(bmiStatus);
    }

   //set status label accordance to bmi result
    private String setBmiStatusLabel(double userBmi){
        String userWeightStatus;

        if (userBmi<Constants.ANOREXIC){
            userWeightStatus="Anorexic";
        }
        else if (userBmi>=Constants.ANOREXIC && userBmi<18.5){
            userWeightStatus="Underweight ";
        }
        else if(userBmi>=Constants.UNDER_WEIGHT && userBmi<Constants.NORMAL){
            userWeightStatus="Normal";
        }
        else if (userBmi>=Constants.NORMAL && userBmi<Constants.OVER_WEIGHT){
            userWeightStatus="Overweight";
        }
        else if(userBmi>=Constants.OBESE && userBmi<Constants.EXTRA_OBESE){
            userWeightStatus="Obese";
        }
        else {
            userWeightStatus="Extreme Obese";
        }


        return userWeightStatus;
    }

    //return ideal weight result calculation
    private double calculateIdealWeight(double userHeight,JTextField userAge,double slimness){
        double idealWeight=0;
        if (!isValidInput(userAge)){
            idealWeight= (userHeight-100+(Double.parseDouble(userAge.getText())/10))*0.9*slimness;
        }

           return idealWeight;
    }

    //return bmi result calculation
    private double calculateBmiResult(UserHeight userHeightSlider){
        double realWeight,realHeight,bmi=0;
        JTextField enteredWeightText=userHeightSlider.getUserWeightPanel().getEnterUserWeight();
        if (!isValidInput(enteredWeightText)){
            realWeight=Double.parseDouble(enteredWeightText.getText());
            realHeight= userHeightSlider.getHeightSlider().getValue();

            //note: due to the fact that the user insert height in cmd we multiplied by 100 to get right bmi
            bmi=realWeight * Constants.CONVERSION_CENTIMETER_TO_METER * Constants.CONVERSION_CENTIMETER_TO_METER / (realHeight * realHeight);
        }

       return bmi;
    }
    //check if age or weight is empty or contain characters/special characters
    private boolean isValidInput(JTextField textField){
       boolean isValidInput=false;
       //check for special characters like *, !, etc
        Pattern special = Pattern.compile (Constants.INVALID_CHARACTERS);
        Matcher hasSpecial = special.matcher(textField.getText());

        if (textField.getText().isEmpty() || hasSpecial.find()){
           isValidInput=true;
        }
        for (char character:textField.getText().toCharArray()) {
            if (Character.isAlphabetic(character) ){
                isValidInput=true;
                break;
            }
        }

      return isValidInput;
    }
    //return false when input invalid and set new warning and instructions labels
    private boolean checkIfInputValid(double idealWeightForUser,double finalBmi,UserHeight userHeightSlider,JTextField userAge){
        //check if ideal or bmi is 0 in this case the user enter something wrong
        boolean valid=true;
        if (idealWeightForUser==0 || finalBmi==0) {
            valid=false;
            userHeightSlider.getUserWeightPanel().getEnterUserWeight().setText(null);
            userAge.setText(null);

            idealWeight.setVisible(false);
            bmiStatus.setVisible(false);
            bmiResult.setVisible(false);

            JLabel warningLabel = new JLabel("oh no, your input isn't valid!!");
            JLabel clearOrderLabel = new JLabel("please press clear to reset and try again");

            warningLabel.setForeground(Color.RED);
            warningLabel.setFont(new Font("Kristen ITC", Font.BOLD, 18));

            clearOrderLabel.setForeground(Color.RED);
            clearOrderLabel.setFont(new Font("Kristen ITC", Font.BOLD, 18));

            add(warningLabel);
            add(Box.createRigidArea(new Dimension(0, 10)));
            add(clearOrderLabel);
        }
      return valid;
    }


    //getters and setters
    public JLabel getBmiResult() {
        return bmiResult;
    }

    public void setBmiResult(JLabel bmiResult) {
        this.bmiResult = bmiResult;
    }

    public JLabel getIdealWeight() {
        return idealWeight;
    }

    public void setIdealWeight(JLabel idealWeight) {
        this.idealWeight = idealWeight;
    }

    public JLabel getBmiStatus() {
        return bmiStatus;
    }

    public void setBmiStatus(JLabel bmiStatus) {
        this.bmiStatus = bmiStatus;
    }
}
