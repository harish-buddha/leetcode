import java.util.HashMap;
import java.util.Map;

class Solution {

    public int maxPoints(int[][] points) {
        int n = points.length;

        if (n <= 2) {
            return n;
        }

        int answer = 2;

        for (int i = 0; i < n; i++) {
            Map<Slope, Integer> slopeCount = new HashMap<>();

            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int gcd = gcd(Math.abs(dx), Math.abs(dy));

                dx /= gcd;
                dy /= gcd;

                // Keep a unique representation for the slope.
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                }

                // Normalize vertical lines.
                if (dx == 0) {
                    dy = 1;
                }

                // Normalize horizontal lines.
                if (dy == 0) {
                    dx = 1;
                }

                Slope slope = new Slope(dy, dx);

                int count = slopeCount.getOrDefault(slope, 0) + 1;
                slopeCount.put(slope, count);

                localMax = Math.max(localMax, count);
            }

            // +1 for the anchor point itself.
            answer = Math.max(answer, localMax + 1);
        }

        return answer;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private static class Slope {
        int dy;
        int dx;

        Slope(int dy, int dx) {
            this.dy = dy;
            this.dx = dx;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (!(obj instanceof Slope)) {
                return false;
            }

            Slope other = (Slope) obj;
            return dy == other.dy && dx == other.dx;
        }

        @Override
        public int hashCode() {
            return 31 * dy + dx;
        }
    }
}