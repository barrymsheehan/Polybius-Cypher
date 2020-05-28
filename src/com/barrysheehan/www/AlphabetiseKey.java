package com.barrysheehan.www;

/*
 * Uses a quicksort algorithm found below to sort a character array into alphabetical order.
 * [https://www.youtube.com/watch?v=Fiot5yuwPAg]
 * Creates an integer array to keep track of the original indices of the character array.
 */

public class AlphabetiseKey {
	
	/*
	 * Sort character array into alphabetical order.
	 * Create integer array of same length and perform same transformations on it.
	 */
	public int[] getAlphabetisedKeyIndices(char[] key) {
		int[] indices = buildIndexArray(key);
		getAlphabetisedKeyIndices(key, indices, 0, key.length - 1);
		return indices;
	}
	
	private void getAlphabetisedKeyIndices(char[] characters, int[] indices, int low, int high) {
		if(low < (high + 1)) {
			int p = partitionByCharacter(characters, indices, low, high);
			getAlphabetisedKeyIndices(characters, indices, low, p -1);
			getAlphabetisedKeyIndices(characters, indices, p + 1, high);
		}
	}
	
	/*
	 * Create array same length as key, consisting of ascending integers beginning at 0.
	 * Integer array stores original indices of each character in key, but after sorting
	 * each integer is stored at the index of its corresponding character after
	 * alphabetisation.
	 */
	private int[] buildIndexArray(char[] key) {
		int[] indices = new int[key.length];
		for(int i = 0; i < key.length; i++) {
			indices[i] = i;
		}
		return indices;
	}
	
	/*
	 * Compare each item in array to pivot val
	 */
	private int partitionByCharacter(char[] characters, int[] indices, int low, int high) {
		swapCharacters(characters, indices, low, high);
		int border = low + 1;
		for(int i = border; i <= high; i++) {
			if(characters[i] < characters[low]) {
				swapCharacters(characters, indices, i, border++);
			}
		}
		swapCharacters(characters, indices, low, border -1);
		return border - 1;
	}
	
	/*
	 * Swap characters at two indices in two arrays
	 */
	private void swapCharacters(char[] characters, int[] indices, int index1, int index2) {
		char tempChar = characters[index1];
		characters[index1] = characters[index2];
		characters[index2] = tempChar;
		
		/*
		 * The same swap is performed on values in the integer array, indices
		 */
		int tempIndex = indices[index1];
		indices[index1] = indices[index2];
		indices[index2] = tempIndex;
	}
}