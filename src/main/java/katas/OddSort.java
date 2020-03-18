package katas;

import java.util.Arrays;

/**
 * 
	You have an array of numbers.
	Your task is to sort ascending odd numbers but even numbers must be on their places.
	
	Zero isn't an odd number and you don't need to move it. If you have an empty array, you need to return it.
	
	Example
	
	sortArray([5, 3, 2, 8, 1, 4]) == [1, 3, 2, 8, 5, 4]
 *
 */

public class OddSort {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortArray(5, 3, 2, 8, 1, 4)));
		System.out.println(Arrays.toString(sortArray(5, 3, 1, 8, 0)));

	}

	public static int[] sortArray(int... array) {
		//Check for empty array
		if(array.length == 0) 
			return array;
		
		for(int i=0; i< array.length; i++) {
			//if first number is even, continue.
			if(array[i] %2  == 0 )
				continue;
			
			for(int j=i+1; j<array.length; j++) {
				
				//if second number is even, iterate till you find odd number
				if(array[j]%2 == 0 )
				{
					for(; j<array.length; j++)
					{
						if(array[j] %2  == 0 )
							continue;
						else 
							break;
					}
					if(j == array.length)
						continue;
				}
				
				//compare and replace both numbers 
				if( ( array[i] > array[j]) )
				{
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
		return array;
	}
	
	public static int[] sortArray2(final int[] array) {

	    // Sort the odd numbers only
	    final int[] sortedOdd = Arrays.stream(array).filter(e -> e % 2 == 1).sorted().toArray();
	    
	    // Then merge them back into original array
	    for (int j = 0, s = 0; j < array.length; j++) {
	      if (array[j] % 2 == 1) array[j] = sortedOdd[s++];
	    }
	    
	    return array;
	  }
	
	public static int[] sortArray3(int[] array) {
		java.util.PrimitiveIterator.OfInt sortedOdds = java.util.stream.IntStream
	        .of(array)
	        .filter(i -> i % 2 == 1)
	        .sorted()
	        .iterator();

	    return java.util.stream.IntStream
	        .of(array)
	        .map(i -> i % 2 == 0 ? i : sortedOdds.nextInt())
	        .toArray();  
	      }

}
