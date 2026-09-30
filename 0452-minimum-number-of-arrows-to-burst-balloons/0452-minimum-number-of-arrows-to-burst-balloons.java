class Solution {
    public int findMinArrowShots(int[][] points) {
         // Sort by the ending coordinate.
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int arrowPosition = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];

            // Current arrow cannot burst this balloon.
            if (start > arrowPosition) {
                arrows++;
                arrowPosition = points[i][1];
            }
        }

        return arrows;
    }
}