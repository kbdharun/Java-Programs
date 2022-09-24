// Simple helloworld program
import java.lang.*;
class HelloWorld{
	public static void main(String args[]){
		for(int i=0;i<10;i++)
		{
		if(i==5)
		break;
		System.out.println("Hello world "+i);
		}
		}
}

/* Note Avoid * while importing packages as it will increase the compile time.
 But it can be used when you don't know the package in which your function resides. */