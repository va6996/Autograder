    
package Judge;

import javax.swing.JOptionPane;

public class ErrorHandling {
    public static void IOError(){
        JOptionPane.showMessageDialog(null,"There was some problem with I/O!",
                "I/O Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void InterruptError(){
        JOptionPane.showMessageDialog(null,"Thread was interrupted!",
                "Interrupt Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void ExecutionError(){
        JOptionPane.showMessageDialog(null,"Error in execution!",
                "Execution Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void FileError(){
        JOptionPane.showMessageDialog(null,"Necessary files are missing!",
                "File Not Found Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void IndexOutOfBoundsError(){
        JOptionPane.showMessageDialog(null,"Illegal Refernce was made!",
                "Index Out of Bounds Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void MessagingError(){
        JOptionPane.showMessageDialog(null,"Error sending mail!",
                "Mailing Error",JOptionPane.ERROR_MESSAGE);
    }
    public static void InternetError(){
        JOptionPane.showMessageDialog(null,"Error connecting to Internet!",
                "Coonection Error",JOptionPane.ERROR_MESSAGE);
    }
}
