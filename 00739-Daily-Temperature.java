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
    public int[] dailyTemperatures2(int[] arr) {
        
        int len = arr.length;
        int result[] = new int[len];
        Stack<Integer> stack = new Stack<>();
        
        for ( int i = 0 ; i <len ; i++)
        {
            while(!stack.isEmpty() && arr[i]>arr[stack.peek()])
            {
                int index = stack.pop();
                result[index]= i - index;
            }
            stack.push(i);
        }

       
        return result;
    }
}