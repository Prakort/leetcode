class Solution {
    public int shipWithinDays(int[] weights, int D) {
        
        // ship capacity must be greater than the heaviest weight
        // let lowerbound = max weight
        // let upperbound = sum of total weight
        // let guess the weight => mid = lowerbound+upperound /2
        // if number ship of guessed weight > D , we have to increase guessed weight lowerbound = mid+1 so that we can reduce the # ship
        // else if number ship is good or < D , but we still have to find optimal capacity
        // return lowerbound
        
        
        int lower=0;
        int hi = 0;
        
        for ( int e : weights)
        {
            hi+=e;
            lower=Math.max(lower,e);
        }
        
        
        while(lower<hi)
        {
            int mid = (lower+hi)/2;
            
            int current_weight_added=0;
            int num_ship =1;
            
            for( int w : weights)
            {
                current_weight_added+=w;// add weight on ship
                if(current_weight_added > mid)// current weight on ship > guess capacity
                {
                    current_weight_added = w;// put weight on new ship
                    num_ship++; // we need another ship
                }
            }
            
            if(num_ship>D)
                lower = mid+1;
            else
                hi=mid;
            
           
        }
         return lower;
    }
}