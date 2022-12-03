/*Swing Menu Handling*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class InvalidMark extends Exception{ //1-pointer contructor is mandatory
    public String toString(){
        return "Enter valid mark"; //In future pass proper message
    }
}

class EditFrame{
    JFrame frm;
    JLabel lbl;
    JTextField txt;
    JButton b;

    EditFrame(){
        frm=new JFrame("Wordpad");
        frm.setVisible(true);
        frm.setSize(500,500);
        frm.setLayout(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbl=new JLabel("Mark: "); frm.add(lbl); lbl.setBounds(50,50,100,50);
        txt=new JTextField(20); frm.add(txt); txt.setBounds(180,50,100,50);//20 is the number of characters allowed
        b=new JButton("Check.."); frm.add(b);
        b.setBounds(50,100,100,50);
        //Alert msg / Message Box
        //JOptionPane.showMessageDialog(frm,"Enter proper value..."); //Parameter
        //JOptionPane.showInputDialog(frm,"Enter proper value...","Input"); // Parameter - container,default value for input, caption
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                int v=Integer.parseInt(txt.getText());
                if(v<0 || v>100)
                    throw new InvalidMark();//use paramterised exception in future instead of default
                }catch(Exception e){
                    JOptionPane.showMessageDialog(frm,""+e); //""+e or e.toString() can be used here
                }
            }
        });
    }

    public static void main(String[] args) {
            new EditFrame();
    }
}