class Solution {
/*
fact1: median of sorted array
if len is odd   --> median [1,5,10] = 5
if len is even  --> median [1,2,5,10] = (2+5)/2=3.5

fact2: median of the two sorted array: 
[......smallX largeX......]
[......smallY largeY......] max(smallX,smallY)+min(largeX,largeY)/2

we wil need to partion both array to get same # of partion vertical

2 elements | 4 elements
4 elements | 2 elements

    
*/
    public double findMedianSortedArrays(int[] A, int[] B) {
    
     int m= A.length;
     int n= B.length;
    
    if (m>n)
    {   //swap array and its len
        int [] tmp = A;
        A=B;
        B=tmp;
        int temp = m;
        m= n;
        n=temp;
    }
        
    int start = 0;
    int end = m; // smallest len of both arrays
    int midLen = (m+n+1)/2 ;// +1 to deal with odd or even len
    
    while(start<=end)
    {
        int i = (start+end)/2; // A array partiion index
        int j = midLen-i; // B array partition index
        
        // if left elememt of A partition > right                                           //element of B partition we have to move i A                                         //partion index back to the left
        if ( i > 0 && A[i-1] > B[j]) 
            end = i-1;
         // we are too on the left side , move start to the right a bit
        else if (i < m && A[i] < B[j-1] ) 
            start = i+1;
        // if i is the right place we should get maxLeftX < minRightY and maxLeftY <          //minRight X
        else
        {
            int maxLeft=0;
            // i = 0 means no element in A is greater than B
            // max( maxLeft X, maxLeftY) is B[j-1]
            if( i == 0) 
                maxLeft = B[j-1];
            else if (j==0)
                maxLeft = A[i-1];
            else
                maxLeft = Math.max(A[i-1],B[j-1]);
            
            if((m+n)%2==1) return maxLeft;
        
    
             int minRight;
               if (i==m) minRight=B[j];
               else if ( j==n) minRight=A[i];
               else
                    minRight = Math.min(B[j],A[i]);
            
            return (double)( maxLeft+minRight)/2;
            
        }
    }
        
        throw new IllegalArgumentException("No");
    }
}