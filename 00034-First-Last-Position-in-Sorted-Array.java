class Solution {
    /*
    We will need 3 binary search 
    
    First search the target index => mid
    
    Second search for the left occurence usig binary
    
    Third search for the right or last occurence 
    
    O(n) = log(n) we use Binary search both left and right sub array
    
    
    */
        public int[] searchRange(int[] nums, int target) {
            int n = nums.length;
            
            
            int lo = 0;
            int hi = n-1;
            while(lo<=hi)
            {
                // find mid index
                int mid = (hi+lo)/2;
                if(nums[mid]>target)
                {
                    //[5 7 7 8 8 10] 8 > 8
                    // if mid element > target , mid -1 index become hi the right upper bound
                    hi = mid-1;
                    
                }
                else if ( nums[mid]<target)
                {
                    lo = mid+1;
                }
                else// when target is found index mid
                {
                    return new int []{bsLeft(nums,0,mid,target),bsright(nums,mid,n-1,target)};
                }
            
            
            }
            return new int[]{-1,-1};
        
        
        }
        /*
    
        search for the left occurrence 
        case 1: [5 7 7 8 8 10]
          index [0 1 2 3 4  5]
          target found at 8 ==> search right sup array is [5 7 7 8]
                                                          [0 1 2 3]
          1# mid = (3+0)/2 = 1
             check if nums[1] < 8 true then low = 1+1 = 2
          2# mid = (3+2)/2 = 2
             check if nums[2] < 8 true then low = 2+1 = 3
          3# low = 3 not < hi =3 break the loop
          return low =3 we found the last occurrence of 8
          
        case 2: [5 7 8 8 8 10]
          index [0 1 2 3 4  5] 
          target found at 8 ==> search right sub array is [5 7 8 8]
                                                          [0 1 2 3]
          1# mid = (3+0)/2 = 1
             check if nums[1] < 8 true then low = 1+1 = 2
          2# mid = (3+2)/2 = 2
             check if nums[2] < 8 false then 
             check if nums[mid -1]= nums[1]< 8 true => return that mid =2 
             bcus we found have 8 is the last occurrence since 8 index -1 is smaller than 8
          
        
        */
        public int bsLeft(int []arr , int left, int right, int target)
        {
            int low = left;
            int hi = right;
            while(low<hi)
            {
                int mid =(low+hi)/2;
                
                if(arr[mid]<target)
                    low=mid+1;
                else if(mid==0) // handle empty array or 1 length array
                    return mid;
                else if (arr[mid-1]<target) // 
                   return mid;
                else 
                    hi=mid-1;
                
            }
            return low;
        }
        public int bsright(int []arr,int left, int right,int target){
            int low = left;
            int hi = right;
            while(low<hi)
            {
                int mid =(low+hi)/2;
                
                if(arr[mid]>target)
                    hi=mid-1;
                else if ( arr[mid+1]>target) // 
                   return mid;
                else 
                    low=mid+1;
                
            }
            return hi;
        }
    }