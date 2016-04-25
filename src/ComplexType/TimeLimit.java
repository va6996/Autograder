
package ComplexType;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;


public class TimeLimit {
    public static void main(String[] args){
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable = new Runnable() {
            public void run()
            {
                SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TransparentWindow sw = new TransparentWindow();
                sw.setVisible(true);
            }
        });
            }
        };

        // Run it in x mins - you would have to calculate how long to wait from "now"
        service.schedule(runnable, 10, TimeUnit.SECONDS); // You can 
        System.out.println("Hello world");
    }
}
