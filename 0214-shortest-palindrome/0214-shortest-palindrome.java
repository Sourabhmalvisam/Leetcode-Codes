class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        int len = combined.length();

        int[] lps = new int[len]; // Longest Prefix-Suffix match

        // Calculate LPS array
        for (int i = 1; i < len; i++) {
            int j = lps[i - 1];
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = lps[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            lps[i] = j;
        }

        // Determine prefix to add to the original string
        String prefix = rev.substring(0, n - lps[len - 1]);

        // Construct the shortest palindrome by adding the prefix to the original string
        return prefix + s;
    }
}
