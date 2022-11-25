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