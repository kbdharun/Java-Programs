import java.util.*;
import java.util.Map.Entry;

class Map{
    public static void main(String arg[]) {
        TreeMap<String,Double> hm=new TreeMap<String,Double>();
        hm.put("Alice",12000.00);
        hm.put("Bob",10000.00);
        hm.put("Clark",10000.00);
        hm.put("Darth",20000.00);
        double d=hm.get("Darth");
        hm.put("Darth",d+5000.00);
        Set<Entry<String,Double>> set=hm.entrySet(); //navigatable set
        for(Entry<String, Double> me:set){
            System.out.println(me.getKey()+"\t+"+me.getValue());
        }
    }
}