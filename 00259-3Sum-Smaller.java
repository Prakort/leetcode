class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        
        Arrays.sort(nums);
        int a,b,c,j,k;
        int count=0;
        int temp=0;
        for (int i =0 ; i < n ; i++)
        {
            j=i+1;
            k=n-1;
            int newTarget = target-nums[i];
            while(j<k)
            {
                
                int sum = nums[j]+nums[k];
               //System.out.println(sum);
                
                if(sum<newTarget)
                {
                        count+=k-j;
                        j++;
                }
                else
                    k--;
                
            }
        }
        return count;
    }
}