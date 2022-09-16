import java.util.Scanner;
class Customer{
	int customerID;
	String customerName;
	String customerAddress;
	Account obj;

	Customer(int customerID, String customerName, String customerAddress, Account obj){
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.obj = obj;
	}
}