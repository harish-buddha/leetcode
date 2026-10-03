class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(1, n, k, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
            int start,
            int n,
            int k,
            List<Integer> current,
            List<List<Integer>> result) {

        // We have selected exactly k numbers.
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        int remaining = k - current.size();

        // Leave enough numbers after i to complete the combination.
        int maxCandidate = n - remaining + 1;

        for (int i = start; i <= maxCandidate; i++) {
            current.add(i);

            backtrack(i + 1, n, k, current, result);

            // Backtrack: remove the last choice.
            current.remove(current.size() - 1);
        }
    }
}