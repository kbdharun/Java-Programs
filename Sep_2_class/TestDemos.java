//Object as return
class Test{
		int a,b;
		Test incr(){
			Test t =new Test();
			a+=2;
			b+=2;
			t.a=a; t.b=b;
			return t;
		}
}
class TestDemos{
		public static void main(String args[]){
			Test t1=new Test();
			Test t2=new Test();
			//System.out.println("Before: a.."+t2.a+"\tb.."+t2.b);
			t2=t1.incr();
			System.out.println("After: a.."+t2.a+"\tb.."+t2.b);
		}
}
