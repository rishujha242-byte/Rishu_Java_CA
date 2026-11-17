class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenE = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // Signs are only valid at the start or immediately after 'e' or 'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                // A dot is invalid if we have already seen a dot or an exponent 'e'
                if (seenDot || seenE) {
                    return false;
                }
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // An exponent is invalid if we've already seen 'e' or if no digits have appeared before it
                if (seenE || !seenDigit) {
                    return false;
                }
                seenE = true;
                seenDigit = false; // Reset digit flag to ensure the exponent is followed by an integer
            } else {
                // Any other character is invalid
                return false;
            }
        }
        
        return seenDigit;
    }
}