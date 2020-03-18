package katas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/*
 Enough is enough!
Alice and Bob were on a holiday. Both of them took many pictures of the places they've been, 
and now they want to show Charlie their entire collection. However, Charlie doesn't like this sessions, 
since the motive usually repeats. He isn't fond of seeing the Eiffel tower 40 times. 
He tells them that he will only sit during the session if they show the same motive at most N times. 
Luckily, Alice and Bob are able to encode the motive as a number. Can you help them to remove numbers such that 
their list contains each number only up to N times, without changing the order?

Task
Given a list lst and a number N, create a new list that contains each number of lst at most N times without reordering.
For example if N = 2, and the input is [1,2,3,1,2,1,2,3], you take [1,2,3,1,2], drop the next [1,2] 
since this would lead to 1 and 2 being in the result 3 times, and then take 3, which leads to [1,2,3,1,2,3].

Example
EnoughIsEnough.deleteNth(new int[] {20,37,20,21}, 1) // return [20,37,21]
EnoughIsEnough.deleteNth(new int[] {1,1,3,3,7,2,2,2,2}, 3) // return [1, 1, 3, 3, 7, 2, 2, 2]
 
 
 * */

public class EnoughIsEnough {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(deleteNth(new int[] { 20, 37, 20, 21 }, 1) ) );	//20, 37, 21
		System.out.println(Arrays.toString(deleteNth(new int[] {1, 1, 3, 3, 7, 2, 2, 2, 2}, 3) ) );//1, 1, 3, 3, 7, 2, 2, 2
		
		//1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5
		System.out.println(Arrays.toString(deleteNth(new int[] {1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1}, 3) ) );
		System.out.println(Arrays.toString(deleteNth(new int[] { 1, 1, 1, 1, 1 }, 5) ) );//1, 1, 1, 1, 1 
		System.out.println(Arrays.toString(deleteNth(new int[] { 0, 1, 1, 1, 1, 1 }, 5) ) );//0,1, 1, 1, 1, 1 
		System.out.println(Arrays.toString(deleteNth(new int[] {}, 5) ) );//{}
	}
	
	public static int[] deleteNth(int[] elements, int maxOccurrences) {
		
		if(elements.length == 0)
			return elements;
		
		Map<Integer, Integer> numCounts = new HashMap<Integer, Integer>(elements.length);
		int[] arr = new int[elements.length];
		Arrays.fill(arr, -9999);
		int j=0;
		
		for(int i=0; i<elements.length; i++)
		{
			int tmp = elements[i];
			
			int count = numCounts.getOrDefault(tmp, 1);
			
			if(count < maxOccurrences)
				arr[j++] = tmp;

			count++;
			
			numCounts.put(tmp, count);
		}
		
		return Arrays.stream(arr).filter(i -> i!=-9999).toArray();
	}
	
	public static int[] deleteNth2(int[] elements, int maxOccurrences) {
	    Map<Integer, Integer> numCounts = new HashMap<>();
	    
	    return IntStream.of(elements)
	      .filter(elem -> numCounts.merge(elem, 1, Integer::sum) <= maxOccurrences)
	      .toArray();
	  }

}
