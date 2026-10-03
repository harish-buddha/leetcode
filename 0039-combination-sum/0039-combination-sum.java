class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int[] candidates,
            int remaining,
            int start,
            List<Integer> current,
            List<List<Integer>> result) {

        // Found a valid combination.
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Since candidates are sorted, all later values
            // will also be too large.
            if (candidates[i] > remaining) {
                break;
            }

            // Choose the current candidate.
            current.add(candidates[i]);

            // Pass i, not i + 1, because the same number
            // can be used unlimited times.
            backtrack(
                    candidates,
                    remaining - candidates[i],
                    i,
                    current,
                    result
            );

            // Undo the choice.
            current.remove(current.size() - 1);
        }
    }
}