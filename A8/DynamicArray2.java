package a8;
/*
 * @author Xia Li
 */

// A more efficient version of the DynamicArray class than the one created in lecture.
//
// Represents the dynamic array [data[0], data[1], ..., data[virtualArrayLength-1]]
// In other words, the first virtualArrayLength elements of data are elements of the 
// dynamic array. The remainder of data is room to grow.  When data fills 
// up, we allocate a new array that is twice as long. 
public class DynamicArray2 {

	private String[] data; // the backing array
	private int virtualArrayLength; // the number of elements in the dynamic array

	/**
	 * Creates an empty dynamic array with room to grow. (DO NOT modify this
	 * method.)
	 */
	public DynamicArray2() {
		// Start with a few available spaces. Do not change this.
		data = new String[8];
		// But the virtual array is empty.
		virtualArrayLength = 0;
	}

	/**
	 * Returns the number of elements in the dynamic array.
	 * 
	 * @return the number of elements
	 */
	public int size() {
		return virtualArrayLength;
	}

	// Appends s to the end of the dynamic array at index this.size().
	public void add(String s) {
		add(this.size(), s);
	}

	/**
	 * Add the String into the array.
	 */
	public void add(int i, String s) {

		if (i < 0 || i > virtualArrayLength)
			throw new IndexOutOfBoundsException();
		if (virtualArrayLength == data.length) {
			String newData[] = new String[data.length * 2];
			for (int j = 0; j < virtualArrayLength; j++) {
				newData[j] = data[j];
			}
			data = newData;
		}

		for (int j = virtualArrayLength; j > i; j--) {
			data[j] = data[j - 1];
		}

		data[i] = s;

		virtualArrayLength++;
	}

	/**
	 * Remove the element at position i of an array.and shifts 
	 * the elements after i down one to fill in the gap.
	 * Throws an IndexOutOfBoundsException if i is not a valid index
	 * @param int: position of the array.
	 */
	
	public void remove(int i) {
		if (i < 0 || i > data.length)
			throw new IndexOutOfBoundsException();
		for (int j = i; j < this.size() - 1; j++) {
			data[j] = data[j + 1];
		}
		data[this.size()] = null;
		virtualArrayLength--;
	}

	/**
	 * Return the element at position i the array.
	 * Throws an IndexOutOfBoundsException if i is not a valid index 
	 * of the dynamic array.
	 * @param int: the position of the element
	 * @return String: the string at position i.
	 */
	public String get(int i) {
		if (i < 0 || i >= data.length)
			throw new IndexOutOfBoundsException();
		if (i >= virtualArrayLength) {
			return null;
		} else {
			return data[i];
		}

	}

	/**
	 * Set a element at postion i in an array.
	 *  Throws an IndexOutOfBoundsException if i is not a valid index 
	 *  of the dynamic array.
	 * @param int : position of the array.
	 * @param String: string that puts at position i in a string.
	 */
	public void set(int i, String s) {
		if(i < 0 || i >= this.size())
			throw new IndexOutOfBoundsException();
		data[i] = s;
	}

	/**
	 * Returns a formatted string version of this dynamic array.
	 * 
	 * @return the formatted string
	 */
	public String toString() {
		String result = "[";
		if (size() > 0)
			result += get(0);

		for (int i = 1; i < size(); i++)
			result += ", " + get(i);

		return result + "] backing size: " + data.length;
	}
}
