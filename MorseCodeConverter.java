import java.io.*; 
import java.util.*; 

public class MorseCodeConverter {
	static MorseCodeTree codeTree = new MorseCodeTree(); 
	

	public MorseCodeConverter() {
	}
	
	/**
	 * Converts a file of morse code into english. Each letter is delimited by a space
	 * each word is delimited by a /
	 * @param codeFile: name of the file that contains the morse code
	 * @return the english translation of the file
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException{
		String toEnglish = ""; 
		String[] word = null;
		String[] letter = null; 
		Scanner input; 
		input = new Scanner(codeFile);
		while(input.hasNext()) {							//Makes sure there the file is not empty
			for(int a = 0; a < word.length; a++) {
				letter = word[a].split(" "); 
				for(int b = 0; b < letter.length; b++) {
					toEnglish += codeTree.fetch(letter[b]); 
				}
				toEnglish += " " ; 
			} 
			toEnglish = toEnglish.trim(); 
		}
		return toEnglish; 
		
	}
	/**
	 * Converts morse code into English. each letter is delimited by a space
	 * Each word is delimited by a /
	 * @param code: The morse code
	 * @return The english translation
	 */
	public static String convertToEnglish(String code) {
		String toEnglish = "";									//String to converted the code to English
		String[] word = code.split(" / "); 						//Each word is split by a /
		String[] letter = code.split(" "); 		
		for(int a = 0; a < word.length; a++) {					//For loop that goes through the word
			letter = word[a].split(" "); 						//Separates each letter with a space
			for(int b = 0; b < letter.length; b++) {
				toEnglish += codeTree.fetch(letter[b]); 		//Fetches the data for the letter
			}
			toEnglish += " " ; 
		} 
		toEnglish = toEnglish.trim(); 							//Removes the space at the end of the string
		return toEnglish;										//Returns the string of morse translated to English
	}
	/**
	 * Returns a string with all the data in the tree in LNR order
	 * @return: The data in the tree in LNR order separated by a space
	 */
	public static String printTree() {
		ArrayList<String> strTree = new ArrayList<String>();	//ArrayList of the tree
		strTree = codeTree.toArrayList(); 						//Converts the morsecodetree object to an arraylist and sets it to the arraylist of the tree
		String str = ""; 
		for(int a = 0; a < strTree.size(); a++) {				//for loop goes through the arraylist
			str += strTree.get(a) + " "; 						//Adds each letter to the string
		}
		return str; 											//Returns the string
	}
}
