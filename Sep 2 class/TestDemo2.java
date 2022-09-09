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
