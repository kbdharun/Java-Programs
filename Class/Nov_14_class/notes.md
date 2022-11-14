# Notes (November 14,2022)

## Topics

- Developing GUI based programs

## General Notes

- In console based application, is sequential based on Threads. Whereas GUI, isn't sequential based programming.
- Input Output interaction is through the User in GUI, unlike console based interaction.

## GUI

- Abbreviation(GUI): **G**raphical **U**ser **I**nterface
- It provides elegant way for interacting with program.
- Java --> User interface ,  Logic
- Implementation must have seperate User interface and logic this kind of event handing is known as *Delegation Event Model*.
- Delegation Event Model is used by Java developers to design GUI.
- Window is a container for the component.
- Button should be inside a frame or window using container.
- Main isn't required for web-based and mobile-based applications.
- Naming: First 3 character must be precided with type.
- For example all button classes must be precided by `btn`.
- Layout- The way in which a control should be arranged.
- Container --> Panel, Frame, Window
  - Panel is a container like canvas (It doesn't have any status bar)
  - Panel doesn't have menu whereas frame has it.

### Delegation Event Model

- **Delegation Event Model (Elements)**
  - Event (Action on any user interface [Mostly by user, but sometimes it is Built-In Action i.e Timer Object])
  - EventSource (Object which triggers the event)
  - EventListener (Contains the logic of what to do when an event occurs)

- Event--->Click (EventSource)--reg-->EventListener
- It delegates the work to EventListener therefore it is known as the Delegation Event Model.
- Event handler is an interface whereas Event and EventSource are class.

### AWT vs Swing

- **A**bstract **W**indowing **T**oolkit [**AWT**] designed by HTML developers using ***C code***.
- From `java` version 2.0; the AWT controls were replaced with *Java platform independent* **Swing** controls.

### AWT frame class (*disassembeled*)

```bash
javap java.awt.Frame
Compiled from "Frame.java"
public class java.awt.Frame extends java.awt.Window implements java.awt.MenuContainer {
  public static final int DEFAULT_CURSOR;
  public static final int CROSSHAIR_CURSOR;
  public static final int TEXT_CURSOR;
  public static final int WAIT_CURSOR;
  public static final int SW_RESIZE_CURSOR;
  public static final int SE_RESIZE_CURSOR;
  public static final int NW_RESIZE_CURSOR;
  public static final int NE_RESIZE_CURSOR;
  public static final int N_RESIZE_CURSOR;
  public static final int S_RESIZE_CURSOR;
  public static final int W_RESIZE_CURSOR;
  public static final int E_RESIZE_CURSOR;
  public static final int HAND_CURSOR;
  public static final int MOVE_CURSOR;
  public static final int NORMAL;
  public static final int ICONIFIED;
  public static final int MAXIMIZED_HORIZ;
  public static final int MAXIMIZED_VERT;
  public static final int MAXIMIZED_BOTH;
  java.awt.Rectangle maximizedBounds;
  java.lang.String title;
  java.awt.MenuBar menuBar;
  boolean resizable;
  boolean undecorated;
  boolean mbManagement;
  java.util.Vector<java.awt.Window> ownedWindows;
  public java.awt.Frame() throws java.awt.HeadlessException;
  public java.awt.Frame(java.awt.GraphicsConfiguration);
  public java.awt.Frame(java.lang.String) throws java.awt.HeadlessException;
  public java.awt.Frame(java.lang.String, java.awt.GraphicsConfiguration);
  java.lang.String constructComponentName();
  public void addNotify();
  public java.lang.String getTitle();
  public void setTitle(java.lang.String);
  public java.awt.Image getIconImage();
  public void setIconImage(java.awt.Image);
  public java.awt.MenuBar getMenuBar();
  public void setMenuBar(java.awt.MenuBar);
  public boolean isResizable();
  public void setResizable(boolean);
  public synchronized void setState(int);
  public void setExtendedState(int);
  public synchronized int getState();
  public int getExtendedState();
  public void setMaximizedBounds(java.awt.Rectangle);
  public java.awt.Rectangle getMaximizedBounds();
  public void setUndecorated(boolean);
  public boolean isUndecorated();
  public void setOpacity(float);
  public void setShape(java.awt.Shape);
  public void setBackground(java.awt.Color);
  public void remove(java.awt.MenuComponent);
  public void removeNotify();
  void postProcessKeyEvent(java.awt.event.KeyEvent);
  protected java.lang.String paramString();
  public void setCursor(int);
  public int getCursorType();
  public static java.awt.Frame[] getFrames();
  public javax.accessibility.AccessibleContext getAccessibleContext();
  static {};
}
```

### Program:-

```java
import java.awt.*;
import java.awt.event.*; //Abstract Windowing Toolkit [AWT]

public class Test extends Frame implements ActionListener{
    static int count;
    Button btnSubmit;
    Label lblStatus;
    public Test(){
        btnSubmit=new Button("Press...");
        lblStatus=new Label();
        setVisible(true);
        setSize(500,500);
        //layout
        setLayout(null); //null layout can be used if need to control each and every component
        add(btnSubmit);
        btnSubmit.setBounds(50,50,100,50); /*(X_displacement_coordinate,Y_displacement_coordinate,width,height)*/
        add(lblStatus);
        lblStatus.setBounds(50,100,100,50);
        btnSubmit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        lblStatus.setText(btnSubmit.getLabel()+(count++));
        repaint();
    }
    public static void main(String[] args){
        new Test();
    }
}
```
