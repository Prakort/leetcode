class Solution {
    public int removeDuplicates(int[] nums) {
        
        
    int n = nums.length;
    int c=0;
        
    for ( int i =0 ; i < n ; i++)
    {
        /*
        
        c index and i index are equal 
        if c index take only non duplicate element
        
        */
        if(nums[i]!=nums[c])
        {   
            nums[++c]=nums[i];
        }
        
    }
    
    // since arrays index start at 0 we add 1 to the final lenght of new array
    return c+1;
    }
    
}