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
        this.setPreferredSize(new Dimension(Model.BMI_CALCULATE_PANEL_WIDTH, Model.BMI_CALCULATE_PANEL_HEIGHT));

        bmiResult=new JLabel();
        bmiResult.setForeground(Color.BLUE);
        bmiResult.setFont(new Font("Ink Free",Font.BOLD,24));

        idealWeight=new JLabel();
        idealWeight.setForeground(Color.MAGENTA);
        idealWeight.setFont(new Font("Ink Free",Font.BOLD,24));

        bmiStatus=new JLabel();
        bmiStatus.setForeground(Color.RED);
        bmiStatus.setFont(new Font("Ink Free",Font.BOLD,24));

        //true if names are empty, if so, won't display bmi calculations. for checkIfInputValid function
        boolean isNameEmpty=isNameEmpty(personData.getFirstNamePanel().getEnterFirstName(), personData.getLastNamePanel().getEnterLastName());
        //true if button is pressed as expected.for checkIfInputValid function
        boolean isGenderButtonPressed=isGenderButtonPressed(personData.getGenderPanel());

        JTextField userAgeTextFiled=personData.getAgePanel().getEnterAge();
        double finalBmi=calculateBmiResult(userHeightSlider);
        double idealWeightForUser=calculateIdealWeight(userHeightSlider.getHeightSlider().getValue(),userAgeTextFiled,bodyStructure.getSlimness());

        if (checkIfInputValid(idealWeightForUser,finalBmi,isNameEmpty,isGenderButtonPressed,bodyStructure.getSlimness())){
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

        if (userBmi< Model.ANOREXIC){
            userWeightStatus="Anorexic";
        }
        else if (userBmi>= Model.ANOREXIC && userBmi<18.5){
            userWeightStatus="Underweight ";
        }
        else if(userBmi>= Model.UNDER_WEIGHT && userBmi< Model.NORMAL){
            userWeightStatus="Normal";
        }
        else if (userBmi>= Model.NORMAL && userBmi< Model.OVER_WEIGHT){
            userWeightStatus="Overweight";
        }
        else if(userBmi>= Model.OBESE && userBmi< Model.EXTRA_OBESE){
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
        if (isValidInput(userAge)){
            idealWeight= (userHeight-100+(Double.parseDouble(userAge.getText())/10))*0.9*slimness;
        }

           return idealWeight;
    }

    //return bmi result calculation
    private double calculateBmiResult(UserHeight userHeightSlider){
        double realWeight,realHeight,bmi=0;
        JTextField enteredWeightText=userHeightSlider.getUserWeightPanel().getEnterUserWeight();
        if (isValidInput(enteredWeightText)){
            realWeight=Double.parseDouble(enteredWeightText.getText());
            realHeight= userHeightSlider.getHeightSlider().getValue();

            //note: due to the fact that the user insert height in cmd we multiplied by 100 to get right bmi
            bmi= Model.CONVERSION_CENTIMETER_TO_METER * Model.CONVERSION_CENTIMETER_TO_METER*realWeight / (realHeight * realHeight);
        }

       return bmi;
    }
    //check if textFiled is empty or contain letters/special characters
    private boolean isValidInput(JTextField textField){
       boolean isValidInput=true;
       //check for special characters like *, !, etc
        Pattern special = Pattern.compile (Model.INVALID_CHARACTERS);
        Matcher hasSpecialCharacter = special.matcher(textField.getText());

        if (textField.getText().isEmpty() || hasSpecialCharacter.find()){
           isValidInput=false;
        }
        for (char character:textField.getText().toCharArray()) {
            if (Character.isAlphabetic(character) ){
                isValidInput=false;
                break;
            }
        }

      return isValidInput;
    }

    //return false when input invalid and set new warning and instructions labels
    private boolean checkIfInputValid(double idealWeight,double finalBmi,boolean isNameEmpty,boolean isGenderButtonPressed, double slimness){
        boolean valid=true;

        //check if ideal or bmi is 0 in this case the user enter something wrong
        if (idealWeight==0 || finalBmi==0 || isNameEmpty || !isGenderButtonPressed || slimness==0) {
            valid=false;

            this.idealWeight.setVisible(false);
            bmiStatus.setVisible(false);
            bmiResult.setVisible(false);

            JLabel warningLabel = new JLabel("oh no, your input isn't valid!!");
            JLabel reminderLabel =new JLabel("REMEMBER all form should be filled");
            JLabel clearOrderLabel = new JLabel("please press clear to reset and try again");

            warningLabel.setForeground(Color.RED);
            warningLabel.setFont(new Font("Kristen ITC", Font.BOLD, 18));

            clearOrderLabel.setForeground(Color.RED);
            clearOrderLabel.setFont(new Font("Kristen ITC", Font.BOLD, 18));

            reminderLabel.setFont(new Font("Kristen ITC", Font.BOLD, 18));
            reminderLabel.setForeground(Color.RED);

            add(Box.createRigidArea(new Dimension(0, 20)));
            add(warningLabel);
            add(Box.createRigidArea(new Dimension(0, 10)));
            add(clearOrderLabel);
            add(Box.createRigidArea(new Dimension(0, 5)));
            add(reminderLabel);
        }
      return valid;
    }
    //check if first or last name is empty
    private boolean isNameEmpty(JTextField firstNameText, JTextField lastNameText){
        boolean isEmpty=false;
        if (firstNameText.getText().isEmpty() || lastNameText.getText().isEmpty()){
            isEmpty=true;
        }

        return isEmpty;
    }
    //check if button is pressed
    private boolean isGenderButtonPressed(Gender gender){
        boolean pressed=true;

        if (gender.getButtonGroup().getSelection()==null){
            pressed=false;
        }
        return pressed;
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
