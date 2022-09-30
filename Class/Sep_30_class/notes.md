# Notes (September 30,2022)

## Topics

- Exceptions (Throw)

## General Notes

- Exception is thrown by the compiler. But developers can manually throw an exception using `throw`.

```java
//throw

try{}
catch(ArithemticException e){
}
catch(NullPointerException e){
}

//throw, But from JDK 7
try{
}
catch(NullPointerException | ArithemticException e){
}
```

- `main()==>f2() rethrow`
- Don't use `throw` keyword at the beginning as it makes the remaining parts of a program unreachable.

## Throw (Exception)

1. Manually raise
2. Chained Exception
3. rethrow
4. User-defined

- Chained exception helps to **identify a situation in which one execution causes another exception.**
- **Rethrow:** If a catch block cannot handle the particular exception it has caught, we can rethrow the exception. The rethrow expression causes the originally thrown object to be rethrown.

## Reference

```bash
[user]$ javap java.lang.Throwable
Compiled from "Throwable.java"
public class java.lang.Throwable implements java.io.Serializable {
  static final boolean $assertionsDisabled;
  public java.lang.Throwable();
  public java.lang.Throwable(java.lang.String);
  public java.lang.Throwable(java.lang.String, java.lang.Throwable);
  public java.lang.Throwable(java.lang.Throwable);
  protected java.lang.Throwable(java.lang.String, java.lang.Throwable, boolean, boolean);
  public java.lang.String getMessage();
  public java.lang.String getLocalizedMessage();
  public synchronized java.lang.Throwable getCause();
  public synchronized java.lang.Throwable initCause(java.lang.Throwable);
  final void setCause(java.lang.Throwable);
  public java.lang.String toString();
  public void printStackTrace();
  public void printStackTrace(java.io.PrintStream);
  public void printStackTrace(java.io.PrintWriter);
  public synchronized java.lang.Throwable fillInStackTrace();
  public java.lang.StackTraceElement[] getStackTrace();
  public void setStackTrace(java.lang.StackTraceElement[]);
  public final synchronized void addSuppressed(java.lang.Throwable);
  public final synchronized java.lang.Throwable[] getSuppressed();
  static {};
}
```

### Program 1: Using `throw` keyword to manually create an excpetion

```java
class Test{
    public static void main(String args[]){
        try{
       // NullPointerException e=new NullPointerException("null");
        throw new NullPointerException("null"); //Anonymous object to throw an exception.
        }catch(NullPointerException e){
            System.out.println("Caught"+e);
        }
    }
}
```

- Output:-

```bash
[user]$ java Test
Caughtjava.lang.NullPointerException: null
```

### Program 2: Using `throw` Exception

```java
class Test{
    static void test(){
        try{
       // NullPointerException e=new NullPointerException("null");
        throw new NullPointerException("null"); //Anonymous object to throw an exception.
        }catch(NullPointerException e){
            System.out.println("test: Caught..."+e);
            throw e;
        }
    }
    public static void main(String args[]){
        try{
            test();
        }catch(Exception e){
                System.out.println("main"+e);
                throw e;
            }
        }
}
```

- Output:-

```bash
[user]$ java Test
Test: Caught...java.lang.NullPointerException: null
mainjava.lang.NullPointerException: null
Exception in thread "main" java.lang.NullPointerException: null
        at Test.test(Test.java:5)
        at Test.main(Test.java:13)
```

### Program 3: Chaining Excepetion

```java
class Test{
    public static void main(String args[]){
        NullPointerException e=new NullPointerException("null");
        try{
                e.initCause(new ArithmeticException());
                throw e;
        }catch(NullPointerException e1){
            System.out.println("test: Caught..."+e1);
            System.out.println("Cause..."+e1.getCause());
            throw e;
        }
    }
}
```

- Output:-

```bash
[user]]$ java Test
test: Caught...java.lang.NullPointerException: null
Cause...java.lang.ArithmeticException
Exception in thread "main" java.lang.NullPointerException: null
        at Test.main(Test.java:3)
Caused by: java.lang.ArithmeticException
        at Test.main(Test.java:5)
```

### Program 4a:-

```java
import java.io.DataInputStream;
class Test{
    public static void main(String[] args)throws Exception {
        DataInputStream in =new DataInputStream(System.in);
        int a=in.readInt();
        System.out.println("a="+a);
    }
}
```

- Output:-

```bash
[user]$ java Test
1
2
a=822751754
```

### Program 4b:-

```java
import java.io.DataInputStream;
import java.io.IOException;
class Test{
    public static void main(String[] args) throws IOException,InterruptedException{
            DataInputStream in =new DataInputStream(System.in);
            int a=in.readInt();
            System.out.println("a="+a);
        }      
}
```

- Output:-

```bash
[user]$ java Test
1
2
a=822751754
```

### Program 5: User-defined Exception

```java
class Account{
    int acno;
    double bal;
    Account(int acno,double bal){
        this.acno=acno;
        this.bal=bal;
    }
    public String toString(){
        return acno+"\t"+bal;
    }
}

class AccountDemo{
    public static void main(String args[]){
        Account a=new Account(1200,-450);
        System.out.println("Account Created");
    }
}
```

- Output:-

```bash
[user]$ java AccountDemo
Account Created
```

### Program 6:-

```java
class NegativeValueException extends Exception{ //Exception handler
    double v;
    NegativeValueException(double v){
        this.v=v;
    }
    public String toString(){
        return v+" is negative";
    }
}
class Account{
    int acno;
    double bal;
    Account(int acno,double bal){
        this.acno=acno;
    try{
        if (bal<0)
            throw new NegativeValueException(bal);
        this.bal=bal;
    }catch(NegativeValueException e){
        System.out.println(e.getClass()+""+e);
    }
}
    public String toString(){
        return acno+"\t"+bal;
    }
}
class AccountDemo{
    public static void main(String args[]){
        Account a=new Account(1200,-450);
        System.out.println("Account Created");
    }
}
```

- Output:-

```bash
class NegativeValueException-450.0 is negative
Account Created
```
