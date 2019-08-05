class Solution {
    /*
    Depth First Search:
    
    Sorted the list
    
    Add repeated element until sum > target
    
    if sum == target return list , other remove size-1 index from list that added
    
    
    
    
    */
        public List<List<Integer>> combinationSum(int[] arr, int target) {
        
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
    
        helperDSF(list, new ArrayList<Integer>(),arr,target,0,0);
            
        return list;
        }
        
        public void helperDSF(List<List<Integer>> list,ArrayList<Integer> path,int []arr, int target, int carrySum, int startingIndex){
            
        // base case 
        if(carrySum==target)
        {
            list.add(new ArrayList(path));
            return;
        }
        
        int nextValue;
            
        for ( int i = startingIndex; i<arr.length;i++ )
        {
    
        nextValue=arr[i];
        // total sum > target break and remove that last value from list
        if(carrySum+nextValue>target)break;
        
        path.add(nextValue);
        
        helperDSF(list,path,arr,target,carrySum+nextValue,i);
        
        // remove last value if total sum in next callback > target
        path.remove(path.size()-1);
        }
            
            
        }
        
    
    
    }