package p2;
import p1.A;
public class B extends A{
    int b;
    public B(){
        super();
        b=20;
    }
    public String toString(){
        return "a="+a+"b="+b;
    }
}