# Notes (December 03, 2022)

## Topics

- Dialog Box, Popup menu..MessageBox..InputBox..

## Programs

### Program 1: PopMenu and Pulldown Menu

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class EditFrame{
    JFrame frm;
    JTextArea ta;
    JPopupMenu mnu;
    JMenuItem mnucut;
    JMenuItem mnucpy;
    JMenuItem mnupas;
    
    EditFrame(){
        frm=new JFrame("Wordpad");
        frm.setVisible(true);
        frm.setSize(500,500);
        frm.setLayout(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ta=new JTextArea(""); //TextArea
        ta.setBounds(0,0,frm.getWidth(),frm.getHeight());
        frm.add(ta);
        frm.getContentPane().repaint();

        mnu=new JPopupMenu();
        mnucut=new JMenuItem("Cut");
        mnucpy=new JMenuItem("Copy");
        mnupas=new JMenuItem("Paste");
        mnu.add(mnucut); mnu.add(mnucpy); mnu.add(mnupas);
        
        mnucut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                ta.cut();
            }
        });
        mnucpy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                ta.copy();
            }
        });
        mnupas.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                ta.paste();
            }
        });

        ta.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                if(me.getButton()==MouseEvent.BUTTON3)
                    mnu.show(ta,me.getX(), me.getY());
            }
        });
    }

    public static void main(String[] args) {
            new EditFrame();
    }
}
```

- Output:-

[1.webm](ttps://user-images.githubusercontent.com/26346867/205425413-1b994088-3375-4a9b-8e11-ce5a15ebf79e.webm)

<center><video controls>
  <source src="https://user-images.githubusercontent.com/26346867/205425413-1b994088-3375-4a9b-8e11-ce5a15ebf79e.webm" type="video/webm">
  Your browser does not support the video tag.
</video></center>

### Program 2: DialogBox (Check Marks Program)

```java
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
```

- Output:-

[2.webm](https://user-images.githubusercontent.com/26346867/205425427-bd0ee96a-54c7-45ae-83b8-d581a9452cdb.webm)

<center><video controls>
  <source src="https://user-images.githubusercontent.com/26346867/205425427-bd0ee96a-54c7-45ae-83b8-d581a9452cdb.webm" type="video/webm">
  Your browser does not support the video tag.
</video></center>

