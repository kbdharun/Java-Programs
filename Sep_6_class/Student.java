class Student{
	int regno;
	String name;
	class DOB{
		int d,m,y;
		DOB(int d,int m,int y){
			this.d=d;
			this.m=m;
			this.y=y;
		}
	}
	DOB dob;
	Student(int regno, String name,DOB dob, int d,int m,int y){
		dob=new DOB(d,m,y);
		this.regno=regno;
		this.name=name;
		this.dob=dob;
	}
}
class StudentDemo{
	public static void main(String args[]){
		Student s=new Student(1200,"XXX",6,12,2005);
	}
}
