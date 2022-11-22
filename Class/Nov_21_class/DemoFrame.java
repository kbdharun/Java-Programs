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
