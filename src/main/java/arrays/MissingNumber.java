package arrays;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Given an array C of size N-1 and given that there are numbers from 1 to N with one element missing, the missing number is to be found.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. For each test case first line contains N(size of array). The subsequent line contains N-1 array elements.
 *
 * Output:
 * Print the missing number in array.
 *
 * Constraints:
 * 1 ≤ T ≤ 200
 * 1 ≤ N ≤ 107
 * 1 ≤ C[i] ≤ 107
 *
 * Example:
 * Input:
 * 2
 * 5
 * 1 2 3 5
 * 10
 * 1 2 3 4 5 6 7 8 10
 *
 * Output:
 * 4
 * 9
 *
 * Explanation:
 * Testcase 1: Given array : 1 2 3 5. Missing element is 4.
 */

public class MissingNumber {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
//        System.out.println("T:"+ T);

        for(int i = 0; i<T; i++ )
        {
            int N = in.nextInt();
//            System.out.println("N:" + N);
            String l = in.nextLine();
            l = in.nextLine();
//            System.out.println("l:" + l);

            int sum = Arrays.asList(l.split(" ")).stream().mapToInt(s -> Integer.valueOf(s)).sum();
            int expectedSum = N * (N+1)/2;
            System.out.println(expectedSum - sum);
        }
    }
}
