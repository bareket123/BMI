import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;


public class BmiCalculationsPanel extends JPanel {
    private JLabel bmiResult;
    private JLabel bmiStatus;
    private JLabel idealWeight;


    public BmiCalculationsPanel(PersonData personData,UserHeight userHeightSlider,BodyStructure bodyStructure){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.bmiResult=new JLabel();
        bmiResult.setForeground(Color.BLUE);
        bmiResult.setFont(new Font("Ink Free",Font.BOLD,24));
        this.idealWeight=new JLabel();
        idealWeight.setForeground(Color.MAGENTA);
        idealWeight.setFont(new Font("Ink Free",Font.BOLD,24));
        this.bmiStatus=new JLabel();
        bmiStatus.setForeground(Color.RED);
        bmiStatus.setFont(new Font("Ink Free",Font.BOLD,24));
        double finalBmi=calculateBmiResult(userHeightSlider);
        JTextField userAge=personData.getAgePanel().getEnterAge();
        double idealWeightForUser=calculateIdealWeight(userHeightSlider.getHeightSlider().getValue(),userAge,bodyStructure.getSlimness());
        if (idealWeightForUser==0 || finalBmi==0){
            userHeightSlider.getUserWeightPanel().getEnterUserWeight().setText(null);
            userAge.setText(null);
            idealWeight.setVisible(false);
            bmiStatus.setVisible(false);
            bmiResult.setVisible(false);
            JLabel warningLabel=new JLabel("oh no, you must enter letters instead numbers");
            JLabel clearOrderLabel=new JLabel("please press clear to reset and try again");
            warningLabel.setForeground(Color.RED);
            warningLabel.setFont(new Font("Kristen ITC",Font.BOLD,18));
            clearOrderLabel.setForeground(Color.RED);
            clearOrderLabel.setFont(new Font("Kristen ITC",Font.BOLD,18));
            add(warningLabel);
            add(Box.createRigidArea(new Dimension(0, 10)));
            add(clearOrderLabel);
        }
        DecimalFormat df = new DecimalFormat();
        //set 3 digit after decimal point
        df.setMaximumFractionDigits(3);
        bmiResult.setText("your bmi is: " +df.format(finalBmi));
        bmiStatus.setText("you are: "+setBmiStatusLabel(finalBmi));
        idealWeight.setText("the ideal weight for you is: " + df.format(idealWeightForUser));
        idealWeight.setAlignmentX(Component.LEFT_ALIGNMENT);


        //userHeightSlider.getUserWeightPanel().add(idealWeight);
        bmiStatus.setAlignmentX(Component.LEFT_ALIGNMENT);
        idealWeight.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setBackground(Color.PINK);
        this.setPreferredSize(new Dimension(400,400));

        add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(idealWeight);
        add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(bmiResult);
        add(Box.createRigidArea(new Dimension(0, 10)));
        this.add(bmiStatus);
    }


    private String setBmiStatusLabel(double userBmi){
        String userWeightStatus;
        if (userBmi<Constants.ANOREXIC){
            userWeightStatus="Anorexic";
        }
        else if (userBmi>=Constants.ANOREXIC && userBmi<18.5){
            userWeightStatus="Underweight ";
        }else if(userBmi>=Constants.UNDER_WEIGHT && userBmi<Constants.NORMAL){
            userWeightStatus="Normal";
        }else if (userBmi>=Constants.NORMAL && userBmi<Constants.OVER_WEIGHT){
            userWeightStatus="Overweight";
        }else if(userBmi>=Constants.OBESE && userBmi<Constants.EXTRA_OBESE){
            userWeightStatus="Obese";
        }else {
            userWeightStatus="Extreme Obese";
        }

           return userWeightStatus;
    }
    private double calculateIdealWeight(double userHeight,JTextField userAge,double slimness){
        double idealWeight=0;
        if (!isValidInput(userAge)){
            idealWeight= (userHeight-100+(Double.parseDouble(userAge.getText())/10))*0.9*slimness;
        }

           return idealWeight;


    }
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
    private boolean isValidInput(JTextField textField){
       boolean isValidInput=false;
       if (textField.getText().isEmpty()){
           isValidInput=true;
       }
        for (char character:textField.getText().toCharArray()) {
            if (Character.isAlphabetic(character)){
                isValidInput=true;
                break;
            }
        }
      return isValidInput;
    }



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
