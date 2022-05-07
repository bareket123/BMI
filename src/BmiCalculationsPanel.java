import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.HashMap;

public class BmiCalculationsPanel extends JPanel {
    private JLabel bmiResult;
    private JLabel bmiStatus;
    private JLabel idealWeight;


    public BmiCalculationsPanel(PersonData personData , Gender gender,UserWeight userWeight,UserHeight userHeightSlider,BodyStructure bodyStructure){
        this.bmiResult=new JLabel();
        this.idealWeight=new JLabel();
        this.bmiStatus=new JLabel();
        double realWeight,realHeight;
        String text= userWeight.getEnterUserWeight().getText();
        realWeight=Double.parseDouble(text);
        realHeight= userHeightSlider.getHeightSlider().getValue();
        //note: due to the fact that the user insert height in cmd we multiplied by 100 to get right bmi
        double finalBmi= realWeight * Constants.CONVERSION_CENTIMETER_TO_METER * Constants.CONVERSION_CENTIMETER_TO_METER / (realHeight * realHeight);
       String userAge=personData.getEnterAge().getText();
       double idealWeightForUser=calculateIdealWeight(userHeightSlider.getHeightSlider().getValue(),Integer.parseInt(userAge),bodyStructure.getSlimness());
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(3);//set 3 digit after decimal point
        bmiResult.setText("your bmi is: " +df.format(finalBmi));
        bmiStatus.setText("you are: "+setBmiStatusLabel(finalBmi));
        idealWeight.setText("the ideal weight for you is: " + idealWeightForUser);
        idealWeight.setAlignmentX(Component.LEFT_ALIGNMENT);
        userWeight.add(idealWeight);
        bmiStatus.setAlignmentX(Component.LEFT_ALIGNMENT);
        idealWeight.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setBackground(Color.MAGENTA);
        this.setPreferredSize(new Dimension(50,50));

         this.add(bmiResult);
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
    private double calculateIdealWeight(double userHeight,double userAge,double slimness){
        return (userHeight-100+(userAge/10))*0.9*slimness;
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
}
