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

