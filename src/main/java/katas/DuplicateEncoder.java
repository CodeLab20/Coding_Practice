package katas;

import java.util.stream.Collectors;

/**
 * The goal of this exercise is to convert a string to a new string where each character in the new string is "(" if that 
 * character appears only once in the original string, or ")" if that character appears more than once in the original string. 
 * Ignore capitalization when determining if a character is a duplicate.

	Examples
	"din"      =>  "((("
	"recede"   =>  "()()()"
	"Success"  =>  ")())())"
	"(( @"     =>  "))((" 
 *
 */

public class DuplicateEncoder {

	public static void main(String[] args) {
		System.out.println(DuplicateEncoder.encode("Prespecialized"));//  )()())()(()()(
		System.out.println(DuplicateEncoder.encode("   ()(   "));//  "))))())))"

	}

	static String encode(String word){
		String uWord = word.toUpperCase();
		String enc = uWord.chars().mapToObj(c -> {
			int idx = uWord.indexOf(c);
			int fidx = uWord.indexOf(c, idx +1);
			return fidx == -1 ? "(" : ")";
		}).collect(Collectors.joining());
		
	    return enc;
	  }
}
