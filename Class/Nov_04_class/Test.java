import java.util.*;

class Test{
    public static void main(String[] args){
        HashSet<String> ll = new HashSet<String>(); //lambda expression
        ll.add("Alice");
        ll.add("Clark");
        ll.add("Bob");
        ll.add("Darth");

        for(var i:ll)
            System.out.println(i+"\t"+i.hashCode());
       // System.out.println(ll);
    }
}