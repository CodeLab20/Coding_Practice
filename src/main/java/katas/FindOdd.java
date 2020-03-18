package katas;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 	Given an array, find the integer that appears an odd number of times.
	There will always be only one integer that appears an odd number of times.
 */

public class FindOdd {

	public static void main(String[] args) {
		System.out.println(FindOdd.findIt2(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));//5
		System.out.println(FindOdd.findIt2(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));//-1
		System.out.println(FindOdd.findIt2(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));//5
		System.out.println(FindOdd.findIt2(new int[]{10}));//10
		System.out.println(FindOdd.findIt2(new int[]{1,1,1,1,1,1,10,1,1,1,1}));//10
		System.out.println(FindOdd.findIt2(new int[]{5,4,3,2,1,5,4,3,2,10,10}));//1

	}

	public static int findIt(int[] a) {

		Map<Integer, Integer> numCounts = new HashMap<>();

		int[] nums = IntStream.of(a).filter(num -> numCounts.merge(num, 1, Integer::sum) %2 == 1 ).toArray();

		OptionalInt oddnum = Arrays.stream(nums).filter(nm -> numCounts.get(nm)%2 == 1 ).findFirst();

		return  (oddnum.isPresent())? oddnum.getAsInt() : -9999;

	}

	public static int findIt2(int[] A) {
		 return Arrays.stream(A).reduce(0, (x, y) -> x ^ y);
	}
	
	 public static int findIt3(int[] a) {
		    return Arrays.stream(a)
		                 .boxed()
		                 .collect(Collectors.groupingBy(Function.identity()))
		                 .entrySet()
		                 .stream()
		                 .filter(e -> e.getValue().size() % 2 == 1)
		                 .mapToInt(e -> e.getKey())
		                 .findFirst()
		                 .getAsInt();
		    }  

}
