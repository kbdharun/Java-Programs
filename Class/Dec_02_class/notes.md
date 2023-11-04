# Notes (December 02, 2022)

## Topics

- Multithreading in GUI

## Programs

### Program 1a:-

```java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ThreadDemo{
        JFrame frm;
        JTextArea t1,t2,t3;
        JButton b;
        ThreadDemo(){
            frm=new JFrame("Thread Demo");
            frm.setVisible(true);
            frm.setSize(600,600);
            frm.setLayout(null);
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            t1=new JTextArea();frm.add(t1);t1.setBounds(100,100,100,300);
            t2=new JTextArea();frm.add(t2);t2.setBounds(250,100,100,300);
            t3=new JTextArea();frm.add(t3);t3.setBounds(400,100,100,300);

            b=new JButton("Start");
            frm.add(b);b.setBounds(50,50,100,50);
            b.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    new AddThread().start();
            }
        });
}
class AddThread extends Thread{
            String msg="";
            public void run(){
                try{
                    for(int i=1;i<15;i++){
                        msg+=i+"+2="+(i+2)+"\n";
                        Thread.sleep(100);
                        t1.setText(msg);
                }
            }catch(Exception e){}
        }
}
        public static void main(String[] args) {
            new ThreadDemo();
        }
}
```

### Program 1b:-

```java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ThreadDemo{
        JFrame frm;
        JTextArea t1,t2,t3;
        JButton b;
        ThreadDemo(){
            frm=new JFrame("Thread Demo");
            frm.setVisible(true);
            frm.setSize(600,600);
            frm.setLayout(null);
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            t1=new JTextArea();frm.add(t1);t1.setBounds(100,100,100,300);
            t2=new JTextArea();frm.add(t2);t2.setBounds(250,100,100,300);
            t3=new JTextArea();frm.add(t3);t3.setBounds(400,100,100,300);

            b=new JButton("Start");
            frm.add(b);b.setBounds(50,50,100,50);
            b.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    new AddThread().start();
                    new SubThread().start();
                    new MulThread().start();
            }
        });
}
class AddThread extends Thread{
            String msg="";
            public void run(){
                try{
                    for(int i=1;i<15;i++){
                        msg+=i+"+2="+(i+2)+"\n";
                        Thread.sleep(100);
                        t1.setText(msg);
                }
            }catch(Exception e){}
        }
}
class SubThread extends Thread{
    String msg="";
    public void run(){
        try{
            for(int i=1;i<15;i++){
                msg+=i+"-2="+(i-2)+"\n";
                Thread.sleep(100);
                t2.setText(msg);
        }
    }catch(Exception e){}
  }
}
class MulThread extends Thread{
    String msg="";
    public void run(){
        try{
            for(int i=1;i<15;i++){
                msg+=i+"*2="+(i*2)+"\n";
                Thread.sleep(100);
                t3.setText(msg);
        }
    }catch(Exception e){}
  }
}
        public static void main(String[] args) {
            new ThreadDemo();
        }
}
```

- Output:-

[1b.webm](https://user-images.githubusercontent.com/26346867/205220359-e756374e-7e4f-4e14-bdda-247f2d371d39.webm)

### Program 2:- GUI Program using timer object (Blinking Effect)

```java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class ThreadDemo{
    JFrame frm;
    JLabel lbl;
    ThreadDemo(){
        frm=new JFrame("Thread Demo");
        frm.setVisible(true);
        frm.setSize(600,600);
        frm.setLayout(null);
        lbl=new JLabel("Test ");
        frm.add(lbl);lbl.setBounds(50,50,300,50);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbl.setFont(new Font("Arial",Font.BOLD,20));
        lbl.setForeground(Color.red);

        Timer t=new Timer(1000,new ActionListener(){ //For instantaneous blinking set 100 
            boolean f=true;int x=0;
            public void actionPerformed(ActionEvent ae){
                    if(f){
                        lbl.setForeground(Color.red);f=false;
                    }else{
                        lbl.setForeground(frm.getBackground());f=true;
                    }
                    lbl.setLocation(x,100);x+=10;
            }
        });
        t.start();
    }
    public static void main(String[] args) {
        new ThreadDemo();
    }
}
```

- Output:-

[2.webm](https://user-images.githubusercontent.com/26346867/205220387-4dac57e4-39f1-486f-ad5e-21874d902def.webm)
