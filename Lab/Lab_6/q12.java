import java.util.Scanner;
abstract class Account{ //Base class
    int accId;
    int cusId;
    Account(int accId ,int cusId){ //Constructor
        this.accId=accId;
        this.cusId=cusId;
    }
    abstract int deposit();
    abstract int withdraw();
   }
   class SavingsAccount extends Account{
    double balance;
    SavingsAccount(int accId, int cusId,double balance){
     super(accId,cusId);
     this.balance=balance;
    }
    int deposit(){
      if(accId>5000 && accId<9999){
       System.out.println("Enter the amount to be deposited:");
       Scanner sc = new Scanner(System.in);
       double amt=sc.nextDouble();
       balance += amt;
       System.out.println("The new balance is " + balance +" .");
       return (1);
      }
      else{
       return (-1);
      }
    }
    int withdraw(){
      if(accId>5000 && accId<9999 ){
       System.out.println("Enter the amount to withdraw:");
       Scanner sd = new Scanner(System.in);
       double amt=sd.nextDouble();
       if(amt<=balance){
        balance -= amt;
        System.out.println("The new balance is " + balance +" .");
        return (1);
       }
       else{
        System.out.println("Insufficient balance!! in account");
       return (2);
       }
      }
      else{
        return (-1);
     }
    }
   }
   class q12{
     public static void main(String args[]){
      Scanner sc = new Scanner(System.in);
      for(int i=0;i<5;i++){
      System.out.println("Enter Account Id, Customer Id, Balance");
      int accId =sc.nextInt();
      int cusId =sc.nextInt();
      double balance = sc.nextDouble();
      SavingsAccount s= new SavingsAccount(accId,cusId,balance);
      int ans;
      int ch;
      do{
         System.out.println("1. Deposit \n2.Withdraw\n 3.Exit");
         ch=sc.nextInt();
         switch(ch){
          case 1:
            ans=s.deposit();
            if(ans==1){
             System.out.println("Amount Deposited Successfully.");
            }
            else{
             System.out.println("Account number doesn't exist..\n Enter a valid Account Number and try again.");
            }
            break;
         case 2:
            ans=s.withdraw();
            if(ans==1){
             System.out.println(" Amount Withdrawed Successfully.");
            }
            else if(ans == 2){
            }
            else{
             System.out.println("Account number doesn't exist..\n Enter a valid Account number and try again.");
            }
            break;
       case 3:
          System.out.println("Thank you\nExiting Program");
          break;
       default:
          System.out.println("Invalid choice");
      }
     }while(ch!=3);
    }
  }
}
   