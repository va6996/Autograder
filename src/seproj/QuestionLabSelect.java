package seproj;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class QuestionLabSelect extends JFrame {

	private JPanel contentPane;

	JTextField regnum;
	Connection connection = null;
	JComboBox labselect;
	JComboBox semselect;
	String semNo;
	String labName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuestionLabSelect frame = new QuestionLabSelect();
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
	public QuestionLabSelect() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		MigLayout layout = new MigLayout("wrap 3");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(layout);
		setContentPane(contentPane);
		
		JLabel header = new JLabel("Enter the Lab to Add Question to");
		header.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(header,"wrap");
		
		
		
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
		
		
		final JButton next= new JButton("Next");
		contentPane.add(next,"wrap, center aligned");
		
		
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
				      
						ResultSet rs = statement.executeQuery("select name from lablist where semester= "+semNo);
						while(rs.next())
					      {
					        // read the result set
							labselect.addItem(rs.getString("name"));
					   	
							System.out.println(rs.getString("name"));
					   	  			      
					      }
						
				 
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

			}});
			
						
						
						
						next.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								labName=labselect.getSelectedItem().toString();
								
								 try
								    {
								      // create a database connection
								      connection = DriverManager.getConnection("jdbc:sqlite:questionsdb.db");
								      final Statement statement = connection.createStatement();
								      statement.setQueryTimeout(30);  // set timeout to 30 sec.
								      

							      System.out.println(labName);
							      System.out.println("select labid from lablist where name="+labName);
								ResultSet rs1 = statement.executeQuery("select labid from lablist where name= '"+labName+"'");
								
								while(rs1.next())
							      {
							        // read the result set
									String labId=rs1.getString("labid");
							   	
									switchtoSetQuestionClass(labId);}}
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

							}});					
								
								
				    
				   


			
}
	void switchtoSetQuestionClass(String labId){
		contentPane.setVisible(false);
		SetQuestion setQuestion = new SetQuestion(labId);
		setQuestion.setVisible(true);
		
	}
}
