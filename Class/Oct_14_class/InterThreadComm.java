//Shared resource program on Interthread communication
class Q{
    int v;
    boolean semaphore=false;
    synchronized void put(int v){
        //wait signal
        while(semaphore)
                try{
                        wait();
                }catch(InterruptedException e){}
        
        //task
        this.v=v;
        System.out.println("Put..."+v);

        //signal
        semaphore=true;
        //notify(); (deadlock)
    }
    synchronized void get(){
        //wait
        while(!semaphore)
                try{
                        wait();
                }catch(InterruptedException e){}
                System.out.println("Semaphore ..."+semaphore);
                System.out.println("Got..."+v);
        
        //signal
        semaphore=false;
        notify();
    }
}
//Producer Thread
class Producer implements Runnable{
        Thread t;
        Q q;
        Producer(Q q){
                this.q=q;
                t=new Thread(this, "Producer");
        }
        public void run(){
                int i=0;
                while(true)
                        q.put(++i);
        }
}
//Consumer Thread
class Consumer implements Runnable{
        Thread t;
        Q q;
        Consumer(Q q){
                this.q=q;
                t=new Thread(this, "Consumer");
        }
        public void run(){
                while(true)
                        q.get();
        }
}

class InterThreadComm{
                public static void main(String args[]){
                        Q q=new Q();
                        Producer p=new Producer(q);
                        Consumer c =new Consumer(q);
                        p.t.start();
                        c.t.start();
                }
}