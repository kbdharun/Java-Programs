class Print{
    synchronized void callPrint(String msg){
        System.out.print("["+msg);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){}
        System.out.println("]");
    }
}

//THREAD
class TestSyn implements Runnable{
        Thread t;
        Print target;
        String msg;
        TestSyn(Print target, String msg){
                this.target=target;
                this.msg=msg;
                t=new Thread(this);
        }     
        public void run(){
            synchronized(target){
                target.callPrint(msg);
            }
        }
}

class TestSynDemo{
        public static void main(String args[]){
            Print target=new Print();//Share resource
            TestSyn t1=new TestSyn(target,"Welcome");
            TestSyn t2=new TestSyn(target,"to");
            TestSyn t3=new TestSyn(target,"University");
            t1.t.start();
            t2.t.start();
            t3.t.start();
        }
}