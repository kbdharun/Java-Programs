import java.io.DataInputStream;
import java.io.IOException;
class Test{
    static void test(){
        DataInputStream din=new DataInputStream(System.in);
        int a=din.readInt();
        Thread.sleep(100);
        System.out.println(a);
    }
    public static void main(String args[]){
        test();
    }
}