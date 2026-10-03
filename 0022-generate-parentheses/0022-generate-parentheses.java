class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(n, 0, 0, new StringBuilder(), result);

        return result;
    }

    private void backtrack(
            int n,
            int open,
            int close,
            StringBuilder current,
            List<String> result) {

        // A complete valid combination has been formed.
        if (open == n && close == n) {
            result.add(current.toString());
            return;
        }

        // We can add '(' as long as we haven't used all n.
        if (open < n) {
            current.append('(');

            backtrack(n, open + 1, close, current, result);

            current.deleteCharAt(current.length() - 1);
        }

        // We can add ')' only if there is an unmatched '('.
        if (close < open) {
            current.append(')');

            backtrack(n, open, close + 1, current, result);

            current.deleteCharAt(current.length() - 1);
        }
    }
}