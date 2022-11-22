import java.awt.*;
import java.awt.event.*;
class FreeHand3 extends Frame implements ItemListener,MouseListener{
    int xPressed,yPressed;
    int xReleased,yReleased;
    List l; int stroke;
    FreeHand3(){
        setVisible(true);
        setSize(500,500);
        setTitle("FreeHand");
        l=new List(5);
        for(int i=1;i<50;i++)
                l.add(i+"");
        add(l);
        stroke=1;
        l.setBounds(50,50,100,50);

        l.addItemListener(this);
        setBackground(Color.yellow);
        setForeground(Color.red);
        addMouseListener(this);
    }
    public void itemStateChanged(ItemEvent ie){
            stroke=Integer.parseInt(l.getSelectedItem());
    }
    /*java.awt.event.MouseListener Package*/
    public void mouseClicked(MouseEvent me){
    }
    public void mousePressed(MouseEvent me){
            xPressed=me.getX();
            xPressed=me.getY();
    }
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me){}
    public void mouseExited(MouseEvent me){}
    /*java.awt.event.MouseMotionListener*/
    public void mouseDragged(MouseEvent me){
            Graphics2D g=(Graphics2D) this.getGraphics();
            g.setStroke(new BasicStroke(stroke));
            xReleased=me.getX();
            xReleased=me.getY();
            g.drawLine(xPressed,yPressed,xReleased,yReleased);
            xPressed=xReleased;
            yPressed=yReleased;
    }
    public void mouseMoved(MouseEvent me){}
    public static void main(String arg[]){
        new FreeHand3();
    }
}
