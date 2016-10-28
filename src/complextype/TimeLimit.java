package complextype;

import judge.Main;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;


public class TimeLimit {
    
    public void lastJob(String RegNo, int type){
        if(type ==1){
            //Send Mail
        }
        else if (type==2){
            String ansList = "Questions solved:\n";
            for(int i=0;i<Main.completedList.size();i++)
                ansList = ansList.concat(Main.completedList.get(i)).concat("\n");
            //Send Mail
        }
        else if (type == 3){
            String OTP = new GenerateOTP().otp();
            TransparentWindow sw = new TransparentWindow(OTP);
            sw.setVisible(true);
            //Send Mail
        }
    }
    
    public void startTime(int time, String RegNo, int type){
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        Runnable runnable = () -> {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    lastJob(RegNo, type);
                }
            });
        };

        // Run it in x mins - you would have to calculate how long to wait from "now"
        service.schedule(runnable, time, TimeUnit.SECONDS); // Call functions after this
        
    }
    public static void main(String args[]){
        TimeLimit tL = new TimeLimit();
        tL.startTime(5, "140911xxx", 3);
    }
}
