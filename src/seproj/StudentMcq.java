package seproj;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.xml.bind.ValidationEvent;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.UIManager.*;

public class StudentMcq {

	public JFrame frame;
	public static JLabel ques1,ques2,ques3,ques4,ques5,scoreDisp;

	public static JRadioButton q1_o1,q1_o2,q1_o3,q1_o4,q2_o1,q2_o2,q2_o3,q2_o4,
	q3_o1,q3_o2,q3_o3, q3_o4, q4_o1,q4_o2,q4_o3,q4_o4,q5_o1,q5_o2,q5_o3,q5_o4;
	
	public static JButton submit;

	public 	Connection connection = null;
    
	public static Statement statement;
	
	public static ButtonGroup groupQ1;
	public static ButtonGroup groupQ2;
	
	public static Integer score;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
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
					
					
					StudentMcq window = new StudentMcq();
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
	public StudentMcq() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		score=0;
		frame = new JFrame("MCQ Paper");
		MigLayout layout = new MigLayout("wrap 4");
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().setLayout(layout);
		
		ques1 = new JLabel("New label");		
		frame.getContentPane().add(ques1, "wrap");	
		
		   q1_o1 = new JRadioButton("");		   
		    frame.getContentPane().add(q1_o1);
		    
		    q1_o2 = new JRadioButton("");		   
		    frame.getContentPane().add(q1_o2);		    
		     q1_o3 = new JRadioButton("");		    
		    frame.getContentPane().add(q1_o3);		    
		    
		    q1_o4 = new JRadioButton("");		  
		    frame.getContentPane().add(q1_o4);
			
		
		ques2 = new JLabel("New label");
		frame.getContentPane().add(ques2,"wrap");
		
		  q2_o1 = new JRadioButton("");		   
		    frame.getContentPane().add(q2_o1);
		
		     q2_o2 = new JRadioButton("");			   
		    frame.getContentPane().add(q2_o2);
		
		    q2_o3 = new JRadioButton("");			   
		    frame.getContentPane().add(q2_o3);
		
		   q2_o4 = new JRadioButton("");			   
		    frame.getContentPane().add(q2_o4,"wrap");
			
		
			
			ques3 = new JLabel("New label");		
			frame.getContentPane().add(ques3, "wrap");	
			
			   q3_o1 = new JRadioButton("");		   
			    frame.getContentPane().add(q3_o1);
			    
			    q3_o2 = new JRadioButton("");		   
			    frame.getContentPane().add(q3_o2);		    
			     q3_o3 = new JRadioButton("");		    
			    frame.getContentPane().add(q3_o3);		    
			    
			    q3_o4 = new JRadioButton("");		  
			    frame.getContentPane().add(q3_o4);
			    
			 
				ques4 = new JLabel("New label");		
				frame.getContentPane().add(ques4, "wrap");	
				
				   q4_o1 = new JRadioButton("");		   
				    frame.getContentPane().add(q4_o1);
				    
				    q4_o2 = new JRadioButton("");		   
				    frame.getContentPane().add(q4_o2);		    
				     q4_o3 = new JRadioButton("");		    
				    frame.getContentPane().add(q4_o3);		    
				    
				    q4_o4 = new JRadioButton("");		  
				    frame.getContentPane().add(q4_o4);	    
				 
			    
			    
			    
					ques5 = new JLabel("New label");		
					frame.getContentPane().add(ques5, "wrap");	
					
					   q5_o1 = new JRadioButton("");		   
					    frame.getContentPane().add(q5_o1);
					    
					    q5_o2 = new JRadioButton("");		   
					    frame.getContentPane().add(q5_o2);		    
					     q5_o3 = new JRadioButton("");		    
					    frame.getContentPane().add(q5_o3);		    
					    
					    q5_o4 = new JRadioButton("");		  
					    frame.getContentPane().add(q5_o4);
					    
					    
		    submit= new JButton("Submit");
		    frame.getContentPane().add(submit, "wrap, align center");	 
		    
		    
		    scoreDisp = new JLabel("");
		    scoreDisp.setVisible(false);
		    frame.getContentPane().add(scoreDisp, "wrap, align center");
		    
		  
	  
	
		try{
			
		connection = DriverManager.getConnection("jdbc:sqlite:questionsdb.db");
	     statement = connection.createStatement();
	    statement.setQueryTimeout(30);
	   
	    setQuestions(1,ques1); 
		setOptions(1,  q1_o1,1);
	    setOptions(1,  q1_o2,2);
	    setOptions(1, q1_o3,3);
	    setOptions(1, q1_o4,4);
	    groupQ1 = new ButtonGroup();
	    groupQ1.add(q1_o1);
	    groupQ1.add(q1_o2);
	    groupQ1.add(q1_o3);
	    groupQ1.add(q1_o4);
	    
	    
	    setQuestions(2,ques2);
	    setOptions(2 , q2_o1,1);
	    setOptions(2 ,  q2_o2,2);
	    setOptions(2 ,  q2_o3,3);
	    setOptions(2 ,  q2_o4,4);
	    groupQ2 = new ButtonGroup();
	    groupQ2.add(q2_o1);
	    groupQ2.add(q2_o2);
	    groupQ2.add(q2_o3);
	    groupQ2.add(q2_o4);   	    
	   	    	  	 
		}
		catch(SQLException e){
			
		}
		finally{
			
		}
		
	
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ans1=getSelectedButtonText(groupQ1);
				String ans2= getSelectedButtonText(groupQ2);
				checkAns(1,ans1);
				checkAns(2,ans2);
				ScoreDisplay scoreDisplay= new ScoreDisplay(score);
				frame.setVisible(false);
				scoreDisplay.setVisible(true);
			}
		});
		
		
		
		
		
		
		
		
	}
	
	
	
		public void setQuestions(int key,  JLabel label) {
			String data = null;
			try {
				ResultSet rs = statement.executeQuery("select question,id from mcq where id = "+key);
				while(rs.next())
			      {
			        // read the result set
			   	  label.setText("Q"+rs.getInt("id")+") " + rs.getString("question"));
			   	  			      }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	 
		  }
		
		
		
		public void setOptions(int key, JRadioButton option, int optionnum) {
			String data = null;
			try {
				ResultSet rs = statement.executeQuery("select option1,option2,option3,option4,id from mcq where id = "+key);
				while(rs.next())
			      {
			        // read the result set
			    	  option.setText( rs.getString("option"+optionnum));
			    	  
			      }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				 
		 }
		
		
		
		
		public static String getSelectedButtonText(ButtonGroup buttonGroup) {
	        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	                return button.getText();
	            }
	        }
	        return null;
	    }
		
		
		public static void checkAns(Integer key,String ans){
			try {
				ResultSet rs = statement.executeQuery("select answer from mcq where id="+key);
				while(rs.next())
			      {
					System.out.println(ans);
					System.out.println(rs.getString("answer"));
			        // read the result set
			    	 if(rs.getString("answer").equals(ans)){
			    		 score++;
			    	 }
			    	  
			      }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				 
		}
}
