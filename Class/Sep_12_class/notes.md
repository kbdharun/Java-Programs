# Notes (September 12,2022)

## Topics

- Dynamic Method Dispatch

## General Notes

- Dynamic Polymorphism - Binding happens at runtime.

### Dynamic Method Dispatch (DMD)

- *Rule:* Base class reference - Derived class object.
- *Constraint:* We can access only **overridden**.
- Base- int a; Derive- long a,b; 
- Where, a- Base class ref, B- Derived class reference.
- Dynamic Method Dispatch requires Inheritance.
- The suitable inheritance type for DMD is **Hierarchial**.
- NOTE: We can use base class reference not base class object.

### Program 1a: Dynamic Method Dispatch (Shape)

```java
/*Dynamic Method Dispatch- Runtime Poly*/
import java.util.Scanner;

class Shape{
	double dim1,dim2;
	Shape(double dim1,double dim2){
		this.dim1=dim1;
		this.dim2=dim2;
	}
	void area(){}
}

class Rectangle extends Shape{
	Rectangle(double l,double b){
		super(l,b); /**super is used here for practice it isn't mandatory.**/
	}
	void area(){
		System.out.println("Area of Rectangle.."+(dim1*dim2));
	}
}

class Triangle extends Shape{
	Triangle(double b,double h){
		super(b,h); //super is used here for practice it isn't mandatory.
	}
	void area(){
		System.out.println("Area of Triangle.."+(dim1*dim2/2.0));
	}
}
class DMDDemo{
	public static void main(String args[]){
		//Rectangle r=new Rectangle(45.6,78.9);
		//Triangle t=new Triangle(45.6,78.9);
		Shape s; //Base class reference 
		
		Scanner in=new Scanner(System.in);
		int ch=in.nextInt();
		if(ch==1) //Switch case can also be used
			s=r; //base class reference = derived class object
		else
			s=t; //base class reference = derived class object
			
	s.area(); /*This function when executed must exhibit 2 different behaviors*/
	}
}
```

```text
Error upon Compilation: 
 DMDDemo.java:39: error: cannot find symbol
			s=r; //base class reference = derived class object
			  ^
  symbol:   variable r
  location: class DMDDemo
DMDDemo.java:41: error: cannot find symbol
			s=t; //base class reference = derived class object
			  ^
  symbol:   variable t
  location: class DMDDemo
2 errors
```

### Program 1b: Using abstract class with DMD

```java
/*Dynamic Method Dispatch- Runtime Poly*/
import java.util.Scanner;

abstract class Shape{
	double dim1,dim2;
	Shape(double dim1,double dim2){
		this.dim1=dim1;
		this.dim2=dim2;
	}
	void area(){
	}
}

class Rectangle extends Shape{
	Rectangle(double l,double b){
		super(l,b); /**super is used here for practice it isn't mandatory.**/
	}
	void area(){
		System.out.println("Area of Rectangle.."+(dim1*dim2));
	}
}

class Triangle extends Shape{
	Triangle(double b,double h){
		super(b,h); //super is used here for practice it isn't mandatory.
	}
	void area(){
		System.out.println("Area of Triangle.."+(dim1*dim2/2.0));
	}
}
class DMDDemo{
	public static void main(String args[]){
		//Rectangle r=new Rectangle(45.6,78.9);
		//Triangle t=new Triangle(45.6,78.9);
		Shape s; //Base class reference 
		
		Scanner in=new Scanner(System.in);
		int ch= in.nextInt();
		if(ch==1) //Switch case can also be used
			s = new Rectangle(45.6,78.9); //Call area of rect;
		else
			s = new Triangle(45.6,78.9); //Call area of triangle;
			
	s.area(); /*This function when executed must exhibit 2 different behaviors*/
	}
}

```

```text
Output:
1
Area of Rectangle..3597.84

```

## Program 2:-

To Try: Create a class called Shape3d with overridden member function called volume, define the classes named sphere, cone and cylinder. Redefine volume method appropriately in each derived classes. Implement by using Dynamic method dispatch concept.

```java
/* Java program using DMD
Question:
Create a class called Shape3d with overridden member function called volume, define the classes named sphere, cone and cylinder. Redefine volume method appropriately in each derived classes. Implement by using Dynamic method dispatch concept.*/

import java.util.Scanner;

abstract class Shape3d{
	final double PI=3.14;
	double dim1,dim2;
	Shape3d(double dim1,double dim2){
		this.dim1=dim1;
		this.dim2=dim2;
	}
	void vol(){}
}

class Sphere extends Shape3d{
	Sphere(double r,double h){
		super(r,h);
	}
	void vol(){
		System.out.println("Volume of Sphere.."+((4/3)*PI*dim1*dim1*dim1));
	}
}

class Cone extends Shape3d{
	Cone(double r,double h){
		super(r,h);
	}
	void vol(){
		System.out.println("Volume of Cone.."+((1/3)*dim1*dim1*dim2));
	}
}

class Cylinder extends Shape3d{
	Cylinder(double r,double h){
		super(r,h);
	}
	void area(){
		System.out.println("Volume of Cylinder.."+(PI*dim1*dim1*dim2));
	}
}

class DMD2{
	public static void main(String args[]){
		Shape3d s; //Base class reference 
		
		Scanner in=new Scanner(System.in);
		int ch= in.nextInt();
		if(ch==1) //Switch case can also be used
			s = new Sphere(45.6,0.0);
		else if(ch==2)
			s = new Cone(45.6,78.9);
		else
			s = new Cylinder(45.6,78.9);
	s.vol();
	}
}

```

```text
Output:
1
Volume of Sphere..297731.08224
```
