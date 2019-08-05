package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Given an array of 0's and 1's your task is to complete the function maxLen which returns size of the largest sub array with equal number of 0's and 1's. The function maxLen takes 2 arguments. The first argument is the array A[] and second argument is the size 'N' of the array A[].
 *
 * Input:
 * The first line of the input is T denoting the number of test cases. Then T test cases follow . Each test case contains two lines. The first line of each test case is a number N denoting the size of the array and in the next line are N space separated values of A [].
 *
 * Output:
 * For each test case output in a new line the max length of the subarray.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 100
 * 0 <= A[] <= 1
 *
 * Example:
 * Input
 * 2
 * 4
 * 0 1 0 1
 * 5
 * 0 0 1 0 0
 *
 * Output
 * 4
 * 2
 *
 * Explanation:
 * Testacase 1: The array from index [0...3] contains equal number of 0's and 1's. Thus maximum length of subarray having equal number of 0's and 1's is 4
 */

/**Hints:
 * 1. Convert all the 0's to -1, thus the problem reduces to find the length of largest subarray giving sum 0.
 * 2. After converting 0's, we can maintain hashmap to keep track of indices of getting subarray sum equal to 0.
 * Also we will keep updating maxLen of subarray by subtracting last zero sum index from current index.
 * */

public class LargestSubArray0n1 {
    public static void main (String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for(int i = 0; i<T; i++ )
        {
            int N = Integer.parseInt(in.readLine());
            String l = in.readLine();

            int[] a = new int[N];
            int c = 0;
            for(String s : l.split(" "))
                a[c++] = Integer.parseInt(s);

            int maxLen =  getLargestSubArray0n1(a);

            System.out.println(maxLen );
        }
    }

    public static int getLargestSubArray0n1(int[] arr) {
        //replace all 0s with -1
        for(int i=0; i< arr.length; i++)
            if(arr[i] == 0)
                arr[i] = -1;

        //stores sum and its index
        Map<Integer, Integer> sum_index = new HashMap<>();
        int maxLen = 0, currSum = 0;

        for(int i =0; i< arr.length; i++)
        {
            //calculate current sum
            currSum += arr[i];

            if(sum_index.containsKey(currSum))
                maxLen = Math.max(maxLen, i - sum_index.get(currSum));
            else if(currSum == 0)
                maxLen = i + 1;
            else
                sum_index.put(currSum, i);
        }
        return  maxLen;
    }
}
