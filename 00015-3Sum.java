/*

First we will sort the array 

First for loop start from index i 0-lenght

Inner loop will start left = i+1 and right = len -1

Sum of 3 index's element equal to the target

If Sum == Target we move left and right pointer inward 

If Sum < 0 that we move only left inward

If Sum > 0 we move only right pointer inward


*/
public List<List<Integer>> threeSum(int[] nums) {
    
        
    HashSet<ArrayList<Integer>> set = new HashSet<>();
    // sort the array first
    Arrays.sort(nums);
    int i =0;
    int n=nums.length;
    
    while(i<n)
    {
        int a = nums[i];
        int left = i+1;
        int right = n-1;
        
        while(left<right)
        {
            int b = nums[left];
            int c = nums[right];
            int sum = a+b+c;
            
            if(sum==0)
            {
                //move both pointer inward
                left++;
                right--;
                set.add(new ArrayList<>(Arrays.asList(a,b,c)));
            }
            else if (sum < 0)
            {
                // move only left inward
                left++;
            }
            else
            {
                right--;
            }
        }
        i++;
     }
        return new ArrayList(set);
        
    }
}