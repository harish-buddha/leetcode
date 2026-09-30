class Solution {
    public int[][] merge(int[][] intervals) {
         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] current : intervals) {
            // No overlap with the last merged interval.
            if (merged.isEmpty()
                    || current[0] > merged.get(merged.size() - 1)[1]) {

                merged.add(new int[]{current[0], current[1]});

            } else {
                // Overlap: extend the end of the last merged interval.
                int[] last = merged.get(merged.size() - 1);
                last[1] = Math.max(last[1], current[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}