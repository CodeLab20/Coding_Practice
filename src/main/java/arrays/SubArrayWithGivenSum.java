package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.
 *
 * Output:
 * For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals to subarray, else print -1.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 107
 * 1 <= Ai <= 1010
 *
 * Example:
 * Input:
 * 2
 * 5 12
 * 1 2 3 7 5
 * 10 15
 * 1 2 3 4 5 6 7 8 9 10
 * Output:
 * 2 4
 * 1 5
 *
 * Explanation :
 * Testcase1: sum of elements from 2nd position to 4th position is 12
 * Testcase2: sum of elements from 1st position to 5th position is 15
 */

/**
 * Hints::
 * We need to use Sliding window Method to solve this Problem.
 *
 * Add the elements, to currsum till it is less than S. If it becomes more than S, start deleting elements from start in the cuusum. if the currsum again becomes less than S, again start adding elements to it. In between also check, if the currsum becomes equal to S.
 * If yes, then output start and end index, else after traversing array no such solution is found, output -1.
 *******************************
 * The complete solution is
 *
 * Maintain start and last index to store and print these values
 * Iterate the complete array.
 * Add array elements to currsum
 * If currsum becomes greater than S, then remove elements starting from start index, till it become less than
     or equal to S, and increement start.
 * if currsum becomes equals to S, then print the starting and last index
 * if the currsum never maches to S, then print -1
 */

public class SubArrayWithGivenSum {
    public static void main (String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for(int i = 0; i<T; i++ )
        {
            String l0 = in.readLine();
            String[] ln = l0.split(" ");
            int N = Integer.parseInt(ln[0]);
            int sum = Integer.parseInt(ln[1]);

            String l = in.readLine();

            int[] a = new int[N];
            int c = 0;
            for(String s : l.split(" "))
                a[c++] = Integer.parseInt(s);

            printSubArrayWithGivenSum(a, sum);
        }
    }

    private static void printSubArrayWithGivenSum(int[] a, int sum) {
        int header = 0, currsum = 0;
        boolean found = false;

        for(int i=0; i<a.length; i++)
        {
            currsum += a[i];

            while (currsum > sum){
                currsum = currsum - a[header++];
            }

            if(currsum == sum){
                found = true;
                System.out.println((header+1) + " " + (i+1));
                break;
            }
        }

        if(! found)
            System.out.println("-1");
    }

}
