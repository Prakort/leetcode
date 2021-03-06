class Solution {
    /*
    Require for this problem is O(n) log(n)
    
    but this O(n) n is faster during test time
    
    using two pointer from mid expand to the end
    
    */
        public int search(int[] nums, int target) {
            
            int n = nums.length;
            int mid = n/2;
            int j = mid;
            int k = mid;
            
            while (j>=0 || k <n)
            {
                if(j>0 && nums[j-1]==target)
                    return j-1;
                if(k<n && nums[k]==target)
                    return k;
                j--;
                k++;
               
            }
            return -1;
            
    
        }
        /*
Binary Search O(n): log(n)

*/
    public int search2(int[] nums, int target) {
        
        int n = nums.length;
       
        int j = 0;
        int k = n-1;
        
        while (j<=k)
        {
             int mid = (j+k)/2;
            if(nums[mid]==target)
                return mid;
            // check if mid element > last element
            // that mean right sub array is acsending
            // [ 5 6 7 8 1 2 3 4 ]
            // 8 > 4
            // target is 6
            if ( nums[mid]>nums[k])
            {
                // if 8 > 6 and 5 < 6
                // hi = mid -1
                if(nums[mid]>target && nums[j]<=target )
                    k=mid-1;
                else
                    j=mid+1;
            }
            else 
            {
                // check if mid < last element
                // just regular binary search algo
                if(nums[mid]<target && target<= nums[k] )
                j=mid+1;
            else
                k=mid-1;
            }
            
           
        }
        return -1;
        

    }
    }