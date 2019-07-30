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
    }