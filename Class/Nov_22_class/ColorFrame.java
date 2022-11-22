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