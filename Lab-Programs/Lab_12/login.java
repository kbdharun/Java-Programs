import java.awt.*;
import java.awt.event.*;

class Aw1 extends Frame implements ActionListener{
	TextField txtUsername;
    TextField txtPswd; 
    Label username;
    Label pswd;
    Button btnLogin;
    Button btnClear;
    Label success;
    Aw1(){
    	txtUsername = new TextField();
    	txtPswd = new TextField();
    	username = new Label("Username: ");
    	pswd = new Label("Password: ");
    	username.setBounds(50, 100, 75, 30);
    	add(username);
    	pswd.setBounds(50, 150, 75, 30);
    	add(pswd);
    	txtUsername.setBounds(150,100,200,22);
    	txtPswd.setBounds(150, 150, 200, 22);
    	add(txtUsername);
    	add(txtPswd);
    	
    	btnLogin = new Button("Login");
    	btnLogin.addActionListener(this);
    	btnLogin.setBounds(200, 200, 50, 25);
    	add(btnLogin);
    	
    	
    	//setsize(int width, int height);
    	//setVisible(true);
    	//setLayout();
    }
    
    public void actionPerformed(ActionEvent e) {
    	String username = txtUsername.getText();
    	String password = txtPswd.getText();
    	if((username.equals("ITSME")) && (password.equals("Hello"))) {
    		success = new Label("Success!! You're in!");
    		success.setBounds(175, 250, 150, 25);
    		add(success);
    	}
    	else {
    		txtUsername.setText("");
    		txtPswd.setText("");
    	}
    }
    
    
}

class login{
	public static void main(String args[]){
    	Aw1 f = new Aw1();
    	f.setTitle("Login Form");
    	f.setLayout(null);
    	f.setSize(500,500);
    	f.setVisible(true);
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
              System.exit(0);
            }
        });
    }
}