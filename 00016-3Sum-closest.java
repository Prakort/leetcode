class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
    int minSum=10;
    int sum=0;
    int temp =Integer.MAX_VALUE;

    int n = nums.length;
    int j,k;
    
    Arrays.sort(nums);
    for( int i =0; i <n -2; i++)
    {   
         
        j = i+1;
         k = n-1;
        if(i>0 && nums[i-1]==nums[i])
            continue;// since array is sorted , skip same element 1 1 2 3 4 
        
        while(j<k)
        {
            sum = nums[i]+nums[j]+nums[k];
           int diff = sum-target;

            if( sum-target==0) return sum;
            if ( Math.abs(temp) > Math.abs(diff))
            {   temp = diff;
                minSum = sum;
            }
            if ( diff>0)
            {
                k--;
            }
            else
            {   
                j++;
            }
         
        }
        
    }
        return minSum;
    }
}