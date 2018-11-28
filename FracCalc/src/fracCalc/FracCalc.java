package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	System.out.print("Welcome to the Frac Calc\nPlease enter expression to evaluate or type \"quit\" to exit Frac Calc: ");
    	String fracString = userInput.nextLine();
    	while (fracString.contentEquals("quit") == false) {
    		System.out.println(produceAnswer(fracString));
    		System.out.println("Please enter expression to evaluate or type \"quit\" to exit Frac Calc: ");
    		fracString = userInput.next();
    	}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String[] fracStringArr = input.split(" "); 
    	//System.out.println(Arrays.toString(fracStringArr));
        int[] alphaFracArr = convertToInt(fracStringArr[0]);
        int[] bravoFracArr = convertToInt(fracStringArr[2]);
        return ("whole:" + bravoFracArr[0] +" numerator:" + bravoFracArr[1] + " denominator:" + bravoFracArr[2]);
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
    public static int[] convertToInt(String input) {
    	int[] fraction = new int[3];
    	int underscoreIndex = input.indexOf("_");
    	int dashIndex = input.indexOf("/");
    	if (dashIndex == -1) { //No Fraction
    		fraction[1] = 0;
    		fraction[2] = 1;
    	}
    	else { //Has Fraction
    		fraction[1] = Integer.parseInt(input.substring((underscoreIndex + 1), dashIndex));
    		fraction[2] = Integer.parseInt(input.substring((dashIndex + 1), input.length()));
    	}
    	if (underscoreIndex > 0 && dashIndex > 0) { //Mixed Num
    		fraction[0] = Integer.parseInt(input.substring(0, underscoreIndex));
    	}
    	else if (underscoreIndex == -1 && dashIndex == -1) { //No Fraction Just Whole Number
    		fraction[0] = Integer.parseInt(input.substring(0, input.length()));
    	}
    	
    	else { //Just Fraction
    		fraction[0] = 0;
    	}
    	return fraction;
    	
    }
}
