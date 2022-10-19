import java.util.Random;

//Volatile
class Student1{
    static volatile int count=0;
    int rno;
    Student1(int rno){
            this.rno=rno;
            count++;
    }
    public String toString(){
        return count+"created.."+"rno:"+rno;
    }
}

class NewThread implements Runnable{
    Thread t;
    NewThread(String name){
        t=new Thread(this,name);
    }
    public void run(){
        Random r=new Random();
        int i=0;
        Student1 s;
        while(i<0){
            s=new Student1(r.nextInt());
            System.out.println(s);i++;
        }
    }
}

class Demo{
    public static void main(String args[]){
            NewThread t1=new NewThread("First");
            t1.t.start();
            NewThread t2=new NewThread("Second");
            t2.t.start();
            NewThread t3=new NewThread("Third");
            t3.t.start();
    }
}