# Notes (November 21,2022)

## Topics

- MouseEvent, MouseListener, MouseMotionListener

## Graphics Package (*disassembeled*)

```bash
$ javap java.awt.Graphics
Compiled from "Graphics.java"
public abstract class java.awt.Graphics {
  protected java.awt.Graphics();
  public abstract java.awt.Graphics create();
  public java.awt.Graphics create(int, int, int, int);
  public abstract void translate(int, int);
  public abstract java.awt.Color getColor();
  public abstract void setColor(java.awt.Color);
  public abstract void setPaintMode();
  public abstract void setXORMode(java.awt.Color);
  public abstract java.awt.Font getFont();
  public abstract void setFont(java.awt.Font);
  public java.awt.FontMetrics getFontMetrics();
  public abstract java.awt.FontMetrics getFontMetrics(java.awt.Font);
  public abstract java.awt.Rectangle getClipBounds();
  public abstract void clipRect(int, int, int, int);
  public abstract void setClip(int, int, int, int);
  public abstract java.awt.Shape getClip();
  public abstract void setClip(java.awt.Shape);
  public abstract void copyArea(int, int, int, int, int, int);
  public abstract void drawLine(int, int, int, int);
  public abstract void fillRect(int, int, int, int);
  public void drawRect(int, int, int, int);
  public abstract void clearRect(int, int, int, int);
  public abstract void drawRoundRect(int, int, int, int, int, int);
  public abstract void fillRoundRect(int, int, int, int, int, int);
  public void draw3DRect(int, int, int, int, boolean);
  public void fill3DRect(int, int, int, int, boolean);
  public abstract void drawOval(int, int, int, int);
  public abstract void fillOval(int, int, int, int);
  public abstract void drawArc(int, int, int, int, int, int);
  public abstract void fillArc(int, int, int, int, int, int);
  public abstract void drawPolyline(int[], int[], int);
  public abstract void drawPolygon(int[], int[], int);
  public void drawPolygon(java.awt.Polygon);
  public abstract void fillPolygon(int[], int[], int);
  public void fillPolygon(java.awt.Polygon);
  public abstract void drawString(java.lang.String, int, int);
  public abstract void drawString(java.text.AttributedCharacterIterator, int, int);
  public void drawChars(char[], int, int, int, int);
  public void drawBytes(byte[], int, int, int, int);
  public abstract boolean drawImage(java.awt.Image, int, int, java.awt.image.ImageObserver);
  public abstract boolean drawImage(java.awt.Image, int, int, int, int, java.awt.image.ImageObserver);
  public abstract boolean drawImage(java.awt.Image, int, int, java.awt.Color, java.awt.image.ImageObserver);
  public abstract boolean drawImage(java.awt.Image, int, int, int, int, java.awt.Color, java.awt.image.ImageObserver);
  public abstract boolean drawImage(java.awt.Image, int, int, int, int, int, int, int, int, java.awt.image.ImageObserver);
  public abstract boolean drawImage(java.awt.Image, int, int, int, int, int, int, int, int, java.awt.Color, java.awt.image.ImageObserver);
  public abstract void dispose();
  public void finalize();
  public java.lang.String toString();
  public java.awt.Rectangle getClipRect();
  public boolean hitClip(int, int, int, int);
  public java.awt.Rectangle getClipBounds(java.awt.Rectangle);
}
```

## MouseEvent, MouseListener and MouseMotionListener class (*disassembeled*)

```bash
$ javap java.awt.event.MouseEvent
Compiled from "MouseEvent.java"
public class java.awt.event.MouseEvent extends java.awt.event.InputEvent {
  public static final int MOUSE_FIRST;
  public static final int MOUSE_LAST;
  public static final int MOUSE_CLICKED;
  public static final int MOUSE_PRESSED;
  public static final int MOUSE_RELEASED;
  public static final int MOUSE_MOVED;
  public static final int MOUSE_ENTERED;
  public static final int MOUSE_EXITED;
  public static final int MOUSE_DRAGGED;
  public static final int MOUSE_WHEEL;
  public static final int NOBUTTON;
  public static final int BUTTON1;
  public static final int BUTTON2;
  public static final int BUTTON3;
  int x;
  int y;
  int clickCount;
  int button;
  boolean popupTrigger;
  public java.awt.Point getLocationOnScreen();
  public int getXOnScreen();
  public int getYOnScreen();
  public java.awt.event.MouseEvent(java.awt.Component, int, long, int, int, int, int, boolean, int);
  public java.awt.event.MouseEvent(java.awt.Component, int, long, int, int, int, int, boolean);
  public int getModifiersEx();
  public java.awt.event.MouseEvent(java.awt.Component, int, long, int, int, int, int, int, int, boolean, int);
  public int getX();
  public int getY();
  public java.awt.Point getPoint();
  public synchronized void translatePoint(int, int);
  public int getClickCount();
  public int getButton();
  public boolean isPopupTrigger();
  public static java.lang.String getMouseModifiersText(int);
  public java.lang.String paramString();
  static {};
}

$ javap java.awt.event.MouseMotionListener
Compiled from "MouseMotionListener.java"
public interface java.awt.event.MouseMotionListener extends java.util.EventListener {
  public abstract void mouseDragged(java.awt.event.MouseEvent);
  public abstract void mouseMoved(java.awt.event.MouseEvent);
}

$ javap java.awt.event.MouseListener
Compiled from "MouseListener.java"
public interface java.awt.event.MouseListener extends java.util.EventListener {
  public abstract void mouseClicked(java.awt.event.MouseEvent);
  public abstract void mousePressed(java.awt.event.MouseEvent);
  public abstract void mouseReleased(java.awt.event.MouseEvent);
  public abstract void mouseEntered(java.awt.event.MouseEvent);
  public abstract void mouseExited(java.awt.event.MouseEvent);

```

### Scrollbar class (*disassembeled*)

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

## General Notes

- MouseEvent... Frame...MouseListener , Panel
- Must be implemented for mouse only events.

## Adjustment Event

- AdjustmentEvent...Scrollbar...AdjustmentListener

## Programs

### Program 1: Free hand drawing using Mouse

```java
/*Free hand drawing Java Program using awt*/
import java.awt.*;
import java.awt.event.*;
class FreeHand extends Frame implements MouseListener, MouseMotionListener{
    int xPressed,yPressed;
    int xReleased,yReleased;
    Label l;
    FreeHand(){
        setVisible(true);
        setSize(500,500);
        setTitle("FreeHand");
        l=new Label("");
        setLayout(null);
        l.setBounds(50,50,500,50);
        add(l);
        setBackground(Color.yellow);
        setForeground(Color.red);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    /*java.awt.event.MouseListener Package*/
    public void mouseClicked(MouseEvent me){
            l.setText(l.getText()+"Clicked..");
    }
    public void mousePressed(MouseEvent me){
            xPressed=me.getX();
            xPressed=me.getY();
            l.setText(l.getText()+"Pressed..");
    }
    public void mouseReleased(MouseEvent me){
        l.setText(l.getText()+"Released..");
    }
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
    /*java.awt.event.MouseMotionListener*/
    public void mouseDragged(MouseEvent me){
            Graphics2D g=(Graphics2D) this.getGraphics();
            g.setStroke(new BasicStroke(8));
            xReleased=me.getX();
            xReleased=me.getY();
            g.drawLine(xPressed,yPressed,xReleased,yReleased);
            xPressed=xReleased;
            yPressed=yReleased;
    }
    public void mouseMoved(MouseEvent me){}
    public static void main(String arg[]){
        new FreeHand();
    }
}
```

```java
/*Free hand drawing Java Program using swing*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class FreeHand1 extends JFrame implements MouseListener, MouseMotionListener{
    int xPressed,yPressed;
    int xReleased,yReleased;
    FreeHand1(){
        setVisible(true);
        setSize(500,500);
        setTitle("FreeHand");
        setLayout(null);
        setBackground(Color.yellow);
        setForeground(Color.red);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    /*java.awt.event.MouseListener Package*/
    public void mouseClicked(MouseEvent me){
    }
    public void mousePressed(MouseEvent me){
            xPressed=me.getX();
            xPressed=me.getY();
    }
    public void mouseReleased(MouseEvent me){
    }
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
    /*java.awt.event.MouseMotionListener*/
    public void mouseDragged(MouseEvent me){
            Graphics2D g=(Graphics2D) this.getGraphics();
            g.setStroke(new BasicStroke(8));
            xReleased=me.getX();
            xReleased=me.getY();
            g.drawLine(xPressed,yPressed,xReleased,yReleased);
            xPressed=xReleased;
            yPressed=yReleased;
    }
    public void mouseMoved(MouseEvent me){}
    public static void main(String arg[]){
        new FreeHand();
    }
}
```

```java
//MouseEvent...Frame,Panel...MouseListener,MouseMotionListener
import java.awt.*;
import java.awt.event.*;
class DemoFrame extends Frame implements MouseListener,MouseMotionListener, ItemListener{
 int xstart,ystart;
 int xend,yend;
 List l;
 List r,b,g;
 int cr,cb,cg;
 int strokesize;
 DemoFrame(){
  setVisible(true);  
  setSize(500,500);
  setTitle("FreeHand");
  setLayout(null);
  strokesize=1;
  l=new List();
  for(int i=1;i<50;i++)
   l.add(i+"");

  add(l);
  l.setBounds(50,50,100,50);
  l.addItemListener(this);
  addMouseListener(this);
  addMouseMotionListener(this);
 }
 public void itemStateChanged(ItemEvent ie){
  strokesize=Integer.parseInt(l.getSelectedItem());
 }
 public void mouseClicked(MouseEvent me){}
   public void mousePressed(MouseEvent me){
  xstart=me.getX();
  ystart=me.getY();
 }
   public void mouseReleased(MouseEvent me){}
   public void mouseEntered(MouseEvent me){}
  public void mouseExited(MouseEvent me){}
   public void mouseDragged(MouseEvent me){
  Graphics2D g=(Graphics2D)this.getGraphics();
  g.setStroke(new BasicStroke(strokesize));
  xend=me.getX();
  yend=me.getY();
  g.drawLine(xstart,ystart,xend,yend);
  xstart=xend;
  ystart=yend;
 }
 public void mouseMoved(MouseEvent me){}

     public static void main(String args[]){
    new DemoFrame();
 }  
}
```
  
- Output:-

[DemoFrame.webm](https://user-images.githubusercontent.com/26346867/203282074-e5e83493-4af2-41f5-a829-932e1b3efb57.webm)
