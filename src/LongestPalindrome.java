public class LongestPalindrome {

    public static String findingLongestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome (e.g., "aba")
            int len1 = expandAroundCenter(s, i, i);
            // Even length palindrome (e.g., "abba")
            int len2 = expandAroundCenter(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

            // If we found a longer palindrome, update our start and end pointers
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // Helper method to expand outwards and find the length of the palindrome
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // Length of the palindrome found
        return right - left - 1;
    }

    static void main(String[] args) {
        System.out.println(findingLongestPalindrome("Apple"));
        System.out.println(findingLongestPalindrome("nitin"));
        System.out.println(findingLongestPalindrome("ssdsdaaaad"));
    }
}
