class Solution {
    public int removeElement(int[] nums, int val) {
    
    int n = nums.length;
    /* create new index for value that is not the target */
    int c=0;
    for ( int i = 0 ; i < n ; i++)
    {
        if(nums[i]!=val)
        {
            // add element into new idex if it not the target removed
            nums[c++]=nums[i];
            
        }
    }
        
    return c;
        
        
    }
}