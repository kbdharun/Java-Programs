# Notes (Sep 5,2022)

## Topics

- Static
- IIB
- Final Datamember

## General Notes

- If a compiler finds an error then there is an error in code, if error is prevent in jvm(java) there will be an exception.

### Static

- Static block
- Static datamember
- Static member function

### IIB

- **IIB** - **I**nstance **I**nitialization block.(Data member to be intialized with specific value.)
- IIB is created before a constructor, *before object creation a constructor must be created. (Same applies for default const)*.
- Only one compound block is allowed for IIB block.

### Final datamember

- It is used to create a symbolic constant.
- Final datamember --> constant (Data/value can't be changed if datamember is precided by final).
- Final memberfunction --> Prevents overriding.
- Final class --> No derived

## Programs

### Program 1: Using IIB Block

```java
/* Java program using IIB block*/
class Student{
	int regno;
	String name;
	{ //IIB
		regno=12003000;
		System.out.println("IIB");
	}
	Student(){
		name ="\0";
		System.out.println("Constructor..");
		regno=14;
	}
}
class StudentDemo{
	public static void main(String args[]){
		Student s=new Student();
		System.out.println("reg.."+s.regno);
	}
}
```

```text
Output: 
IIB
Constructor..
reg..14
```

## Program 2: Using static

```java
/* Java program using IIB block and static datamember*/

class Student{
	int regno;
	String name;
	int m1,m2,m3;
	/*{ //IIB
		regno=12003000;
		System.out.println("IIB");
	}*/
	
	static int count,avg;
	static{
		count=0;avg=0;
		System.out.println("Static block");
	}
	/*static void count(){
		count++;
	}*/
	static void classAvg(){
		System.out.println("class avg.."+ (avg/count));
	}
	Student(int regno,String name,int m1,int m2,int m3){
		this.regno=regno;
		this.name=name;
		this.m1=m1;
		this.m2=m2;
		this.m3=m3;
		avg+=((m1+m2+m3)/3);
		count++;
	}
	void avg(){
		System.out.println(name+":"+(m1+m2+m3)/3);
	}
}
class StudentDemo{
	public static void main(String args[]){
		Student s1=new Student(3001,"xxxx",98,67,56);
		s1.avg();
		Student s2=new Student(3002,"yyyy",88,67,56);
		Student.classAvg();
		s2.avg();
		Student s3=new Student(3003,"zzzz",38,67,56);
		s3.avg();
		Student.classAvg();
		//System.out.println("reg.."+s.regno);
		//System.out.println("Count.."+Student.count);
	}
}
```

```text
Output:
Static block
xxxx:73
class avg..71
yyyy:70
zzzz:53
class avg..65
```

## Program 3: Final datamember

```java
/* Java program using IIB block and static datamember*/

class Student{
	int regno;
	String name;
	int m1,m2,m3;
	/*{ //IIB
		regno=12003000;
		System.out.println("IIB");
	}*/
	
	static int count=0,avg=0;
	final float PI;
	static{
		count=0;avg=0;
		System.out.println("Static block");
	}
	/*static void count(){
		count++;
	}*/
	static void classAvg(){
		System.out.println("class avg.."+ (avg/count));
	}
	Student(int regno,String name,int m1,int m2,int m3){
		this.regno=regno;
		this.name=name;
		this.m1=m1;
		this.m2=m2;
		this.m3=m3;
		avg+=((m1+m2+m3)/3);
		PI=3.14f;
		count++;
	}
	void avg(){
		System.out.println(name+":"+(m1+m2+m3)/3);
	}
}
class StudentDemo{
	public static void main(String args[]){
		Student s1=new Student(3001,"xxxx",98,67,56);
		s1.avg();
		Student s2=new Student(3002,"yyyy",88,67,56);
		Student.classAvg();
		s2.avg();
		Student s3=new Student(3003,"zzzz",38,67,56);
		s3.avg();
		Student.classAvg();
		//System.out.println("reg.."+s.regno);
		//System.out.println("Count.."+Student.count);
	}
}
```

```text
Output:
Static block
xxxx:73
class avg..71
yyyy:70
zzzz:53
class avg..65
```

## Programs to try

- *Compute array of 3 distance using static datamember*.
