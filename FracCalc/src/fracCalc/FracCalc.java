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
    		System.out.print("Please enter expression to evaluate or type \"quit\" to exit Frac Calc: ");
    		fracString = userInput.nextLine();
    	}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fractionArr string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fractionArr after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	String[] fracStringArr = input.split(" "); 
    	//System.out.println(Arrays.toString(fracStringArr));
        int[] alphaFrac = convertToInt(fracStringArr[0]);
        int[] bravoFrac = convertToInt(fracStringArr[2]);
        int[] answerArr = new int[2];
        if (fracStringArr[1].equals("*") == true) {
        	answerArr = multiply(alphaFrac,bravoFrac);
        }
        else if (fracStringArr[1].equals("/") == true) {
        	answerArr = divide(alphaFrac,bravoFrac);
        }
        else if (fracStringArr[1].equals("+") == true) {
        	//answerArr = multiply(alphaFrac,bravoFrac);
        }
        else if (fracStringArr[1].equals("-") == true) {
        	//answerArr = multiply(alphaFrac,bravoFrac);
        }
        return Arrays.toString(answerArr);
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
    public static int[] convertToInt(String input) {
    	int[] fractionArr = new int[3];
    	int underscoreIndex = input.indexOf("_");
    	int dashIndex = input.indexOf("/");
    	if (dashIndex == -1) { //No fractionArr
    		fractionArr[1] = 0;
    		fractionArr[2] = 1;
    	}
    	else { //Has fractionArr
    		fractionArr[1] = Integer.parseInt(input.substring((underscoreIndex + 1), dashIndex));
    		fractionArr[2] = Integer.parseInt(input.substring((dashIndex + 1), input.length()));
    	} 
    	//Following Conditionals to Set Whole Number
    	if (underscoreIndex > 0 && dashIndex > 0) { //Mixed Num
    		fractionArr[0] = Integer.parseInt(input.substring(0, underscoreIndex));
    	}
    	else if (underscoreIndex == -1 && dashIndex == -1) { //No fractionArr Just Whole Number
    		fractionArr[0] = Integer.parseInt(input.substring(0, input.length()));
    	}
    	
    	else { //Just fractionArr
    		fractionArr[0] = 0;
    	}
    	return toImproperFrac(fractionArr);
    }
    public static int[] toImproperFrac(int[] mixedFrac) {
    	int[] improperFrac = new int[2];
    	improperFrac[1] = mixedFrac[2];
    	boolean negative = false;
    	if (mixedFrac[0] < 0) {
    		mixedFrac[0] = mixedFrac[0] * -1;
    		negative = true;
    	}
    	improperFrac[0] = mixedFrac[0] * mixedFrac[2] + mixedFrac[1];
    	if (negative == true) {
    		improperFrac[0] = improperFrac[0] * -1;
    	}
    	return improperFrac;
    }
    public static int[] multiply(int[] alphaFrac, int[] bravoFrac) {
    	int[] productFrac = new int[2];
    	productFrac[0] = alphaFrac[0] * bravoFrac[0];
    	productFrac[1] = alphaFrac[1] * bravoFrac[1];
    	System.out.println("Product: " + Arrays.toString(productFrac));
    	return productFrac;
    }
    public static int[] divide(int[] alphaFrac, int[] bravoFrac) {
    	int[] quotientFrac = new int[2];
    	quotientFrac[0] = alphaFrac[0] * bravoFrac[1];
    	quotientFrac[1] = alphaFrac[1] * bravoFrac[0];
    	System.out.println("Quotient: " + Arrays.toString(quotientFrac));
    	return quotientFrac;
    }
    public static int[] subtract(int[] alphaFrac, int[] bravoFrac) {
    	int[] difference = new int[2];
    	if (alphaFrac[1] != bravoFrac[1]) {
    		int alphaDenom = alphaFrac[1];
        	int bravoDenom = bravoFrac[1];
    		alphaFrac[0] = alphaFrac[0] * bravoDenom;
    		alphaFrac[1] = alphaFrac[1] * bravoDenom;
    		bravoFrac[0] = bravoFrac[0] * alphaDenom;
    		bravoFrac[1] = bravoFrac[1] * alphaDenom;
    	}
    	difference[0] = alphaFrac[0] - bravoFrac[0];
    	difference[1] = bravoFrac[1];
    	return difference;
    }
    public static int gcf(int number1, int number2) {
		number1 = (int) (absValue(number1));
		number2 = (int) (absValue(number2));
		
		if (number1 == 0 || number2 == 0) {
			throw new IllegalArgumentException ("Sorry, there is no gcf for zero. Please enter a positive integer.");
		}
		int lownum = (int) (min((double) number1, (double) number2));
		int highnum = (int) (max(number1,number2));
		int factor = lownum;
		boolean factorable = (isDivisibleBy(highnum,factor));
		while (factorable == false) {
			factor--;
			factorable = ( isDivisibleBy(highnum, factor) && ( isDivisibleBy(lownum, factor)));
		}
		return (factor);
	}
  //returns the greatest number of three passed numbers
    public static double max(double number1, double number2) {
		if (number1 > number2) {
			return (number1);
		}
		else /*if (number1 < number2)*/ {
			return (number2);					
		}
	}
  	//returns the smaller number passed
  	public static double min(double number1, double number2) {
  		if (number1 < number2) {
  			return (number1);
  		}
  		else return (number2);
  	}
  //determines whether integer is evenly divisible by another
  	public static boolean isDivisibleBy(int number1, int number2) {
  		if (number2 == 0) {
  			throw new IllegalArgumentException ("Sorry, numbers cannot be divided by 0. Please enter a positive integer.");
  		}
  		boolean test = number1 % number2 == 0;
  		return test;
  	}
  	//returns absolute value of number
  	public static double absValue(double number) {
  		if (number < 0 ) {
  			return (number *-1);
  		}
  		else return (number);
  	}
}
    
