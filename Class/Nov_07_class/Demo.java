import java.util.*;
class MyCompLast implements Comparator<String>{
    public int compare(String a,String b){
        int i=a.lastIndexOf(" ");
        int j=b.lastIndexOf(" ");
        return a.substring(i).compareTo(b.substring(j));
    }
}

class MyCompFirst implements Comparator<String>{
    public int compare(String a,String b){
        return a.compareTo(b);
    }

}

class Demo{
    public static void main(String[] args) {
        MyCompLast<String> c=new MyCompLast<String>();
        MyCompFirst<String> comp=c.thenComparing(new MyCompFirst());
        TreeMap<String, Double> hm=new TreeMap<String, Double>(new MyCompLast());
        hm.put("John Alice", 12000.00);
        hm.put("Mark Bob", 10000.00);
        hm.put("Mathew Clark", 10000.00);
        hm.put("Kevin Darth", 20000.00);

        Set<Map.entry<String,Double>> set=hm.entrySet();
        for(var me:set)
                System.out.println(me.getKey()+"\t"+me.getValue());
    }
}
