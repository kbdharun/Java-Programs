/*Java program to find distance*/

/* Question
Create a class called Point with 2 cartisian coordiantes x,y as a data member.
 To:-	
	Define no argument constructor to initiate x,y= 0;
	Define parametrerized constructor and also define copy constructor;
	Define a function findDistance() with 2 parameters x,y;
	Define find distance function by passing 2 point object as a parameter;
	display() x and y value.
	Find distance:- (int,int),(point),(point, point)

Also, Self document the program*/

import java.lang.*; /*Imports all packages we need*/
/*"java.lang.Math" package used for pow command can be imported seperately too*/

class Point{
	int x;
	int y;
	
	Point() // Default constructor
	{
		x=0;
		y=0;
	}
	
	Point(int x1, int y1) // Parameterized constructor
	{
		x=x1;
		y=y1;
	}

	Point(Point p1) // Copy constructor
	{
		x = p1.x;
		y = p1.y;
	}
	
	double findDistance(int x, int y) /* Calculates distance for 2 points (int,int) */
	{
		return Math.sqrt(Math.pow((this.x-x),2)+Math.pow((this.y-y),2));
	}
	double findDistance(Point p) /* Calculates distance for 1 point*/
	{
		return Math.sqrt(Math.pow((x-p.x),2)+Math.pow((y-p.y),2));
	}
	double findDistance(Point p1, Point p2) /* Calculates distance for 2 points */
	{
		return Math.sqrt(Math.pow((p1.x-p2.x),2)+Math.pow((p1.y-p2.y),2));
	}
	
	void display() /* This command displays the coordinates */
	{
		System.out.println("("+x+","+y+")");
	}
}

class Points{
	public static void main(String[] args){

	/*Creating Objects*/
	Point p = new Point(5,2);
	Point p1 = new Point(2,2);
	Point p3 = new Point();

	/*Displaying Coordinates*/
	System.out.println("The points are");
	p.display();
	p1.display();

	System.out.println("The distance between the points is");
	System.out.println(p.findDistance(2,2)); /* Finding distance int,int */
	System.out.println(p.findDistance(p1)); /* Finding distance point */
	System.out.println(p3.findDistance(p1,p)); /* Finding distance point,point */
	}
}