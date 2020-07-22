package Application;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Chatlive extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					String uname;
					
					InputStream input = new FileInputStream("./config.properties");
					Properties prop = new Properties();
					prop.load(input);
					uname=prop.getProperty("username");
					
					
				
					Chatlive frame = new Chatlive(uname);
					frame.setVisible(true);
					
					System.out.println("the name is :::::::::"+frame.getName());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Chatlive(final String uname) {
		
		
		setTitle(uname);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1172, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(15, 16, 1100, 515);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(34, 574, 850, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MicroOperations mo=new MicroOperations();
				try {
					System.out.println("The username is :::::::::::::: "+uname);
					String userid=mo.getuserid(uname);
					//textField.setText(userid);
					System.out.println("The user id is ***********************"+userid);
					

					
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ProtocolException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnSend.setBounds(918, 573, 170, 29);
		contentPane.add(btnSend);
		
		
	}
}
