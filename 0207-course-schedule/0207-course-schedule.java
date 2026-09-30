class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // adjacency list: prerequisite -> courses depending on it
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // indegree[i] = number of prerequisites required for course i
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int requiredCourse = prerequisite[1];

            graph.get(requiredCourse).add(course);
            indegree[course]++;
        }

        // Courses with no prerequisites can be taken immediately.
        Queue<Integer> queue = new LinkedList<>();

        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }

        int coursesCompleted = 0;

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            coursesCompleted++;

            // Remove currentCourse as a prerequisite
            // from all dependent courses.
            for (int nextCourse : graph.get(currentCourse)) {
                indegree[nextCourse]--;

                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // If every course was processed, there is no cycle.
        return coursesCompleted == numCourses;
    }
}