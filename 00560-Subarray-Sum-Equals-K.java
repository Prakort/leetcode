class Solution {
    /*

    Time: O(n*n)
    Space: O(1)

    */
    public int subarraySum(int[] nums, int k) {
  
    int counter = 0;
        
    for ( int i =0 ; i < nums.length ; i++)
    {
        int sum = 0;
        
        for ( int j = i ; j< nums.length ; j++)
        {
    
            sum +=nums[j];
            if(sum==k)
                counter++;
        }
    }   
        return counter++;

    // Time: O(n)
    // Space: O(n)
    public int second(int []arr,int k)
    {
        int count =0;
        int sum = 0;

        HashMap<Integer,Integer> map = new HashMap<>();

        for ( int e : arr)
        {
            sum+=e;
            if(map.containsKey(sum-k))
                count+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);

        }
        return count;
    }
}
    