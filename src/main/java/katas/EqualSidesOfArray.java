package katas;

import java.util.Arrays;

/*
	Let's say you are given the array {1,2,3,4,3,2,1}:
	Your function will return the index 3, because at the 3rd position of the array, 
	the sum of left side of the index ({1,2,3}) and the sum of the right side of the index ({3,2,1}) both equal 6.
	
	Let's look at another one.
	You are given the array {1,100,50,-51,1,1}:
	Your function will return the index 1, because at the 1st position of the array, 
	the sum of left side of the index ({1}) and the sum of the right side of the index ({50,-51,1,1}) both equal 1.
	
	Last one:
	You are given the array {20,10,-80,10,10,15,35}
	At index 0 the left side is {}
	The right side is {10,-80,10,10,15,35}
	They both are equal to 0 when added. (Empty arrays are equal to 0 in this problem)
	Index 0 is the place where the left side and right side are equal.
	
	Note: Please remember that in most programming/scripting languages the index of an array starts at 0.
	
	Input:
	An integer array of length 0 < arr < 1000. The numbers in the array can be any integer positive or negative.
	
	Output:
	The lowest index N where the side to the left of N is equal to the side to the right of N. If you do not find an index that fits these rules, then you will return -1.
	
	Note:
	If you are given an array with multiple answers, return the lowest correct index.
*/

public class EqualSidesOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(EqualSidesOfArray.findEvenIndex(new int[] {1,2,3,4,3,2,1}));//3
		System.out.println(EqualSidesOfArray.findEvenIndex(new int[] {1,100,50,-51,1,1}));//1
		System.out.println(EqualSidesOfArray.findEvenIndex(new int[] {1,2,3,4,5,6}));//-1
		System.out.println(EqualSidesOfArray.findEvenIndex(new int[] {20,10,30,10,10,15,35}));//3
		System.out.println(EqualSidesOfArray.findEvenIndex(new int[] {-8505, -5130, 1926, -9026}));//-1
		System.out.println(EqualSidesOfArray.findEvenIndex(new int[] {2824, 1774, -1490, -9084, -9696, 23094}));//1
		System.out.println(EqualSidesOfArray.findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));//6
		System.out.println(EqualSidesOfArray.findEvenIndex(new int[] {20,10,-80,10,10,15,35}));//0

	}
	
	public static int findEvenIndex(int[] arr) {
		int arrSum = Arrays.stream(arr).sum();
		
		int leftSum = 0;
		
		for(int i=0; i<arr.length; i++)
		{
			if( ( leftSum - (arrSum - (leftSum + arr[i]) )) != 0 )
				leftSum += arr[i];
			else
				return i;
		}
		
		return -1;
	  }

}
