class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {

            if (isOperator(token)) {
                int right = stack.pop();
                int left = stack.pop();

                int result;

                switch (token) {
                    case "+":
                        result = left + right;
                        break;

                    case "-":
                        result = left - right;
                        break;

                    case "*":
                        result = left * right;
                        break;

                    case "/":
                        result = left / right;
                        break;

                    default:
                        throw new IllegalArgumentException("Invalid operator");
                }

                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private boolean isOperator(String token) {
        return token.equals("+")
                || token.equals("-")
                || token.equals("*")
                || token.equals("/");
    }
}