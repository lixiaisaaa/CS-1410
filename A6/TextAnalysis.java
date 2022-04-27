package a6;
/**
 * @assignment TextAnalysis
 * @author Xia Li
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextAnalysis {
	/**
	 * This is the main method that run testing code
	 *
	 */
	public static void main(String[] args) {
		// use methods to get the percentage of positive and negative words, and put
		// them into 10 chunks.
		String[] trumpSpeechTesting = convertFileToStringArray("assignment/a6/trumpSpeech.txt");
		trumpSpeechTesting = convertToLowerCase(trumpSpeechTesting);
		trumpSpeechTesting = cleanPunctuation(trumpSpeechTesting);
		trumpSpeechTesting = replaceBoringWordsWithNull(trumpSpeechTesting);
		// At this point, finish modify arrays,count the positive and negative
		// percentage.
		double numbersOfPositive = countNumbersOfPostive(trumpSpeechTesting, 0, trumpSpeechTesting.length);
		double numbersOfNegative = countNumbersOfNegative(trumpSpeechTesting, 0, trumpSpeechTesting.length);
		double positivePercentage = calculatePercentage(trumpSpeechTesting, numbersOfPositive);
		double negativePercentage = calculatePercentage(trumpSpeechTesting, numbersOfNegative);

		System.out.println("Report shows on trumpSpeech.txt");
		System.out.println("The overall sentiment is: "
				+ ResultOfSentiment(trumpSpeechTesting, positivePercentage, negativePercentage));
		// repeat calculate and input the values into 10 difference chunk.
		int chunkForTrumpSpeech = 0;
		while (chunkForTrumpSpeech < 10) {
			double positiveSentimentPercentage = calculatePercentage(trumpSpeechTesting,
					totalPositiveSeg(trumpSpeechTesting, chunkForTrumpSpeech));
			double negativeSentimentPercentage = calculatePercentage(trumpSpeechTesting,
					totalNegativeSentiment(trumpSpeechTesting, chunkForTrumpSpeech));
			System.out.println("Chunk " + chunkForTrumpSpeech + ": " + chunkSentiment(trumpSpeechTesting,
					positiveSentimentPercentage, negativeSentimentPercentage, chunkForTrumpSpeech));
			chunkForTrumpSpeech++;
		}
		System.out.println("Report on trumpSpeech.txt finished");

		// Do same methods as above, but different file.
		String[] theScarletLtterTesting = convertFileToStringArray("assignment/a6/TheScarletLetter.txt");
		theScarletLtterTesting = convertToLowerCase(theScarletLtterTesting);
		theScarletLtterTesting = cleanPunctuation(theScarletLtterTesting);
		theScarletLtterTesting = replaceBoringWordsWithNull(theScarletLtterTesting);

	
		System.out.println("Reporting shows on TheScarletLetter.txt");
		System.out.println("Overall sentiment is: "
				+ ResultOfSentiment(theScarletLtterTesting, positivePercentage, negativePercentage));
		int chunkForTheScareletLetter = 0;
		while (chunkForTheScareletLetter < 10) {
			double positivePercentageSentiment1 = calculatePercentage(theScarletLtterTesting,
					totalPositiveSeg(theScarletLtterTesting, chunkForTheScareletLetter));
			double negativeSentimentPercentage1 = calculatePercentage(theScarletLtterTesting,
					totalNegativeSentiment(theScarletLtterTesting, chunkForTheScareletLetter));
			System.out.println("Chunk " + chunkForTheScareletLetter + ": " + chunkSentiment(theScarletLtterTesting,
					positivePercentageSentiment1, negativeSentimentPercentage1, chunkForTheScareletLetter));
			chunkForTheScareletLetter++;
		}
		System.out.println("Report on TheScarletLetter.txt finished");
		
		String[] taleOfTwoCities = convertFileToStringArray("assignment/a6/TaleOfTwoCities.txt");
		taleOfTwoCities = convertToLowerCase(taleOfTwoCities);
		taleOfTwoCities = cleanPunctuation(taleOfTwoCities);
		taleOfTwoCities = replaceBoringWordsWithNull(taleOfTwoCities);

		System.out.println("Report shows on TaleOfTwoCities.txt");
		System.out.println("The overall sentiment is: "
				+ ResultOfSentiment(taleOfTwoCities, positivePercentage, negativePercentage));
	}

	/**
	 * This method is converting the file's context into arrays separate by comma.
	 * 
	 * @param filename
	 * @return return the array which include the context in file, if file is not
	 *         found, return null.
	 */
	public static String[] convertFileToStringArray(String filename) {
		File file = new File(filename);
		try (Scanner measureArrayLength = new Scanner(file)) {
			int length = 0;
			// find size of array
			while (measureArrayLength.hasNext()) {
				measureArrayLength.next();
				length++;
			}
			String[] stringFile = new String[length];
			Scanner catchWordsInFile = new Scanner(file);
			int i = 0;
			// add words to array
			while (catchWordsInFile.hasNext()) {
				stringFile[i] = catchWordsInFile.next();
				i++;
			}
			catchWordsInFile.close();
			return stringFile;
			// if file not find, return null.
		} catch (FileNotFoundException e) {
			System.out.println("file" + filename + "not Found");
			return null;
		}
	}

	/**
	 * This method is converting Upper-case character to lower-case character with
	 * toLowerCase method.
	 * 
	 * @param fileInArrayForm
	 * @return the new array that all of the indexes are in lower-case.
	 */
	public static String[] convertToLowerCase(String[] fileInArrayForm) {
		String[] fileContent = new String[fileInArrayForm.length];
		// search the array, make every character to lower-case.
		for (int i = 0; i < fileContent.length; i++) {
			fileContent[i] = fileInArrayForm[i].toLowerCase();

		}
		return fileContent;
	}

	/**
	 * This method is clean the punctuation in every words.
	 * 
	 * @param fileInArrayForm
	 * @return the new String Array that "" instead of A-Z, or a-z.
	 */
	public static String[] cleanPunctuation(String[] fileInArrayForm) {
		// search through the array, set punctuation to empty.
		for (int i = 0; i < fileInArrayForm.length; i++) {
			fileInArrayForm[i] = fileInArrayForm[i].replaceAll("[^a-zA-Z ]", "");
		}
		return fileInArrayForm;
	}

	/**
	 * This method is replacing the boring words from stop_word.txt into null.
	 * 
	 * @param fileInArrayForm
	 * @param stopWords
	 * @return the new String with the null that instead the words from
	 *         "stop_words.txt."
	 */
	public static String[] replaceBoringWordsWithNull(String[] fileInArrayForm) {
		String[] stopTxtArray = convertFileToStringArray("assignment/a6/stop_words.txt");
		// At this point, get the words in array.
		for (int i = 0; i < fileInArrayForm.length; i++) {
			String word = fileInArrayForm[i];
			// At this point, compare the words in array to every words in stop_words.txt.
			for (int j = 0; j < stopTxtArray.length; j++) {
				String replaceWord = stopTxtArray[j];
				if (word.equals(replaceWord)) {
					fileInArrayForm[i] = null;
				}
			}
		}
		return fileInArrayForm;

	}

	/**
	 * This method is counting how many words in the negative.txt file expect null.
	 * 
	 * @param negativeFileInArray
	 * @return the total words that is in "negative.txt." without null.
	 */
	public static int countNumbersOfNegative(String[] negativeFileInArray, int chunkStartingPoint, int chunkEndPoint) {
		String[] negativeWord = convertFileToStringArray("assignment/a6/negative.txt");
		int negativeWordCounter = 0;
		// get the words from array.
		for (int i = 0; i < negativeFileInArray.length; i++) {
			// get the words from file.
			for (int j = 0; j < negativeWord.length; j++) {
				if (negativeFileInArray[i] != null && negativeFileInArray[i].equals(negativeWord[j])) {
					negativeWordCounter++;
					break;
				}
			}
		}

		return negativeWordCounter;
	}

	/**
	 * In this method we are going to accumulate all the words from "positive.txt."
	 * 
	 * @param positiveFileInArray
	 * @param chunkEndPoint
	 * @param chunkStartingPoint
	 * @return the total words that is in "positive.txt."
	 */
	public static int countNumbersOfPostive(String[] positiveFileInArray, int chunkStartingPoint, int chunkEndPoint) {
		String[] positiveWords = convertFileToStringArray("assignment/a6/positive.txt");
		int positiveWordsCounter = 0;
		// get the words from array.
		for (int length = 0; length < positiveFileInArray.length; length++) {
			// get the words from file.
			for (int words = 0; words < positiveWords.length; words++) {
				if (positiveFileInArray[length] != null && positiveFileInArray[length].equals(positiveWords[words])) {
					positiveWordsCounter++;
					break;
				}

			}
		}
		return positiveWordsCounter;
	}

	/**
	 * This method is calculating the percentage of positive number or negative in
	 * the text.
	 * 
	 * @param fileAfterFilted
	 * @param numbersOfWords
	 * @return the percentage of positive of negative numbers.
	 */
	public static double calculatePercentage(String[] fileAfterFilted, double numbersOfWords) {
		String[] originalTxt = fileAfterFilted;
		int totalWords = 0;
		// get the numbers of total words.
		for (int index = 0; index < originalTxt.length; index++) {
			if (originalTxt[index] != null) {
				totalWords++;
			}
		}
		// calculate the words' percentage.
		return (numbersOfWords * 100) / totalWords;
	}

	/**
	 * This method is getting the sentiment numbers of negative words.
	 * 
	 * @param negativeWordsInFile
	 * @param sentimentParts
	 * @return the numbers of total negative sentiments.
	 */
	public static double totalNegativeSentiment(String[] negativeWordsInFile, int sentimentParts) {
		String[] negativeWords = convertFileToStringArray("assignment/a6/negative.txt");
		int negativeNumberCounter = 0;
		// set the sentiment of negative words.
		int theStartingPartOfSentiment = (int) (negativeWordsInFile.length * 0.1 * (sentimentParts));
		// this lane for move on
		int sentimentMoveOn = (int) (negativeWordsInFile.length * 0.1 * (sentimentParts + 1));
		// input the value
		for (int i = theStartingPartOfSentiment; i < sentimentMoveOn; i++) {
			// move and compare
			for (int j = 0; j < negativeWords.length; j++) {
				if (negativeWordsInFile[i] != null) {
					if (negativeWordsInFile[i].equals(negativeWords[j])) {
						negativeNumberCounter = negativeNumberCounter + 1;
					}
				}
			}
		}
		// return negative numbers.
		return -negativeNumberCounter;
	}

	/**
	 * This method is getting the sentiment numbers of negative words.
	 * 
	 * @param positiveWordsInFile
	 * @param sentimentPart
	 * @return the total value of positive sentiment.
	 */
	public static double totalPositiveSeg(String[] positiveWordsInFile, int sentimentPart) {
		String[] positiveeWordsInArray = convertFileToStringArray("assignment/a6/positive.txt");
		int positiveNumbersCounter = 0;
		// set starting part of sentiment of positiveWords.
		int theStartingPartOfSentiment = (int) (positiveWordsInFile.length * 0.1 * (sentimentPart));
		// this lane for move on
		int sentimentMoveOn = (int) (positiveWordsInFile.length * 0.1 * (sentimentPart + 1));
		// input the value
		for (int i = theStartingPartOfSentiment; i < sentimentMoveOn; i++) {
			// move and compare
			for (int j = 0; j < positiveeWordsInArray.length; j++) {
				if (positiveWordsInFile[i] != null) {
					if (positiveWordsInFile[i].equals(positiveeWordsInArray[j])) {
						positiveNumbersCounter = positiveNumbersCounter + 1;
					}
				}
			}
		}
		return positiveNumbersCounter;
	}

	/**
	 * This method is add positive and negative sentiment together.
	 * 
	 * @param file
	 * @param positiveNumbers
	 * @param negativeNumbers
	 * @return the total value of sentiment
	 */
	public static double ResultOfSentiment(String[] file, double positiveNumbers, double negativeNumbers) {
		// this point is getting the sentiment of positive and negative numbers.
		positiveNumbers = calculatePercentage(file, countNumbersOfPostive(file, 0, file.length));
		negativeNumbers = calculatePercentage(file, countNumbersOfNegative(file, 0, file.length));
		double Result = positiveNumbers - negativeNumbers;
		return Result;
	}

	/**
	 * This method is setting up the chunks.
	 * 
	 * @param file
	 * @param positiveNumbers
	 * @param negativeNumbers
	 * @param sentiments
	 * @return the overallValue of positive and negative.
	 */
	public static double chunkSentiment(String[] file, double positiveNumbers, double negativeNumbers, int sentiments) {
		// set to 10 parts.
		int chunkSize = file.length / 10;
		int remainder = file.length % 10;
		// At this point, input the numbers into chunk and move on.
		for (int chunk = 0; chunk < file.length - remainder; chunk += chunkSize) {
			countNumbersOfPostive(file, chunk, chunkSize + chunk);
			countNumbersOfNegative(file, chunk, chunkSize + chunk);
		}
		// overall numbers.
		double overallNumbers = positiveNumbers + negativeNumbers;
		return overallNumbers;
	}

}