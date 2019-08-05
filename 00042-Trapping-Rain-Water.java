class Solution {
    public int trap(int[] arr) {
        
        int left = 0;
        int right = arr.length-1;
        int sum =0;
        int maxLeft=0;
        int maxRight=0;
        while(left<right)
        {
            if(arr[left]<arr[right])
            {
                if(arr[left]>=maxLeft)
                    maxLeft=arr[left];
                else
                    sum+=maxLeft-arr[left];
                
                left++;
                
            }
            else
            {
                if(arr[right]>=maxRight)
                    maxRight=arr[right];
                else
                    sum+=maxRight-arr[right];
                
                right--;

            }       
        }
        return sum;
    }
}