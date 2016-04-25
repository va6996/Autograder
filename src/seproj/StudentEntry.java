package seproj;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import net.miginfocom.swing.MigLayout;

public class StudentEntry extends JFrame {

	private JPanel contentPane;

	JTextField regnum;
	Connection connection = null;
	JComboBox labselect;
	JComboBox semselect;
	String semNo;
	String labId;
	String labPwd;
	static String regNo;
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
					StudentEntry frame = new StudentEntry();
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
	public StudentEntry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		MigLayout layout = new MigLayout("wrap 3");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(layout);
		setContentPane(contentPane);
		
		JLabel header = new JLabel("Enter the Details");
		header.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(header,"wrap");
		
		
		JLabel reg = new JLabel("Registration Number");
		reg.setFont(new Font("Dialog", Font.PLAIN, 16));
		contentPane.add(reg);
		regnum= new JTextField(20);
		contentPane.add(regnum,"wrap");
		
		JLabel sem= new JLabel("Semester");
		sem.setFont(new Font("Dialog", Font.PLAIN, 16));
		contentPane.add(sem);
		 semselect= new JComboBox();
		contentPane.add(semselect,"wrap");
		semselect.addItem("1");
		semselect.addItem("2");
		semselect.addItem("3");
		semselect.addItem("4");
		semselect.addItem("5");
		semselect.addItem("6");
		semselect.addItem("7");
		
		
		
		JLabel lab = new JLabel("Lab");
		lab.setFont(new Font("Dialog", Font.PLAIN, 16));
		contentPane.add(lab);
		labselect= new JComboBox();
		contentPane.add(labselect,"wrap");
		
		JLabel pass = new JLabel("Enter Password");
		pass.setFont(new Font("Dialog", Font.PLAIN, 16));
		contentPane.add(pass);
		final JPasswordField passenter= new JPasswordField(20);
		contentPane.add(passenter,"wrap");
		
		final JButton next= new JButton("Start");
		contentPane.add(next,"wrap");
		
		semselect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 semNo=semselect.getSelectedItem().toString();
				 
				 try
				    {
				      // create a database connection
				      connection = DriverManager.getConnection("jdbc:sqlite:questionsdb.db");
				      final Statement statement = connection.createStatement();
				      statement.setQueryTimeout(30);  // set timeout to 30 sec.
				      

				      labselect.removeAllItems();
				      
						ResultSet rs = statement.executeQuery("select name from lablist where semester= '"+semNo+"'");
						while(rs.next())
					      {
					        // read the result set
							labselect.addItem(rs.getString("name"));					   	
					   	  			      
					      }

						next.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								
								regNo=regnum.getText();                                      //RegNum check for alphanumeric and size
								
								String labName=labselect.getSelectedItem().toString();
								try {
									  connection = DriverManager.getConnection("jdbc:sqlite:questionsdb.db");
								      final Statement statement = connection.createStatement();
								      statement.setQueryTimeout(30);  // set timeout to 30 sec.
								      
									
									System.out.println("select labid from lablist where name= '"+labName+"'");
									ResultSet rs1 = statement.executeQuery("select labid from lablist where name= '"+labName+"'");
									System.out.println(passenter.getPassword());				
																		
									while(rs1.next())
								      {
								        // read the result set
										labId=rs1.getString("labid");
								   	
										System.out.println(labId);
										
								   	  			      
								      }
									
									ResultSet rs4= statement.executeQuery("select password from lablist where name='"+labName+"'");
									while(rs4.next()){
										labPwd= rs4.getString("password");
										
									}
									
									String passText = new String(passenter.getPassword());
									if(passText.equals(labPwd)){
										switchtoStudentMcqClass(labId);                        //Prompt if Wrong Password
									}
									
									 
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						})	;			
				    }
				      catch(SQLException ex)
					    {
					      // if the error message is "out of memory", 
					      // it probably means no database file is found
					      System.err.println(ex.getMessage());
					    }
					    finally
					    {
					      try
					      {
					        if(connection != null)
					          connection.close();
					      }
					      catch(SQLException ex)
					      {
					        // connection close failed.
					        System.err.println(ex);
					      }
				
				
			}
				 
				
			}
		});	

}
	void switchtoStudentMcqClass(String labid){
		contentPane.setVisible(false);
		StudentMcq studentMcq= new StudentMcq(labid);
		studentMcq.frame.setVisible(true);
	}
}
