/* Simple Program using Threading */
class MainThread{
        public static void main(String[] args) {
            Thread t=Thread.currentThread();
            System.out.println(t.getName()+"..."+t.getState()+"..."+t.getPriority()+"..."+t.isAlive());
        try{
            for (int i=0;i<10;i++){
                System.out.println(t.getName()+"...i..."+i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println("..."+e);
        }
    }
}