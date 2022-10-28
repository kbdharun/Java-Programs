import java.util.*;
class Product{
        int pid; //Product ID
        String pname; //Product name
        double up; //up=Unit Price
        Product(int pid, String pname,double up){
            this.pid=pid;
            this.pname=pname;
            this.up=up;
        }

        public String toString(){
            return pid+"\t"+pname+"\t"+up;
        }
}

class Comp implements Comparator<Product>{
        public int compare(Product p1,Product p2){
                return (p1.pname).compareTo(p2.pname);
        }
}

class Comp1 implements Comparator<Product>{
    public int compare(Product p1,Product p2){
            return (String.valueOf(p1.pid).compareTo(String.valueOf(p2.pid)));
    }
}

class Demo{
    public static void main(String[] args) {
            ArrayList<Product> al =new ArrayList<Product>();
            al.add(new Product(120,"XXX",34.5));
            al.add(new Product(100,"AAA",74.5));
            al.add(new Product(202,"BBB",64.5));
            System.out.println("Before sorting..."+al);
            Collections.sort(al,new Comp());

            for(var i:al)
                    System.out.println(i);
    }
}