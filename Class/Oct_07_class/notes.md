# Notes (October 7,2022)

## Topics

- Multithreading

## General Notes

- `Java` is the only high level language that provides API and has support for Multithreading.
- `isAlive` function returns true or false (bool) for active/dead state in threads.

## Multiprogramming

- Context switching is costly in terms of computing and memory requirement.

## Multitasking

- Interleaved excelution of more than 1 task.
- It is a heavy weight software.
- Context switching is necessary for multi tasking.

## Multithreading

- Light Weight, Thread based overlapped excecution.
- No need for Context switching.
- Thread means no execution point.
- Whenever we use _Multitasking,Multiprogramming and Multithreading_ is used there is a PROBLEM **Dependency between statement**. SOLUTION is to execute it in a synchornised manner or **Synchronized thread**.
- Interthread communication and synchorinised communication.

### Packages

```text
java.lang.Thread (class)
java.lang.Runnable (interface)
```

```bash
[user]$ javap java.lang.Thread
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

### Thread States

- |New|->Start()->|(Runnable[Ready to CPU])(Running[Assigned to CPU])|->Dead State.
- Running is currently in excecution whereas runable isn't.
- All states are represented as final static constants.
- |New|->Start()->|(Runnable[Ready to CPU])(Running[Assigned to CPU])|-stop-> Terminated State.
- Suspend function temporarily blocks a thead.

### Program 1a: Simple Threading Program

```java
/* Simple Program using Threading */
class MainThread{
        public static void main(String[] args) {
            Thread t=Thread.currentThread();
            System.out.println(t.getName()+"..."+t.getState()+"..."+t.getPriority()+"..."+t.isAlive());
        }
}
```

- Output:-

```text
main...RUNNABLE...5...true
```

### Program 1b:-

```java
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
```

- Output:-

```bash
[user]$ java MainThread
main...RUNNABLE...5...true
main...i...0
main...i...1
main...i...2
main...i...3
main...i...4
main...i...5
main...i...6
main...i...7
main...i...8
main...i...9
```
