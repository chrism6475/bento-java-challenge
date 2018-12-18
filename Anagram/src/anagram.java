/* 
 *  Problem: Taking the the list of words below, output all word pairs that are “anagrams” of each other. Please
	display each anagram word pair to System.out.
	
	Input: 
	Output: 

*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class anagram {
	
	public static boolean checkAnagram(String worda, String wordb) {
		
		if (worda.length() != wordb.length()) {
			return false;
		}
		
		if (worda == wordb) {
			return false;
		}
		
		Map<Character, Integer> present_words = new HashMap<>();
		
		for (char letter: worda.toCharArray())
		{
			if (present_words.containsKey(letter)) {
				present_words.put(letter, present_words.get(letter));
			}
			else { 
				present_words.put(letter, 1);
			}
		}
		
		for (char letter: wordb.toCharArray()) {
			if (present_words.containsKey(letter)) {
				present_words.put(letter, present_words.get(letter)-1);
				if(present_words.get(letter) == 0) {
					present_words.remove(letter);
				}
			} else {
			}
		}
		
		return true;
	}
	/* Function Identify Anagram
		Parameters: words - String[], array of words to identify anagrams
		Output: System.out word pairs that are anagrams. 
	
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

