package a2;

/**
 * A collection of methods exercising if, while, String, and problem solving.
 * 
 * @author David Johnson
 * @author Xia Li
 * 
 *         This material is copyright David Johnson January 2020. Derived works
 *         may not be published publicly. This notice must remain. Failure to
 *         follow these copyright restrictions constitutes academic misconduct
 *         for the course and academic sanctions can be applied at any time.
 *
 */
public class ExampleMethods {
	// main
	public static void main(String[] args) {
		// call method1, describeSignOfNumbe, and print it out.
		String signOfNumberTesting = describeSignOfNumber(7);
		System.out.println("The sign of number is: " + signOfNumberTesting);
		// call method2, classifyNumber, and print it out.
		String classifyNumbeTesting = classifyNumber(0);
		System.out.println("The classified number is: " + classifyNumbeTesting);
		// call method3, isEvenlyDivisibleBySeven, and print it out.
		boolean divisibleNumbeTesting = isEvenlyDivisibleBySeven(7);
		System.out.println("This number is divisible by Seven: " + divisibleNumbeTesting);
		// call method4, chooseLargest, and print it out.
		double largestNumbeTesting = chooseLargest(10.0, 100.0);
		System.out.println("The larger number is: " + largestNumbeTesting);
		// call method5, firstDoublingPastOneHundred, and print it out.
		int doubleNumbeTesting = firstDoublingPastOneHundred(20);
		System.out.println("The final number: " + doubleNumbeTesting);
		// call method6, everyOtherLetter, and print it out.
		String sentenceTesting = everyOtherLetter("David is cool");
		System.out.println(sentenceTesting);
		// call method7, makeLine, and print it out.
		String lineTesting = makeLine('+', '-', 8);
		System.out.println(lineTesting);
		// call method8, makeSquare, and print it out.
		String squareTesting = makeSquare(7);
		System.out.println(squareTesting);
	}

	/**
	 * Method1, this method returns "negative" if value is less than 0, in any else
	 * situation, return "positive" .
	 */

	public static String describeSignOfNumber(int value) {
		if (value < 0) {
			return "negative";
		} else {
			return "non-negative";
		}

	}

	/**
	 * Method2, this method returns "negative" when value is less than 0, returns
	 * "zero" when value is equaled to 0, returns "positive" in other situation.
	 */

	/**
	 * Method2, this method returns "negative" when value is less than 0, returns
	 * "zero" when value is equaled to 0, returns "positive" in other situation.
	 * 
	 * @param value number to identify
	 * @return "negative" or "zero" or "positive".
	 */
	public static String classifyNumber(int value) {
		if (value < 0) {
			return "negative";
		} else if (value == 0) {
			return "zero";
		} else {
			return "positive";
		}
	}

	/**
	 * Method3, this method returns true of false to determine if an integer is
	 * divisible by seven.
	 * 
	 * @param value number to identify
	 * @return true or false.
	 */
	public static boolean isEvenlyDivisibleBySeven(int value) {
		// Change or modify the return. This is here for now to prevent compiler errors.
		if (value % 7 == 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * Method4, this method return the largest number between 2 numbers.
	 * 
	 * @param number1 to identify and compare.
	 * @param number2 to identify and compare.
	 * @return number1 and number2.
	 */
	public static double chooseLargest(double number1, double number2) {
		if (number1 < number2) {
			return number2;
		} else {
			return number1;
		}
	}

	/**
	 * *Method5, this method double the integer if the integer less or equal to 100,
	 * until the number is greater than 100 after it is doubled.
	 *
	 * @param startNumber to identify.
	 * @return starNumberl
	 */
	public static int firstDoublingPastOneHundred(int startNumber) {
		while (startNumber <= 100) {
			startNumber = startNumber * 2;
		}
		return startNumber;
	}

	/**
	 * Method6, this method returns empty if sentence is empty. Produce a new
	 * sentence that contain odd number position from old sentence.
	 * 
	 * @param String a sentence used to read.
	 * @return a new sentence after read and plug in.
	 */
	public static String everyOtherLetter(String sentence) {
		if (sentence.isEmpty())
			return "";
		int count = 0;
		String newSentence = "";
		while (count < sentence.length()) {
			String temp = sentence.substring(count, count + 1);
			newSentence += temp;
			count = count + 2;

		}
		return newSentence;
	}

	/**
	 * Produces a String starting and ending with the edge character and having the
	 * inner char repeated in-between. The total number of characters in the string
	 * is width. As an example makeLine('+', '-', 8) would return the string
	 * "+------+".
	 * 
	 * NOTE: This method is already completely implemented and must not be modified
	 * for the assignment.
	 * 
	 * @param edge  The character used at the start and end of the returned string.
	 * @param inner The character repeated in-between the edge char.
	 * @param width The total number of characters in the returned string. Width
	 *              must be greater or equal to 2.
	 * @return A string with width characters.
	 */
	public static String makeLine(char edge, char inner, int width) {
		String line = "";
		int currentLocation = 0;
		// Make the middle part of the line first.
		while (currentLocation < width - 2) {
			line = line + inner;
			currentLocation = currentLocation + 1;
		}
		// Add in the start and end character to the line.
		return edge + line + edge;
	}

	/**
	 * Produce the String at starting and ending with edge character '+', and having
	 * inner character '-' in-between with makeline's code. In order to make 2
	 * lines, we create top and bottom as variables with makeline's code. We also
	 * make body variable to form a square. When our width less or equal to 2, stop.
	 * 
	 * @param width used to give value forming square.
	 * @return Two strings with width characters in different lane and have body
	 *         line connect them.
	 */
	public static String makeSquare(int width) {
		String top;
		String body = "";
		String bottom;
		top = makeLine('+', '-', width) + "\n";
		int count = 0;
		while (count < width - 2) {
			body = body + makeLine('|', ' ', width) + "\n";
			count = count + 1;
		}
		bottom = makeLine('+', '-', width) + "\n";
		return top + body + bottom;
	}
	// Replace this line with your own code.
}
