class Stack{
        int top;
        int stack[];
        Stack(){
                top=-1;
                stack[]=new int[10];
        }
        void push(int v){
            stack[++top]=v;
            System.out.println("Pushed..."+stack[top]);
        }
        void pop(){
            System.out.println("Popped..."+stack[top]);
            --top;
        }
}

//THREAD
class TestSyn implements Runnable{
        Thread t;
        Stack target;
        String msg;
        TestSyn(Stack target, String msg){
                this.target=target;
                this.msg=msg;
                t=new Thread(this);
        }     
        public void run(){
                if(ch=1)
                    target.push(v);
                else
                    targer.pop();
        }
}

class StackDemo{
        public static void main(String args[]){
            Print target=new Print();//Share resource
            TestSyn t1=new TestSyn(target,"Welcome");
            TestSyn t2=new TestSyn(target,"to");
            TestSyn t3=new TestSyn(target,"University");
            t1.t.start();
            t2.t.start();
            t3.t.start();
        }
}

/*Deadlock concept to be continued tomorrow*/