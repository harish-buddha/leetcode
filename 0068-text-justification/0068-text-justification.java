class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {

            int totalLetters = words[index].length();
            int last = index + 1;

            // Greedily pack words
            while (last < words.length) {
                if (totalLetters + 1 + words[last].length() > maxWidth) {
                    break;
                }
                totalLetters += 1 + words[last].length();
                last++;
            }

            StringBuilder line = new StringBuilder();
            int wordCount = last - index;

            // Last line or single-word line
            if (last == words.length || wordCount == 1) {

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i != last - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }

            } else {

                int lettersOnly = 0;
                for (int i = index; i < last; i++) {
                    lettersOnly += words[i].length();
                }

                int totalSpaces = maxWidth - lettersOnly;
                int gaps = wordCount - 1;

                int evenSpace = totalSpaces / gaps;
                int extra = totalSpaces % gaps;

                for (int i = index; i < last; i++) {

                    line.append(words[i]);

                    if (i == last - 1) {
                        continue;
                    }

                    int spaces = evenSpace;
                    if (extra > 0) {
                        spaces++;
                        extra--;
                    }

                    while (spaces-- > 0) {
                        line.append(" ");
                    }
                }
            }

            result.add(line.toString());
            index = last;
        }

        return result;
    }
}