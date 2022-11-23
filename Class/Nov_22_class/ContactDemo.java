//ItemEvent..ItemListener..List..Choice..Checkbox..RadioButton
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
class Contact{
 String name;
 long mobile;
 Contact(String name,long mobile){
  this.name=name;
  this.mobile=mobile;
 }
 public String toString(){
  return name+","+mobile;
 }
}
class ContactDemo extends Frame implements ActionListener,ItemListener{
 Label lblname,lblmobile;
 TextField txtname,txtmobile;
 Button btnadd,btnremove;
 List cl;
 ArrayList<Contact> al;

 ContactDemo(){
  setVisible(true);
  setSize(500,500);
  setTitle("ContactManagment");
  setLayout(null);
  al=new ArrayList<Contact>();
  lblname=new Label("Name:"); add(lblname); lblname.setBounds(50,50,100,30);
  lblmobile=new Label("Mobile:");add(lblmobile); lblmobile.setBounds(50,150, 100,30);
  
  txtname=new TextField(20);add(txtname); txtname.setBounds(150,50,100,30);
  txtmobile=new TextField(20);add(txtmobile); txtmobile.setBounds(150,150,100,30);

  btnadd=new Button("Add");add(btnadd); btnadd.setBounds(350,50,100,30);
  btnremove=new Button("Remove");add(btnremove); btnremove.setBounds(350,150,100,30);
  
  cl=new List(5);add(cl); cl.setBounds(250,250,150,50);

  btnadd.addActionListener(this);
  btnremove.addActionListener(this);
  cl.addItemListener(this);
 }
 public void actionPerformed(ActionEvent ae){
  if (ae.getSource()==btnadd){
   Contact c=new Contact(txtname.getText(),Long.parseLong(txtmobile.getText()));
   al.add(c);
   cl.add(c+"");
  }
  if (ae.getSource()==btnremove){
   Contact c=new Contact(txtname.getText(),Long.parseLong(txtmobile.getText()));
   al.remove(c);
   cl.remove(c+"");
  }
  txtname.setText("");
  txtmobile.setText("");
 }
 public void itemStateChanged(ItemEvent ie){
  Contact c=(Contact)al.get(cl.getSelectedIndex());
  txtname.setText(c.name);
  txtmobile.setText(c.mobile+"");
 }
 public static void main(String args[]){
  new ContactDemo();
 }
}
