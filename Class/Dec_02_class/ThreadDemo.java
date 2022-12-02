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