class Solution {
    public int[] dailyTemperatures(int[] arr) {
        
        int len = arr.length;
        
        for( int k = 0 ; k < len ; k++){
    
        boolean warm=false;
        for ( int i = k ;i < len ;i++)
        {
           if(arr[i]> arr[k])
           {
               arr[k]=i-k;
               warm = true;
               break;
           }
            
        }
        if(!warm) 
            arr[k]= 0;
        }
        

        
        return arr;
    }
}