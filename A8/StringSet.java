package a8;

// A StringSet is a collection of non-null strings, with no duplicates
// (i.e., no two elements may be equal).  
public class StringSet {

	private DynamicArray2 da;

	// To hold the set data, use a DynamicArray.
	// Creates an empty StringSet object
	public StringSet() {
		da = new DynamicArray2();
	}

	/**   Throws an IllegalArgumentException if e is null, otherwise adds 
     * e to the set if there is not already an element in the set equal
     *  to e
     * @param String: element trying to insert to the set.
     */
	public void insert(String e) {
		if (e == null) {
			throw new IllegalArgumentException();
		}

		if (!contains(e)) {
			da.add(e);
		}
	}

	/**
	 * Throws an IllegalArgumentException if e is null, otherwise indicates whether
	 * the set contains e
	 * 
	 * @param String e: element, trying to search
	 * @return boolean: weather the set has e or not .
	 */
	public boolean contains(String e) {
		if (e == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < this.size(); i++) {
			if (e.equals(da.get(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Throws an IllegalArgumentException if e is null, otherwise removes e from the
	 * set
	 * 
	 * @param String e : remove the e from the string set.
	 */
	public void remove(String e) {
		if (e == null) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < da.size(); i++) {
			if (e.equals(da.get(i))) {
				da.remove(i);
			}
		}
	}

	/**
	 * Returns the number of strings in the set
	 * 
	 * @return int: the number of the strings.
	 */
	public int size() {
		return da.size();
	}

	/**
	 * compute two String sets , but only adds the elements that doesnt exist in the
	 * originally string sets. Throws an IllegalArgumentException if other is null.
	 * 
	 * @param Stringset other: a string to compute with the original one.
	 * @return String set: the new String set that is union.
	 */
	public StringSet union(StringSet other) {
		if (other == null) {
			throw new IllegalArgumentException();
		}

		StringSet union = new StringSet();
		union.da = this.da;

		for (int i = 0; i < other.size(); i++) {
			union.insert(other.da.get(i));
		}

		return union;
	}

	/**
	 * Computes and returns a string set that only have the elements exist in both
	 * string sets.
	 * 
	 * @param String set other:
	 * @return String set intersection: the new string set that only has the value
	 *         that exist in both string sets.
	 */
	public StringSet intersection(StringSet other) {
		StringSet intersect = new StringSet();
		String temp = "";
		for (int i = 0; i < other.size(); i++) {
			temp = other.da.get(i);
			if (this.contains(temp)) {
				intersect.insert(temp);
			}
		}
		return intersect;
	}

	/**
     * Returns a formatted string version of this set.
     */
 
	public String toString() {
		String result = "{";
		if (da.size() > 0)
			result += da.get(0);

		for (int i = 1; i < size(); i++)
			result += ", " + da.get(i);

		return result + "}";

	}
}