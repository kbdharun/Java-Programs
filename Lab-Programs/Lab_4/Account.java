
abstract class Account{
	int accountNo;
	double balance;

	Account(){accountNo = 0; balance = 0.0;}
	Account(int accountNumber, double balance){
		this.accountNo = accountNo;
		this.balance = balance;
	}

	void display(){
		System.out.println("Balance amount:"+balance+"\n");
	}

	abstract void deposit();
	abstract void withdrawal();
}