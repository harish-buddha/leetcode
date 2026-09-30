class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        // If endWord is not available, transformation is impossible.
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process one complete BFS level.
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char[] chars = currentWord.toCharArray();

                // Try changing every character.
                for (int position = 0; position < chars.length; position++) {
                    char original = chars[position];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == original) {
                            continue;
                        }

                        chars[position] = ch;
                        String nextWord = new String(chars);

                        // Found the target.
                        if (nextWord.equals(endWord)) {
                            return level + 1;
                        }

                        // Valid and unvisited word.
                        if (wordSet.contains(nextWord)) {
                            wordSet.remove(nextWord);
                            queue.offer(nextWord);
                        }
                    }

                    // Restore original character.
                    chars[position] = original;
                }
            }

            level++;
        }

        return 0;
    }
}