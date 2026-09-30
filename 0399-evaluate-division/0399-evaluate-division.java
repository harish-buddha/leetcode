class Solution {
    static class Edge {
        String node;
        double weight;

        Edge(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        // Build weighted graph.
        Map<String, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.computeIfAbsent(a, k -> new ArrayList<>())
                 .add(new Edge(b, value));

            graph.computeIfAbsent(b, k -> new ArrayList<>())
                 .add(new Edge(a, 1.0 / value));
        }

        double[] result = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String source = queries.get(i).get(0);
            String target = queries.get(i).get(1);

            if (!graph.containsKey(source) || !graph.containsKey(target)) {
                result[i] = -1.0;
                continue;
            }

            Set<String> visited = new HashSet<>();
            result[i] = dfs(source, target, 1.0, graph, visited);
        }

        return result;
    }

    private double dfs(
            String current,
            String target,
            double product,
            Map<String, List<Edge>> graph,
            Set<String> visited) {

        if (current.equals(target)) {
            return product;
        }

        visited.add(current);

        for (Edge edge : graph.get(current)) {
            if (visited.contains(edge.node)) {
                continue;
            }

            double result = dfs(
                    edge.node,
                    target,
                    product * edge.weight,
                    graph,
                    visited
            );

            if (result != -1.0) {
                return result;
            }
        }

        return -1.0;
    }
}