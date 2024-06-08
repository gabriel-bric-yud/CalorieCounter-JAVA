import java.util.Scanner;
import java.text.DecimalFormat;

public class Calories {
	
	
	/**This function checks if the userInput is within the acceptable range of cookies in the bag.
	 * If it is less than 0 or greater than 40 then it returns false.
	 */
	public static boolean inRange(Double input, int totalCookies) {
		if (input == null) {
			System.out.println("You can't eat null cookies.");
			return false;
		}
		if (input < 0) {
			System.out.println("You can't eat negative cookies. That's not a way to lose weight!");
			return false;
		}
		else if (input > totalCookies) {
			System.out.println("There are only 40 cookies in the bag! ");
			return false;
		}
		return true;
	}
	

	public static void main(String[] args) {
		
		//these are the constants
		final int COOKIE_BAG = 40;
		final int SINGLE_SERVING = COOKIE_BAG / 10;
		final int CALORIES_PER_SERVING = 300;
		final int CALORIES_PER_COOKIE = CALORIES_PER_SERVING / SINGLE_SERVING;
		final DecimalFormat fmt1 = new DecimalFormat("0.#");
		
		
		System.out.println("You had "+ COOKIE_BAG + " cookies left in your cookie bag.");
		
		//Create the Scanner object and empty userInput variable for future assignment and validation.
		Scanner scan = new Scanner(System.in);	
		scan.useDelimiter("\\R");
		Double userInput = null;
			
		/**This while-loop is to check if userInput has been updated from Null and is in the valid range.
		 * The try/catch checks if a TypeMismatchError has been thrown.
		 * You can't pass this point unless a number has been entered and it's in the range.
		 */
		while (userInput == null || !inRange(userInput, COOKIE_BAG)) {
			userInput = null;
		    try {
		    	System.out.print("\nEnter how many cookies you ate: ");
		    	userInput = scan.nextDouble();
		    }
		    catch (Exception e) {
		        System.out.println("Please enter a number!");
		        scan.nextLine();
		    }
		}
			
		//run the calculation and display the output.
		double totalCalories = CALORIES_PER_COOKIE * userInput;
		System.out.println("\nYou consumed " + fmt1.format(totalCalories) + " total calories from eating " + fmt1.format(userInput) + " cookies.");
		scan.close();
	}
}




/**My original version used scan.nextLine() and I validated with Integer.parseInt() to convert it.
 * That version allowed me to use the try/catch to catch a NumberFormatException error and also checks for null values. 
 * I think it gives more control to get a string with nextLine() than to use nextInt() or nextDouble() since nextLine() can capture ANY user input and you validate it manually. 
 * nextInt()/nextDouble() will automatically throw an error if a string is entered which makes it harder to control.
 * InputMismatchErrors also do not seem to be caught easily in a try/catch. This makes nextInt() and nextDouble() harder to use.
 * One answer seems to be to use hasNextDouble() in my while loop. But I would have to totally re-factor my code to make it work properly.
 * My current version still catches all errors. 
 * I use scan.useDelimiter("\\R") to prevent multiple "ENTER" presses by the user. I found this solution on stackoverflow.com
 * It's cool that stackoverflow.com also recommends my idea of nextLine() and Integer.parseInt() with a try/Catch to allow for more control than nextInt(). I had made that solution on my own!
 */

