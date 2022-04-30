import java.text.DecimalFormat;
import java.util.Scanner;

public class Cal {

    public static void main(String[] args) {
        Scanner keyboard  = new  Scanner (System.in);

        int feet, inches, totalHeightInInches = 0;
        double totalBMI ,weight ;
        final int BMI_CONSTANT_VALUE=703;

        System.out.println("what is your weight?");
         weight = keyboard.nextInt();

        System.out.println("what is your height?");
        System.out.println("Feet:");
        feet = keyboard.nextInt();

        System.out.println("inches:");
        inches =  keyboard.nextInt();

        totalBMI = (weight * BMI_CONSTANT_VALUE) / (Math.pow(totalHeightInInches, 2));

        DecimalFormat fmt = new DecimalFormat("0.##");
        System.out.println("your current BMI is: " + fmt.format(totalBMI));



    }
}