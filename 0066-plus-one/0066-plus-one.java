class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carry needed, return updated array
            }
            digits[i] = 0; // Carry over, set current digit to 0
        }
        
        // If all digits were 9, we need a new array with an extra leading 1
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}