import java.util.HashMap;
import java.util.Map;

public class ScrambleString {

    // Memoization map to store results of subproblems
    private static Map<String, Boolean> memo = new HashMap<>();

    public static boolean isScramble(String s1, String s2) {
        // Base case 1: If strings are identical, they are scrambled versions of each other
        if (s1.equals(s2)) {
            return true;
        }

        // Base case 2: If lengths don't match, they can't be scrambled
        if (s1.length() != s2.length()) {
            return false;
        }

        // Check if the result is already computed
        String key = s1 + "#" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Optimization (Pruning): If they don't have the exact same characters, they can't match
        if (!hasSameCharacters(s1, s2)) {
            memo.put(key, false);
            return false;
        }

        int n = s1.length();

        // Try splitting the string at every possible index i
        for (int i = 1; i < n; i++) {
            // Case 1: No swap (left matches left, right matches right)
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))) {
                memo.put(key, true);
                return true;
            }

            // Case 2: Swapped (left matches right, right matches left)
            if (isScramble(s1.substring(0, i), s2.substring(n - i)) &&
                    isScramble(s1.substring(i), s2.substring(0, n - i))) {
                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    // Helper method to check if two strings are anagrams of each other
    private static boolean hasSameCharacters(String s1, String s2) {
        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) return false;
        }
        return true;
    }

    static void main(String[] args) {
       System.out.println(isScramble("greats","argeat"));
    }
}
