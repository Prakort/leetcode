class Solution {
/*

Fact: s[i] = { A[i] A[A[i]] ------- so on}
find s[0]-----> s[n]

the rule any of s cannot contain the duplicate 
s[1] and s[0] cannot have same number either 

9% acceptance

*/
    public int arrayNesting(int[] nums) {
        
        int len = nums.length;
        int max=0;
        for ( int i = 0 ; i < len ; i++)
        {
            Set<Integer> set = new HashSet<>();
            int temp = nums[i];
            nums[i]=-1;
            while(!set.contains(temp) && temp!=-1)
            {   
                    set.add(temp);
                    temp = nums[temp];
              
            }
            int size = set.size();
            
            max=Math.max(size,max);
        }
        return max;
    }
    /*

    without using extra space set
    36% acceptance



    */
    public int arrayNesting2(int[] nums) {
        
        int len = nums.length;
        int max=0;
        for ( int i = 0 ; i < len ; i++)
        {
            int count=0;
            int temp = nums[i];
            nums[i]=-1;
            while(temp!=-1)
            {   
                    count++;
                    temp = nums[temp];
            }
            max=Math.max(count,max);
        }
        return max;
    }
    public int arrayNesting3(int[] nums) {

    int len = nums.length;
    int max=0;
    boolean[] visit = new boolean[len];
    for ( int i = 0 ; i < len ; i++)
    {
        int count=0;
        int temp = nums[i];
        if (visit[i]!= true){
        while(true)
        {   
            count++;
            temp = nums[temp];
            visit[temp]=true;
            
            // since elements are distince , duplicate is the first element in S
            if(temp == nums[i])
                break;
            
        }
        }
        max=Math.max(count,max);
    }
    return max;
    // the 100% solution 
    // since value 0< 1000000
    // visited element as -1
    public int arrayNesting4(int[] nums) {
        
     
        int len = nums.length;
        int max=0;

        for ( int i = 0 ; i < len ; i++)
        {
            if(nums[i]!=-1){
            int count=0;
            int NextIndex = nums[i];
        
            while(nums[NextIndex]!=-1)
            {   
                count++;
                int temp = NextIndex;
                NextIndex = nums[temp];
                nums[temp]=-1;
                
            }
            max=Math.max(count,max);
            }
        }
        return max;
    }
}
}