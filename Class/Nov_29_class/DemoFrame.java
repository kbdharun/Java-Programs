import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DemoFrame{
    JFrame frm;
    JCheckBox cb1,cb2,cb3;
    String msg;
    JLabel lbl;
    DemoFrame(){
        frm=new JFrame("Wordpad");
        frm.setVisible(true);
        frm.setSize(500,500);
        frm.setLayout(null);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cb1=new JCheckBox("AB");
        cb2=new JCheckBox("CD");
        cb3=new JCheckBox("EF");

        lbl=new JLabel("Status");
        lbl.setBounds(50,50,100,50);
        frm.add(lbl);
        cb1.setBounds(100,100,100,50);frm.add(cb1);
        cb2.setBounds(100,160,100,50);frm.add(cb2);
        cb3.setBounds(100,220,100,50);frm.add(cb3);
        ButtonGroup bg=new ButtonGroup();
        bg.add(cb1);bg.add(cb2);bg.add(cb3);

        cb1.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                if(cb1.isSelected())
                       lbl.setText(lbl.getText()+cb1.getText());
            }       
    }); 
     cb2.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
            if(cb2.isSelected())
                lbl.setText(lbl.getText()+cb2.getText());
        }       
}); 
    cb3.addItemListener(new ItemListener(){
     public void itemStateChanged(ItemEvent ie){
         if(cb3.isSelected())
              lbl.setText(lbl.getText()+cb3.getText());
    }   
}); 
}
    
    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() { //nameless object
                    public void run(){
                        new DemoFrame();
                    }
            });
    }
}