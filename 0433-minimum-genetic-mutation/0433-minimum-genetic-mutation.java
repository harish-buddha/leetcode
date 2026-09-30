class Solution {

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        // The target gene is not reachable if it is not a valid bank gene.
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(startGene);
        visited.add(startGene);

        char[] genes = {'A', 'C', 'G', 'T'};
        int mutations = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Process all genes at the current mutation level.
            for (int i = 0; i < levelSize; i++) {
                String current = queue.poll();

                if (current.equals(endGene)) {
                    return mutations;
                }

                char[] chars = current.toCharArray();

                // Try changing every position.
                for (int position = 0; position < chars.length; position++) {
                    char original = chars[position];

                    // Try all possible nucleotides.
                    for (char gene : genes) {
                        if (gene == original) {
                            continue;
                        }

                        chars[position] = gene;
                        String next = new String(chars);

                        // Only valid and unvisited genes can be explored.
                        if (bankSet.contains(next) && visited.add(next)) {
                            queue.offer(next);
                        }
                    }

                    // Restore original character.
                    chars[position] = original;
                }
            }

            mutations++;
        }

        return -1;
    }
}