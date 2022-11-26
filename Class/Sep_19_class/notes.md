# Notes (September 19, 2022)

## Topics

- Interface
- Implements

## General Notes

- Java provides the ability to make it abstract when a specification is unknown.
- Abstract delays the definition of function in abstract class.
- Inheritance with private access specifier is not allowed in the interface.

## Interface

- Interface is a **complete abstract class**.
- Multiple inheritances are possible in Java with Interface only.
- It is a combination of the final static constant and member declaration.
- We need not create a separate (dummy) class to implement the interface.
- Data member, the function shouldn't be preceded with protected or private.
- Multiple inheritances can be integrated into a single class using Implements.
- It has an addon functionality called adaptor class. The compiler gives the remaining definition in this class.

- Rules for declaring interface:

1. All data members are final and static. (Don't )
2. All methods become abstract by default.

- Rules for implementing the interface:

1. Forcefully define all the methods in the interface. If not defined, the class becomes an abstract class.
2. Interface with private or protected access specifier is not allowed.
3. Don't pack too many definitions in the interface. Else we use an interface with the extends keyword.

```java
class A{
    ...
    ...
    ...declaring
    abstract void area(){}
    void display(){
    }
}
```

- Syntax 1:

```java
Interface <interface>{
    datatype v1 = Value v1; //Final Static Constant -> The value of this variable can't be changed.
    datatype v2 = Value v2;

    <returntype> {{function_name}} (dt1 va1,dt2 v2){}

}
```

- Syntax 2: Using implements

```java
Interface <interface>{
    datatype v1 = Value v1; //Final Static Constant -> The value of this variable can't be changed.
    datatype v2 = Value v2;

    <returntype> {{function_name}} (dt1 va1,dt2 v2){ //Should be exactly same as in interface
        //definition
    }
    class {{class_name}} implements {{interface_name}}

}
```

- Syntax 3:

```java
Interface <interface 2> extends <interface1>{
    ---
    ---
    <returntype><function_name2>();
}
Class {{class_name}} implements <interface1>,<interface2>{ //Multiple inheritance is allowed
    ---
    ---
}
Class {{class_name}} extends A implements B{ //Multiple inheritance

}
```

### Program 1: Sample Program

```java
class A {
    void A(){
        System.out.println("Initialisation");
    }    
}

class Demo{
    public static void main(){
        A obj= new A();
    }
}
```

### To try

- Rewrite Shape program using Interface (area,perimeter).
