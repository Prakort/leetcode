class Solution {
    public int firstMissingPositive(int[] nums) {
        int start = 1;
        
        int n = nums.length;
        
        for ( int i = 0; i < n ;)
        {
            if(nums[i]==start)
            {
                start++;
                i=0;
            }
            else
            {
                i++;
            }
                
            
        }
        
        
        
        return start;
    }
}