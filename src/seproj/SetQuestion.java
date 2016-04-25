package seproj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SetQuestion extends JFrame {

	private JPanel contentPane;
	private JTextField textField1,textField2,textField3,textField4,textField5;

	Statement statement;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
				    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				        if ("Nimbus".equals(info.getName())) {
				            UIManager.setLookAndFeel(info.getClassName());
				            break;
				        }
				    }
				} catch (Exception e) {
				    // If Nimbus is not available, you can set the GUI to another look and feel.
				}
				
				
				
				try {
					SetQuestion frame = new SetQuestion();
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
	public SetQuestion() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		MigLayout layout = new MigLayout("wrap 3");
		contentPane = new JPanel(layout);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		JLabel header = new JLabel("Enter the Question to be added");
		
		header.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(header,"cell 1 0 2 1");
		
		textField1 = new JTextField();
		
		contentPane.add(textField1, "cell 0 1 4 1, wrap"); //
		textField1.setColumns(30);
		
		JLabel header2 = new JLabel("Enter the Answer");
		header2.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(header2,"wrap");
		
       textField2 = new JTextField();
		
		contentPane.add(textField2, " wrap"); //
		textField2.setColumns(20);
		
		JLabel header3 = new JLabel("Enter the Other Options");
		header3.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(header3,"wrap");
		
		 textField3 = new JTextField();			
			contentPane.add(textField3); //
			textField3.setColumns(10);
			
			 textField4 = new JTextField();			
				contentPane.add(textField4); //
				textField4.setColumns(10);
				
				 textField5 = new JTextField();			
					contentPane.add(textField5); //
					textField5.setColumns(10);
			
		
		
		JButton btnSubmit = new JButton("Submit");
		
		contentPane.add(btnSubmit, "wrap, align center");
		
		Connection connection = null;
		try{
			
			
		connection = DriverManager.getConnection("jdbc:sqlite:questionsdb.db");
	    final Statement statement = connection.createStatement();
	    statement.setQueryTimeout(30);
        btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ques =textField1.getText();

				 getQuestion(ques);
				 
				 String ans=textField2.getText();
				 getAnswer(ans);
			
				 
				textField1.setText(" ");
				showDb();
			}
		});	    
	
		}
		catch(SQLException e){
			
		}
		finally{
			
		}
		
		
	}
	

	public void getQuestion( String ques){
		String data = null;
		try {
			 statement.executeUpdate("insert into mcq(question) values('"+ques+"')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void getAnswer( String ans){
		String data = null;
		try {
			 statement.executeUpdate("insert into mcq(answer) values('"+ans+"')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public void showDb(){
	 ResultSet rs;
	try {
		rs = statement.executeQuery("select * from mcq");
		  while(rs.next())
		     {
		       // read the result set
		       System.out.println("question = " + rs.getString("question"));
		       System.out.println("id = " + rs.getInt("id"));
		     }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
   }

}	

