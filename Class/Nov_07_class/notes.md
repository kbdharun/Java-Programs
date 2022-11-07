# Notes (November 07,2022)

## Topics

- Collections (Map)

## General Notes

- `<Key,value>`
- No duplicate key (But if you want to duplicate then there is a class weakset)
- Key is a unique identity for an object. It can be of any value but it is mostly an integer and sometimes string.
- Iterator can't be used with Map. Data member that allows Sequntial access allows Iterator.
- All collection classes are dynamic array (memory can be expanded or reduced) [By default initial memory is 16 bit].

## Map

- HashMap -> Map with a set of key value path. Hash value/code to be computed based on key not value as it allows duplicates. HashMap is unsorted.
    - `HashMap`<String,> hm= new HashMap<>();
- TreeMap -> It is sorted based on key.
- LinkedHashMap

## Double class (*Disassembeled*)

```bash
javap java.lang.Double
Compiled from "Double.java"
public final class java.lang.Double extends java.lang.Number implements java.lang.Comparable<java.lang.Double>, java.lang.constant.Constable, java.lang.constant.ConstantDesc {
  public static final double POSITIVE_INFINITY;
  public static final double NEGATIVE_INFINITY;
  public static final double NaN;
  public static final double MAX_VALUE;
  public static final double MIN_NORMAL;
  public static final double MIN_VALUE;
  public static final int SIZE;
  public static final int PRECISION;
  public static final int MAX_EXPONENT;
  public static final int MIN_EXPONENT;
  public static final int BYTES;
  public static final java.lang.Class<java.lang.Double> TYPE;
  public static java.lang.String toString(double);
  public static java.lang.String toHexString(double);
  public static java.lang.Double valueOf(java.lang.String) throws java.lang.NumberFormatException;
  public static java.lang.Double valueOf(double);
  public static double parseDouble(java.lang.String) throws java.lang.NumberFormatException;
  public static boolean isNaN(double);
  public static boolean isInfinite(double);
  public static boolean isFinite(double);
  public java.lang.Double(double);
  public java.lang.Double(java.lang.String) throws java.lang.NumberFormatException;
  public boolean isNaN();
  public boolean isInfinite();
  public java.lang.String toString();
  public byte byteValue();
  public short shortValue();
  public int intValue();
  public long longValue();
  public float floatValue();
  public double doubleValue();
  public int hashCode();
  public static int hashCode(double);
  public boolean equals(java.lang.Object);
  public static long doubleToLongBits(double);
  public static native long doubleToRawLongBits(double);
  public static native double longBitsToDouble(long);
  public int compareTo(java.lang.Double);
  public static int compare(double, double);
  public static double sum(double, double);
  public static double max(double, double);
  public static double min(double, double);
  public java.util.Optional<java.lang.Double> describeConstable();
  public java.lang.Double resolveConstantDesc(java.lang.invoke.MethodHandles$Lookup);
  public int compareTo(java.lang.Object);
  public java.lang.Object resolveConstantDesc(java.lang.invoke.MethodHandles$Lookup) throws java.lang.ReflectiveOperationException;
  static {};
}
```

## Comparator

```text
int compare(obj1,obj2)
=0
=Positive (-1)
=Negative (1)

boolean equals(obj1,obj2)

naturalSort
reverseSort()/reversed()

John Alice

Lastname firstname
```

## Programs

### Program 1a:-

```java
import java.util.*;

/* Reference: To add
HashMap<String,Double> hm=new HashMap<String,Double>();
ClassCastException
hm.put("Alice",12000.00)
hm.getValue("Alice")
*/

class Map{
    public static void main(String arg[]) {
        HashMap<String,Double> hm=new HashMap<String,Double>();
        hm.put("Alice",12000.00);
        hm.put("Bob",10000.00);
        hm.put("Clark",10000.00);
        hm.put("Darth",20000.00);
    
        Set<Map.Entry<String,Double>>set=hm.entrySet(); //navigatable set
        for(var me:set){
            System.out.println(me.getKey()+"\t+"+me.getValue());
        }
    }
}
```

### Program 1b:-

```java
//Sorted
import java.util.*;

class Map{
    public static void main(String arg[]) {
        TreeMap<String,Double> hm=new TreeMap<String,Double>();
        hm.put("Alice",12000.00);
        hm.put("Bob",10000.00);
        hm.put("Clark",10000.00);
        hm.put("Darth",20000.00);
        double d=hm.get("Darth");
        hm.put("Darth",d+5000.00);
        Set<Map.Entry<String,Double>> set=hm.entrySet(); //navigatable set
        for(var me:set){
            System.out.println(me.getKey()+"\t+"+me.getValue());
        }
    }
}
```

### Program 2:-

```java
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

        Set<Map.Entry<String,Double>> set=hm.entrySet();
        for(var me:set)
                System.out.println(me.getKey()+"\t"+me.getValue());
    }
}
```
