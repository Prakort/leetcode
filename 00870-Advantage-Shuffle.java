class Solution {
    /*
    
    Maximize such that A[i]>B[i] ====> result is a new permutation 
    
    B array stay the same
    
    Find the largest element of B such that largest of A is greater 
    
    if not , non element is greater that largest of B
    
    We must sort A --> ascending order
    
    We must sort B --> descending order and store it's index and value as pair
    
    If largest of B is not safitied we will put smallest of A in its index
    
    
    
    */
        public int[] advantageCount(int[] A, int[] B) {
            
            Arrays.sort(A);
            int n = A.length;
            int result [] = new int[n];
            
            int low =0;
            int hi = n-1;
            
            // [value,index] of B element
            // put them in PQ
            PriorityQueue<int []> pq = new PriorityQueue<>( new Comparator<int []>(){
                
                public int compare( int[] a , int []b){
                    return b[0]-a[0];}
            });
                
            // add pairs val,index of B into PQ
            for ( int i = 0 ; i < n ; i++)
                pq.add(new int[]{B[i],i
                });
            
            /*
            [8 12 24 32] A
            [32,2] [25,1] [13, 0] [11,3] PQ
            
            #first get val 32 index 2
            A[hi] = 32 > 32 NOPE ==> result[index=2]=A[lo]=8 low++ // 32,2 is removed
            #then val 25, index 1 
            A[hi] =32 > 25 YES ==> result[index=1]=A[hi--]=32 // 25, 1 is removed 
            
            */
    
            while(!pq.isEmpty())
            {
                int [] temp = pq.poll();
                int index = temp[1];
                int value = temp[0];
                if(A[hi]>value)
                {
                    result[index]=A[hi--];
                }
                else 
                {
                    result[index]=A[low++];
                }
            }
            
            
            
            return result;
            
        }
    }