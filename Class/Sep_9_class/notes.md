# Notes (September 9,2022)

## Topics

- Reusability
- Inheritance
- Access Specifiers

## General Notes

- Interface is completely abstract class.
- Base class constructor is called first when using super keyword.
- Dot [.] is the only allowed member axis datamember.
- Datatype mismatch is allowed in overloading.
- Overloading is a way of implementing static polymorphism, whereas overriding is a way of implementing dynamic polymorphism.
- super.memfunc resolves conflict of base class datamember and dervived class

### Reusability

- It is possible due to Inheritance. (Inheritance<-->Reusability)

### Inheritance

- **Types:**
  
1. Single (A->B)
2. Multiple (Generalisation) ([A,B]->C)
3. Hierarchial (Specialisation) (A->[B,C])
4. Multi-level (A->B->C)

```java
class <superclass>{
...
...
}
class <subclass> extends <baseclass>{
... // Adding new function
... //Existing function can be modified.
... //Deletion with access specifier.
}
```

- Extends, super <-- keyword
- Example: A->B (A,B has disp functions);when using Inheritance data will be allocated for A in B and the data members are shared.

### Access Specifiers

- Private
- Public
- Protected

### Use of super keyword:

1. To invoke/call base class constructor.
2. To access overriden data member.
3. To call overriden member function.

### Overriding and Overloading

```text
//Overloading

void findDistance(int,int);

void findDistance(Point p);

void findDistance(Point p1, Point p2);

// Overriding

void findDistance(Point p1,Point p2);
```

### Program 1a: Basic Inheritance Program

```java
/*Inheritance*/
class A{
	int a;
	void dispA(){
		System.out.println("A's..a...."+a);
	}
}
class B extends A{
	int b;
	void dispB(){
		System.out.println("B's..b...."+b);
	}
}
class InheritanceDemo{
	public static void main(String args[]){ 
		B b=new B();
		b.dispB();
		b.dispA();
	}
}
```

```text
Output:
B's..b....0
A's..a....0
```

### Program 1b: Inheritance Program using Default Constructor

```java
/*Inheritance*/
class A{
	int a;
	A(){
		System.out.println("Constructor of A...");
	}
	void dispA(){
		System.out.println("A's..a...."+a);
	}
}
class B extends A{
	int b;
	B(){
		System.out.println("Constructor of B..");
	}
	void dispB(){
		System.out.println("B's..b...."+b);
	}
}
class InheritanceDemo{
	public static void main(String args[]){ 
		B b=new B();
		b.dispB();
		b.dispA();
	}
}
```

```text
Output:
Constructor of A...
Constructor of B..
B's..b....0
A's..a....0
```

### Program 2: Inheritance using super keyword

```java
/*Inheritance*/
class A{
	int a;
	A(int a){
		this.a=a;
		System.out.println("Constructor of A...");
	}
	void dispA(){
		System.out.println("A's..a...."+a);
	}
}
class B extends A{
	int b;
	B(int a,int b){
		super(a);
		this.b=b;
		System.out.println("Constructor of B..");
	}
	void dispB(){
		System.out.println("A's..a...."+a);
		System.out.println("B's..b...."+b);
	}
}
class InheritanceDemo{
	public static void main(String args[]){ 
		B b=new B(10,30);
		b.dispB();
		b.dispA();
	}
}
```

```text
Output:
Constructor of A...
Constructor of B..
A's..a....10
B's..b....30
A's..a....10
```

### Program 3a: Inheritance using super keyword with an overriden datamember

- Note: We can refine existing datamember in base class using super keyword.

```java
/*Inheritance*/
class A{
	int a;
	A(int a){
		this.a=a;
		System.out.println("Constructor of A...");
	}
	void dispA(){
		System.out.println("A's..a...."+a);
	}
}
class B extends A{
	int b;
	int a; //overriden data member
	B(int aa,int a,int b){
		super(aa);
		this.b=b;
		System.out.println("Constructor of B..");
	}
	void dispB(){
		System.out.println("A's..a...."+a);
		System.out.println("B's..b...."+b);
	}
}
class InheritanceDemo{
	public static void main(String args[]){ 
		B b=new B(10,20,30);
		b.dispB();
		b.dispA();
	}
}
```

```text
Output:
Constructor of A...
Constructor of B..
A's..a....0
B's..b....30
A's..a....10
```

### Program 3b: Inheritance using super keyword with an overriden datamember(long)

```java
/*Inheritance*/
class A{
	int a;
	A(int a){
		this.a=a;
		System.out.println("Constructor of A...");
	}
	void dispA(){
		System.out.println("A's..a...."+a);
	}
}
class B extends A{
	int b;
	int a; //overriden data member
	B(int aa,int a,int b){
		super(aa);
		this.b=b;
		this.a=a;
		System.out.println("Constructor of B..");
	}
	void dispB(){
		System.out.println("A's..a...."+super.a);
		System.out.println("B's..a...."+a);
		System.out.println("B's..b...."+b);
	}
}
class InheritanceDemo{
	public static void main(String args[]){ 
		B b=new B(10,20,30);
		b.dispB();
		//b.dispA();
	}
}
```

```text
Output:
Constructor of A...
Constructor of B..
A's..a....10
B's..a....20
B's..b....30
```

### Program 4: Calling member function using Super

```java
/*Inheritance*/
class A{
	private int a;
	A(int a){
		this.a=a;
		System.out.println("Constructor of A...");
	}
	void display(){
		System.out.println("A's..a...."+a);
	}
}
class B extends A{
	int b;
	//long a; //overriden data member
	B(int a,int b){
		super(a);
		this.b=b;
		//this.a=a;
		System.out.println("Constructor of B..");
	}
	void display(){
		super.display();
		System.out.println("B's..b...."+b);
	}
}
class InheritanceDemo{
	public static void main(String args[]){ 
		B b=new B(10,20);
		b.display();
	}
}
```

```text
Output:
Constructor of A...
Constructor of B..
A's..a....10
B's..b....20
```
