/*Free hand drawing Java Program*/
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