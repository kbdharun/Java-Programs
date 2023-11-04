/*Contacts Management:
Create a swing GUI application to manage contact information.
Create a class Contact with details like Name, mobile number, type of conctact(family,
official).
Create another class called ContactManagement. In this class create an ArrayList to store the
objects of contact class objects. Create methods to perform following activities.
-
Add a contact into array list. This method should receive a contact class object and
insert it into array list. Before insert, iterate the array list and check the new contact
mobile number already exist the array list contacts. If exists, throw user defined
exception “Duplicate Contact”.
Search contact - this method should accept a name and searches it in the array list.
This method should return all the contact names which contains input name as a
substring. Example if input is “Raj” then all names which contains “Raj” and their
mobile number must be concatenated into single string and stored in a temporary
array list. this method should return that array list.
Display contacts - this method should return array list sorted by mobile number.
In swing application create text fields to get inputs(name and mobile number) and drop down
list to get type of contact. Create three buttons, “Add contact”, “Search Contact” and “Display
All Contacts”.
-
Add Contact button – read the information from text fields and drop down list and
pass this information to add contact method of contact management class to store
the details in the array list.
Search contact – read name from text field and pass this to search contact method
of contact management class. If contact found display details in a text area,
otherwise display the respective error message in the same text area.
Display All Contacts – call the display contacts method from contact management
class and get the list of contacts. Display all contacts in a text area by iterating the
array list. (Concatenate all contact details into one single string and set this string
to text area).*/

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
