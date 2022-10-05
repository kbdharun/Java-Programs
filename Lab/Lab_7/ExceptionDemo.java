/*Credits to Mudit Golchha*/
/*
create an exception class Invalidoperation with one data member of type char with one parameter consrt and overidden tostring function. define another 
exception named operationfailexception with two overloaded const - one constructor with parameter char , another const with two parameter'of type 
string and of throwable
cause/ reason for operationfailedException should be invalidoperatorexception. implement this usin chained exception.
*/
import java.util.Scanner;
class OperationFailedException extends Exception{
	char operator;	
	String q;
	Throwable t;
	OperationFailedException(char operator){
		this.operator = operator;
	}
	OperationFailedException(String str, Throwable cause){
		q = str;
		t = cause;
	}
	public String toString(){
		return " "+this.getClass();
	}
	
}

class OperandFailedException extends Exception{
	String w;
	char g;
	Throwable t;
	OperandFailedException(char operator){
		g = operator;
	}
	OperandFailedException(String str, Throwable cause){
		w =str;
		t = cause;
	}
	public String toString(){
		return " "+this.getClass();
	}
}
	




class InvalidOperationException extends Exception{
	char operator;
	InvalidOperationException(char operator){
		this.operator = operator;
	}
	public String toString(){	
		return " "+this.getClass();
	}
}

public class ExceptionDemo
{
	public static void main(String[] args){
		
		try{
			Scanner in = new Scanner(System.in);
			String op1,op2;
			System.out.println("Enter the oprand: ");
			op1 = in.next();
			op2 = in.next();
			System.out.println("Enter the operator : ");
			char g = in. next().charAt(0);
			if(isInteger(op1 , 10) && isInteger(op2,10) ){
				int a = Integer.parseInt(op1);
				int b = Integer.parseInt(op2);
				switch(g){
					case '+':
						System.out.println("Add.."+(a+b));
						break;
					case '-':
						System.out.println("sub.."+(a+b));
						break;
					case '/':
						System.out.println("div.."+(a+b));
						break;
					case '*':
						System.out.println("mul.."+(a+b));
						break;
					case '%':
						System.out.println("mod.."+(a+b));
						break;
					default :
						OperationFailedException e = new OperationFailedException(g);
						e.initCause(new InvalidOperationException(g));
						throw e;
				}
			}
			else{
				OperandFailedException e = new OperandFailedException(g);
				e.initCause(new InvalidOperationException(g));
				throw e;
			}
			System.out.println("$$$$$$$");
		}
		
		catch (Exception e){
			System.out.println("Error.."+e+" "+e.getCause());
		}				
	}
	public static boolean isInteger(String s, int radix) {
    		if(s.isEmpty()) 
			return false;
    		for(int i = 0; i < s.length(); i++) 
		{
       			 if(i == 0 && s.charAt(i) == '-') {
           			 	if(s.length() == 1) 
					return false;
            			else 
					continue;
      			  }
       			 if(Character.digit(s.charAt(i),radix) < 0) 
				return false;
   		 }
   		 return true;
	}
}