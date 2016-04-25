package seproj;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import java.awt.Font;

public class ScoreDisplay extends JFrame {

	private JPanel contentPane;

	public static Integer score;
	public JLabel scoreDisplay;
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
					
					ScoreDisplay frame = new ScoreDisplay(score);
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
	public ScoreDisplay(Integer score) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MigLayout layout = new MigLayout("wrap 4");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel(layout);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scoreDisplay= new JLabel("Your Score is:" + score.toString() );
		scoreDisplay.setFont(new Font("Dialog", Font.BOLD, 20));
		
		contentPane.add(scoreDisplay);
	}

}
