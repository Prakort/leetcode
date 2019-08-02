class Solution {
    /*
    Fact: array is sorted
    
    Fact: return if value is found but when to break ?
    
    Fact: we insert before the larger element in the array or at last index+1 if value 
    
    is the largest
    
    => Linear Scan break when we find element is greater than value
    
    
    */
        public int searchInsert(int[] nums, int target) {
            int n = nums.length;
            
            int i =0;
            
            while(i<n && nums[i]<target)
                i++;
            return i;
        }
    }