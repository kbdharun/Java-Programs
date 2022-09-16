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

