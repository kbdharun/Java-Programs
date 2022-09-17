# Notes (September 2,2022)

## Topic

- Pass by reference
- Object as return

### Program 1: Pass by Reference

```java
//Pass by Reference Java Program
class Test{
		int a,b;
		void incr(Test t){
			t.a+=2;
			t.b+=2;
		}
}
class TestDemo{
		public static void main(String args[]){
			Test t1=new Test();
			Test t2=new Test();
			System.out.println("Before: a.."+t2.a+"\tb.."+t2.b);
			t1.incr(t2);
			System.out.println("After: a.."+t2.a+"\tb.."+t2.b);
		}
}
```

```text
Output:
Before: a..0	b..0
After: a..2	b..2
```

### Program 2a: Object as return

``java
//Object as return
import java.util.Scanner;
class Test{
		int a,b;
		void getTest(){
			Scanner in=new Scanner(System.in);
			a=in.nextInt();
			b=in.nextInt();
		}
		
		int avg(){
			return (a+b)/2;
		}
}
class TestDemo1{
		public static void main(String args[]){
			Test t[]=new Test[3]; //array declaration
			int avg=0;
			for(Test v:t){  //t can be array of object 
				v=new Test();
				v.getTest();
				avg+=v.avg();
			}
			System.out.println("Avg..."+(avg/t.length));
}
}
```

```text
Output:
1
2
3
4
5
6
Avg...3
```

### Program 2b: Object as return

```java
//Object as return
import java.util.Scanner;
class Test{
		int a,b;
		void getTest(){
			Scanner in=new Scanner(System.in);
			a=in.nextInt();
			b=in.nextInt();
		}
		
		int avg(){
			return (a+b)/2;
		}
}
class TestDemo2{
		public static void main(String args[]){
			//Scanner in=new Scanner(System.in);
			//int n=in.nextInt();
			Test t[][]=new Test[2][2]; //array declaration
			int avg=0;
			for(Test u[]:t){ // u is a collection of array, t is a colletion of one dimentional array
			for(Test v:u){  //t can be array of object 
				v=new Test();
				v.getTest();
				avg+=v.avg();
			}
		}
			System.out.println("Length of t..."+t.length*t[0].length);
			System.out.println("Avg..."+(avg/t.length));
		
	}
}
```

```text
Output:
1
2
3
4
5
6
7
8
Length of t...4
Avg...8
```

### Program 2c: Object as return

```java
//Object as return
class Test{
		int a,b;
		Test incr(){
			Test t =new Test();
			a+=2;
			b+=2;
			t.a=a; t.b=b;
			return t;
		}
}
class TestDemos{
		public static void main(String args[]){
			Test t1=new Test();
			Test t2=new Test();
			//System.out.println("Before: a.."+t2.a+"\tb.."+t2.b);
			t2=t1.incr();
			System.out.println("After: a.."+t2.a+"\tb.."+t2.b);
		}
}
```

```text
Output:
After: a..2	b..2
```
