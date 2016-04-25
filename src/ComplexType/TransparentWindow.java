package ComplexType;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TransparentWindow extends JFrame {
    public TransparentWindow() {
        setLayout(new GridBagLayout());
        JFrame jfr =this;
        setUndecorated(true);
        
        setSize(new Double(Toolkit.getDefaultToolkit().getScreenSize().getWidth()).intValue(),
                new Double(Toolkit.getDefaultToolkit().getScreenSize().getHeight()).intValue());
        setOpacity(0f);
        JTextField in = new JTextField(10);
        add(in);
        JButton button = new JButton();
        add(button);
        button.addActionListener(new AbstractAction("Click to add") {
        @Override
        public void actionPerformed(ActionEvent e) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                   if(in.getText().equals("12345")) {
                       System.out.println("Yes");
                       jfr.dispose();
                   }
                   else{
                       System.out.println("No");
                       in.setText("");
                   }
                }
            
            });}});
        this.getRootPane().setDefaultButton(button);
        this.addWindowListener(new WindowAdapter(){
            @Override
            public void windowOpened(WindowEvent e){
                in.requestFocus();
            }
        });
    }

    

}
