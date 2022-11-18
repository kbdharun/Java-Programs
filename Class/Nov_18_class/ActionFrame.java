import java.awt.*;
import java.awt.event.*;
//import java.util.Random; //Never use util package with * as there are so many pacakages in it, compilation time increases
import javax.swing.*;

class ActionFrame extends JFrame implements ActionListener{
    JButton b;
    JLabel l;
    ActionFrame(){
        setVisible(true); //setVisible is false by default for frame
        setSize(500,500);
        setTitle("ActionDemo");
        setLayout(null);

        b=new JButton("Click");
        l=new JLabel("Test");
        add(b);
        b.setBounds(50,50,100,50);
        add(l);
        l.setBounds(50,100,300,50);

        b.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        //Random r=new Random();
        getContentPane().setBackground(Color.blue);
    }
    public static void main(String args[]){
        new ActionFrame();
    }
}