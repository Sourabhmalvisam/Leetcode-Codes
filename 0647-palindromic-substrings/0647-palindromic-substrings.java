class Solution {
    public int countSubstrings(String s) {
        int res = 0;  // Initialize count for palindromic substrings
        
        for (int i = 0; i < s.length(); i++) {
            res += countPali(s, i, i);  // Count odd-length palindromes
            res += countPali(s, i, i + 1);  // Count even-length palindromes
        }
        
        return res;
    }
    
    public int countPali(String s, int l, int r) {
        int res = 0;  // Initialize count for palindromes
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {  // Expand the palindrome
            res += 1;  // Increment count for each valid palindrome
            l--;  // Move left pointer
            r++;  // Move right pointer
        }
        return res;
    }
}
