import java.util.Scanner;
class CurrentAccount extends Account{
	final double MAXAMT = 1000000.00;
	void deposit(){
		Scanner in = new Scanner(System.in);
		double amt = in.nextDouble();
		if (balance+amt < MAXAMT)
			balance+=amt;
		
	}

	void withdrawal(){
		Scanner in = new Scanner(System.in);
		double amt = in.nextDouble();
		if (balance<amt)
			System.out.println("Insufficient Balance!");
		else
			balance-=amt;
	}
}