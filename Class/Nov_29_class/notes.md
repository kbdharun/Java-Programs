# Notes (November 29, 2022)

## Topics

- JToggleButton..JRadioButton..JCheckBox
- ItemItem...ItemListener
- Swing..Menu Handling

## Programs

### Program 1a:-

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class DemoFrame{
    JFrame frm;
    JToggleButton tb;
    String msg;
    JLabel lbl;
    DemoFrame(){
        frm=new JFrame("Wordpad");
        frm.setVisible(true);
        frm.setSize(500,500);
        frm.setLayout(null);
        tb.setBounds(100,100,100,50);
        frm.add(tb);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tb=new JToggleButton("ON/OFF");
        lbl=new JLabel("Status");
        lbl.setBounds(50,50,100,50);
        frm.add(lbl);
        tb.setBounds(100,100,100,50);
        frm.add(tb);
        msg="";
        tb.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                if(tb.isSelected()==true)
                       lbl.setText("ON");

                else
                        lbl.setText("OFF");
            frm.getContentPane().repaint(); 
            }
    }); 
}
    
    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() { //nameless object
                    public void run(){
                        new DemoFrame();
                    }
            });
    }
}
```

### Program 1b:-

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DemoFrame{
    JFrame frm;
    JRadioButton rb1,rb2,rb3;
    String msg;
    JLabel lbl;
    DemoFrame(){
        frm=new JFrame("Wordpad");
        frm.setVisible(true);
        frm.setSize(500,500);
        frm.setLayout(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rb1=new JRadioButton("CSE");
        rb2=new JRadioButton("IT");
        rb3=new JRadioButton("ICT");

        lbl=new JLabel("Status");
        lbl.setBounds(50,50,100,50);
        frm.add(lbl);
        rb1.setBounds(100,100,100,50);frm.add(rb1);
        rb2.setBounds(100,160,100,50);frm.add(rb2);
        rb3.setBounds(100,220,100,50);frm.add(rb3);
        ButtonGroup bg=new ButtonGroup();
        bg.add(rb1);bg.add(rb2);bg.add(rb3);

        rb1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                if(rb1.isSelected())
                       lbl.setText("CSE");
            }       
    }); 
    rb2.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
            if(rb2.isSelected())
                   lbl.setText("IT"); 
        }       
}); 
rb3.addItemListener(new ItemListener(){
    public void itemStateChanged(ItemEvent ie){
        if(rb3.isSelected())
               lbl.setText("ICT"); 
    }   
}); 
}
    
    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() { //nameless object
                    public void run(){
                        new DemoFrame();
                    }
            });
    }
}
```

- Output:-

[1b.webm](https://user-images.githubusercontent.com/26346867/204508874-5611341d-32a2-4179-99ba-d12a00d97c42.webm)

<center><video width="100%" height= "auto" controls>
  <source src="https://user-images.githubusercontent.com/26346867/204508874-5611341d-32a2-4179-99ba-d12a00d97c42.webm" type="video/webm">
  Your browser does not support the video tag.
</video></center>

### Program 1c:-

```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DemoFrame{
    JFrame frm;
    JCheckBox cb1,cb2,cb3;
    String msg;
    JLabel lbl;
    DemoFrame(){
        frm=new JFrame("Wordpad");
        frm.setVisible(true);
        frm.setSize(500,500);
        frm.setLayout(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cb1=new JCheckBox("AB");
        cb2=new JCheckBox("CD");
        cb3=new JCheckBox("EF");

        lbl=new JLabel("Status");
        lbl.setBounds(50,50,100,50);
        frm.add(lbl);
        cb1.setBounds(100,100,100,50);frm.add(cb1);
        cb2.setBounds(100,160,100,50);frm.add(cb2);
        cb3.setBounds(100,220,100,50);frm.add(cb3);
        ButtonGroup bg=new ButtonGroup();
        bg.add(cb1);bg.add(cb2);bg.add(cb3);

        cb1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                if(cb1.isSelected())
                       lbl.setText(lbl.getText()+cb1.getText());
            }       
    }); 
     cb2.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
            if(cb2.isSelected())
                lbl.setText(lbl.getText()+cb2.getText());
        }       
}); 
    cb3.addItemListener(new ItemListener(){
     public void itemStateChanged(ItemEvent ie){
         if(cb3.isSelected())
              lbl.setText(lbl.getText()+cb3.getText());
    }   
}); 
}
    
    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() { //nameless object
                    public void run(){
                        new DemoFrame();
                    }
            });
    }
}
```

- Output:-

[1c.webm](https://user-images.githubusercontent.com/26346867/204508963-573573e2-191a-4f4b-b223-9284b2d4c5e1.webm)

<center><video width="100%" height= "auto" controls>
  <source src="https://user-images.githubusercontent.com/26346867/204508963-573573e2-191a-4f4b-b223-9284b2d4c5e1.webm" type="video/webm">
  Your browser does not support the video tag.
</video></center>


## References

### JToggleButton class (*disassembeled*)

```bash
$ javap javax.swing.JToggleButton
Compiled from "JToggleButton.java"
public class javax.swing.JToggleButton extends javax.swing.AbstractButton implements javax.accessibility.Accessible {
  public javax.swing.JToggleButton();
  public javax.swing.JToggleButton(javax.swing.Icon);
  public javax.swing.JToggleButton(javax.swing.Icon, boolean);
  public javax.swing.JToggleButton(java.lang.String);
  public javax.swing.JToggleButton(java.lang.String, boolean);
  public javax.swing.JToggleButton(javax.swing.Action);
  public javax.swing.JToggleButton(java.lang.String, javax.swing.Icon);
  public javax.swing.JToggleButton(java.lang.String, javax.swing.Icon, boolean);
  public void updateUI();
  public java.lang.String getUIClassID();
  boolean shouldUpdateSelectedStateFromAction();
  public void requestFocus(java.awt.event.FocusEvent$Cause);
  public boolean requestFocusInWindow(java.awt.event.FocusEvent$Cause);
  protected java.lang.String paramString();
  public javax.accessibility.AccessibleContext getAccessibleContext();
  static javax.accessibility.AccessibleContext access$000(javax.swing.JToggleButton);
  static javax.accessibility.AccessibleContext access$100(javax.swing.JToggleButton);
  static javax.accessibility.AccessibleContext access$200(javax.swing.JToggleButton);
}
```
