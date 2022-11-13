# Notes (October 21,2022)

## Topics

- FileReader
- `instanceof` Keyword
- Extending a thread

## General Notes

- `copy file1.txt file2.txt` is a DOS command used to copy contents of 1 file to another file.
- `instanceof` keyword is used in Dynamic Method Dispatch(DMD). (Prefix `obj instance of {{class_name}}` and suffix `{{obj}} instanceof {{class_name}}`). It isn't used often.

### Program 1a:-

```java
//try() {}
import java.io.*;
class Test{
    public static void main(String args[]) throws Exception{
            File f =new File("sample.txt");
            try{
                FileReader fr=new FileReader(f);
                int d;
                while((d=fr.read())!=-1)
                            System.out.print((char)d);
                fr.close();
            }catch(FileNotFoundException e){
                    System.out.println(e);
            }
            
    }
}
```

- Output:-

```text
sample.txt
Hello
```

```bash
Hello
```

### Program 1b:-

```java
//try() {}
import java.io.*;
class Test{
    public static void main(String args[]) throws Exception{
            File f =new File("sample.txt");
            try(var fr=new FileReader(f)){
                int d;
                while((d=fr.read())!=-1)
                            System.out.print((char)d);
            }catch(FileNotFoundException e){
                    System.out.println(e);
            }
            
    }
}
```

### Program 1c:-

```java
//try() {}
import java.io.*;
class Test{
    public static void main(String args[]){
            File f =new File("sample.txt");
            try(var fr=new FileReader(f)){
                int d;
                while((d=fr.read())!=-1)
                            System.out.print((char)d);
            }catch(Exception e){
                    System.out.println(e);
            }
            
    }
}
```

### Program 2:-

```java
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
        }
}
```

```java
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
```

- Output:-

```bash
[user@hostname dir]$ java MainThread
created...Child1state...NEW
created...Child2state...NEW
Child1...RUNNABLE...5
Child2...RUNNABLE...5
Child2....i....0main....RUNNABLE....5....true
Child1....i....0main....i....0Child2....i....1Child1....i....1Child2....i....2Child1....i....2main....i....1Child2....i....3Child1....i....3Child2....i....4Child1....i....4main....i....2Child2....i....5Child1....i....5Child2....i....6main....i....3Child1....i....6Child2....i....7Child1....i....7Child2....i....8main....i....4Child1....i....8Child2....i....9Child1....i....9
```
