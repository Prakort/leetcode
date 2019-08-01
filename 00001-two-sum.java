class Solution {
/*

    We want to find the index of two element that add up to the target. 
    We will add element to the next element in the list for every element
    in order to check the sum.
    If there are two sum , we will return the two index
    #time complexity is n square
    #space complexity is 1;

*/
    public int[] twoSum01(int[] nums, int target) {
        
        for ( int i =0; i<nums.length ;i++)
        {
            for ( int j = i+1; j<nums.length ; j++)
            {
                if (nums[j]+nums[i]==target)
                    return new int []{i,j}; // using new int []{} to instantiate a new array
            }
        
        }
        throw new IllegalArgumentException("No solution");
    }

/*
    This solution, we use an extra hashmap to store <element, index> 
    of the complement Target - each element

    If hashmap contains element return its value, index and nums[i]

*/

    public int[] twoSum02(int[] nums, int target) {

        Map <Integer,Integer> map = new HashMap<>();
        
        for ( int i =0; i<nums.length ;i++)
        {
            int complement = target - nums[i];
            
            if(!map.containsKey(complement))
                map.put(nums[i],i);  
            else
               return new int []{map.get(complement),i};
        }
            throw new IllegalArgumentException("No solution");
    }



}