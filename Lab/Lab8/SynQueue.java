import java.util.Scanner;
import java.lang.*;
import java.util.Random;
class Queue{
	int n;
	int queue[];
	int front, rear;
	boolean full, empty;
	Queue(){
		front=-1;
		rear=-1;
		Scanner obj=new Scanner(System.in);
		System.out.print("Enter the number of elements in the queue : ");
		n=obj.nextInt();
		queue=new int[n];
	}
	boolean full(){
		boolean isFull;
		if (rear>=(n-1)){
			isFull=true;
		}
		else{
			isFull=false;
		}
		return isFull;
	}
	boolean empty(){
		boolean isEmpty;
		if (front==-1){
			isEmpty=true;
		}
		else{
			isEmpty=false;
		}
		return isEmpty;
	}
	void get(int e){
		if (full()){
			System.out.print("Overflow");
		}
		else{
			rear++;
			queue[rear]=e;
			if (empty()){
				front++;
			}
			System.out.println("Element successfully added into queue");
		}
		display();
	}
	void put(){
		int out;
		if (empty()){
			System.out.print("Underflow");
		}
		else{
			out=queue[front];
			System.out.println("Dequeue operation completed. Element dequeued is : "+out);
			front++;
			display();
		}
	}
	void display(){
		System.out.println("Queue is : ");
		for (int i=front; i<=rear; i++){
			System.out.print(queue[i]+" ");
		}
	}
}
class TestSyn implements Runnable{
	Thread t;
	Queue target;
	int choice;
	Random rand = new Random();
	TestSyn(Queue target, int choice){
		this.target=target;
		this.choice=choice;
		t=new Thread(this);
	}
	public void run(){
		synchronized(target){
			if (choice==1){
				target.get(rand.nextInt(100)+1);
			}
			else if (choice==2){
				target.put();
			}
		}
	}
}
class SynQueue{
	public static void main(String args[]){
		Queue target=new Queue();
		target.get(5);
		target.get(10);
		target.get(15);
		target.get(20);
		TestSyn t1 = new TestSyn(target, 1);
		TestSyn t2 = new TestSyn(target, 2);
		TestSyn t3 = new TestSyn(target, 1);
		TestSyn t4 = new TestSyn(target, 2);
		t1.t.start();
		t2.t.start();
		t3.t.start();
		t4.t.start();
	}
}
		