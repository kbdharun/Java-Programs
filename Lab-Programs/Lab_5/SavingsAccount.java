package bank.acc.sav;
import bank.acc.Account;
import java.util.Scanner;
public class SavingsAccount extends Account{
	final double MAXAMT = 1000000.00;
	public void deposit(){
		Scanner in = new Scanner(System.in);
		double amt = in.nextDouble();
		if (balance+amt < MAXAMT)
			balance+=amt;
		
	}

	public void withdrawal(){
		Scanner in = new Scanner(System.in);
		double amt = in.nextDouble();
		if (balance<amt)
			System.out.println("Insufficient Balance!");
		else
			balance-=amt;
	}
}