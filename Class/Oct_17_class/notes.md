# Notes (October 17,2022)

## Topics

- java.io package

## `java.io` Package

- We need some type of abstraction for Input-Output devices which is provided uniquely by **Stream** in Java and Python.
- **Stream** - *Abstraction of input and output*.

### Types of Stream

- **Byte-oriented** [8 bit]--> 11001100

- In JDK 1.1 version a new type of stream was introduced namely **character-oriented** (unicode).

### Base class for Byte-oriented Stream

- InputStream ==> Reader (Present in `java.io` package)
  - BufferInputStream   (DC)
  - FileInputStream     (DC)
  - ObjectInputStream   (DC)
  - DataInputStream     (DC)
- OutputStream

> DC - Derived class

## Base class for Character-oriented Stream

- Reader
- Writer

## Packages in Input Stream

> This is a subpackage of `java.io.*`.

```bash
[user ~]$ javap java.io.InputStream
Compiled from "InputStream.java"
public abstract class java.io.InputStream implements java.io.Closeable {
  public java.io.InputStream();
  public static java.io.InputStream nullInputStream();
  public abstract int read() throws java.io.IOException;
  public int read(byte[]) throws java.io.IOException;
  public int read(byte[], int, int) throws java.io.IOException;
  public byte[] readAllBytes() throws java.io.IOException;
  public byte[] readNBytes(int) throws java.io.IOException;
  public int readNBytes(byte[], int, int) throws java.io.IOException;
  public long skip(long) throws java.io.IOException;
  public void skipNBytes(long) throws java.io.IOException;
  public int available() throws java.io.IOException;
  public void close() throws java.io.IOException;
  public synchronized void mark(int);
  public synchronized void reset() throws java.io.IOException;
  public boolean markSupported();
  public long transferTo(java.io.OutputStream) throws java.io.IOException;
}
```

## Packages in Output Stream

> This is a subpackage of `java.io.*`.

```bash
[user ~]$ javap java.io.OutputStream
Compiled from "OutputStream.java"
public abstract class java.io.OutputStream implements java.io.Closeable,java.io.Flushable {
  public java.io.OutputStream();
  public static java.io.OutputStream nullOutputStream();
  public abstract void write(int) throws java.io.IOException;
  public void write(byte[]) throws java.io.IOException;
  public void write(byte[], int, int) throws java.io.IOException;
  public void flush() throws java.io.IOException;
  public void close() throws java.io.IOException;
}
```

## Packages in `lang.System`

```bash
[user ~]$ javap java.lang.System
Compiled from "System.java"
public final class java.lang.System {
  public static final java.io.InputStream in;
  public static final java.io.PrintStream out;
  public static final java.io.PrintStream err;
  static java.lang.ModuleLayer bootLayer;
  public static void setIn(java.io.InputStream);
  public static void setOut(java.io.PrintStream);
  public static void setErr(java.io.PrintStream);
  public static java.io.Console console();
  public static java.nio.channels.Channel inheritedChannel() throws java.io.IOException;
  public static void setSecurityManager(java.lang.SecurityManager);
  public static java.lang.SecurityManager getSecurityManager();
  public static native long currentTimeMillis();
  public static native long nanoTime();
  public static native void arraycopy(java.lang.Object, int, java.lang.Object, int, int);
  public static native int identityHashCode(java.lang.Object);
  public static java.util.Properties getProperties();
  public static java.lang.String lineSeparator();
  public static void setProperties(java.util.Properties);
  public static java.lang.String getProperty(java.lang.String);
  public static java.lang.String getProperty(java.lang.String, java.lang.String);
  public static java.lang.String setProperty(java.lang.String, java.lang.String);
  public static java.lang.String clearProperty(java.lang.String);
  public static java.lang.String getenv(java.lang.String);
  public static java.util.Map<java.lang.String, java.lang.String> getenv();
  public static java.lang.System$Logger getLogger(java.lang.String);
  public static java.lang.System$Logger getLogger(java.lang.String, java.util.ResourceBundle);
  public static void exit(int);
  public static void gc();
  public static void runFinalization();
  public static void load(java.lang.String);
  public static void loadLibrary(java.lang.String);
  public static native java.lang.String mapLibraryName(java.lang.String);
  static {};
}
```

### Program 1a (Input & Output Stream):-

```java
//InputStream...OutputStream
import java.io.*;
class Test1{
        public static void main(String args[])throws IOException{
            /*To read data from console*/
            InputStream in=System.in;
            byte data[]= new byte[10];
            in.read(data);
            in.close();

            OutputStream out=System.out;
            out.write(data);
            out.close(); //to flush/prevent unopened string
        }
}
```

- Output:-

```bash
[user]$ java Test1
1234
1234
[user]$ java Test1
abcdefghijk
abcdefghij
```

> It outputs only 10 character/integer as specified in byte size.

### Program 1b:-

```java
//InputStream...OutputStream
import java.io.*;
class Test1{
        public static void main(String args[])throws IOException{
            /*To read data from console*/
            Reader in= new InputStreamReader (System.in);
            char data[]= new char[10];
            in.read(data);
            in.close();

            Writer out= new OutputStreamWriter (System.out);
            out.write(data);
            out.close(); //to flush/prevent unopened string
        }
}
```

- Output:-

```bash
[user@hostname dir]$ java Test1
123456
123456
[user dir]$ java Test1
12345678910
1234567891[user dir]$
```

> Byte input stream is preferred over character input stream.

## Program 1c:-

```java
//InputStream...OutputStream
import java.io.*;
class Test1{
        public static void main(String args[])throws IOException{
            DataInputStream din=new DataInputStream(System.in);
            System.out.println("Enter int...");
            int a=din.readInt();
            System.out.println("Enter float..."); //Non-static method
            float b=din.readFloat();
            din.close();
    }
}
```

- Output:-

```bash
[user]$ java Test1
Enter int...
123
Enter float...
12.3
```

### Program 1d:-

```java
//InputStream...OutputStream
import java.io.*;
class Test1{
        public static void main(String args[])throws IOException{
            DataInputStream din=new DataInputStream(System.in);
            int a=din.readInt();
            float b=din.readFloat();
            din.close();

            DataOutputStream dout=new DataOutputStream(System.out);
            dout.writeInt(a);
            dout.writeFloat(b);
            din.close();
        }
}
```

> For byte oriented avoid constuctor and also using `Scanner` function.

```java
//InputStream...OutputStream
import java.io.*;
class Test1{
        public static void main(String args[])throws IOException{
            DataInputStream din=new DataInputStream(System.in);
            int a=din.readInt();
            int b=din.readInt();
            din.close();

            int c=a+b;
            DataOutputStream dout=new DataOutputStream(System.out);
             
            dout.writeInt(c);
            System.out.println("C"+c);
            dout.close();
        }
}
```

> No proper output

### Program 1e:-

```java
//InputStream...OutputStream
import java.io.*;
class Test1{
        public static void main(String args[])throws IOException{
            BufferedInputStream bin= new BufferedInputStream(System.in);
            byte [] data = new byte[100];
            bin.read(data);
            System.out.println(new String(data));
        }
}
```

- Output:-

```bash
[user]$ java Test1
123
123
```
