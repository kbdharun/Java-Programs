import java.awt.*;
import java.awt.event.*; //Abstract Windowing Toolkit [AWT]

public class Test extends Frame implements ActionListener{
    static int count;
    Button btnSubmit;
    Label lblStatus;
    public Test(){
        btnSubmit=new Button("Press...");
        lblStatus=new Label();
        setVisible(true);
        setSize(500,500);
        //layout
        setLayout(null); //null layout can be used if need to control each and every component
        add(btnSubmit);
        btnSubmit.setBounds(50,50,100,50); /*(X_displacement_coordinate,Y_displacement_coordinate,width,height)*/
        add(lblStatus);
        lblStatus.setBounds(50,100,100,50);
        btnSubmit.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        lblStatus.setText(btnSubmit.getLabel()+(count++));
        repaint();
    }
    public static void main(String[] args){
        new Test();
    }
}