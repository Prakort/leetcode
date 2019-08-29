import java.util.HashMap;
import java.util.TreeMap;

class TimeMap{

    HashMap<String,TreeMap<Integer,String>> map;

    public TimeMap(){
        map= new HashMap();
    }

    public void set(String key, String value, int timestamp){
        TreeMap<Integer , String> pair = map.get(key);
        if(pair==null)
        {
            pair = new TreeMap<>();
        }

        pair.put(timestamp,value);
        map.put(key,pair);
        return;
    }

    public get(String key,int time){

        if(!map.containsKey(key))
        return "";
        TreeMap<Integer,String> pairs = map.get(key);
        Integer t = pairs.floorKey(time);
        if(t==null)
        return "";

        return pairs.get(t);
    }

}