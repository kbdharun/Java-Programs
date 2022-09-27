import java.util.Scanner;
class Test{
    public static void main(String args[]){
        int a=10;
        Scanner in=new Scanner(System.in);
        int b=in.nextInt();
        int x[]={10,20,30,40,50};
        String s[] = new String [10];
        try{
            System.out.println("Outer try...");
            try{
                a=a/b;
                int m=s[1].length();
                System.out.println("a="+a);
                System.out.println("X[5]"+x[5]);
            }
        catch(ArithmeticException e){
                System.out.println("Error.."+e); /**+e invokes 2 string function.
                 When developer return this function a detailed error message will be displayed.**/
        }
        catch(ArrayIndexOutOfBoundsException e){
                System.out.println("Error.."+e);
        }
    }
        catch(Exception e){ //Generic Handler
                System.out.println("Error.."+e);  
        }
        System.out.println("After catch...");
    }
}