class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // adjacency list: prerequisite -> courses depending on it
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // indegree[i] = number of prerequisites for course i
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];

            graph.get(prerequisiteCourse).add(course);
            indegree[course]++;
        }

        // Courses with no prerequisites can be taken immediately.
        Queue<Integer> queue = new ArrayDeque<>();

        for (int course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;

            // Remove this course as a prerequisite
            // for all dependent courses.
            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;

                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // If not all courses were processed, a cycle exists.
        if (index != numCourses) {
            return new int[0];
        }

        return order;
    }
}