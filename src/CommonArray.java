import java.util.Arrays;

public class CommonArray {

    /*
    * You are given two 0-indexed integer permutations A and B of length n.

A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.

Return the prefix common array of A and B.

A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.



Example 1:

Input: A = [1,3,2,4], B = [3,1,2,4]
Output: [0,2,3,4]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.

Example 2:

Input: A = [2,3,1], B = [3,1,2]
Output: [0,1,3]
Explanation: At i = 0: no number is common, so C[0] = 0.
At i = 1: only 3 is common in A and B, so C[1] = 1.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.

    *
    *
    *
    * */
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] c = new int[n];
        int[] freq = new int[n+1];
        int common=0;

        for (int i =0;i<n;i++){
            freq[A[i]]++;
            if(freq[A[i]]==2){
                common++;
            }
            System.out.println("after A "+ common);
            System.out.println("after A "+ Arrays.toString(freq));
            freq[B[i]]++;
            if(freq[B[i]]==2){
                common++;
            }
            System.out.println("after B "+ common);
            System.out.println("after B "+ Arrays.toString(freq));
            c[i]= common;
            System.out.println("after C "+ Arrays.toString(c));
        }
      return c;
    }

    static void main(String[] args) {
        int[] a = {2,4,3,1};
        int[] b = {4,3,2,1};
        int[] c= findThePrefixCommonArray(a,b);
        System.out.println(Arrays.toString(c));
    }

}
