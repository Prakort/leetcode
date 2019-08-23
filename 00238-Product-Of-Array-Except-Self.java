/*

|4| 5 1 8 2
4 |5| 1 8 2
4 5 |1| 8 2
4 5 1 |8| 2
4 5 1 8 |2|

1<=(1) 4<=(1*4) 20<=(4*5) 20<=(20*1) 160<=(20*8) L
80 16 16 2 1 R
look at product except index as product of left sub array and right sub array 
instead.

we have to store the product of all the element before the index 
by multiply every element before it same as the right side

then we get the result by L[i]*R[i]= re[i] by pre calculate the product




*/


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int [] output = new int[len];
        int [] left = new int[len];
        int [] right = new int[len];
    
        left[0]=1;
        right[len-1]=1;
        for (int i = 1 ; i < nums.length ; i++){
            left[i]=left[i-1]*nums[i-1];
        }
        
        
        for ( int i = len-2; i>=0 ; i--){
            right[i]=right[i+1]*nums[i+1];
        }
        int i =0;
        while (i<len){
            output[i]=right[i]*left[i];
            i++;
        }
        return output;
    }
}