import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class EditFrame{
    JFrame frm;
    JTextArea ta;
    JMenuBar mb;
    JMenu filemnu;
    JMenu colormnu;
    JMenuItem savemnuitm,openmnuitm;
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
        savemnuitm=new JMenuItem("Save",KeyEvent.VK_0);
        savemnuitm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        openmnuitm=new JMenuItem("Open",KeyEvent.VK_0);
        openmnuitm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        filemnu.add(savemnuitm);
        filemnu.add(openmnuitm);

        openmnuitm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                JFileChooser jc=new JFileChooser();
                int opt=jc.showOpenDialog(frm);
                if(opt==JFileChooser.APPROVE_OPTION){ //APPROVE_OPTION -> static data member
                try{
                    File f=jc.getSelectedFile(); //getSelected file -> non-static function
                    FileInputStream fin=new FileInputStream(f);
                    byte d[]=new byte[(int)f.length()]; //Java doesn't allow long in byte arrays so we use int for explicit type conversion
                    ta.setText(new String(d)); //byte array to String conversion
                    frm.getContentPane().repaint();
                    fin.close();
                }catch(Exception e){
                    ta.setText("Caught.."+e);
                }
              }
            }
        });

        savemnuitm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                JFileChooser jc=new JFileChooser();
                int opt=jc.showSaveDialog(frm);
                if(opt==JFileChooser.APPROVE_OPTION){
                    try{
                        File f=jc.getSelectedFile();
                        FileInputStream fin=new FileInputStream(f);
                        byte d[]=new byte[(int)f.length()]; //Java doesn't allow long in byte arrays so we use int for explicit type conversion
                        ta.setText(new String(d)); //byte array to String conversion
                        frm.getContentPane().repaint();
                        fin.close();
                    }catch(Exception e){
                        ta.setText("Caught.."+e);
                    }
                }
            }
        });

        bcmnuitm=new JCheckBoxMenuItem("Background");
        fcmnuitm=new JCheckBoxMenuItem("Foreground");
        colormnu.add(bcmnuitm);
        colormnu.add(fcmnuitm);
        bcmnuitm.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                Color c=JColorChooser.showDialog(frm,"Select a color",Color.white);
                ta.setBackground(c);
                frm.getContentPane().repaint();
            }
        });
        //fcmnuitm.addItemListener(new );

    }

   
    

    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() { //nameless object
                    public void run(){
                        new EditFrame();
                    }
            });
    }
}