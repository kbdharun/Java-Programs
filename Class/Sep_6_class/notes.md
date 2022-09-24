# Notes (Sep 6,2022)

## Topics

- Nested class
- Anonymous object and class
- Abstract class

## General Notes

- Class can be prefixed with static.
- In C,C++ we can define function after main, and we will get compilation error. Similarly in Java, it considers it as an undefined datamember.
- Abstract class:-
- Memory isn't allocated in class definition unless *static datamember* as class is a blueprint. And memory can only be allocated by Object.

### Nested class

- A class which is defined in another class.
- There are **2 ways to create a nested class**: *Static and non-static nested class*.
- Nested Scopes:

```(java)
{ //outer scope
	int a=12; //inner scope
	{
		int b=14;
	}
}
```

### Inner class

- Inner class can be static, and it can only access Static datamember and static member function of outer class.
- It is a **non-static nested class** or *static inner class*.

### Anonymous object and class

- Object created without name.
- Anonymous object is very commonly used in object classes.
- *Anonymous inner class* is class created without name.

```java
\*Sample*\
class Student{

}
class StudentDemo{
	public static void main(){
			Student s=new Student();
			s.display(); 
			new Student(); //anonymous class
	}
}
```

### Abstract class

- In abstract class we no need to create IIB block.

### Program 1: Invoking object in Outer class

```java
class Outer{
	int a;
	class Inner{
		void display(){
			System.out.println("Inner class...");
		}
	}
	Outer(int a){
		this.a=a;
	}
	void display(){
		System.out.println("outer...");
		Inner in=new Inner(); //object created
/*If the object is created inside a function the scope is only inside it.*/
		in.display();
	}
}
class OuterDemo{
	public static void main(String args[]){
		Outer out=new Outer(10);
		out.display();
		
	}
}
```

```text
Output:
outer...
Inner class...
```

## Program 2: Using abstract class

```java
abstract class Inner{
	abstract void display(); //abstract class forces inheritance
}
class Outer{
	int a;
	
	Outer(int a){
		this.a=a;
	}
	void display(){
		System.out.println("Outer class...");
		new Inner(){
			void display(){
				System.out.println("Inner class..");
			}
		}.display();
		//new Student().display();
	}
}
class OuterDemo{
	public static void main(String args[]){
		Outer out=new Outer(10);
		out.display();
	}
}
```

```text
Output:
Outer class...
Inner class..
```

- Continuation:

```java
abstract class Inner{
	//abstract void display(); 
}
class Outer{
	int a;
	
	Outer(int a){
		this.a=a;
	}
	abstract class Inner{}
	void display(){
		System.out.println("Outer class...");
		new Inner(){
			int b;
			{
				b=10;
			}
			void display(){
				System.out.println("Inner class.."+b);
			}
		}.display();
		//new Student().display();
	}
}
class OuterDemo{
	public static void main(String args[]){
		Outer out=new Outer(10);
		out.display();
	}
}
```

```text
Output:
Outer class...
Inner class..10
```
