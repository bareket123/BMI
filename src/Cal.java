import java.text.DecimalFormat;
import java.util.Scanner;

public class Cal {

    public static void main(String[] args) throws Exception {
        calculateBMI();
    }

    private static void calculateBMI() throws Exception {
        System.out.print("Please enter your weight in kg: ");
        Scanner s = new Scanner(System.in);
        float weight = s.nextFloat();
        System.out.print("Please enter your height in cm: ");
        float height = s.nextFloat();
        float bmi =weight/(height*height);
        System.out.println("Your BMI is: "+bmi);
        printBMICategory(bmi);

    }

    private static void printBMICategory(float bmi) {
        if (bmi < 15) {
            System.out.println("You are Anorexic");
        }
        else if (bmi < 18.5) {
            System.out.println("You are Underweight ");
        }
        else if (bmi < 24.9) {
            System.out.println("You are Normal ");
        }
        else if (bmi < 29.9) {
            System.out.println("You are Overweight ");
        }
        else if (bmi < 35) {
            System.out.println("You are Obese ");
        }
        else {
            System.out.println("You are Extreme Obese ");
        }

    }
}