package seproj;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField userN;
	private JPasswordField pwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblUsername = new JLabel("UserName");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblUsername, 74, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblUsername, 73, SpringLayout.WEST, contentPane);
		contentPane.add(lblUsername);
		
		userN = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, userN, 24, SpringLayout.EAST, lblUsername);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, userN, 0, SpringLayout.SOUTH, lblUsername);
		contentPane.add(userN);
		userN.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPassword, 26, SpringLayout.SOUTH, lblUsername);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPassword, 0, SpringLayout.EAST, lblUsername);
		contentPane.add(lblPassword);
		
		pwd = new JPasswordField();
		pwd.setText("");
		sl_contentPane.putConstraint(SpringLayout.NORTH, pwd, 0, SpringLayout.NORTH, lblPassword);
		sl_contentPane.putConstraint(SpringLayout.EAST, pwd, 0, SpringLayout.EAST, userN);
		contentPane.add(pwd);
		pwd.setColumns(10);
		
		JLabel lblLoginToAdmin = new JLabel("Login to Admin Account");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblLoginToAdmin, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblLoginToAdmin, 0, SpringLayout.EAST, userN);
		lblLoginToAdmin.setFont(new Font("Dialog", Font.BOLD, 15));
		contentPane.add(lblLoginToAdmin);
		
		JButton btnLogin = new JButton("Login");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnLogin, 36, SpringLayout.SOUTH, pwd);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnLogin, 140, SpringLayout.WEST, contentPane);
		contentPane.add(btnLogin);
		
		
btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String passText = new String(pwd.getPassword());
				System.out.println(passText);
				System.out.println(userN.getText());
				// TODO Auto-generated method stub
			if(passText.equals("teacher") && userN.getText().equals("teacher")){
				System.out.println(userN.getText());
				switchtoQuestionLabSelectClass();
					
			}
			}
			
			});
	}
	
		
	
	
	void switchtoQuestionLabSelectClass(){
		contentPane.setVisible(false);
		QuestionLabSelect questionLabSelect= new QuestionLabSelect();
		questionLabSelect.setVisible(true);
	}
	

}
