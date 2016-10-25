    
package judge;

import javax.swing.JOptionPane;

public class ErrorHandling {
    public static void ioError(){
        JOptionPane.showMessageDialog(null,"There was some problem with I/O!",
                "I/O Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void interruptError(){
        JOptionPane.showMessageDialog(null,"Thread was interrupted!",
                "Interrupt Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void executionError(){
        JOptionPane.showMessageDialog(null,"Error in execution!",
                "Execution Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void fileError(){
        JOptionPane.showMessageDialog(null,"Necessary files are missing!",
                "File Not Found Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void indexOutOfBoundsError(){
        JOptionPane.showMessageDialog(null,"Illegal Refernce was made!",
                "Index Out of Bounds Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void messagingError(){
        JOptionPane.showMessageDialog(null,"Error sending mail!",
                "Mailing Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void internetError(){
        JOptionPane.showMessageDialog(null,"Error connecting to Internet!",
                "Coonection Error",JOptionPane.ERROR_MESSAGE);
    }
}
