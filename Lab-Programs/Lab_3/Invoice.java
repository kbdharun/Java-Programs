/* Java program using static
Question:
Create a class called Product with the following specifiation productID, productName, unitPrice and quantity.
The customer is purchasing 5 different product with 5 different quantity.
Compute and display invoice without using array of objects 
Static, static datamember, static memberfn, final (ifreq)
*/

import java.lang.*; /*Imports all lang packages, but we require java.lang.String package only*/
class Product{
int productID;
int quantity;
double unitPrice;
String productName;
double total;

static double grandtotal;
static {
grandtotal=0;
}
static final int  MAX = 5;
static int count=0;


static double compute(){

return grandtotal;
}

Product(){
productID=0;
quantity=0;
productName = " ";
unitPrice=0.0;}
Product(int productID, int quantity, String productName, double unitPrice){
this.productID = productID;
this.quantity = quantity;
this.productName = productName;
this.unitPrice = unitPrice;
grandtotal+=unitPrice*quantity;
count+=1;

if (count>MAX)
System.out.println("\nINVOICE INVALID\nMAX value is reached.");
}

void display(){
System.out.println("\t  "+productID+" \t\t  "+productName+"        \t\t  "+unitPrice+"        \t\t  "+quantity+"      \t\t         "+unitPrice*quantity);
}


}

class Invoice{
public static void main(String args[]){

System.out.println("\t Product ID \t\t Product Name \t\t Unit Price \t\t Quantity \t\t Total");
System.out.println("_______________________________________________________________________________________________________________");

Product p1 = new Product(1, 2, "Boost", 75.0);
Product p2 = new Product(2, 3, "Horlicks", 55.0);
Product p3 = new Product(3, 2, "Maggi noodles", 25.0);
Product p4 = new Product(4, 4, "PERK Chocolate", 45.0);
Product p5 = new Product(5, 3, "Goli soda", 10.0);
Product p6 = new Product(6, 3, "Paneer soda", 10.0);
p1.display();
p2.display();
p3.display();
p4.display();
p5.display();
p6.display();
//Product p7 = new Product();
System.out.println("GRAND TOTAL IS: "+ Product.compute());
}
}