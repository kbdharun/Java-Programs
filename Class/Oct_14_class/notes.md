# Notes (October 14,2022)

## Topics

- Thread Communication/Interthread Communication

## General Notes

- `boolean semaphore` is used in Interthread communication for a common signaling between 2 threads.
- `sleep` will make the CPU into the coding state. `wait()` will wait for the CPu until event state. `notify()` notifies it.
- Deadlock is a special type of error that you need to avoid that relates specifically to
multitasking.
- To prevent deadlock condition we need timed loop.

## Interthread Communication

- Methods:-
  - wait()
  - wait(long)
  - notify()
  - notifyall()
- Syntax:

```text
synchronized{
    ---
    ---
}
```

### Program 1a:-

```java
//Shared resource
class Q{
    int v;
    synchronized void put(int v){
        this.v=v;
        System.out.println("Put..."+v);
    }
    synchronized void get(){
            System.out.println("Got..."+v);
    }
}
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
```

- Output:-

(Infinite Loop) [Fix this with wait and signal approach]

### Program 1b:-

```java
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
        notify();
    }
    synchronized void get(){
        //wait
        while(!semaphore)
                try{
                        wait();
                }catch(InterruptedException e){}
        
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
```

- Output:-

```bash
[dharunkrishna@dharun-fedora-laptop Oct_14_class]$ java InterThreadComm
Put...1
Got...1
Put...2
Got...2
Put...3
Got...3
Put...4
Got...4
Put...5
Got...5
Put...6
Got...6
Put...7
```

> (This is a loop and the output continues)

### Program 1c:-

```java
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
```

```bash
[user]$ java InterThreadComm
Put...1
Semaphore ...true
Got...1
Put...2
```
