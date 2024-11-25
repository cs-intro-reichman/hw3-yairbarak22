/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		int i = 0;
		while ( i < str1.length()) {
			int index = str2.indexOf(str1.charAt(i));
			if (index < 0 ) {
				
				return false;
			}
			i++;
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String newstr = "";
		int i=0;
		str = str.toLowerCase();
		String letters = "abcdefghijklmnopqrstuvwxyz";
		while ( i < (str.length())) { 
			int index = letters.indexOf(str.charAt(i));
			if(index >= 0) newstr += str.charAt(i);
			char x = str.charAt(i);
			if (x == ' ') newstr += str.charAt(i); 
			i++;
			}
			
		return newstr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		// לסדר מחרוזת
		//לבנות מחרוזת חדשה
		// להגריל תו אחד כל פעם ולהכניס אותו למחרוזת החדשה
		// 
		str = preProcess(str);
		String dynstr = "";
		String newstr = "";
		int i = 0;
		
		while (i < str.length()) {
			int m = (int) (Math.random() * str.length());		
			if (dynstr.indexOf((char) m) == -1) {
				newstr += str.charAt(m);
				dynstr += (char) m;
				i++;
			}
			}

		

		return newstr;
	}
}
