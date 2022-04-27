package a4;
/*
 * This class is practicing using searching and Optimizing Loops.
 * @author Xia Li
 */

import java.awt.Color;
import java.util.Scanner;

import a4.Picture;

public class SearchAndOptimizingLoops {
	/*
	 * Main method, this method call the name and print the output.
	 */
	public static void main(String[] args) {
		int testfindSmallestPositiveNumbe = findSmallestPositiveNumber("2 -4 5");
		System.out
				.println("The smallest positive number in this series of numbers is: " + testfindSmallestPositiveNumbe);

		int testfindSmallestPositiveNumbe1 = findSmallestPositiveNumber("-9 -4 6 1");
		System.out.println("The smallest positive number in this series of numbers when the first number is negative: "
				+ testfindSmallestPositiveNumbe1);

		String testlowestAlphabetically = lowestAlphabetically("amazon basic can");
		System.out.println("The lowest alphabetical word is: " + testlowestAlphabetically);

		String testlowestAlphabeticallyForOneWord = lowestAlphabetically("decided");
		System.out.println(
				"The lowest alphabetical word when there is only one word: " + testlowestAlphabeticallyForOneWord);

		int testFindSmallestNumberInTwoStrings = findSmallestNumberInTwoStrings("9 1 9", "8 0 5");
		System.out.println(
				"The smallest number between two strings when all positive is: " + testFindSmallestNumberInTwoStrings);

		int testFindSmallestNumberInTwoStrings1 = findSmallestNumberInTwoStrings("0 -1 2", "1 2 3");
		System.out.println(
				"The smallest number between two strings included negative is: " + testFindSmallestNumberInTwoStrings1);

		String test1curveScoresWhenOneHundred = curveScores("100 30 20");
		System.out.println(
				"The strings of scores after curve when there is 100 included: " + test1curveScoresWhenOneHundred);

		String test1curveScores2 = curveScores("50 60 70 80 90");
		System.out.println("The strings of scores after curve is: " + test1curveScores2);

		Picture image = new Picture("Arches.jpg");
		Color pix = new Color(100, 100, 100);
		System.out.println("This picture contains this color: " + containsThisColor(image, pix));

		Picture image1 = new Picture("Arches.jpg");
		Color pix1 = new Color(255, 255, 255);
		System.out.println("This picture contains this color: " + containsThisColor(image1, pix1));

	}

	/*
	 * Method 1, this method finds the smallest positive numbers and ignore the
	 * negative numbers, after finds the smallest positive numbers, output it.
	 * 
	 * @param A sting contains integer numbers separate by space,must contains at
	 * least one positive integer.
	 * 
	 * @return The smallest positive number in the string.
	 */
	public static int findSmallestPositiveNumber(String numbers) {
		Scanner findTheSmallest = new Scanner(numbers);
		int smallestPositive;
		smallestPositive = findTheSmallest.nextInt();
		// Ensure to find the positive number to get into next while loop.
		while (smallestPositive < 0) {
			smallestPositive = findTheSmallest.nextInt();
		}
		// Scan the numbers, and find the smallest positive number.
		while (findTheSmallest.hasNextInt()) {
			int input = findTheSmallest.nextInt();
			if (input < smallestPositive && input > 0) {
				smallestPositive = input;
			}
		}
		findTheSmallest.close();
		return smallestPositive;
	}

	/*
	 * Method2, find the lowest alphabetical word in the string by scanning.
	 * 
	 * @param A series of lower-case words, start from a-z. Must contain one word.
	 * 
	 * @return The lowest alphabetical lower-cased word.
	 */
	public static String lowestAlphabetically(String words) {
		Scanner findTheLowest = new Scanner(words);
		String input = findTheLowest.next();
		// A while loop scan and compare the each word, until finish scanning all words.
		while (findTheLowest.hasNext()) {
			String temp = findTheLowest.next();
			if (temp.compareTo(input) < 0)
				input = temp;// Replace if the word found is lower than before.
		}
		findTheLowest.close();
		return input;
	}

	/*
	 * Method3, finds the smallest number between two strings by using two scanners.
	 * 
	 * @param Two strings contains numbers, the first one must contain at least one
	 * word.
	 * 
	 * @return A integer is found between two strings.
	 */
	public static int findSmallestNumberInTwoStrings(String num, String val) {
		Scanner theSmallestNum = new Scanner(num);
		int smallestNum = theSmallestNum.nextInt();
//This while loop find the smallest number in the first string.
		while (theSmallestNum.hasNextInt()) {
			int numSmallest = theSmallestNum.nextInt();
			if (numSmallest < smallestNum) {
				smallestNum = numSmallest;
			}
		}
		theSmallestNum.close();
		Scanner inputVal = new Scanner(val);
		int smallestVal = inputVal.nextInt();
		//// This while loop find the smallest number in the second string.
		while (inputVal.hasNextInt()) {
			int valSmallest = inputVal.nextInt();
			if (valSmallest < smallestVal) {
				smallestVal = valSmallest;
			}
		}
		inputVal.close();
		if (smallestVal < smallestNum) {
			return smallestVal;
		} else {
			return smallestNum;
		}
	}

	/*
	 * Method4, curve the score by first find the greatest number, 100 - the
	 * greatest number = a number and add "a number" to each number in the string.
	 * 
	 * @param A string contains number from 0-100, separate by space, contains at
	 * least one number.
	 * 
	 * @return A string contains the number after curve.
	 */
	public static String curveScores(String numbers) {
		Scanner findCurveS = new Scanner(numbers);
		int temp = findCurveS.nextInt();
		// This while loop find the greatest number in the string.
		while (findCurveS.hasNextInt()) {
			int curveLargest = findCurveS.nextInt();
			if (curveLargest > temp) {
				temp = curveLargest;
			}
		}
		findCurveS.close();
		int input = 0;
		Scanner s1 = new Scanner(numbers);
		String input1 = "" + (s1.nextInt() + 100 - temp);
		// This while loop add numbers to the integer in the string.
		while (s1.hasNextInt()) {
			int newNum = s1.nextInt();
			input = newNum + 100 - temp;
			input1 += " " + input;
		}
		s1.close();
		return input1;// Output.
	}

	/*
	 * Method5, check if a color is existed in an image, return true if exist, else
	 * return false.
	 * 
	 * @param A picture object at least 1*1 pixel and color object.
	 */
	public static boolean containsThisColor(Picture image, Color color) {
		// These two for loops get the pixel of the picture from row and column, and
		// check if
		// their color is equaled to the color object.
		for (int pixRow = 0; pixRow < image.height(); ++pixRow) {
			for (int pixCol = 0; pixCol < image.height(); ++pixCol) {
				// Equation to check if colors are equaled.
				if (image.get(pixCol, pixRow).equals(color))
					return true;
			}
		}
		return false;// if not statify the if loop.
	}

}
