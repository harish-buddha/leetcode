class WordDictionary {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int index, TrieNode node) {
        // We have processed the entire search pattern.
        if (index == word.length()) {
            return node.isEndOfWord;
        }

        char ch = word.charAt(index);

        // Normal character: follow exactly one Trie path.
        if (ch != '.') {
            int childIndex = ch - 'a';

            if (node.children[childIndex] == null) {
                return false;
            }

            return search(word, index + 1, node.children[childIndex]);
        }

        // '.': try every possible child.
        for (TrieNode child : node.children) {
            if (child != null && search(word, index + 1, child)) {
                return true;
            }
        }

        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */