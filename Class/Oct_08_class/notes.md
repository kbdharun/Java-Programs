# Notes (October 8,2022)

## Topics

- Multi Threading (Runnable)

## Methods for creating a thread

1. Thread class (extends)
2. Runnable interface (implements)

### Thread Package

```bash
javap java.lang.Thread
Compiled from "Thread.java"
public class java.lang.Thread implements java.lang.Runnable {
  java.lang.ThreadLocal$ThreadLocalMap threadLocals;
  java.lang.ThreadLocal$ThreadLocalMap inheritableThreadLocals;
  volatile java.lang.Object parkBlocker;
  public static final int MIN_PRIORITY;
  public static final int NORM_PRIORITY;
  public static final int MAX_PRIORITY;
  long threadLocalRandomSeed;
  int threadLocalRandomProbe;
  int threadLocalRandomSecondarySeed;
  static void blockedOn(sun.nio.ch.Interruptible);
  public static native java.lang.Thread currentThread();
  public static native void yield();
  public static native void sleep(long) throws java.lang.InterruptedException;
  public static void sleep(long, int) throws java.lang.InterruptedException;
  public static void onSpinWait();
  protected java.lang.Object clone() throws java.lang.CloneNotSupportedException;
  public java.lang.Thread();
  public java.lang.Thread(java.lang.Runnable);
  java.lang.Thread(java.lang.Runnable, java.security.AccessControlContext);
  public java.lang.Thread(java.lang.ThreadGroup, java.lang.Runnable);
  public java.lang.Thread(java.lang.String);
  public java.lang.Thread(java.lang.ThreadGroup, java.lang.String);
  public java.lang.Thread(java.lang.Runnable, java.lang.String);
  public java.lang.Thread(java.lang.ThreadGroup, java.lang.Runnable, java.lang.String);
  public java.lang.Thread(java.lang.ThreadGroup, java.lang.Runnable, java.lang.String, long);
  public java.lang.Thread(java.lang.ThreadGroup, java.lang.Runnable, java.lang.String, long, boolean);
  public synchronized void start();
  public void run();
  public final void stop();
  public void interrupt();
  public static boolean interrupted();
  public boolean isInterrupted();
  public final native boolean isAlive();
  public final void suspend();
  public final void resume();
  public final void setPriority(int);
  public final int getPriority();
  public final synchronized void setName(java.lang.String);
  public final java.lang.String getName();
  public final java.lang.ThreadGroup getThreadGroup();
  public static int activeCount();
  public static int enumerate(java.lang.Thread[]);
  public int countStackFrames();
  public final synchronized void join(long) throws java.lang.InterruptedException;
  public final synchronized void join(long, int) throws java.lang.InterruptedException;
  public final void join() throws java.lang.InterruptedException;
  public static void dumpStack();
  public final void setDaemon(boolean);
  public final boolean isDaemon();
  public final void checkAccess();
  public java.lang.String toString();
  public java.lang.ClassLoader getContextClassLoader();
  public void setContextClassLoader(java.lang.ClassLoader);
  public static native boolean holdsLock(java.lang.Object);
  public java.lang.StackTraceElement[] getStackTrace();
  public static java.util.Map<java.lang.Thread, java.lang.StackTraceElement[]> getAllStackTraces();
  public long getId();
  public java.lang.Thread$State getState();
  public static void setDefaultUncaughtExceptionHandler(java.lang.Thread$UncaughtExceptionHandler);
  public static java.lang.Thread$UncaughtExceptionHandler getDefaultUncaughtExceptionHandler();
  public java.lang.Thread$UncaughtExceptionHandler getUncaughtExceptionHandler();
  public void setUncaughtExceptionHandler(java.lang.Thread$UncaughtExceptionHandler);
  static void processQueue(java.lang.ref.ReferenceQueue<java.lang.Class<?>>, java.util.concurrent.ConcurrentMap<? extends java.lang.ref.WeakReference<java.lang.Class<?>>, ?>);
  static {};
}
```

### Program 1a:-

```java
//Creation of thread using Runnable interface
class MainThread{
        public static void main(String args[]){
            Thread t=Thread.currentThread();
            System.out.println(t.getName()+"..."+t.getState());
            try{
                for (int i=0;i<5;i++){
                    System.out.println(t.getName()+"..."+i);
                    Thread.sleep(1000);
                }
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
}
```

- Output:-

```bash
[user]$ java MainThread
main...RUNNABLE
main...0
main...1
main...2
main...3
main...4
```

### Program 1b:-

```java
//Creation of thread using Runnable interface
class NewThread implements Runnable{
    Thread t;
    NewThread(String name){
        t=new Thread(this,name);
        System.out.println(t.getName()+"..."+t.getState());
    }
    public void run(){
        try{
            for (int i=4;i>0;i--){
                System.out.println(t.getName()+"..."+i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}
class MainThread{
        public static void main(String args[]){
            Thread t=Thread.currentThread();
            System.out.println(t.getName()+"..."+t.getState());
            NewThread t1=new NewThread("Child Thread1:");
            t1.t.start();
            System.out.println(t1.t.getName()+"..."+t1.t.getState());
            try{
                for (int i=0;i<5;i++){
                    System.out.println(t.getName()+"..."+i);
                    Thread.sleep(1000);
                }
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
}
```

- Output:-

```bash
[dharunkrishna@dharun-fedora-laptop Oct_08_class]$ java MainThread
main...RUNNABLE
Child Thread1:...NEW
Child Thread1:...RUNNABLE
main...0
Child Thread1:...4
main...1
Child Thread1:...3
main...2
Child Thread1:...2
main...3
Child Thread1:...1
main...4
```

### Program 1c:-

```java
//Creation of thread using Runnable interface
class NewThread implements Runnable{
    Thread t;
    NewThread(String name){
        t=new Thread(this,name);
        System.out.println(t.getName()+"..."+t.getState());
    }
    public void run(){
        try{
            for (int i=4;i>0;i--){
                System.out.println(t.getName()+"..."+i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}
class MainThread{
        public static void main(String args[]){
            Thread t=Thread.currentThread();
            System.out.println(t.getName()+"..."+t.getState());
            NewThread t1=new NewThread("Child Thread1:");
            t1.t.start();
            NewThread t2=new NewThread("Child Thread2:");
            t2.t.start();
            System.out.println(t1.t.getName()+"..."+t1.t.getState());
            System.out.println(t2.t.getName()+"..."+t2.t.getState());
            try{
                for (int i=0;i<5;i++){
                    System.out.println(t.getName()+"..."+i);
                    Thread.sleep(1000);
                }
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
}
```

- Output:-

```bash
main...RUNNABLE
Child Thread1:...NEW
Child Thread2:...NEW
Child Thread1:...RUNNABLE
Child Thread2:...RUNNABLE
Child Thread2:...4
main...0
Child Thread1:...4
Child Thread2:...3
Child Thread1:...3
main...1
Child Thread2:...2
Child Thread1:...2
main...2
Child Thread2:...1
Child Thread1:...1
main...3
main...4
```

### Program 1d:-

```java
//Creation of thread using Runnable interface
class NewThread implements Runnable{
    Thread t;
    NewThread(String name){
        t=new Thread(this,name);
        System.out.println(t.getName()+"..."+t.getState());
    }
    public void run(){
        try{
            for (int i=4;i>0;i--){
                System.out.println(t.getName()+"..."+i);
                Thread.sleep(1000);
                if (i==2)
                    t.stop();

            }
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}
class MainThread{
        public static void main(String args[]){
            Thread t=Thread.currentThread();
            System.out.println(t.getName()+"..."+t.getState()+"..."+t.isAlive());
            NewThread t1=new NewThread("Child Thread1:");
            t1.t.start();
            NewThread t2=new NewThread("Child Thread2:");
            t2.t.start();
            System.out.println(t1.t.getName()+"..."+t1.t.getState()+"..."+t1.t.isAlive());
            System.out.println(t2.t.getName()+"..."+t2.t.getState()+"..."+t2.t.isAlive());
            try{
                for (int i=0;i<5;i++){
                    System.out.println(t.getName()+"..."+i);
                    Thread.sleep(1000);
                }
            }catch(InterruptedException e){
                System.out.println(e);
            }
            System.out.println(t1.t.getName()+"..."+t1.t.getState()+"..."+t1.t.isAlive());
            System.out.println(t2.t.getName()+"..."+t2.t.getState()+"..."+t2.t.isAlive());
        }
}
```

- Output:-

```bash
[user]$ javac MainThread.java
MainThread.java:14: warning: [removal] stop() in Thread has been deprecated and marked for removal
                    t.stop();
                     ^
1 warning
[user]$ java MainThread
main...RUNNABLE...true
Child Thread1:...NEW
Child Thread2:...NEW
Child Thread1:...RUNNABLE...true
Child Thread2:...RUNNABLE...true
Child Thread2:...4
main...0
Child Thread1:...4
Child Thread2:...3
main...1
Child Thread1:...3
Child Thread2:...2
main...2
Child Thread1:...2
main...3
main...4
Child Thread1:...TERMINATED...false
Child Thread2:...TERMINATED...false
```

### Program 1e:-

```java
//Creation of thread using Runnable interface
class NewThread implements Runnable{
    Thread t;
    NewThread(String name){
        t=new Thread(this,name);
        System.out.println(t.getName()+"..."+t.getState());
    }
    public void run(){
        try{
            for (int i=4;i>0;i--){
                System.out.println(t.getName()+"..."+i);
                Thread.sleep(1000);
                if (i==2)
                    t.suspend();
                if(i==4)
                    t.resume();

            }
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }
}
class MainThread{
        public static void main(String args[]){
            Thread t=Thread.currentThread();
            System.out.println(t.getName()+"..."+t.getState()+"..."+t.isAlive());
            NewThread t1=new NewThread("Child Thread1:");
            t1.t.start();
            NewThread t2=new NewThread("Child Thread2:");
            t2.t.start();
            System.out.println(t1.t.getName()+"..."+t1.t.getState()+"..."+t1.t.isAlive());
            System.out.println(t2.t.getName()+"..."+t2.t.getState()+"..."+t2.t.isAlive());
            try{
                for (int i=0;i<5;i++){
                    System.out.println(t.getName()+"..."+i);
                    Thread.sleep(1000);
                }
            }catch(InterruptedException e){
                System.out.println(e);
            }
            System.out.println(t1.t.getName()+"..."+t1.t.getState()+"..."+t1.t.isAlive());
            System.out.println(t2.t.getName()+"..."+t2.t.getState()+"..."+t2.t.isAlive());
        }
}
```

### Program 1f:-

```java
//Creation of thread using Runnable interface
class NewThread implements Runnable{
    Thread t;
    NewThread(String name){
        t=new Thread(this,name);
        System.out.println(t.getName()+"..."+t.getState());
    }
    public void run(){
        try{
            for (int i=4;i>0;i--){
                System.out.println(t.getName()+"..."+i);
                //Thread.sleep(1000);
            //  if(i==2)
                    t.join();
            //  if(i==4)
            //  t.resume();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
class MainThread{
        public static void main(String args[]){
            Thread t=Thread.currentThread();
            System.out.println(t.getName()+"..."+t.getState()+"..."+t.isAlive());
            NewThread t1=new NewThread("Child Thread1:");
            t1.t.start();
            NewThread t2=new NewThread("Child Thread2:");
            t2.t.start();
            System.out.println(t1.t.getName()+"..."+t1.t.getState()+"..."+t1.t.isAlive());
            System.out.println(t2.t.getName()+"..."+t2.t.getState()+"..."+t2.t.isAlive());
            try{
                for (int i=0;i<5;i++){
                    System.out.println(t.getName()+"..."+i);
                   // Thread.sleep(1000);
                    if(i==2)
                        t.join();
                }
                t1.t.join();
            }catch(Exception e){
                System.out.println(e);
            }
            System.out.println(t1.t.getName()+"..."+t1.t.getState()+"..."+t1.t.isAlive());
            System.out.println(t2.t.getName()+"..."+t2.t.getState()+"..."+t2.t.isAlive());
        }
}
// Even without sleep the output is overlapping... and this is known as multitasking
```

```bash
[user]$ java MainThread
main...RUNNABLE...true
Child Thread1:...NEW
Child Thread2:...NEW
Child Thread1:...RUNNABLE...true
Child Thread2:...RUNNABLE...true
Child Thread2:...4
Child Thread1:...4
main...0
main...1
main...2
^C[user]$ 
```
