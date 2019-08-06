class Solution {
    /*
    
    [2 -1 1 2 2] 
     0  1 2 3 4
    a[i] is positive or negative # step
    
    strictly right circular or left circular ex: allow index 0 -> 2 -> 3 -> 4 
    
    not allow 1 -> 0 -> 2 this is bidirection 
    
    cycle's length must be > 1 meaning [1 2] 1->1 lenght is 1 will not count
    
    search for every possible loop in the array
    
    solution:
    
    find nextIndex base on formular ( index + value + len) % len this will work 
    
    both neg- or pos+ value
    
    if direction is strictly 
    
    we will change value of index = 0 as our base case
    
    then dfs on next Index untill next Index of dfs value ==0 
    
    that mean it loops back
    
    if it not , replace its value back
    
        public boolean circularArrayLoop(int[] nums) {
            int n = nums.length;
            
            
            for ( int i = 0; i < n ; i++)
            {
                if(dfs(i,nums,n))
                    return true;
                
            }
            
            return false;
        }
        public boolean dfs(int index, int[] nums, int len)
        {
            // base case
            if(nums[index]==0)
                return true;
            
            // find its nextIndex 
            // must follow strictly direction
            // that means value of index * value of nextIndex > 0 != neg-
            
            int NextIndex =(((nums[index]+index)%len)+len)%len;
            
            // return false it is bidirection
            // or 1 circle length  [1 2] index == NextIndex
            if( index==NextIndex || nums[index]*nums[NextIndex]<0 )
                return false;
            
            // set up for possible start element of the loop to Zero for base case
            int temp = nums[index];
            nums[index]=0;
            
            // return true if it a loop ==> nextIndex satifies base case
            if(dfs(NextIndex,nums,len)) return true;
            
            // else put back the value for next search
            
            nums[index]= temp;
            
            return false;
        }*/
        
         public boolean circularArrayLoop(int[] nums) {
             
    /*
    
    this approach is replacing value of each index that will circle as a loop
    
    [2 -1 1 2 2]
    each iteration 
    [1001 -1 1001 1001 2] i = 0 , the circle index loop should have the same value after
    iteration   
    
    */
        int len = nums.length;
             
        for ( int i = 0 ; i < len ; i++)
        {
            int cur = i;
            int prev = i;
            int direct=0;
            
            while(nums[cur]<=1000)
            {
                prev = cur;
                // find next index of cur
                int nextIndex = (cur+nums[cur])%len;
                
                // check if pos+ or neg-
                if ( nums[cur]>0)
                {
                    cur = nextIndex;
                    // 1 to the right 2 to the left, -1 bidirection
                    direct=(direct==0 || direct ==1)? 1:-1;
                }
                else
                {
                    cur = (nextIndex<0) ? (len+nextIndex): nextIndex;
                    direct=(direct==0 || direct ==2)? 2:-1;
                    
                }
                
                if ( direct==-1)
                    break;
                nums[prev]=1001+i;
                
                if(prev==cur)
                    break;
                    
                
            }
            if( prev!=cur && direct != -1 && nums[cur]==1001+i)
                return true;
        }
             return false;
             
         }
        
    }