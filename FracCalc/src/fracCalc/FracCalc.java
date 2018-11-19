package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
        // TODO: Read the input from the user and call produceAnswer with an equation
    	Scanner userInput = new Scanner(System.in);
    	/*System.out.print("Would you like to initiate Frac Calc program? (Type \"yes\" or \"no\"):");
    	String contProgram = userInput.next().toLowerCase();
    	if (contProgram.contentEquals("yes") == true) System.out.println("Welcome to the Frac Calc");
    	while (contProgram.contentEquals("quit") != true) {
    		System.out.print("Please enter fractions: ");
    		String fracString = userInput.next();
    		produceAnswer(fracString);
    		System.out.println("\nDo you want to continue Frac Calc? (Type \"quit\" to end)");
    		contProgram = userInput.next();
    	}*/
    	String fracString = userInput.next();
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
    
}
