package a3;

/*
 * 
 * @author Xia Li
 */

import java.util.Scanner;

public class LoopsAndImages {
	public static void main(String[] args) {
    	String testHideLetterA = hideLetterA("A rabbit has a carrot");
    	System.out.println("The sentence after hide letter 'a' is: " + testHideLetterA);
    	
    	boolean testHasMoreEvenThanOddIfEmpty = hasMoreEvenThanOdd(" ");
    	System.out.println("The testString has more even than odd for empty string:" + testHasMoreEvenThanOddIfEmpty);
    	
    	boolean testingHasMoreEvenThanOddExpectTure = hasMoreEvenThanOdd("1 3 4 6 -8");
    	System.out.println("The testString has more even than odd expected ture:" + testingHasMoreEvenThanOddExpectTure);
    	
    	boolean testHasMoreEvenThanOddIfSame = hasMoreEvenThanOdd("1 3 5 2 4 6");
    	System.out.println("The testString has more even than odd if same numbers of even and odd:" + testHasMoreEvenThanOddIfSame);
    	
    	boolean testingHasMoreEvenThanOddExpectFalse = hasMoreEvenThanOdd("1 3 4");
    	System.out.println("The testString has more even than odd expected false:" + testingHasMoreEvenThanOddExpectFalse);
    	
    	String testMakeTextTriangle = makeTextTriangle(4);
    	System.out.print("The triangle:" + "\n" + testMakeTextTriangle);
    	
    	
    	Picture image = new Picture("Arches.jpg");{
    		image = makeGrey(image);
    		image.show();
    		
    	Picture testImage = new Picture("Arches.jpg");{
        		image = makeNegative(testImage);
        		image.show();
        
        int testSafeColor = safeColor(300);		
        System.out.println ("the safecolor test value for number greater than 255 is: " + testSafeColor);
        
        int testingSafeColor = safeColor(100);		
        System.out.println ("the Safecolor test value is: " + testingSafeColor);
        
        int testSafeColorLess0 = safeColor(-10);		
        System.out.println ("the safecolor test value for number less than zero is: " + testSafeColorLess0);
        
        Picture testImageBright = new Picture("Arches.jpg");{
    		image = makeBrighter(testImageBright);
    		image.show();
        
    	}
    	}
    	}
    }


/*
 * Method: hideLetterA
 * Input a sentence, this method would replace the character 'a'(not 'A') to '*', 
 * and have exact same character beside 'a' in the string.
 * 
 * @param A string include a sentence. An empty string is allowed.
 * @return A string has same characters as parameter says, 
 * except 'a' is replaced by '*'.
 */
public static String hideLetterA(String sentence) {
	String newSentence = sentence;
	//this for-loop will scan the sentence's character.
	  for(int count = 0; count< sentence.length(); count++) {
	   //if the character is 'a' when scan, change to '*'.
		  if(newSentence.substring(count, count +1).equals("a")) {
	    newSentence = newSentence.substring(0,count) + "*" + newSentence.substring(count+1, newSentence.length());
	   }
	  }
	  return newSentence;//return the sentence after replaced.
	} 

/*
 * Method hasMoreEvenThanOdd is scanning in a string of number, compare if even numbers are more
 * than odd numbers, if even is more return true, else return false. An empty string is allowed.
 * 
 * @param A string contains only integer numbers separated by space.An empty string is allowed.
 * @return Return true if even number is more than odd numbers, otherwise, return false.
 */
public static boolean hasMoreEvenThanOdd(String integers) {
	//two variable to count the numbers of even and odd.
	int evenCount = 0;
	int oddCount = 0;
	Scanner s = new Scanner(integers);
	while (s.hasNextInt()) {
		// this if loop will determine if numbers are evens or odds. 
	if (s.nextInt() % 2 == 0) {
		evenCount++; 
	 }else {
		oddCount++ ;
	 }
	}
	s.close();
	//comparing , return if even is more.
	if (evenCount > oddCount) {
		return true;
	}else {
		return false;
	}
}

	
/*
 * Method makeTextTriangle is making a text right triangle by using two for loops.
 * 
 * @param A string that decides that how width( or how many '*') we are making.
 * @return A string value that makes a text triangle.
 * 
 */
public static String makeTextTriangle(int width) {
	//a place for toString to return.
	StringBuilder result = new StringBuilder();
    // decide how many lines.
	for (int r = 1; r <= width; r++) {
		// decide how many columns in each line. 
        for (int j = 1; j <= r; j++) {
            
        	result.append("*"); 
        }
        result.append("\n");
    }
    return result.toString();//return the string value of triangle.
}

/*
 * Method makeGrey make the picture grey by equivalent of the corresponding pixel.
 * 
 * @param A picture in the file.
 * @return A new picture after processes.
 * 
 */
public static Picture makeGrey(Picture imageGrey) {
	//Two for loops the the x and y coordinate.
	for (int row=0; row < imageGrey.height(); ++row) {
		for(int col = 0;col < imageGrey.width();++col) {
		int rgb=imageGrey.getRGB(col, row);
		// move r,g,b out for adjusting.
		int r = (rgb >> 16)& 0xFF;
		int g = (rgb >> 8) & 0xFF;
		int b = (rgb >> 0) & 0xFF;
		// a temporary place to calculate the average of r,g,b.
		int temp = (r+g+b)/3;
		// move back.
		rgb = (temp << 16)+(temp << 8)+ (temp << 0);
		imageGrey.setRGB(col, row, rgb);
		}
	}
	return imageGrey;// return the picture after we get finished.
}

/*
 * Method makeNegative will make the color in picture go opposite side.
 * 
 * @param A picture in the file.
 * @return A new picture object after we adjusting.
 */
public static Picture makeNegative(Picture imageNegative) {
	//Two for loops the the x and y coordinate.
	for (int row=0; row < imageNegative.height(); ++row) {
		for(int col = 0;col < imageNegative.width();++col) {
		int rgb=imageNegative.getRGB(col, row);
		// move r,g,b out for adjusting.
		int r = (rgb >> 16)& 0xFF;
		int g = (rgb >> 8) & 0xFF;
		int b = (rgb >> 0) & 0xFF;
		//  calculate by taking each red, green, and blue value in the source 
		//  and setting it to 255 - each value in the returned image.
		r = 255 - r;
		g = 255 - g;
		b = 255 - b;
		//move back
		rgb = (r << 16)+(g << 8)+ (b << 0);
		imageNegative.setRGB(col, row, rgb);
		}
	}
	return imageNegative;//return new image.
}

/*
 * Method safeColor is controlling the value in r,g,b, return to a safe range.
 * 
 * @param A single integer represent the value to put in r,g,b.
 * @return If less than 0, return 0. If in range of 0-255, return itself.
 * If greater than 255, return 255.
 */
public static int safeColor(int value) {
	if (value < 0) {
		return 0;//less than 0
	} else if (255 < value) {
		return 255;// greater than 255
	} else {
		return value;//this is the situation value in 0-255.
	}
		
}

/*
 * Method makeBrighter makes the picture brighter by double the value r,g,b in safe range.
 * 
 * @param A picture in the file.
 * @return A picture with r,g,b doubled in safe range, which makes the picture brighter.
 */
public static Picture makeBrighter(Picture imageBright) {
	//Two for loops the the x and y coordinate.
	for (int row=0; row < imageBright.height(); ++row) {
		for(int col = 0;col < imageBright.width();++col) {
		int rgb=imageBright.getRGB(col, row);
		// move r,g,b out for adjusting.
		int r = (rgb >> 16)& 0xFF;
		int g = (rgb >> 8) & 0xFF;
		int b = (rgb >> 0) & 0xFF;
		// calculate by doubling the value in safe range.
		r = safeColor(r*2);
		g = safeColor(g*2);
		b = safeColor(b*2);
		//return after calculated
		rgb = (r << 16)+(g << 8)+ (b << 0);
		imageBright.setRGB(col, row, rgb);
		}
	}
	return imageBright; //return a brighter image.
}

}
