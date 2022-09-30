class NegativeValueException extends Exception{ //Exception handler
    double v;
    NegativeValueException(double v){
        this.v=v;
    }
    public String toString(){
        return v+" is negative";
    }
}
class Account{
    int acno;
    double bal;
    Account(int acno,double bal){
        this.acno=acno;
    try{
        if (bal<0)
            throw new NegativeValueException(bal);
        this.bal=bal;
    }catch(NegativeValueException e){
        System.out.println(e.getClass()+""+e);
    }
}
    public String toString(){
        return acno+"\t"+bal;
    }
}
class AccountDemo{
    public static void main(String args[]){
        Account a=new Account(1200,-450);
        System.out.println("Account Created");
    }
}