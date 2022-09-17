# Notes (September 13,2022)

## Topics

- Dynamic Type Inference with Multi Level Inheritance

## General Notes

- If we don't know a primitve or user defined data type we use where.
- Java allows Dynamic type casting.

### Dynamic Type Inference with Multi Level Inheritance

- Rule: Base class reference is compatible with derived class object.
- Property of Class A --Inherited->B(Direct Derived class)-->C (Indirect derived class).
- A's reference is compatible with Direct and Indirect derived classes.
- In DMD and here use anonymous nameless obj class inference.

### Program 1(a):-

```java
/*Java programs using DTI- Multilevel inheritance*/

import java.util.Scanner;
class MyClass
{
	int x;
	public String toString(){
		return "MyClass";
	}
}
class FirstClass extends MyClass
{
	int y;
	public String toString(){
		return "FirstClass";
	}
}
class SecondClass extends FirstClass
{
	int z;
	public String toString(){
		return "SecondClass";
	}
}
class DTIDemo{
	static MyClass getObj(int which){
		switch(which){
			case 1: return new MyClass();
			case 2: return new FirstClass();
			default: return new SecondClass();
		}
	}
	MyClass m=new MyClass();
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int ch= in.nextInt();
		var obj=getObj(ch);
		System.out.println("Object created..."+obj);
	/*toString doesn't require seperate calling.*/
	}
}
```

```text
Output:
1
Object created...MyClass
```

### Program 1(b):-

```java
/*Java programs using DTI- Multilevel inheritance*/

import java.util.Scanner;
class MyClass
{
	int x;
	MyClass(){x=10;};
	public String toString(){
		return "x="+x;
	}
}
class FirstClass extends MyClass
{
	int y;
	FirstClass(){super(); y=20;};
	public String toString(){
		return "x="+x+"y="+y;
	}
}
class SecondClass extends FirstClass
{
	int z;
	SecondClass(){super();z=30;};
	public String toString(){
		return "x="+x+"y="+y+"x="+z;
	}
}
public class DTIDemo{
	static MyClass getObj(int which){
		switch(which){
			case 1: return new MyClass();
			case 2: return new FirstClass();
			default: return new SecondClass();
		}
	}
	MyClass m=new MyClass();
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int ch= in.nextInt();
		var obj=getObj(ch);
		System.out.println("Object created..."+obj);
	/*to call to String Method*/
	}
}
```

```text
Output:
1
Object created...x=10
```

### Program 2:-

- Using Multilevel Inheritence.
- Create a class called box with 3 datamembers with a overridden toString function to display the width, height and depth. Create a class called boxWeight with a datamember weight and overridden toString to display width, height and depth. Create a class called Shipment with cost datamember and overridden to display width, height, depth, weight and cost.
- Hint:

```text
Box
|width,height,depth,toString()
BoxWeight
|Weight toString()
Shipment
|cost toString()

```

```java
import java.util.Scanner;
class box
{
	int x,y,z;
	box(int a,int b,int c){
	x=a;
	y=b;
	z=c;
	}
	public String toString(){
		return "x ="+x+"y="+y+"z="+z;
	}
}
class boxWeight extends box
{
	int w;
	boxWeight(int a, int b, int c, int d){
		super(a,b,c);
		w=d;
	}
	public String toString(){
		return "x="+x+" y="+y+" z ="+z+" weight ="+w;
	}
}
class Shipment extends boxWeight
{
	int cost;
	Shipment(int a,int b,int c,int d,int e){
		super(a,b,c,d);
		cost=e;
	}
	public String toString(){
		return "x ="+x+" y ="+y+" x ="+z+" weight ="+w+" cost"+cost;
	}
}
public class Box{
	static box getObj(int which){
		switch(which){
			case 1: return new box(1,2,3);
			case 2: return new boxWeight(1,2,3,4);
			default: return new Shipment(1,2,3,4,5);
		}
	}
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int ch= in.nextInt();
		var obj=getObj(ch);
		System.out.println("Object created..."+obj);
	}
}
```

```text
Output:
1
Object created...x =1y=2z=3
```
