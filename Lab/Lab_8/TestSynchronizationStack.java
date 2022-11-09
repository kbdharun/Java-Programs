import java.util.Scanner;
class Stack{
	int top;
	int stack[];
	Stack(){
		top=-1;
		stack = new int[10];
	}

	void push(int ele){
		stack[++top] = ele;
		System.out.println("Pushed element "+stack[top]);
	}

	void pop(){
		System.out.println("Popped element "+stack[top]);
		--top;
	}

	void display(){
		for(int size=0; size<top+1; size++)
			System.out.print(stack[size] + " ");
		System.out.print("\n");
	}
}

class TestStack implements Runnable{
	Thread t;
	Stack StObj;
	TestStack(Stack StObj){
		this.StObj = StObj;
		t = new Thread(this);
	}
	
	public void run(){
		synchronized(StObj){
			StObj.push(5);
			StObj.display();
			StObj.push(6);
			StObj.display();
			StObj.pop();
			StObj.display();
		}
	}
}

class TestStack1 implements Runnable{
	Thread t;
	Stack StObj;
	TestStack1(Stack StObj){
		this.StObj = StObj;
		t = new Thread(this);
	}
	
	public void run(){
		synchronized(StObj){
			StObj.push(5);
			StObj.display();
			StObj.push(6);
			StObj.display();
			StObj.pop();
			StObj.display();
		}
	}
}

class TestSynchronizationStack{
	public static void main(String args[]){
		Stack stObj = new Stack();
		TestStack t1 = new TestStack(stObj);
		TestStack1 t2 = new TestStack1(stObj);
		t1.t.start();
		t2.t.start();
	}
}

		
	