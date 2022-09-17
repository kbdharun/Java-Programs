# Notes (September 16,2022)

## Topics

- Package & Import

## General Notes

- Naming Collision conflict is a serious issue in Java i.e happens when multiple people are working with same classes,etc on a project. This can be overcome using Packages.
- Base class in one package and derived class in different package is possible.
- Avoid `*` while importing packages as it will increase the compile time. But it can be used when we don't know the package.
- Protected is not allowed for class.

## Commands

- When using `javac -d . {{file.java}}` this command the PWD is searched for the source file and then it is compiled and is present under a new `p1` folder. Here `.` searchs for the source file in all directories in the physical or network location.
- This command `dir *.class` lists all `.class` files.

## Package & Import

- Problem -> Naming collision conflict ; Solved using -> Packages.
- If package isn't used then `.class` file is created in PWD. When we use Packages `.class` file is created under a sub directory.

```text
Syntax:

package <packagenme>;

Example:

package pack1.pack2;
```

## Access Specifier

Table: Access Specifiers in Java

| Access Specifier | Same class | Sub class (in pack) | Non-Sub class (in pack) | Subclass  (in different pack) | Non-Subclass (in different pack) |
|------------------|------------|--------------------|-------------------------|-------------------------------|---------------------------------|
| **Private**          | Yes        | No                 | No                      | No                            | No                              |
| **Default**          | Yes        | Yes                | Yes                     | No                            | No                              |
| **Protected**        | Yes        | Yes                | Yes                     | Yes                           | No                              |
| **Public**           | Yes        | Yes                | Yes                     | Yes                           | Yes                             |

### Program 1a: Basic Program using Packages

```java
/* A.java : Java Program using package & import*/
package p1;
public class A{
    int a;
    public A(){
        a=10;
    }
    public String toString(){
        return "a="+a;
    }
}
```

### Program 1b: Basic Program using Packages

```java
/*Test.java*/
import p1.A;
class Test{
        public static void main(String args[]){
                A objA= new A();
                System.out.println(objA.getClass()+"..."+objA);
        }
}
```

```text
Output:
class p1.A...a=10
```

### Program 2: Basic Program using Packages (Multiple Programs)

```text
Commands:
javac -d . A.java 
javac -d . B.java 
```

```java
/*A.java: Under p1 folder after executing command*/
package p1;
public class A{
    protected int a;
    protected A(){
        a=10;
    }
    public String toString(){
        return "a="+a;
    }
}
```

```java
/*B.java: Under p1 folder after executing command*/
package p2;
import p1.A;
public class B extends A{
    int b;
    public B(){
        super();
        b=20;
    }
    public String toString(){
        return "a="+a+"b="+b;
    }
}
```

```java
/*Test.java: Inside main directory*/
import p2.B;
class Test{
        public static void main(String args[]){
                B objB= new B();
                System.out.println(objB.getClass()+"..."+objB);
        }
}
```

```text
Output:
class p2.B...a=10b=20
```
