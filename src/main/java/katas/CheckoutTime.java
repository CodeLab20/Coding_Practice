package katas;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Stream;

/*
	 There is a queue for the self-checkout tills at the supermarket. 
	 Your task is write a function to calculate the total time required for all the customers to check out!

	input
	customers: an array of positive integers representing the queue. 
	Each integer represents a customer, and its value is the amount of time they require to check out.
	n: a positive integer, the number of checkout tills.
	output
	The function should return an integer, the total time required.

	Important
	Please look at the examples and clarifications below, to ensure you understand the task correctly :)

	Examples
	queueTime([5,3,4], 1)
	// should return 12
	// because when there is 1 till, the total time is just the sum of the times

	queueTime([10,2,3,3], 2)
	// should return 10
	// because here n=2 and the 2nd, 3rd, and 4th people in the 
	// queue finish before the 1st person has finished.

	queueTime([2,3,10], 2)
	// should return 12
	Clarifications
	There is only ONE queue serving many tills, and
	The order of the queue NEVER changes, and
	The front person in the queue (i.e. the first element in the array/list) proceeds to a till as soon as it becomes free.
	N.B. You should assume that all the test input will be valid, as specified above.

	P.S. The situation in this kata can be likened to the more-computer-science-related idea of a thread pool,
	 with relation to running multiple processes at the same time: https://en.wikipedia.org/wiki/Thread_pool
 * */

public class CheckoutTime {

	public static void main(String[] args) {
//		System.out.println(CheckoutTime.solveSuperMarketQueue(new int[] {1,2}, 1));//3
//		System.out.println(CheckoutTime.solveSuperMarketQueue(new int[] {1,2,3}, 1));//4
		System.out.println(CheckoutTime.solveSuperMarketQueue(new int[] {1,2,3, 1}, 1));//7
		System.out.println(CheckoutTime.solveSuperMarketQueue(new int[] {1,2,3, 1}, 2));//7p
//		System.out.println(CheckoutTime.solveSuperMarketQueue(new int[] {10,2,3,3}, 1));//18
//		System.out.println(CheckoutTime.solveSuperMarketQueue(new int[] {10,2,3,3}, 2));//10
		//		System.out.println(CheckoutTime.solveSuperMarketQueue(new int[] {2,3,10}, 2));//12
		//		System.out.println(CheckoutTime.solveSuperMarketQueue(new int[] { 2, 2, 3, 3, 4, 4 }, 2));//9
		//		System.out.println(CheckoutTime.solveSuperMarketQueue(new int[] {  }, 1));//0
		//		System.out.println(CheckoutTime.solveSuperMarketQueue(new int[] {1, 2, 3, 4, 5}, 1));//15

	}

//	public static int solveSuperMarketQueue(int[] customers, int tills) {
//		int time = 0;
//		int j=0;
//
//		int counters[] = new int[tills];
//
//		while( j < customers.length)
//		{
//			for(int t=0; t<tills; t++)
//			{
//				int tmpT = counters[t];
//				
//				if(tmpT == 0)
//				{
//					counters[t] = customers[j];
//					j++;
//				}
//				else
//				{
//					counters[t] = --tmpT;
//				}
//				time++;
//			}
//		}
//
//
//
//		return time;
//	}
	
	public static int solveSuperMarketQueue(int[] customers, int tills) {
		if(customers == null || customers.length == 0)
			return 0;
		
		if(tills == 1)
			return Arrays.stream(customers).sum();
		
		int totalTime=0;
		int to=0;
		int from = 0;
		
		while(true)
		{
			if(to >=customers.length)
				break;
			
			to = (from + tills) > customers.length ? customers.length : from + tills;
			int[] subArr = Arrays.copyOfRange(customers, from, to);
			
			int subMin = Arrays.stream(subArr).min().getAsInt();
			
			
		}
		
		
			
		
		



		return totalTime;
	}

}
