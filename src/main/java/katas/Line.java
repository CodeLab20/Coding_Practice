package katas;

import java.util.Arrays;

/**
 * The new "Avengers" movie has just been released! There are a lot of people at the cinema box office standing in a huge line. 
 * Each of them has a single 100, 50 or 25 dollar bill. An "Avengers" ticket costs 25 dollars.

Vasya is currently working as a clerk. He wants to sell a ticket to every single person in this line.

Can Vasya sell a ticket to every person and give change if he initially has no money and sells the 
tickets strictly in the order people queue?

Return YES, if Vasya can sell a ticket to every person and give change with the bills he has at hand at that moment.
Otherwise return NO.

Examples:
Line.Tickets(new int[] {25, 25, 50}) // => YES 
Line.Tickets(new int[]{25, 100}) // => NO. Vasya will not have enough money to give change to 100 dollars
Line.Tickets(new int[] {25, 25, 50, 50, 100}) // => NO. Vasya will not have the right bills to give 75 dollars of change (you can't make two bills of 25 from one of 50)
 *
 */
public class Line {

	private static final String YES = "YES";
	private static final String NO = "NO";

	public static void main(String[] args) {
		System.out.println(Line.Tickets(new int[] {25, 25, 50}));//YES
		System.out.println(Line.Tickets(new int[] {25, 100}));//NO
		System.out.println(Line.Tickets(new int[] {25, 25, 50, 50, 100}));//NO
		System.out.println(Line.Tickets(new int[] {25, 25, 25, 25, 50, 100, 50}));//YES

	}
	
	public static String Tickets(int[] peopleInLine)
	  {
		System.out.println(java.util.Arrays.toString(peopleInLine));
	    int price = 25;
	    int change = 0;
	    int n25bills = 0;
	    int n50bills = 0;
	    int n100bills = 0;
	    
	    for(int p : peopleInLine)
	    {
	    	change = p - price;
	    	
	    	if(change == 0)
	    	{
	    		n25bills++;
	    	}else if(change == 25)
	    	{
	    		if(n25bills > 0)
	    			n25bills--;
	    		else 
	    			return NO;
	    		n50bills++;
	    	}
	    	else if(change == 75)
	    	{
	    		if(n50bills >=1 && n25bills >=1 )
	    		{
	    			n50bills--;
	    			n25bills--;
	    		}
	    		else if(n25bills >= 3 )
	    			n25bills -= 3;
	    		else 
	    			return NO;
	    		
	    		n100bills++;
	    	}
	    }
	    
		return YES;
	  }

}
