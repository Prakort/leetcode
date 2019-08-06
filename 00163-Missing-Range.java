/*

[0 1 3 50 75]

if element == lower ==> update lower = element +1 

if lower = element -1 ==> return a signle missing number
lower = element+1

if lower < elment - 1 ==> return lower + --> + element-1
lower = element

now we look at the upper 

if lower is less than upper (since our lower is updated)
return lower -> upper
else
    return nothing 

*/
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> list = new ArrayList<>();
        
        for ( int element : nums)
        {
            
            if(element == Integer.MIN_VALUE)
            {
                // we update the lower to element +1
                lower = element+1;
                continue;
            }
            
            if ( lower == element -1)
            {
                // [1 3] lower =1 , element = 3 => missing is 2
            
                list.add(Integer.toString((element-1)));
                
            }
            else if ( lower < element -1)
            {
                // we have a range missing lo to element -1
                list.add(Integer.toString(lower) +"->"+ Integer.toString(element-1));
    
            }
            
            lower = element+1;
            
            if(element==Integer.MAX_VALUE)
                return list;

        }
          // look at the upper bound 
            if(lower < upper)
            {
                list.add(Integer.toString(lower) +"->"+ Integer.toString(upper));
            }
            else if ( lower==upper)
            {
                list.add(Integer.toString(lower));
            }
        return list;
    }
}