package a5;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraysAndSound {

//Main method, this method is testing the other method in this class.	
public static void main(String[] args) {
		int[] clearArrayTesting = { 1, 2 };
		System.out.println("Original number:" + Arrays.toString(clearArrayTesting));
		clearArray(clearArrayTesting);
		System.out.println("After clear:" + Arrays.toString(clearArrayTesting));

		int[] arrayToStringTesting = { 1, 2 };
		System.out.println("The elements after adding curly brace is:" + arrayToString(arrayToStringTesting));
		int[] arrayToStringTesting1 = { 0, 0 };
		System.out.println("The elements after adding curly brace is:" + arrayToString(arrayToStringTesting1));

		String[] containsDuplicateExpectedFalse = { "David", "Joe" };
		System.out.println("This array contain duplicate:" + containsDuplicate(containsDuplicateExpectedFalse));
		String[] containsDuplicateExpectedTure = { "a", "b", "a" };
		System.out.println("This array contain duplicate:" + containsDuplicate(containsDuplicateExpectedTure));

		int[] averageArrayValuesTesting = { 1, 2 };
		System.out.println("The element aftre averaging is:" + averageArrayValues(averageArrayValuesTesting));
		int[] averageArrayValuesTesting0 = { 0, 0 };
		System.out.println("The element aftre averaging is:" + averageArrayValues(averageArrayValuesTesting0));
		int[] averageArrayValuesTestingNegative = { -1, -2, 4, 5 };
		System.out.println("The element aftre averaging is:" + averageArrayValues(averageArrayValuesTestingNegative));
		int[] averageArrayValuesTestingMix = { 1, 2, 4, 5 };
		System.out.println("The element aftre averaging is:" + averageArrayValues(averageArrayValuesTestingMix));

		int[] frequencyCountTesting = { 0, 0, 1, 1, 1, 7 };
		System.out.println("The number of element found is: " + arrayToString(frequencyCount(frequencyCountTesting)));
		int[] frequencyCountTesting0 = { 0, 0, 0, 0, 0, 0 };
		System.out.println("The number of element found is: " + arrayToString(frequencyCount(frequencyCountTesting0)));

		double[] reverseSoundTesting = { 0.1, 0.2, 0.3, 0.5 };
		System.out.println("The elements after reverse is:" + Arrays.toString(reverseSound(reverseSoundTesting)));
		double[] reverseSoundTesting0 = { 0.0, 0.0, 0.0, 0.0 };
		System.out.println("The elements after reverse is:" + Arrays.toString(reverseSound(reverseSoundTesting0)));
		double[] reverseSoundTestingAllNegative = { -0.1, -0.2, -0.3, -0.5 };
		System.out.println("The elements after reverse is:" + Arrays.toString(reverseSound(reverseSoundTestingAllNegative)));

		double[] scaleSoundTesting = { 0.0, -0.1, 0.3 };
		System.out.println("The elements after scale is: " + Arrays.toString(scaleSound(scaleSoundTesting, 2.0)));
		double[] scaleSoundTesting0 = { 0.0, -0.0, 0.0 };
		System.out.println("The elements after scale is: " + Arrays.toString(scaleSound(scaleSoundTesting0, 0.0)));
		double[] scaleSoundTestingAllNegative = { -0.1, -0.1, -0.3 };
		System.out.println("The elements after scale is: " + Arrays.toString(scaleSound(scaleSoundTestingAllNegative, -2.0)));
		double[] scaleSoundTestingAllPositive = { 0.1, 0.1, 0.3 };
		System.out.println("The elements after scale is: " + Arrays.toString(scaleSound(scaleSoundTestingAllPositive, 2.0)));

		double[] echoSoundTesting = { 0.1, 0.2, 0.3, 0.4 };
		System.out.println("The elements after echo method is: " + Arrays.toString(echoSound(echoSoundTesting, 1, 0.5)));
		double[] echoSoundTesting0 = { 0.0, 0.0, 0.0, 0.0 };
		System.out.println("The elements after smoothed is: " + Arrays.toString(echoSound(echoSoundTesting0, 0, 0.0)));
		double[] echoSoundTestingNegative = { -0.1, -0.2, -0.3, -0.4 };
		System.out.println("The elements after smoothed is: " + Arrays.toString(echoSound(echoSoundTestingNegative, 1, -0.5)));

		double[] smoothSoundTesting = { 1, 3, 2 };
		System.out.println(("The elements after smoothed is: " + Arrays.toString(smoothSound(smoothSoundTesting))));
		double[] smoothSoundTesting0 = { 0, 0, 0 };
		System.out.println(("The elements after smoothed is: " + Arrays.toString(smoothSound(smoothSoundTesting0))));
		double[] smoothSoundTestingNegative = { -1, -3, -2 };
		System.out.println(("The elements after smoothed is: " + Arrays.toString(smoothSound(smoothSoundTestingNegative))));

	}

	/*
	 * This method clear the elements in array by change to 0.
	 * 
	 * @param a int array.
	 * 
	 * @return nothing, this is a void method.
	 */
	public static void clearArray(int[] array) {
		// check each element in the array.
		for (int i = 0; i < array.length; i++) {
			// set the element to 0.
			array[i] = 0;
		}
	}

	/*
	 * This method call the element in the array, print it with curly braces.
	 * 
	 * @param a int array.
	 * 
	 * @return A string contain the number in the array, starts and end with curly
	 * brace.
	 */
	public static String arrayToString(int[] arrays) {
		// set the start string.
		String newString = "{";
		int i = 0;
		// Grab elements from array, put it in.
		while (i < arrays.length) {
			newString = newString + arrays[i];
			// execute only if we at the last digit of the length.
			if (i == arrays.length - 1) {
				break;
			}
			// set period between numbers.
			newString = newString + ", ";
			i++;
		}
		newString = newString + "}";
		return newString;
	}

	/*
	 * This method check if there is duplicate character in the string, for example,
	 * 'a','a'.
	 * 
	 * @param A string array.
	 * 
	 * @return Booleans true if contain duplicate, false otherwise.
	 */
	public static boolean containsDuplicate(String[] duplicatedArray) {
		Set<String> set = new HashSet<>();
		for (String elementInArray : duplicatedArray) {
			set.add(elementInArray);
		}
		return set.size() < duplicatedArray.length;
	}

	/*
	 * This method calculate the average value in the array.
	 * 
	 * @param A int array.
	 * 
	 * @return A double number, which represent the average value.
	 * 
	 */
	public static double averageArrayValues(int[] arrayAveraging) {
		double sum = 0;
		// this loop add up all the numbers in the array.
		for (int i = 0; i < arrayAveraging.length; i++) {
			sum += arrayAveraging[i];
		}
		return sum / arrayAveraging.length;
	}
     /*
      * This method finds how many elements.
      * 
      * @param A int Array.
      * 
      * @return A int array that counts the numbers of elements.
      */
	public static int[] frequencyCount(int[] frequencyCountArray) {
		//Set the length.
		int[] newArray = new int[10];
		//When find the elements, counts is up.
		for (int i = 0; i < frequencyCountArray.length; i++) {
			newArray[frequencyCountArray[i]]++;
		}
		return newArray;
	}

	/*
	 * This method reverse the sequence of the elements in array.
	 * 
	 * @param A double array
	 * 
	 * @return The double array after reverse the original one.
	 */
	public static double[] reverseSound(double[] reverseSoundArray) {
		double[] reversedArray = new double[reverseSoundArray.length];
		//plug in every element from last to first.
		for (int i = 0; i < reverseSoundArray.length; i++) {
			reversedArray[reverseSoundArray.length - i - 1] = reverseSoundArray[i];
		}
		return reversedArray;
	}

	/*
	 * This method scale the elements in the array use for sound.
	 * 
	 * @param A double array, double number.
	 * 
	 * @return A double array after scaling.
	 */
	public static double[] scaleSound(double[] elements, double scalingNumber) {
		double[] newElements = new double[elements.length];
		// At this poing, find the element in array, multiple it by scalingNumber,
		// so we get the number.
		for (int i = 0; i < elements.length; i++) {
			newElements[i] = elements[i] * scalingNumber;
		}
		return newElements;
	}

	/*
	 * This method make the sound echo.
	 * 
	 * @param A double array, int number, double number.
	 * 
	 * @return A double array after we make it echo.
	 */
	public static double[] echoSound(double[] elements, int echoTimes, double echoScale) {
		double[] echo = new double[elements.length + echoTimes];
		// At this point we count first time from last to first。
		for (int i = 0; i < echoTimes; i++) {
			echo[i] = elements[i];
			echo[echo.length - i - 1] = elements[elements.length - i - 1] * echoScale;
		}
		// we do the same thing, but from first to last this time.
		for (int i = echoTimes; i < echo.length - echoTimes; i++) {
			echo[i] = elements[i] + (elements[i - echoTimes] * echoScale);
		}
		return echo;
	}

	/*
	 * This method make the sound smooth.
	 * 
	 * @param A double array
	 * 
	 * @return a double array after smoothed.
	 */
	public static double[] smoothSound(double[] elements) {
		double[] smoothSoundNew = new double[elements.length];
		// This lane calculates for the first number in array.
		smoothSoundNew[0] = (elements[0] + elements[1]) / 2;
		// This lane calculates for the last number in array.
		smoothSoundNew[smoothSoundNew.length - 1] = (elements[elements.length - 1] + elements[elements.length - 2]) / 2;
		// At this point, we calculate for the middle number.
		for (int i = 1; i < elements.length - 1; i++) {
			smoothSoundNew[i] = (elements[i - 1] + elements[i] + elements[i + 1]) / 3;
		}
		return smoothSoundNew;
	}
}
