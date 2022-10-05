# Notes (September 26,2022)

## Topics

- Exception

## General Notes

- Compiler finds all errors like type mismatch errors, etc during runtime.
- Segmentation core dump is a runtime error.
- Some common errors are core dump, index out of bound,etc these exceptions are handled by deafult handler.
- Interrupted exception is handled by compiler. If I don't know the exception I can give interrupted exception.
- Most common checked exception is Interrupted excpetion which is available in `java.lang` package.
- If we don't know the derived class name we can use the base class object reference. If we don't know the exact name of checked exception we can just give `throws Exception`.
- All user defined exception comes under **unchecked** exception.
- **_Unchecked exceptions are exceptions which may or may not arise._**

## Commands

- `javap java.lang.Throwable` displays the exceptions available in java.
- `javap java.lang.Thread` displays the exceptions and whether it is interrupted (check) or not.

## Exception

- Exception is _Unexpected_ Runtime error.
- Segmentation core dump is a runtime error. We don't know which line causes the segmentation error as no information is provided and the program gets terminated. This can be remedied by using **Checkpoint** or error injection code which is useful for precedural language programs which use all of the settings. In java, exception handling responds back by providing a clear description ot stacktrace of the error.
- Default exception hander is present in JVM (Java Virtual Machine).
- Custom exception has limited visibility in C++. But here in Java, most of the class exceptions are user defined exceptions.
- Main class is `Throwable`
- Throwable has 2 subclasses namely Error and Exception.
- Throwable -> Error, Exception
- Some common examples of fatal error Stack overflow. JVM will display the error and the program will be terminated. This type of error happen in Sockets, Database handing,etc.

```md
# Flowchart (Types)

Throwable -> Error , Exception

Exception -> RunTimeException
```

### Keywords

- Some keywords that define exception handling in Java are are **try, catch, finally, throw, throws**.

### Built-in Exceptions

- Some exceptions are unchecked while some are checked.

- Some common **unchecked** exceptions are

1. ArithmeticException (Base class: Exception)
2. ArrayIndexOutOfBoundsException
3. NullPointerException

- Some common **checked** exception are

1. IOException
2. FileNotFoundException
3. ClassCastExceptions

### Program 1a: Arithmetic Exception program but without intialisation

```java
class Test{
    public static void name(String args[]) {
        int a,b;
        b=0;
        a=a/b;
        System.out.println("a="+a);
    }
}

//Excepting divide by 0 arithmetic exception
```

```text
Error:
Test.java:5: error: variable a might not have been initialized
        a=a/b;
          ^
1 error
```

### Program 1b: Arithmetic Exception

```java
class Test{
    static void test(){
        int a,b;
        b=0;a=10;
        a=a/b;
        System.out.println("a="+a);
    }
    public static void main(String args[]) 
    {
        test();
    }
}
//Excepting divide by 0 arithmetic exception
```

```bash
[user]$ javac Test.java
[user]$ java Test.java
Exception in thread "main" java.lang.ArithmeticException: / by zero
at Test.test(Test.java:5)
at Test.main(Test.java:10)
```

## Program 2: IOException program

```java
import java.io.DataInputStream;
class Test{
    public static void main(String args[])throws InterruptedException{
        DataInputStream din=new DataInputStream(System.in);
        int a=din.readInt();
        System.out.println(a);
    }
}
```

```bash
[user]$ javac Test.java
Test.java:5: error: unreported exception IOException; must be caught or declared to be thrown
        int a=din.readInt();
                         ^
1 error
```

## Program 3: Check Exception Program

- Program will be excitted after Interrupted exception.

```java
import java.io.DataInputStream;
import java.io.IOException;
class Test{
    public static void main(String args[])throws Exception{
        DataInputStream din=new DataInputStream(System.in);
        int a=din.readInt();
        Thread.sleep(100);
        System.out.println(a);
    }
}
```

- Output:

```bash
[user]$ javac Test.java
[user]$ java Test
123
825373450
```

## Program 4: Exception

```javac
import java.io.DataInputStream;
import java.io.IOException;
class Test{
    static void test(){
        DataInputStream din=new DataInputStream(System.in);
        int a=din.readInt();
        Thread.sleep(100);
        System.out.println(a);
    }
    public static void main(String args[]){
        test();
    }
}
```

```bash
Test.java:6: error: unreported exception IOException; must be caught or declared to be thrown
        int a=din.readInt();
                         ^
Test.java:7: error: unreported exception InterruptedException; must be caught or declared to be thrown
        Thread.sleep(100);
                    ^
2 errors
```
