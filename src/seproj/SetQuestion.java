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

	Connection connection ;
	Statement statement;
	String queslabId;
	
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
				
				
				
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SetQuestion(String labId) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		MigLayout layout = new MigLayout("wrap 3");
		contentPane = new JPanel(layout);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		queslabId=labId;
		
		JLabel header = new JLabel("Enter the Question to be added");
		
		header.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(header,"cell 0 0 2 1");
		
		textField1 = new JTextField();
		
		contentPane.add(textField1, "cell 0 1 4 1, wrap"); //
		textField1.setColumns(30);
		
		JLabel header2 = new JLabel("Enter the Answer");
		header2.setFont(new Font("Dialog", Font.BOLD, 14));
		contentPane.add(header2,"wrap");
		
       textField2 = new JTextField();
		
		contentPane.add(textField2, " wrap"); //
		textField2.setColumns(20);
	
		
		
		JButton btnSubmit = new JButton("Submit");
		contentPane.add(btnSubmit, " align center");
		
		
		JButton btnExit= new JButton("Exit");
		contentPane.add(btnExit," align right ");
		connection = null;
		try{
			
			
		connection = DriverManager.getConnection("jdbc:sqlite:questionsdb.db");
	     statement = connection.createStatement();
	    statement.setQueryTimeout(30);
	    showDb();
        btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ques =textField1.getText().toString();

				
				 
				 String ans=textField2.getText().toString();
				 
			
				 setQuesAns(ques,ans);
				 
				textField1.setText(" ");
				textField2.setText(" ");
				showDb();
				     
			}
		});	    
        
        btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				contentPane.setVisible(false);
				AccessSelection accessSelection = new AccessSelection();
				accessSelection.frame.setVisible(true); 
			}
		});
	
		}
		catch(SQLException e){
			
		}
		finally{
			
		}
		
		
	}
	

	public void setQuesAns( String ques, String ans){
		String data = null;
		try {
			 statement.executeUpdate("insert into mcq(question,answer,labid) values('"+ques+"','"+ans+"','"+queslabId+"')");
			
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
		       System.out.println("labid ="+ rs.getString("labid"));
		     }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
   }

}	

