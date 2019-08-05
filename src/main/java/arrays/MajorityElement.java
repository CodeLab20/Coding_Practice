package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * https://www.geeksforgeeks.org/majority-element/
 * Moore’s Voting Algorithm
 * Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times in the array.
 *
 * Input:
 * The first line of the input contains T denoting the number of testcases. The first line of the test case will be the size of array and second line will be the elements of the array.
 *
 * Output:
 * For each test case the output will be the majority element of the array. Output "-1" if no majority element is there in the array.
 *
 * Constraints:
 * 1 <= T<= 100
 * 1 <= N <= 107
 * 0 <= Ai <= 106
 *
 * Example:
 * Input:
 * 2
 * 5
 * 3 1 3 3 2
 * 3
 * 1 2 3
 *
 * Output:
 * 3
 * -1
 *
 * Explanation:
 * Testcase 1: Since, 3 is present more than N/2 times, so it is the majority element.
 */
public class MajorityElement {
    public static void main (String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(in.readLine());
        for(int i = 0; i<T; i++ )
        {
            int N = Integer.parseInt(in.readLine());
            String l = in.readLine();

            Integer num = getMajorityElementOptimized(N, l);

            System.out.println(num);
        }
    }

    private static Integer getMajorityElementOptimized(int n, String l) {
        Integer[] s1 = Stream.of(l.split(" ")).mapToInt(s -> Integer.valueOf(s)).boxed().collect(Collectors.toList()).toArray(new Integer[]{});

        Integer cand = findCandidate(s1);

        boolean isMajor =  isMajority(s1, n, cand);

        return isMajor ? cand : -1;
    }

    private static boolean isMajority(Integer[] s1, int n, Integer cand) {
        int count = 0;
        for(int i=0; i<n; i++)
            if(s1[i] == cand)
                count++;
        if(count > (n/2))
            return true;
        else
            return false;
    }

    private static Integer findCandidate(Integer[] a) {
        int maj_index = 0, count = 1;

        for(int i=1; i< a.length; i++)
        {
            if(a[maj_index] == a[i])
                count++;
            else
                count--;

            if(count == 0)
            {
                maj_index = i;
                count = 1;
            }
        }
        return a[maj_index];
    }

    //Non optimized
    private static String getMajorityElement_nonOptimized(int n, String l) {

        Map<String, Long> collect = Arrays.asList(l.split(" ")).stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long max = 1L; String num = "-1";
        for(Map.Entry<String, Long> etr : collect.entrySet())
        {
            if(max < etr.getValue())
            {
                max = etr.getValue();
                num = etr.getKey();
            }
        }

        if(max < (n /2))
            num = "-1";
        return num;
    }
}
