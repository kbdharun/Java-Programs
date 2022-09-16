abstract class Inner{
	//abstract void display(); 
}
class Outer{
	int a;
	
	Outer(int a){
		this.a=a;
	}
	abstract class Inner{}
	void display(){
		System.out.println("Outer class...");
		new Inner(){
			int b;
			{
				b=10;
			}
			void display(){
				System.out.println("Inner class.."+b);
			}
		}.display();
		//new Student().display();
	}
}
class OuterDemo{
	public static void main(String args[]){
		Outer out=new Outer(10);
		out.display();
	}
}
