//Pass by Reference Java Program
class Test{
		int a,b;
		void incr(Test t){
			t.a+=2;
			t.b+=2;
		}
}
class TestDemo{
		public static void main(String args[]){
			Test t1=new Test();
			Test t2=new Test();
			System.out.println("Before: a.."+t2.a+"\tb.."+t2.b);
			t1.incr(t2);
			System.out.println("After: a.."+t2.a+"\tb.."+t2.b);
		}
}
