package bank.acc;
 public abstract class Account{
	public int accountNo;
	public double balance;

	public Account(){accountNo = 0; balance = 0.0;}
	public Account(int accountNumber, double balance){
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public void display(){
		System.out.println("Balance amount:"+balance+"\n");
	}

	public void deposit(){}
	public void withdrawal(){}
}