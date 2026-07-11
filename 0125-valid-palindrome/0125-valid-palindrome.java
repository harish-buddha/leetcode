class Solution {
    public boolean isPalindrome(String s) {
        String result = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); 
        boolean ans = true;
        int start = 0;
        int end = result.length()-1;
        while(start<=end){
            if(result.charAt(start)==result.charAt(end)){
                start+=1;
                end-=1;
            }else{
                ans = false;
                break;
            }
        }
        return ans;
    }
}