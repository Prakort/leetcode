class Solution {
    
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] a, int target) {
    
    Arrays.sort(a);

    
        helperDSF(a,target,0,0, new ArrayList<Integer>());
        
        
    return list; 
    
    }
    public void helperDSF(int []arr,int target, int sum, int  index,ArrayList<Integer> path)
    {
        if(sum==target)
        {
            list.add( new ArrayList(path));
            return;
        }
   
        int val ;
        for( int i= index; i < arr.length; i++)
        {
            val=arr[i];
        
            if(sum+val > target ) break;
            if(i>index && arr[i]==arr[i-1])continue;
            
            path.add(val);
            
            helperDSF(arr,target,sum+val,i+1, path);
            path.remove(path.size()-1);
            
            /*
           [1 1 6] i=0
           dsf(0,0) path(1)
           dsf(1,1) path(1 1)
           dsf(2,2) path(1 1 2) x remove !=8 => path (1 1)
           dsf(3,3) path(1 1 5) x remove !=8 => path (1 1)
           dsf(4,4) path(1 1 6) add to list return path
           [1 2 5] i=1
           dsf(1,1) path(1)
           dsf(1,2) path(1 2)
           dsf(3,3) path(1 2 5) sum == 8 return path
           [2,6] i=2
           dsf(2,3) path(2)
           dsf(5,4) path (2 5 ) 2+7 != 8 remove 5=> path(2)
             3=> idex start 3 ==> i++ => i=4
            sum =2 , val = arr[4]=6 
            path add(6) => path (2 6) return path
           
           
            
            
            
            
            
            
            */
          
            
        
    }
    }   
}