class Solution {
    public int divide(int dividend, int divisor) {
        // Handle special case: Avoid integer overflow when dividend is Integer.MIN_VALUE and divisor is -1
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine the sign of the result (positive or negative)
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        
        // Ensure we work with positive values for division
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        
        // Initialize quotient to 0
        long quotient = 0;
        
        // Perform division using bit manipulation
        while (ldividend >= ldivisor) {
            long temp = ldivisor;
            long multiple = 1;
            
            // Find the largest multiple of the divisor that doesn't exceed the dividend
            while (ldividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            
            // Update dividend and quotient
            ldividend -= temp;
            quotient += multiple;
        }
        
        // Adjust sign and return the result as an integer
        return (int)(sign * quotient);
    }
}
