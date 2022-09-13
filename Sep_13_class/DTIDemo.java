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
