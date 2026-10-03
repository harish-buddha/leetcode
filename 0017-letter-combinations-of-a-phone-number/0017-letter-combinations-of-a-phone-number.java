class Solution {

    private static final String[] PHONE = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        StringBuilder path = new StringBuilder();

        backtrack(digits, 0, path, result);

        return result;
    }

    private void backtrack(
            String digits,
            int index,
            StringBuilder path,
            List<String> result) {

        // A complete combination has been constructed.
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String letters = PHONE[digits.charAt(index) - '0'];

        for (char letter : letters.toCharArray()) {
            // Choose
            path.append(letter);

            // Explore
            backtrack(digits, index + 1, path, result);

            // Undo choice
            path.deleteCharAt(path.length() - 1);
        }
    }
}