class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maximumArea = 0;

        while (left < right) {
            int width = right - left;
            int containerHeight = Math.min(height[left], height[right]);
            int currentArea = width * containerHeight;

            maximumArea = Math.max(maximumArea, currentArea);

            // Move the shorter wall
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maximumArea;
    }
}