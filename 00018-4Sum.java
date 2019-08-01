class Solution {
    
    /*
    Super brute force : O(n): n*n*n*n
    Traditional four loop to solve
    
    
    
    */
        public List<List<Integer>> fourSum(int[] nums, int target) {
            HashSet<ArrayList<Integer>> set = new HashSet<>();
            
            Arrays.sort(nums);
            
            int n = nums.length;
            for ( int i = 0 ; i < n ; i++)
            {   
                for (int j = i+1; j<n ; j++)
                {
                    for(int k = j+1 ; k<n ; k++)
                    {
                        for ( int h = k+1; h <n; h++)
                        {
                            int a = nums[i];
                            int b = nums[j];
                            int c = nums[k];
                            int d = nums[h];
                            
                            int sum = a+b+c+d;
                            
                            if ( sum==target)
                            {
                                set.add(new ArrayList(Arrays.asList(a,b,c,d)));
                            }
                        }
                    }
                }
                
            }
            List<List<Integer>> list = new ArrayList<>();
            list = new ArrayList(set);
             
            // sort inside the list in list
               Collections.sort(list, new Comparator<List<Integer>> () {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(1).compareTo(o2.get(1));
            }
      });
            
            return list;
            
        }
        /*

Double two pointers from the end 
O(n): n*3 + nlogn with sorting arrays

*/
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        
        Arrays.sort(nums);
        
        int n = nums.length;
        // i < n-2 no need to go to the end since j , k , m get value to add to the sum 
        for ( int i = 0 ; i < n -2; i++)
        {   
            for (int j = i+1; j< n-1; j++)
            {
                int k=j+1;
                int h= n-1;
                while(k<h)
                {
                        int a = nums[i];
                        int b = nums[j];
                        int c = nums[k];
                        int d = nums[h];
                        
                        int sum = a+b+c+d;
                        
                        if ( sum==target)
                        {
                            set.add((new ArrayList(Arrays.asList(a,b,c,d))));
                            k++;
                            h--;
                        }
                        else if(sum > target)
                        {
                            h--;
                        }
                        else
                        {
                            k++;
                        }
                    }
                }
            }
        // return set into arraylist <>
        return new ArrayList<>(set);
        
    }
    }