# Notes (25 November,2022)

## Topics

- Adapter class, Inner class and KeyListener

## WindowListener class (*disassembeled*)

```bash
$ javap java.awt.event.WindowListener
Compiled from "WindowListener.java"
public interface java.awt.event.WindowListener extends java.util.EventListener {
  public abstract void windowOpened(java.awt.event.WindowEvent);
  public abstract void windowClosing(java.awt.event.WindowEvent);
  public abstract void windowClosed(java.awt.event.WindowEvent);
  public abstract void windowIconified(java.awt.event.WindowEvent);
  public abstract void windowDeiconified(java.awt.event.WindowEvent);
  public abstract void windowActivated(java.awt.event.WindowEvent);
  public abstract void windowDeactivated(java.awt.event.WindowEvent);
}
```

## WindowAdapter class (*disassembeled*)

```bash
$ javap java.awt.event.WindowAdapter
Compiled from "WindowAdapter.java"
public abstract class java.awt.event.WindowAdapter implements java.awt.event.WindowListener,java.awt.event.WindowStateListener,java.awt.event.WindowFocusListener {
  protected java.awt.event.WindowAdapter();
  public void windowOpened(java.awt.event.WindowEvent);
  public void windowClosing(java.awt.event.WindowEvent);
  public void windowClosed(java.awt.event.WindowEvent);
  public void windowIconified(java.awt.event.WindowEvent);
  public void windowDeiconified(java.awt.event.WindowEvent);
  public void windowActivated(java.awt.event.WindowEvent);
  public void windowDeactivated(java.awt.event.WindowEvent);
  public void windowStateChanged(java.awt.event.WindowEvent);
  public void windowGainedFocus(java.awt.event.WindowEvent);
  public void windowLostFocus(java.awt.event.WindowEvent);
}
```

## KeyListener class (*disassembeled*)

```bash
javap java.awt.event.KeyListener
Compiled from "KeyListener.java"
public interface java.awt.event.KeyListener extends java.util.EventListener {
  public abstract void keyTyped(java.awt.event.KeyEvent);
  public abstract void keyPressed(java.awt.event.KeyEvent);
  public abstract void keyReleased(java.awt.event.KeyEvent);
}
```

## General Notes

- Placeholder

## Programs

### Program 1: Using WindowListener to close a program

```java
//WindowEvent..Frame..Panel...WindowListener...WindowAdapter
import java.awt.*;
import java.awt.event.*;

class DemoFrame extends Frame implements WindowListener{
    DemoFrame(){
            setVisible(true);
            setSize(500,500);
            setTitle("FrameDemo");
            addWindowListener(this);
    }
  public void windowOpened(WindowEvent we){};
  public void windowClosing(WindowEvent we){
        System.exit(0);
  };
  public void windowClosed(WindowEvent we){};
  public void windowIconified(WindowEvent we){};
  public void windowDeiconified(WindowEvent we){};
  public void windowActivated(WindowEvent we){};
  public void windowDeactivated(WindowEvent we){};

    public static void main(String[] args) {
        new DemoFrame();
    }
}
```

- Output:-

### Program 2:-

```java
//WindowEvent..Frame..Panel...WindowListener...WindowAdapter
import java.awt.*;
import java.awt.event.*;

class DemoFrame extends Frame{
    DemoFrame(){
            setVisible(true);
            setSize(500,500);
            setTitle("FrameDemo");
            addWindowListener(new MyWindowAdapter(this));
    }

    public static void main(String[] args) {
        new DemoFrame();
    }
}

class MyWindowAdapter extends WindowAdapter{
    DemoFrame fr;
    MyWindowAdapter(DemoFrame fr){
        this.fr=fr;
    }
    public void windowClosing(WindowEvent we){
        System.exit(0);
    }
}
```

- Output:- Same as Program 1

### Program 3:-

```java
//WindowEvent..Frame..Panel...WindowListener...WindowAdapter
import java.awt.*;
import java.awt.event.*;

class DemoFrame extends Frame{
    DemoFrame(){
            setVisible(true);
            setSize(500,500);
            setTitle("FrameDemo");
            addWindowListener(new MyWindowAdapter());
    }

    class MyWindowAdapter extends WindowAdapter{ //Adapter Inner class
        public void windowClosing(WindowEvent we){
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new DemoFrame();
    }
}
```

- Output:- Same as Program 1

### Program 4:-

```java
//WindowEvent..Frame..Panel...WindowListener...WindowAdapter
import java.awt.*;
import java.awt.event.*;

class DemoFrame extends Frame{
    DemoFrame(){
            setVisible(true);
            setSize(500,500);
            setTitle("FrameDemo");
            addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent we){
                    System.exit(0);
                }
        });
    }

    public static void main(String[] args) {
        new DemoFrame();
    }
}
```

```java
//WindowEvent..Frame..Panel...WindowListener...WindowAdapter
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DemoFrame extends JFrame{
    DemoFrame(){
            setVisible(true);
            setSize(500,500);
            setTitle("FrameDemo");
            /*addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent we){
                    System.exit(0);
                }
        });*/
    }

    public static void main(String[] args) {
        new DemoFrame();
    }
}
```

- Output:- Same as Program 1

### Program 5:-

```java
//WindowEvent..Frame..Panel...WindowListener...WindowAdapter
import java.awt.*;
import java.awt.event.*;

class DemoFrame extends Frame{
    String msg;
    DemoFrame(){
            setVisible(true);
            setSize(500,500);
            setTitle("Frame Demo");
            setFont(new Font("Arial",Font.BOLD,20));
            setForeground(Color.red);
            msg="";
            addKeyListener(new KeyAdapter(){
                public void keyTyped(KeyEvent ke){
                    msg+=ke.getKeyChar();
                    repaint();
                }
        });
    }
    public void paint(Graphics g){
        g.drawString(msg,50,50);
    }
    public static void main(String[] args) {
        new DemoFrame();
    }
}
```

- Output:-
