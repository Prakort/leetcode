class Solution {
    /*
    
    If we have [1,3,5,4,2,1] from end find element that break the sorting order
    
    which 3 and then find we have sub list [5 4 2 1]
    
    in that list we find the next larget that 3 and swap
    
    the we get [1 4 5 3 2 1] and sub list is [5 3 2 1] and
    
    reverse this sub list we get the result
    
    
    */
        public void nextPermutation(int[] nums) {
        
        int n = nums.length;
        // why i start at n-2 ? bcus nums[i+1] is nums[n-1] if i = n-2
        int i = n-2;
        for (  ; i>=0 ; i--)
        {   //Find the next element called Fallen that small then the largest
            // if it smaller  then break
            if(nums[i+1]>nums[i])
                break;
        }
        int j = n-1;
        if ( i >=0)
        {
            for (; j>=0; j--)
            {   // find the element that is bigger than Fallen element
                if(nums[j]>nums[i])
                    break;
            }
            swap(i,j,nums);
        }
    
        int index = i+1;
        int end = n-1;
        while(index<end)
        {
            swap(index,end,nums);
            index++;
            end--;
        }
            
        }
        public void swap(int a, int b, int [] arr)
        {
            int tmp = arr[a];
            arr[a]=arr[b];
            arr[b]=tmp;
        }
    }