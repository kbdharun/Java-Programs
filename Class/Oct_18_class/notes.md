# Notes (October 18,2022)

## Topics

- FileInputStream
- FileOutputStream

## Keywords

- transient
- volatile

## FileInputStream Package

```bash
[user]$ javap java.io.FileInputStream
Compiled from "FileInputStream.java"
public class java.io.FileInputStream extends java.io.InputStream {
  public java.io.FileInputStream(java.lang.String) throws java.io.FileNotFoundException;
  public java.io.FileInputStream(java.io.File) throws java.io.FileNotFoundException;
  public java.io.FileInputStream(java.io.FileDescriptor);
  public int read() throws java.io.IOException;
  public int read(byte[]) throws java.io.IOException;
  public int read(byte[], int, int) throws java.io.IOException;
  public byte[] readAllBytes() throws java.io.IOException;
  public byte[] readNBytes(int) throws java.io.IOException;
  public long transferTo(java.io.OutputStream) throws java.io.IOException;
  public long skip(long) throws java.io.IOException;
  public int available() throws java.io.IOException;
  public void close() throws java.io.IOException;
  public final java.io.FileDescriptor getFD() throws java.io.IOException;
  public java.nio.channels.FileChannel getChannel();
  static {};
}
```

## Java File Package

```bash
[user]$ javap java.io.File
Compiled from "File.java"
public class java.io.File implements java.io.Serializable, java.lang.Comparable<java.io.File> {
  public static final char separatorChar;
  public static final java.lang.String separator;
  public static final char pathSeparatorChar;
  public static final java.lang.String pathSeparator;
  static final boolean $assertionsDisabled;
  final boolean isInvalid();
  int getPrefixLength();
  public java.io.File(java.lang.String);
  public java.io.File(java.lang.String, java.lang.String);
  public java.io.File(java.io.File, java.lang.String);
  public java.io.File(java.net.URI);
  public java.lang.String getName();
  public java.lang.String getParent();
  public java.io.File getParentFile();
  public java.lang.String getPath();
  public boolean isAbsolute();
  public java.lang.String getAbsolutePath();
  public java.io.File getAbsoluteFile();
  public java.lang.String getCanonicalPath() throws java.io.IOException;
  public java.io.File getCanonicalFile() throws java.io.IOException;
  public java.net.URL toURL() throws java.net.MalformedURLException;
  public java.net.URI toURI();
  public boolean canRead();
  public boolean canWrite();
  public boolean exists();
  public boolean isDirectory();
  public boolean isFile();
  public boolean isHidden();
  public long lastModified();
  public long length();
  public boolean createNewFile() throws java.io.IOException;
  public boolean delete();
  public void deleteOnExit();
  public java.lang.String[] list();
  public java.lang.String[] list(java.io.FilenameFilter);
  public java.io.File[] listFiles();
  public java.io.File[] listFiles(java.io.FilenameFilter);
  public java.io.File[] listFiles(java.io.FileFilter);
  public boolean mkdir();
  public boolean mkdirs();
  public boolean renameTo(java.io.File);
  public boolean setLastModified(long);
  public boolean setReadOnly();
  public boolean setWritable(boolean, boolean);
  public boolean setWritable(boolean);
  public boolean setReadable(boolean, boolean);
  public boolean setReadable(boolean);
  public boolean setExecutable(boolean, boolean);
  public boolean setExecutable(boolean);
  public boolean canExecute();
  public static java.io.File[] listRoots();
  public long getTotalSpace();
  public long getFreeSpace();
  public long getUsableSpace();
  public static java.io.File createTempFile(java.lang.String, java.lang.String, java.io.File) throws java.io.IOException;
  public static java.io.File createTempFile(java.lang.String, java.lang.String) throws java.io.IOException;
  public int compareTo(java.io.File);
  public boolean equals(java.lang.Object);
  public int hashCode();
  public java.lang.String toString();
  public java.nio.file.Path toPath();
  public int compareTo(java.lang.Object);
  static {};
}
```

## FileInputStream vs FileOutputStream

- Most common file exception is File not found exception.

### Program 1:-

```java
import java.io.*;
class Test{
        public static void main(String args[])throws IOException{
                File f=new File("sample.txt");
                FileInputStream fin = new FileInputStream(f);
                    byte data[]=new byte[(int)f.length()];

                    fin.read(data);

                System.out.println("read..."+new String(data));

                File f1=new File("sample1.txt");
                FileOutputStream fout = new FileOutputStream(f1);
                    import java.io.*;
class Test{
        public static void main(String args[])throws IOException{
                File f=new File("sample.txt");
                FileInputStream fin = new FileInputStream(f);
                    byte data[]=new byte[(int)f.length()];

                    fin.read(data);

                System.out.println("read..."+new String(data));

                File f1=new File("sample1.txt");
                FileOutputStream fout = new FileOutputStream(f1);
                    fout.write(data);
                System.out.println("written...");
                    fin.close();
                    fout.close();
        }
}fout.write(data);
                System.out.println("written...");
                    fin.close();
                    fout.close();
        }
}
```

```text
sample.txt
This is sample text
```

```text
sample1.txt
This is sample text
```

- Output:-

```bash
[user]$ java Test
read...This is sample text
written...
```

### Program 2a:-

```java
import java.io.*;
class Student implements Serializable{
        int rno;
        String name;
        Student(int rno){
            this.rno=rno;
        }
        public String toString(){
            return "rno:"+rno+" name:"+name;
        }
}

class Test1{
    public static void main(String args[])throws Exception{
        File f=new File("student.txt");
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(f));
        Student s=(Student) in.readObject();
        System.out.println(s);
        s=(Student) in.readObject();
        System.out.println(s);
        in.close();
    }
}
```

### Program 2b:-

```java
import java.io.*;
class Student implements Serializable{
        transient int rno;
        String name;
        Student(int rno, String name){
            this.rno=rno;
            this.name=name;
        }
        public String toString(){
            return "rno:"+rno+" name:"+name;
        }
}

class Test1b{
    public static void main(String args[])throws Exception{
        File f=new File("student1.txt");
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(f));
        Student s=new Student(0,"Ravi");
        out.writeObject(s);
        s=new Student(1, "Raj");
        out.writeObject(s);
        out.close();

        ObjectInputStream in=new ObjectInputStream(new FileInputStream(f));
        s=(Student) in.readObject();
        System.out.println(s);
        s=(Student) in.readObject();
        System.out.println(s);
        in.close();
    }
}
```

