# Notes (November 04,2022)

## Topics

- Collection API (List, Set, Map)

## General Notes

- List is consecutive memory.
- Bucket - Hash like data structure.
- In set, list of objects is never stored in consecutive order and rather in hash.
- In Map-Reduce data structure, element is stored as a `<key,value>` pair.
- ArrayList is faster than LinkedList and retrieval is faster.
  
- ArrayList,LinkedList-Iterator, ListIterator(updation),comparator
- HashSet, TreeSet, LinedTreeSet-Iterator,Comparator
- HashMap, TreeMap, LinkedHashMap-Iterator,Comparator*.

## List

1. ArrayList (Options available-add,remove)
2. LinkedList (Options available-add,addFirst,addLast,addPrevios,remove,removeLast,removeFirst)

## Set

1. HashSet (unsorted set - as it stores data related to hash value)
2. TreeSet (sorted set)
3. LinkedHashSet

## Map

1. HashMap
2. TreeMap
3. LinkedHashMap

## LinkedList Package (`Disassembled`)

```bash
[user]$ javap java.util.LinkedList
Compiled from "LinkedList.java"
public class java.util.LinkedList<E> extends java.util.AbstractSequentialList<E> implements java.util.List<E>, java.util.Deque<E>, java.lang.Cloneable, java.io.Serializable {
  transient int size;
  transient java.util.LinkedList$Node<E> first;
  transient java.util.LinkedList$Node<E> last;
  public java.util.LinkedList();
  public java.util.LinkedList(java.util.Collection<? extends E>);
  void linkLast(E);
  void linkBefore(E, java.util.LinkedList$Node<E>);
  E unlink(java.util.LinkedList$Node<E>);
  public E getFirst();
  public E getLast();
  public E removeFirst();
  public E removeLast();
  public void addFirst(E);
  public void addLast(E);
  public boolean contains(java.lang.Object);
  public int size();
  public boolean add(E);
  public boolean remove(java.lang.Object);
  public boolean addAll(java.util.Collection<? extends E>);
  public boolean addAll(int, java.util.Collection<? extends E>);
  public void clear();
  public E get(int);
  public E set(int, E);
  public void add(int, E);
  public E remove(int);
  java.util.LinkedList$Node<E> node(int);
  public int indexOf(java.lang.Object);
  public int lastIndexOf(java.lang.Object);
  public E peek();
  public E element();
  public E poll();
  public E remove();
  public boolean offer(E);
  public boolean offerFirst(E);
  public boolean offerLast(E);
  public E peekFirst();
  public E peekLast();
  public E pollFirst();
  public E pollLast();
  public void push(E);
  public E pop();
  public boolean removeFirstOccurrence(java.lang.Object);
  public boolean removeLastOccurrence(java.lang.Object);
  public java.util.ListIterator<E> listIterator(int);
  public java.util.Iterator<E> descendingIterator();
  public java.lang.Object clone();
  public java.lang.Object[] toArray();
  public <T> T[] toArray(T[]);
  public java.util.Spliterator<E> spliterator();
}
```

## Programs

### Program 1a:-

```java
import java.util.*;
class Test{
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("Alice");
        ll.add("Clark");
        ll.add("Bob");
        ll.add("Darth");
        System.out.println(ll);

        Iterator<String> itr=ll.iterator();
        while(itr.hasNext())
                System.out.println(itr.next());
    }
}
```

- Output:-

```bash
[Alice, Clark, Bob, Darth]
Alice
Clark
Bob
Darth
```

### Program 1b:-

```java
import java.util.*;

class MyComp implements Comparator<String>{
    public int compare(String a,String b){
        return a.compareTo(b);
    }
}

class Test{
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("Alice");
        ll.add("Clark");
        ll.add("Bob");
        ll.add("Darth");
        System.out.println(ll);
        Collections.sort(ll,new MyComp());

        Iterator<String> itr=ll.iterator();
        while(itr.hasNext())
                System.out.println(itr.next());
    }
}
```

- Output:-

```bash
[Alice, Clark, Bob, Darth]
Alice
Bob
Clark
Darth
```

### Program 1c:-

```java
import java.util.*;

class MyComp implements Comparator<String>{
    public int compare(String a,String b){
        return a.compareTo(b);
    }
}

class Test{
    public static void main(String[] args){
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("Alice");
        ll.add("Clark");
        ll.add("Bob");
        ll.add("Darth");
        System.out.println(ll);
        Collections.sort(ll,new MyComp());

        ListIterator<String> itr=ll.listIterator();
        while(itr.hasNext()){
                String e=itr.next();
                itr.set(e+"...");
        }
        System.out.println(ll);
    }
}
```

- Output:-

```bash
[Alice, Clark, Bob, Darth]
[Alice..., Bob..., Clark..., Darth...]
```

### Program 1d:-

```java
import java.util.*;

class MyComp implements Comparator<String>{
    public int compare(String a,String b){
        return a.compareTo(b);
    }
}

class Test{
    public static void main(String[] args){
        LinkedList<String> ll = new LinkedList<String>();
        ll.add("Alice");
        ll.add("Clark");
        ll.add("Bob");
        ll.add("Darth");
        ll.addFirst("xxx");
        //Collections.sort(ll,new MyComp());

        ListIterator<String> itr=ll.listIterator();
        while(itr.hasNext()){
                String e=itr.next();
                itr.set(e+"...");
        }
        System.out.println(ll);
    }
}
```

- Output:-

```bash
[xxx..., Alice..., Clark..., Bob..., Darth...]
```

### Program 1e:-

```java
import java.util.*;

class MyComp implements Comparator<String>{
    public int compare(String a,String b){
        return a.compareTo(b);
    }
}

class Test{
    public static void main(String[] args){
        HashSet<String> ll = new HashSet<String>();
        ll.add("Alice");
        ll.add("Clark");
        ll.add("Bob");
        ll.add("Darth");

        //for(var i:ll)
        //    System.out.println(ll);
        System.out.println(ll);
    }
}
```

- Output:-

```bash
[Clark, Bob, Darth, Alice]
```

### Program 1f:-

```java
import java.util.*;

class MyComp implements Comparator<String>{
    public int compare(String a,String b){
        return a.compareTo(b);
    }
}

class Test{
    public static void main(String[] args){
        HashSet<String> ll = new HashSet<String>();
        ll.add("Alice");
        ll.add("Clark");
        ll.add("Bob");
        ll.add("Darth");

        for(var i:ll)
            System.out.println(i+"\t"+i.hashCode());
        System.out.println(ll);
    }
}
```

```bash
Clark	65190193
Bob	66965
Darth	65802409
Alice	63350368
[Clark, Bob, Darth, Alice]
```

### Program 1g:-

```java
import java.util.*;

class Test{
    public static void main(String[] args){
        TreeSet<String> ll = new TreeSet<String>((fstr,sstr)->fstr.compareTo(sstr)); //lambda expression
        ll.add("Alice");
        ll.add("Clark");
        ll.add("Bob");
        ll.add("Darth");

        for(var i:ll)
            System.out.println(i+"\t"+i.hashCode());
       // System.out.println(ll);
    }
}
```

- Output:-

```bash
Alice	63350368
Bob	66965
Clark	65190193
Darth	65802409
```

### To try:-

- Create employee class with empname, id and basic_name as data members compute DA(Dearness Allowance),HRA, DF, NetPay,GrossPay, DA is 10% of Basic Pay, HRA % of Bpay, Gross pay = Basic pay+DA+HRA. Create ArrayList to store 5 employee objects compute pay slip for each employee, Display the list based on the sorted order of Basic/Net pay. Use ArrayList, Iterator, Comparator.

