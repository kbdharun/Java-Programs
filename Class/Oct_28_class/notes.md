# Notes (October 28,2022)

## Topics

- Collection (API)

## Collection (API)

> Offtopic: This API has high industry demand in India.

- `java.util.Collection` is the package for Collections.
- For collection utility, `Collection` is the base class.
- `java.util.Collection..ArrayList..Iterator..Spliterator...Comparator`
- ArrayList (class).
- Interface:-
  - Iterator - Allows only the **Traversal of data**.
  - Spliterator - Allows parallel processing (given by *default*) [Splits the data - compared to Iterator it is fast]
  - Comparator - Also traversal but it performs sorting technique (arranging data) behind the scenes.
- Data Structures:-
  - Set - No duplication datamember
  - List
  - Map - Key value pair (like `Python`)

```md
Syntax:-

ArrayList<Integer>
ArrayList<classname> obj= new ArrayList<classname>(int) //we have 3 constructor - 1 default and 2 parameterized
```

### Collection Package (*Disassembled*)

```bash
[user]$ javap java.util.Collection
Compiled from "Collection.java"
public interface java.util.Collection<E> extends java.lang.Iterable<E> {
  public abstract int size();
  public abstract boolean isEmpty();
  public abstract boolean contains(java.lang.Object);
  public abstract java.util.Iterator<E> iterator();
  public abstract java.lang.Object[] toArray();
  public abstract <T> T[] toArray(T[]);
  public default <T> T[] toArray(java.util.function.IntFunction<T[]>);
  public abstract boolean add(E);
  public abstract boolean remove(java.lang.Object);
  public abstract boolean containsAll(java.util.Collection<?>);
  public abstract boolean addAll(java.util.Collection<? extends E>);
  public abstract boolean removeAll(java.util.Collection<?>);
  public default boolean removeIf(java.util.function.Predicate<? super E>);
  public abstract boolean retainAll(java.util.Collection<?>);
  public abstract void clear();
  public abstract boolean equals(java.lang.Object);
  public abstract int hashCode();
  public default java.util.Spliterator<E> spliterator();
  public default java.util.stream.Stream<E> stream();
  public default java.util.stream.Stream<E> parallelStream();
}

```

### Iterator Package (*Disassembeled*)

```bash
[user]$ javap java.util.Iterator
Compiled from "Iterator.java"
public interface java.util.Iterator<E> {
  public abstract boolean hasNext();
  public abstract E next();
  public default void remove();
  public default void forEachRemaining(java.util.function.Consumer<? super E>);
}
```

### Program 1:-

```java
import java.util.*;
class Demo{
    public static void main(String[] args) {
            ArrayList<String> al =new ArrayList<String>();
            al.add("First");
            al.add("Second");
            al.add("Third");

            System.out.println(al+"\n"+al.size());

            al.remove(1);

            System.out.println("2:"+al+"\n"+al.size());
            al.clear();
            System.out.println("3:"+al+"\n"+al.size());
    }
}
```

- Output:-

```bash
[First, Second, Third]
3
2:[First, Third]
2
3:[]
0
```

### Program 2a:-

```java
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

class Demo{
    public static void main(String[] args) {
            ArrayList<Product> al =new ArrayList<Product>();
            al.add(new Product(120,"XXX",34.5));
            al.add(new Product(100,"AAA",74.5));
            al.add(new Product(202,"BBB",64.5));

            System.out.println(al);
            al.remove(0);
            for(var i:al)
                System.out.println(i);
    }
}
```

- Output:-

```bash
[120	XXX	34.5, 100	AAA	74.5, 202	BBB	64.5]
100	AAA	74.5
202	BBB	64.5
```

### Program 2b:-

```java
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

class Demo{
    public static void main(String[] args) {
            ArrayList<Product> al =new ArrayList<Product>();
            al.add(new Product(120,"XXX",34.5));
            al.add(new Product(100,"AAA",74.5));
            al.add(new Product(202,"BBB",64.5));

            System.out.println(al);
            al.remove(0);
            double amt=0;double t=0;
            for(var i:al){
                t=(i.up*2.0);
                System.out.println(i);
                amt+=t;
            }
            System.out.println("Amount to be paid: "+amt);
    }
}
```

-Output:-

```bash
[120	XXX	34.5, 100	AAA	74.5, 202	BBB	64.5]
100	AAA	74.5
202	BBB	64.5
Amount to be paid: 278.0
```

### Program 2c:-

```java
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

class Demo{
    public static void main(String[] args) {
            ArrayList<Product> al =new ArrayList<Product>();
            al.add(new Product(120,"XXX",34.5));
            al.add(new Product(100,"AAA",74.5));
            al.add(new Product(202,"BBB",64.5));

            Iterator<Product> itr=al.iterator();
            while(itr.hasNext())
                    System.out.println(itr.next());
    }
}
```

- Output:-

```bash
120	XXX	34.5
100	AAA	74.5
202	BBB	64.5
```

### Program 3:-

```java
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
```

- Output:-

```bash
Before sorting...[120	XXX	34.5, 100	AAA	74.5, 202	BBB	64.5]
100	AAA	74.5
202	BBB	64.5
120	XXX	34.5
```
