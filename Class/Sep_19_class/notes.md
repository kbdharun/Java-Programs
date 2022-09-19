# Notes (September 19,2022)

## Topics

- Interface
- Implements

## General Notes

- Java provides ability to make it to abstract when a specification is unknown.
- Abstract delays the definition of function in abstract class.
- Inheritance with private access specifier is not allowed in interface.

## Interface

- Interface is a **complete abstract class**.
- Multiple inheritance is possible in Java with Interface only.
- It is a combination of final static constant and member declaration.
- We need not create a seperate (dummy) class to implement interface.
- Datamember, function shouldn't be precided with protected or private.
- Multiple inheritance can be integrated in single class using Implements.
- It has a addon functionality called adaptor class. The comipler gives the remaining defintion in this class.

- Rules for declaring interface:

1. All datamembers are final and static. (Don't )
2. All methods becomes abstract by default.

- Rules for implementing interface:

1. Forcefully define all the methods in the interface. If not defined, the class becomes an abstract class.
2. Interface with private or protected access specifier is not allowed.
3. Don't pack too many definitions in interface. Else we use interface with extends keyword.

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
