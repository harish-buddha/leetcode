class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 ||
            words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int wordCount = words.length;
        int totalLength = wordLength * wordCount;

        if (s.length() < totalLength) {
            return result;
        }

        Map<String, Integer> targetFreq = new HashMap<>();

        for (String word : words) {
            targetFreq.put(word,
                    targetFreq.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLength; offset++) {

            int left = offset;
            int right = offset;

            Map<String, Integer> windowFreq = new HashMap<>();
            int wordsUsed = 0;

            while (right + wordLength <= s.length()) {

                String currentWord =
                        s.substring(right, right + wordLength);

                right += wordLength;

                if (!targetFreq.containsKey(currentWord)) {
                    windowFreq.clear();
                    wordsUsed = 0;
                    left = right;
                    continue;
                }

                windowFreq.put(
                        currentWord,
                        windowFreq.getOrDefault(currentWord, 0) + 1
                );

                wordsUsed++;

                while (windowFreq.get(currentWord)
                        > targetFreq.get(currentWord)) {

                    String leftWord =
                            s.substring(left, left + wordLength);

                    windowFreq.put(
                            leftWord,
                            windowFreq.get(leftWord) - 1
                    );

                    left += wordLength;
                    wordsUsed--;
                }

                if (wordsUsed == wordCount) {

                    result.add(left);

                    String leftWord =
                            s.substring(left, left + wordLength);

                    windowFreq.put(
                            leftWord,
                            windowFreq.get(leftWord) - 1
                    );

                    left += wordLength;
                    wordsUsed--;
                }
            }
        }

        return result;
    }
}