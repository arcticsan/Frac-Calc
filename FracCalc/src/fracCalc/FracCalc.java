package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	System.out.print("Welcome to the Frac Calc\nPlease enter expression to evaluate or type \"quit\" to exit Frac Calc: ");
    	String fracString = userInput.next();
    	while (fracString.contentEquals("quit") != true) {
    		produceAnswer(fracString);
    		System.out.println("Please enter expression to evaluate or type \"quit\" to exit Frac Calc: ");
    		fracString = userInput.next();
    	}
    	System.out.println(produceAnswer(fracString));
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
        return fracStringArr[2];
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
    public static int[] convertToInt(String input) {
    	int[] fraction = new int[3];
    	int underscoreIndex = input.indexOf("_");
    	if (underscoreIndex != -1) {
    		fraction[0] = Integer.parseInt(input.substring(0, underscoreIndex));
    		underscoreIndex++;
    	}
    	else {
    		fraction[0] = 0;
    	}
    	int dashIndex = input.indexOf("/");
    	if (dashIndex == -1) {
    		
    	}
    	
    }
}
