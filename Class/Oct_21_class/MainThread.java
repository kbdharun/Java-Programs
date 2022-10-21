class NewThread extends Thread{
        NewThread(String name){
                super(name);
                System.out.println("created..."+this.getName()+"state..."+this.getState());
        }
        public void run(){
            System.out.println(this.getName()+"..."+this.getState()+"..."+this.getPriority());
            try{
                for(int i=0;i<10;i++){
                        System.out.print(this.getName()+"....i...."+i);
                        Thread.sleep(1000); //long interger parameter
                }
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
}

class MainThread{
        public static void main(String args[]){
            NewThread t1 = new NewThread("Child1");
            t1.start();
            NewThread t2 = new NewThread("Child2");
            t2.start();
            Thread t = Thread.currentThread();
            System.out.println(t.getName()+"...."+t.getState()+"...."+t.getPriority()+"...."+t.isAlive());
            try{
                for(int i=0;i<5;i++){
                        System.out.print(t.getName()+"....i...."+i);
                        Thread.sleep(2000); //long interger parameter
                }
            }catch(InterruptedException e){
                System.out.println(e);
        }
    }
}