class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending in 0 (other than 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber / 10
        // For example, when x = 12321, at the end of the loop we get x = 12, revertedNumber = 123
        // Since the middle digit doesn't matter in a palindrome (it's equal to itself), we simply remove it.
        return x == revertedNumber || x == revertedNumber / 10;
    }
}