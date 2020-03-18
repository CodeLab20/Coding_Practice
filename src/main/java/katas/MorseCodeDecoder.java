package katas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MorseCodeDecoder {

	private static final Map<String, String> MorseCode = new HashMap<String, String>();
	
	static {
		
		String alphabets = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
		String morseCodes = ".- / -... / -.-. / -.. / . / ..-. / --. / .... / .. / .--- / -.- / .-.. / -- / -. / --- / .--. / --.- / .-. / ... / - / ..- / ...- / .-- / -..- / -.-- / --..";
		
		String[] chars = alphabets.split("\\s");
		String[] morsechars = morseCodes.split("/");
		
		for(int i=0;i<chars.length; i++)
			MorseCode.put(morsechars[i].trim(), chars[i].trim());
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(MorseCode);
		System.out.println(MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. ."));//HEY JUDE
		System.out.println(MorseCodeDecoder.decode(" ."));//E
	}
	
	public static String decode(String morseCode) {
		
        return Arrays.stream(morseCode.trim().split("\\s{3}")).map(wrd -> { 
        		String[] mChars = wrd.split("\\s");
        		return Arrays.stream(mChars).map(c -> MorseCode.get(c)).collect(Collectors.joining());
    		}).collect(Collectors.joining(" "));
		
    }
	
	public static String decode2(String morseCode) {
	    return Stream.of(morseCode.trim().split("   "))
	      .map(word -> Stream.of(word.split(" ")).map(MorseCode::get).collect(Collectors.joining()))
	      .collect(Collectors.joining(" "));
	  }

}
