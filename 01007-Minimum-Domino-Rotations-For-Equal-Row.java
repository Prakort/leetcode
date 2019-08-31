class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        
        int rotation= Integer.MAX_VALUE;
        
        for ( int i=1 ; i <=6 ; i++)
        {
            int checkA = check(A,B,i);
            
            if (checkA == Integer.MAX_VALUE)
                continue;
            int checkB= check(B,A,i);
            
            rotation = Math.min(rotation,Math.min(checkA,checkB));
            
            
        }
        
        if(rotation==Integer.MAX_VALUE)
            rotation=-1;
        
        return rotation;
        
    }
    
    public int check(int A[],int B[], int target)
    {

    int count =0;
        for ( int i = 0 ; i < A.length ; i++)
        {
            if(A[i]==target)
                continue;
            else if(B[i]==target)
                count++;
            else{
                 count = Integer.MAX_VALUE;
                break;
            }
              
        } 
        
    return count;
    
    }
}