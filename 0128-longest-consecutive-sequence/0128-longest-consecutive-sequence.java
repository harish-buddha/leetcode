class Solution {
    public int longestConsecutive(int[] nums) {
         Set<Integer> numberSet = new HashSet<>();

        // Store all numbers
        for (int number : nums) {
            numberSet.add(number);
        }

        int longestLength = 0;

        for (int number : numberSet) {

            // Only begin from the start of a sequence
            if (!numberSet.contains(number - 1)) {

                int currentNumber = number;
                int currentLength = 1;

                while (numberSet.contains(currentNumber + 1)) {
                    currentNumber++;
                    currentLength++;
                }

                longestLength = Math.max(longestLength, currentLength);
            }
        }

        return longestLength;
    }
}