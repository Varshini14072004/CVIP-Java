import java.util.*;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        System.out.print("Enter your weight in kilograms: ");
        double weight = s.nextDouble();


        System.out.print("Enter your height in meters: ");
        double height = s.nextDouble();


        double bmi = calculateBMI(weight, height);


        String interpretation = interpretBMI(bmi);
        System.out.println("Your BMI is: " + bmi);
        System.out.println("Interpretation: " + interpretation);


    }


    private static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }


    private static String interpretBMI(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi >= 18.5 && bmi < 25) {
            return "Normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
