import java.util.Scanner;
class CustomerDemo{
	static Account objCreation(){
		System.out.println("Enter account type\n");
		System.out.println("1. Savings Account\n2. Current Account");
		Scanner in = new Scanner(System.in);
		int ch = in.nextInt();
		switch(ch){
			case 1: return new SavingsAccount();
			default: return new CurrentAccount();
		}
	}

	public static void main(String args[]) {
		Account C[] = new Account[5];
		for (int i=0; i<5; i++){
			Scanner in = new Scanner(System.in);
			System.out.println("Account No: ");
			int accNo = in.nextInt();
			System.out.println("Balance: ");
			double balance = in.nextDouble();
			C[i] = objCreation();
			C[i].accountNo = accNo;
			C[i].balance = balance;
			C[i].display();
			System.out.println( "1. Deposit \n2. Withdrawal\n");
			int ch = in.nextInt();
			switch(ch){
				case 1: C[i].deposit(); break;
				default: C[i].withdrawal(); break;
			}
			C[i].display();
		}
	}
}