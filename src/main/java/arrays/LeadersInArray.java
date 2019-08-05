package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of positive integers. Your task is to find the leaders in the array.
 * Note: An element of array is leader if it is greater than or equal to all the elements to its right side. Also, the rightmost element is always a leader.
 *
 * Input:
 * The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows.
 * The first line of each test case contains a single integer N denoting the size of array.
 * The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
 *
 * Output:
 * Print all the leaders.
 *
 * Constraints:
 * 1 <= T <= 100
 * 1 <= N <= 107
 * 0 <= Ai <= 107
 *
 * Example:
 * Input:
 * 3
 * 6
 * 16 17 4 3 5 2
 * 5
 * 1 2 3 4 0
 * 5
 * 7 4 5 7 3
 * Output:
 * 17 5 2
 * 4 0
 * 7 7 3
 *
 * Explanation:
 * Testcase 3: All elements on the right of 7 (at index 0) are smaller than or equal to 7. Also, all the elements of right side of 7 (at index 3) are smaller than 7. And, the last element 3 is itself a leader since no elements are on its right.
 */
public class LeadersInArray {
    public static void main (String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for(int i = 0; i<T; i++ )
        {
            int N = Integer.parseInt(in.readLine());
            String l = in.readLine();

            List<Integer> arrayLeaders =  getLeadersOfArray(N, l);

            StringBuilder sb = new StringBuilder();
            int ldrSize = arrayLeaders.size();
            for(int j =  ldrSize-1; j >=0; j-- )
                sb.append(arrayLeaders.get(j)).append( " " );
            System.out.println(sb.toString());
        }
    }

    private static List<Integer> getLeadersOfArray(int n, String l) {
        int[] a = new int[n];
        int c = 0;
        for(String s : l.split(" "))
            a[c++] = Integer.parseInt(s);

        List<Integer> leaders = new ArrayList<>();
        int max = a[n-1];
        leaders.add(max);

        for(int i = (n-2); i>= 0; i--)
        {
            if(a[i] >= max)
            {
                max = a[i];
                leaders.add(max);
            }
        }
        return leaders;
    }
}
