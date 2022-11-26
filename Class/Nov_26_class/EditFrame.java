import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EditFrame implements ItemListener{
    JFrame frm;
    JTextArea ta;
    JMenuBar mb;
    JMenu filemnu;
    JMenu colormnu;
    JMenuItem savemnuitm,opMenuItem;
    JCheckBoxMenuItem bcmnuitm,fcmnuitm;
    EditFrame(){
        frm=new JFrame("Wordpad");
        frm.setVisible(true);
        frm.setSize(500,500);
        frm.setLayout(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ta=new JTextArea("Enter here...");
        ta.setBounds(0,0,frm.getWidth(),frm.getHeight());
        frm.add(ta);

        mb=new JMenuBar();
        frm.setJMenuBar(mb);
        filemnu=new JMenu("File");
        mb.add(filemnu);

        colormnu=new JMenu("Color");
        mb.add(colormnu);
        savemnuitm=new JMenuItem("Save");
        opMenuItem=new JMenuItem("Open");
        filemnu.add(savemnuitm);
        filemnu.add(opMenuItem);

        bcmnuitm=new JCheckBoxMenuItem("Background");
        fcmnuitm=new JCheckBoxMenuItem("Foreground");
        colormnu.add(bcmnuitm);
        colormnu.add(fcmnuitm);
        bcmnuitm.addItemListener(this);
        fcmnuitm.addItemListener(this);

    }

    public void itemStateChanged(ItemEvent ie){
        if (ie.getSource()==bcmnuitm)
                if (bcmnuitm.getState())
                        ta.setBackground(Color.red);
                else
                        frm.setBackground(Color.white);
        else
                if (fcmnuitm.getState())
                        ta.setForeground(Color.yellow);
                else
                ta.setForeground(Color.black);  
    }

    public void paint(Graphics g){
        
    }

    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() { //nameless object
                    public void run(){
                        new EditFrame();
                    }
            });
    }
}