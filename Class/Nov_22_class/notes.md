# Notes (November 22,2022)

## Topics

- AdjustmentEvent..Scrollbar...AdjustmentListener

## Programs

### Program 1: ColorFrame

```java
//AdjustmentEvent..Scrollbar...AdjustmentListener
import java.awt.*;
import java.awt.event.*;
class ColorFrame extends Frame implements AdjustmentListener{
        Scrollbar sr,sg,sb;
        ColorFrame(){
            setVisible(true);
            setSize(500,500);
            setTitle("ColorFrame");
            setLayout(null);

            sr=new Scrollbar(Scrollbar.HORIZONTAL,0,5,0,255); add(sr);
            sg=new Scrollbar(Scrollbar.HORIZONTAL,0,5,0,255); add(sg);
            sb=new Scrollbar(Scrollbar.HORIZONTAL,0,5,0,255); add(sb);
            sr.setBackground(Color.red);
            sr.setBounds(50,50,255,30);
            sg.setBounds(50,150,255,30);
            sb.setBounds(50,250,255,30);

            sr.addAdjustmentListener(this);
            sg.addAdjustmentListener(this);
            sb.addAdjustmentListener(this);



        }
        public void adjustmentValueChanged(AdjustmentEvent ae){
            setBackground(new Color(sr.getValue(),sg.getValue(),sb.getValue()));
        }
        public static void main(String args[]) {
            new ColorFrame();
        }
}
```

- Output:-

[1.webm](https://user-images.githubusercontent.com/26346867/203294391-88074e92-fea5-44bf-bea0-fb8ed8d5fa9e.webm)
                                                                                                            
### Program 2: ColorFrame using Swing

```java
//AdjustmentEvent..Scrollbar...AdjustmentListener
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class ColorFrame extends JFrame implements AdjustmentListener{
        JScrollBar sr,sg,sb;
        ColorFrame(){
            setVisible(true);
            setSize(500,500);
            setTitle("ColorFrame");
            setLayout(null);

            sr=new JScrollBar(JScrollBar.HORIZONTAL,0,5,0,255); add(sr);
            sg=new JScrollBar(JScrollBar.HORIZONTAL,0,5,0,255); add(sg);
            sb=new JScrollBar(JScrollBar.HORIZONTAL,0,5,0,255); add(sb);
            //sr.setBackground(Color.red);
            sr.setBounds(50,50,255,30);
            sg.setBounds(50,150,255,30);
            sb.setBounds(50,250,255,30);

            sr.addAdjustmentListener(this);
            sg.addAdjustmentListener(this);
            sb.addAdjustmentListener(this);



        }
        public void adjustmentValueChanged(AdjustmentEvent ae){
            setBackground(new Color(sr.getValue(),sg.getValue(),sb.getValue()));
        }
        public static void main(String args[]) {
            new ColorFrame();
        }       
}
```     
- Output:-
             
[2.webm](https://user-images.githubusercontent.com/26346867/203294578-03377be2-1322-492e-9e55-74e62ec65dd6.webm)

### Program 3 (To try):-

- Question: Contacts Management
Create a swing GUI application to manage contact information.
Create a class Contact with details like Name, mobile number, type of contact(family,
official).
Create another class called ContactManagement. In this class create an ArrayList to store the
objects of contact class objects. Create methods to perform following activities.

Add a contact into array list. This method should receive a contact class object and
insert it into array list. Before insert, iterate the array list and check the new contact
mobile number already exist the array list contacts. If exists, throw user defined
exception “Duplicate Contact”.
Search contact - this method should accept a name and searches it in the array list.
This method should return all the contact names which contains input name as a
substring. Example if input is “Raj” then all names which contains “Raj” and their
mobile number must be concatenated into single string and stored in a temporary
array list. this method should return that array list.
Display contacts - this method should return array list sorted by mobile number.
In swing application create text fields to get inputs(name and mobile number) and drop down
list to get type of contact. Create three buttons, “Add contact”, “Search Contact” and “Display
All Contacts”.

Add Contact button – read the information from text fields and drop down list and
pass this information to add contact method of contact management class to store
the details in the array list.
Search contact – read name from text field and pass this to search contact method
of contact management class. If contact found display details in a text area,
otherwise display the respective error message in the same text area.
Display All Contacts – call the display contacts method from contact management
class and get the list of contacts. Display all contacts in a text area by iterating the
array list. (Concatenate all contact details into one single string and set this string
to text area).


### Scrollbar Package (*disassembeled*)

```bash
$ javap java.awt.Scrollbar
Compiled from "Scrollbar.java"
public class java.awt.Scrollbar extends java.awt.Component implements java.awt.Adjustable,javax.accessibility.Accessible {
  public static final int HORIZONTAL;
  public static final int VERTICAL;
  int value;
  int maximum;
  int minimum;
  int visibleAmount;
  int orientation;
  int lineIncrement;
  int pageIncrement;
  transient boolean isAdjusting;
  transient java.awt.event.AdjustmentListener adjustmentListener;
  public java.awt.Scrollbar() throws java.awt.HeadlessException;
  public java.awt.Scrollbar(int) throws java.awt.HeadlessException;
  public java.awt.Scrollbar(int, int, int, int, int) throws java.awt.HeadlessException;
  java.lang.String constructComponentName();
  public void addNotify();
  public int getOrientation();
  public void setOrientation(int);
  public int getValue();
  public void setValue(int);
  public int getMinimum();
  public void setMinimum(int);
  public int getMaximum();
  public void setMaximum(int);
  public int getVisibleAmount();
  public int getVisible();
  public void setVisibleAmount(int);
  public void setUnitIncrement(int);
  public synchronized void setLineIncrement(int);
  public int getUnitIncrement();
  public int getLineIncrement();
  public void setBlockIncrement(int);
  public synchronized void setPageIncrement(int);
  public int getBlockIncrement();
  public int getPageIncrement();
  public void setValues(int, int, int, int);
  public boolean getValueIsAdjusting();
  public void setValueIsAdjusting(boolean);
  public synchronized void addAdjustmentListener(java.awt.event.AdjustmentListener);
  public synchronized void removeAdjustmentListener(java.awt.event.AdjustmentListener);
  public synchronized java.awt.event.AdjustmentListener[] getAdjustmentListeners();
  public <T extends java.util.EventListener> T[] getListeners(java.lang.Class<T>);
  boolean eventEnabled(java.awt.AWTEvent);
  protected void processEvent(java.awt.AWTEvent);
  protected void processAdjustmentEvent(java.awt.event.AdjustmentEvent);
  protected java.lang.String paramString();
  public javax.accessibility.AccessibleContext getAccessibleContext();
  static {};
}
```
