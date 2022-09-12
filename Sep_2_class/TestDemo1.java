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
