class Solution {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } 
            else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } 
            else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } 
            else if (ch == '(') {
                // Save the calculation outside this parenthesis.
                stack.push(result);
                stack.push(sign);

                // Start a fresh calculation inside parentheses.
                result = 0;
                sign = 1;
            } 
            else if (ch == ')') {
                // Complete the current number.
                result += sign * number;
                number = 0;

                // Restore the sign and result from before '('.
                int previousSign = stack.pop();
                int previousResult = stack.pop();

                result = previousResult + previousSign * result;
            }
        }

        // Add the final number.
        result += sign * number;

        return result; 
    }
}