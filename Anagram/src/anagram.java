/* 
 *  Problem: Taking the the list of words below, output all word pairs that are “anagrams” of each other. Please
	display each anagram word pair to System.out.
	
	Input: 
	Output: 

*/
import java.util.HashMap;
import java.util.Map;

public class anagram {
	
	/* 
	 *  Function: checkAnagram. 
	 *	Parameters: wordA - string, first word to check for pair
	 *				wordB - string, second word to check
	 *	Output: System.out - word pairs that are anagrams. 
	*/
	public static boolean checkAnagram(String wordA, String wordB) {
		
		// If words are not the same length, exit function because they violate anagram rules. 
		if (wordA.length() != wordB.length()) {
			return false;
		}
		
		// Check if words are
		if (wordA == wordB) {
			return false;
		}
		
		// This hash map keeps track of chars/letters and their frequency per word
		Map<Character, Integer> present_letters = new HashMap<>();
		
		for (char letter: wordA.toCharArray())
		{
			if (present_letters.containsKey(letter)) {
				present_letters.put(letter, present_letters.get(letter));
			}
			else { 
				present_letters.put(letter, 1);
			}
		}
		
		for (char letter: wordB.toCharArray()) {
			if (present_letters.containsKey(letter)) {
				present_letters.put(letter, present_letters.get(letter)-1);
				if(present_letters.get(letter) == 0) {
					present_letters.remove(letter);
				}
			} 
		}
		// If hash map is not empty, matching letters in words were not found. 
		if (present_letters.size() != 0) {
			return false;
		}
		return true;
	}
	/* 
	 *  Function Identify Anagram
	 *	Parameters: words - String[], array of words to identify anagrams
	 *	Output: System.out word pairs that are anagrams. 
	*/
	public static void identifyAnagram(String[] words) {
		
		for (int i = 0; i< words.length-1; i++){
			for(int j = 0; j< words.length - 1; j++)
				if (checkAnagram(words[i],words[j]) == true && i != j) {
					System.out.println( '['+words[i] + ':' + words[j] + ']');
				}			
		}
	}
	public static void main(String[] args) {
		// Input string
		String [] words = {"bat", "gods", "latte", "name", "apres", "spit", "joke", "ham", "dog", 
				"act", "tale", "parse", "pits", "asper", "tab", "table", "mane", "late", "god", "cat",
				"table", "save", "spare"};
		identifyAnagram(words);
	}

}

