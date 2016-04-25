package seproj;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JRadioButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.UIManager.*;
public class AccessSelection {

	private JFrame frame;
 
	
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
					AccessSelection window = new AccessSelection();
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
	public AccessSelection() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Select Access Type");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		final JRadioButton rdbtnStudent = new JRadioButton("Student");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnStudent, 91, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, rdbtnStudent, 183, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(rdbtnStudent);
		
		final JRadioButton rdbtnInstructor = new JRadioButton("Instructor");
		springLayout.putConstraint(SpringLayout.NORTH, rdbtnInstructor, 15, SpringLayout.SOUTH, rdbtnStudent);
		springLayout.putConstraint(SpringLayout.WEST, rdbtnInstructor, 0, SpringLayout.WEST, rdbtnStudent);
		frame.getContentPane().add(rdbtnInstructor);
		
		JButton btnConfirm = new JButton("Confirm");
		springLayout.putConstraint(SpringLayout.NORTH, btnConfirm, 30, SpringLayout.SOUTH, rdbtnInstructor);
		springLayout.putConstraint(SpringLayout.WEST, btnConfirm, 0, SpringLayout.WEST, rdbtnStudent);
		frame.getContentPane().add(btnConfirm);
		
	
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(rdbtnStudent.isSelected()){
				switchtoStudentClass();
				}
				else if(rdbtnInstructor.isSelected()){
					switchtoSetQuestionClass();
				}
					
				}
			
		});
		
	}
	void switchtoStudentClass(){
	
		frame.dispose();
		StudentMcq mcq = new StudentMcq();
		mcq.frame.setVisible(true);      
		
	}
	
	void switchtoSetQuestionClass(){
		frame.dispose();
		SetQuestion setQuestion = new SetQuestion();
		setQuestion.setVisible(true);
		
	}
	
	
}
