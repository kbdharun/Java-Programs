import java.util.Scanner;
abstract class University
{
 String str[]={"CSE","IT","ECE","ICT","EEE","EIE"};
 int max[]={60,55,50,45,40,40};
 abstract void admit(double p);
}

class SOC extends University
{
 SOC()
 {

 }
 void admit(double percentage)
 {
  if(percentage>9.0)
  {
   System.out.println("You are admitted in SOC-CSE");
   max[0]--;
  }

  else if(percentage>8.5)
  {
   System.out.println("You are admitted in SOC-IT");
   max[1]--;
  }

  else if(percentage>7.5)
  {
   System.out.println("You are admitted in SOC-ICT");
   max[3]--;
  }
 }

}
class SEEE extends University
{
 SEEE()
 {

 }
 void admit(double percentage)
 {
  if(percentage>8.5)
  {
   System.out.println("You are admitted in SEEE-ECE");
   max[2]--;
  }

  else if(percentage>7.0)
  {
   System.out.println("You are admitted in SEEE-EEE");
   max[4]--;
  }

  else if(percentage>6.5)
  {
   System.out.println("You are admitted in -SEEE-EIE");
   max[5]--;
  }
 }
}
class Student
{
 int stuid;
 String sname;
 double percentage;
 University admitted_school;

 Student(int id,String nm,double pr,University u)
 {
  stuid=id;
  sname=nm;
  percentage=pr;
  admitted_school=u;
 }
 public String toString()
 {
  return (stuid+"\t"+sname+"\t"+percentage+"\t"+admitted_school.getClass());
 }
}
class StudentDemo
{
 public static void main(String args[])
 {
  Scanner sc=new Scanner(System.in);
  int s_id;
  String s_name;
  double per;


  University admitted_school;

  Student obj[]=new Student[120];
  for(int i=0;i<10;i++)
  {

   System.out.println("Enter student id,student name,and percentage in +2 examination");
   s_id=sc.nextInt();
   s_name=sc.next();
   per=sc.nextDouble();
   if(per>8.5)
   {
    admitted_school=new SOC();
    obj[i]=new Student(s_id,s_name,per,admitted_school);
    
    obj[i].admitted_school.admit(per);

   
   }
   else if(per>7.5&&per<8)
   {
    admitted_school=new SOC();
    obj[i]=new Student(s_id,s_name,per,admitted_school);
    
    obj[i].admitted_school.admit(per);

   }

   else if(per>8)
   {
    
     admitted_school=new SEEE();
      obj[i]=new Student(s_id,s_name,per,admitted_school);
    
    obj[i].admitted_school.admit(per);
   }

   else 
   {
    admitted_school=new SEEE();
    obj[i]=new Student(s_id,s_name,per,admitted_school);
    
    obj[i].admitted_school.admit(per);
   }
   

 }
 for(int i=0;i<10;i++)
 {
  System.out.println(""+obj[i]);
 }
 }
}
