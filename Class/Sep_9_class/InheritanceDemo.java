/*Inheritance*/
class A{
	private int a;
	A(int a){
		this.a=a;
		System.out.println("Constructor of A...");
	}
	void display(){
		System.out.println("A's..a...."+a);
	}
}
class B extends A{
	int b;
	//long a; //overriden data member
	B(int a,int b){
		super(a);
		this.b=b;
		//this.a=a;
		System.out.println("Constructor of B..");
	}
	void display(){
		super.display();
		System.out.println("B's..b...."+b);
	}
}
class InheritanceDemo{
	public static void main(String args[]){ 
		B b=new B(10,20);
		b.display();
	}
}
