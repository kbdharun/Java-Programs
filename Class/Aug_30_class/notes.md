# Notes (August 30, 2022)

## Introductory class to java

- Simple Hello World Program:-

```java
// Simple helloworld program using java
import java.lang.*;
class HelloWorld{
	public static void main(String args[]){
		for(int i=0;i<10;i++)
		{
		if(i==5)
		break;
		System.out.println("Hello world "+i);
		}
		}
}
/* Note: Avoid * while importing packages as it will increase the compile time.
 But it can be used when you don't know the package in which your function resides. */
```

```text
Output:
Hello world 0
Hello world 1
Hello world 2
Hello world 3
Hello world 4
```
