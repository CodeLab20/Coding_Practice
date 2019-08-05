package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Given an array A of size N containing 0s, 1s, and 2s; you need to sort the array in ascending order.
 *
 * Input:
 * The first line contains an integer 'T' denoting the total number of test cases. Then T testcases follow.
   Each testcases contains two lines of input. The first line denotes the size of the array N.
   The second lines contains the elements of the array A separated by spaces.
 *
 * Output:
 * For each testcase, print the sorted array.
 *
 * Constraints:
 * 1 <= T <= 500
 * 1 <= N <= 106
 * 0 <= Ai <= 2
 *
 * Example:
 * Input :
 * 2
 * 5
 * 0 2 1 2 0
 * 3
 * 0 1 0
 *
 * Output:
 * 0 0 1 2 2
 * 0 0 1
 *
 * Explanation:
 * Testcase 1: After segregating the 0s, 1s and 2s, we have 0 0 1 2 2 which shown in the output.
 */

public class SortArray012 {
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

            printSortedArrayWith012(a);
        }
    }

    private static void printSortedArrayWith012(int[] a) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        for(int i =0; i < a.length; i++)
        {
            int num = a[i];
            if(num == 0)
                cnt0++;
            else if(num == 1)
                cnt1++;
            else
                cnt2++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<cnt0; i++)
            sb.append(0).append(" ");
        for(int i=0; i<cnt1; i++)
            sb.append(1).append(" ");
        for(int i=0; i<cnt2; i++)
            sb.append(2).append(" ");

        System.out.println(sb.toString());
    }
}
