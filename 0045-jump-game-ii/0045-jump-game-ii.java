class Solution {
    public int jump(int[] nums) {
        int reachEnd=0;
        int jumps =0;
        int maxjumps=0;
        for(int i=0;i<nums.length-1;i++){
            maxjumps=Math.max(maxjumps, i+nums[i]);
            if(i==reachEnd){
                jumps++;
                reachEnd=maxjumps;
            }
        }
        return jumps;
    }
}