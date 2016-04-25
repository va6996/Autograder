package seproj;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

import net.miginfocom.swing.MigLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
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

	
	
	
	public static JTextField ans1,ans2,ans3,ans4,ans5;
	
	public static JButton submit;

	public 	Connection connection = null;
    
	public static Statement statement;
	
	public static ButtonGroup groupQ1;
	public static ButtonGroup groupQ2;
	
	public static Integer score=0;
	public ArrayList<Integer> shuflist ;
	String queslabid;
	 ArrayList<Integer> labqueslist;
	
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
				
				
				
				
				
			}
		});
		

	
	}

	/**
	 * Create the application.
	 */
	public StudentMcq(String labId) {
		initialize(labId);
		
		 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String labId) {
		score=0;
		frame = new JFrame("MCQ Paper");
		MigLayout layout = new MigLayout("wrap 4");
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   queslabid=labId;
		frame.getContentPane().setLayout(layout);
		
		ques1 = new JLabel("Q1)" );		
		frame.getContentPane().add(ques1, "wrap 4");	
		

		ans1= new JTextField("",20);
		frame.getContentPane().add(ans1,"wrap 4");
		
		
		ques2 = new JLabel("Q2) ");
		frame.getContentPane().add(ques2,"wrap 4");
		
		ans2= new JTextField("",20);
		frame.getContentPane().add(ans2,"wrap 4");
		
			
		
			
			ques3 = new JLabel("Q3) ");		
			frame.getContentPane().add(ques3, "wrap");	
			
			ans3= new JTextField("",20);
			frame.getContentPane().add(ans3,"wrap");
			 
				ques4 = new JLabel("Q4) ");		
				frame.getContentPane().add(ques4, "wrap");	
				
				ans4= new JTextField("",20);
				frame.getContentPane().add(ans4,"wrap");
			    
			    
			    
					ques5 = new JLabel("Q5) ");		
					frame.getContentPane().add(ques5, "wrap");	
					
					ans5= new JTextField("",20);
					frame.getContentPane().add(ans5,"wrap");
					    
					
					
					
					try{
						
						connection = DriverManager.getConnection("jdbc:sqlite:questionsdb.db");
					     statement = connection.createStatement();
					    statement.setQueryTimeout(30);
					   
					    //System.out.println("Create View quesView as select id,x.question,x.answer from mcq as x where labid= '"+queslabid+"'  );
					    //statement.executeUpdate("Create View quesView as select id,x.question,x.answer from mcq as x where labid= '"+queslabid+"' );
					   // showView();
					    
					    /*String tableMake=
					    		"Insert into questemp(question,answer) values((SELECT mcq.question FROM mcq WHERE labid = '"+queslabid+"'"+" ),(SELECT answer FROM mcq WHERE labid =  '"+queslabid+"'))";
					    System.out.println(tableMake);
					    ResultSet r3= statement.executeQuery(tableMake);
					    while(rs3.next)*/
					  labqueslist = new ArrayList<Integer>();
				      
					    ResultSet rs3;
					    rs3=statement.executeQuery("select * from mcq where labid= '"+queslabid+"'");
					    System.out.println("select * from mcq where labid= '"+queslabid+"'");
					    System.out.println(rs3.getFetchSize());
					    while(rs3.next()){
					    	
					    	System.out.println(rs3.getInt("id"));
					    	 labqueslist.add(rs3.getInt("id"));
					    }
					    
					   /* ResultSet rs1;
					    rs1=statement.executeQuery("select max(id) from questemp");
					   
					    
					    int x=rs1.getInt("max(id)");
					   
					    ArrayList<Integer> list = new ArrayList<Integer>();
				        for (int i=1; i<x; i++) {
				            list.add(new Integer(i));}
				         shuflist = new ArrayList<Integer>();
				        Collections.shuffle(list);
				        for (int i=0; i<5; i++) {
				        	shuflist.add(list.get(i));
				        }*/
				       
				        setQuestions(labqueslist.get(0), ques1);
					    setQuestions(labqueslist.get(1), ques2);
					    setQuestions(labqueslist.get(2), ques3);
					    setQuestions(labqueslist.get(3), ques4);
					    setQuestions(labqueslist.get(4), ques5);
					
					    showDb();
						}
						catch(SQLException e){
							
						}
						finally{
							
						}
		    submit= new JButton("Submit");
		    frame.getContentPane().add(submit, "wrap, align center");	 
		    
		    
		    scoreDisp = new JLabel("");
		    scoreDisp.setVisible(false);
		    frame.getContentPane().add(scoreDisp, "wrap, align center");
		 
		    System.out.println(queslabid);
		    
		    System.out.println(queslabid);
		    
	
		  
		
		
	
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String a1=ans1.getText().toString();
				String a2= ans2.getText().toString();
				String a3= ans3.getText().toString();
				String a4= ans4.getText().toString();
				String a5= ans5.getText().toString();
				checkAns(labqueslist.get(0),a1);
				checkAns(labqueslist.get(1),a2);
				checkAns(labqueslist.get(2),a3);
				checkAns(labqueslist.get(3),a4);
				checkAns(labqueslist.get(4),a5);
				calcFinalScore(score);
				
				
			}
		});
		
		
		
		
		
		
		
		
	}
	
	
	public void calcFinalScore(Integer score){
		ScoreDisplay scoreDisplay= new ScoreDisplay(score);		
		frame.setVisible(false);
		scoreDisplay.setVisible(true);
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
	
	public void showView(){
		 ResultSet rs;
		try {
			rs = statement.executeQuery("select * from questemp");
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
		
	
	
		public void setQuestions(int key,  JLabel label) {
			String data = null;
			try {
				
				ResultSet rs = statement.executeQuery("select question,id from mcq where id = "+key);
				while(rs.next())
			      {
			        // read the result set
			   	  label.setText(label.getText() + rs.getString("question"));
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
			    		 ++score;
			    	 }
			    	  
			      }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				 
		}
}
