/*
Question:
Create a class called box with 3 datamembers with a overridden toString function to display the width, height and depth. Create a class called boxWeight with a datamember weight and overridden toString to display width, height and depth. Create a class called Shipment with cost datamember and overridden to display width, height, depth, weight and cost.*/

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
