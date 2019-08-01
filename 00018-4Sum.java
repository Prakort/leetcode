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
    }