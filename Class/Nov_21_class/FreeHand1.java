/*Free hand drawing Java Program*/
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