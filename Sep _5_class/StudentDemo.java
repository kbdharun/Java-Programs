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
