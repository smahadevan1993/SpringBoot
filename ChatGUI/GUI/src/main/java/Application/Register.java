package Application;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.awt.event.ActionEvent;

public class Register {

	private JFrame frame;
	private JTextField textField;

	/**
	* Launch the application.
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	* Create the application.
	*/
	public Register() {
		initialize();
	}

	/**
	* Initialize the contents of the frame.
	*/
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterYourName = new JLabel("Enter your name");
		lblEnterYourName.setBounds(32, 43, 111, 16);
		frame.getContentPane().add(lblEnterYourName);
		
		textField = new JTextField();
		textField.setBounds(184, 38, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username=textField.getText();
				
				if(username!=null)
				{
					JOptionPane.showMessageDialog(frame, "Welcome  "+username);
					
					MicroOperations mo=new MicroOperations();
					mo.saveUserDetails(username);
					
					//save the username on to properties file 
					try {
						OutputStream output = new FileOutputStream("./config.properties");
			            Properties prop = new Properties();
			            prop.setProperty("username", username);
			            prop.store(output, null);

					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					Chatlive cl=new Chatlive(username);
					
					cl.setVisible(true);
					Register window = new Register();
					window.frame.setVisible(false);
				    cl.setSize(1150, 750);
					
				
				}
			}
		});
		btnRegister.setBounds(107, 118, 117, 29);
		frame.getContentPane().add(btnRegister);
	}
}
