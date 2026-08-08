class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],0);
        int num1=-1;
        int num2=-1;
        for(int i=1;i<nums.length;i++){
            int rem  = target-nums[i];
            if(map.containsKey(rem)){
                num1=map.get(rem);
                num2=i;
                break;
            } 
            map.put(nums[i],i);
        }
        return new int[]{num1,num2};
    }
}