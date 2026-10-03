class Solution {

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    private final List<String> result = new ArrayList<>();
    private int rows;
    private int cols;

    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length;
        cols = board[0].length;

        TrieNode root = buildTrie(words);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dfs(board, row, col, root);
            }
        }

        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode current = root;

            for (char ch : word.toCharArray()) {
                int index = ch - 'a';

                if (current.children[index] == null) {
                    current.children[index] = new TrieNode();
                }

                current = current.children[index];
            }

            // Store the complete word at its terminal node.
            current.word = word;
        }

        return root;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node) {
        // Boundary check.
        if (row < 0 || row >= rows ||
            col < 0 || col >= cols) {
            return;
        }

        char ch = board[row][col];

        // '#' means this cell is already used in the current path.
        if (ch == '#') {
            return;
        }

        TrieNode next = node.children[ch - 'a'];

        // No word has this prefix.
        if (next == null) {
            return;
        }

        // A complete word has been found.
        if (next.word != null) {
            result.add(next.word);

            // Prevent adding the same word again.
            next.word = null;
        }

        // Mark current cell as visited.
        board[row][col] = '#';

        dfs(board, row + 1, col, next);
        dfs(board, row - 1, col, next);
        dfs(board, row, col + 1, next);
        dfs(board, row, col - 1, next);

        // Backtrack.
        board[row][col] = ch;
    }
}