class Solution {
    /*
    Brute Force Solution:
    Find each area and assign to the max
    */
        public int maxArea1(int[] height) {
        int max=0;
        int n = height.length;
            
        for(int i =0;i<n;i++)
        {
            for ( int j=i+1;j<n;j++)
            {   // get width
                int width= j-i;
                // get height
                int h = Math.min(height[i],height[j]);
                // previous max area vs area now
                max=Math.max(max,width*h);
            }
        }        
        return max;
        }


    /*
    Two pointer solution:

    First we set start i point : 0 , end j pointer len -1

    we calucate max area respect to the index pointers 

    and compare to the previous max area value

    We want to find the largest area so we move one of the point if its value is 

    less than the other
    */
        public int maxArea2(int[] height) {
    int max=0;
    int n = height.length;
    
    int i = 0,j=n-1;
    while(i<=j)
    {
        int width = j-i;
        int hi = Math.min(height[i],height[j]);
        
        max=Math.max(max,width*hi);
        
        if(height[j]>height[i]) i++;
        else j--;
        
    }
    return max;
    }
}