import java.util.HashMap;

class solution{

    class int ans(int []arr)
    {
        int count = 0;
        int sum =0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for ( int n : arr){
            sum+=n;
            if(map.containsKey(sum-k))
                count+=map.get(sum-k);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}