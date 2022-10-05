/*Java Program on Chained Exception*/

import java.util.Scanner;
class InvalidOperatorException extends Exception{
		char operator;
		InvalidOperatorException(char operator){
		this.operator = operator;
	}

public String toString(){
		return ""+this.getClass();
/*"" automatically calls 2 string otherwise class will be called and outputted*/
	}
}

class OperationFailedException extends Exception{
			char chr;
			String str;
			Throwable obj;
			OperationFailedException(char chr){
			this.chr = chr;
	}

	OperationFailedException(String str ,Throwable obj){
			this.str= str;
			this.obj = obj;
	}

	public String toString(){
		return ""+this.getClass();
	}
}

class ChainedExceptionDemo{
public static void main(String args[]){
	try{
		Scanner in = new Scanner(System.in);
		String op1, op2;
		System.out.println("Enter operand 1: ");
		op1 = in.next();
		System.out.println("Enter operand 2: ");
		op2 = in.next();
		int a = Integer.parseInt(op1);
		int b = Integer.parseInt(op2);
		System.out.println("Enter operator");
		char op = in.next().charAt(0);
		switch(op){
		case '+':
			System.out.println("Result = "+(a+b));
			break;
		case '-':
			System.out.println("Result = "+(a-b));
			break;
		case '*':
			System.out.println("Result = "+(a*b));
			break;
		case '/':
			System.out.println("Result = "+(a/b));
			break;
		case '%':
			System.out.println("Result = "+(a%b));
			break;
		default:
			OperationFailedException e = new OperationFailedException(op);
			e.initCause(new InvalidOperatorException(op));
			throw e;
		}
	}catch(Exception e){
		System.out.println("ExceptionCatched:"+e+" "+e.getCause());
		}
	}
}

