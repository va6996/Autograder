package Judge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//Multi-threaded class for TLE check.
class ExecuteThread extends Thread{
    private static Process proc;
    public ExecuteThread(ProcessBuilder p) throws IOException{
        proc = p.start();
        Execute.exec = proc;
    }
    @Override
    public void run(){
    	try {
                proc.waitFor();
            } catch (InterruptedException e) {
                ErrorHandling.InterruptError();
            }
        
    }
}

public class Execute {
    public static String path = new File("").getAbsolutePath().concat("/");
    public static boolean tle;
    public static Process exec = null;
    private static ProcessBuilder prorunner;

    //Set up the ProcessBuilder Streams.
    private static void setUpProcess(String[] execute, File output, String relPath){
        prorunner = new ProcessBuilder( execute );
        prorunner.directory(new File(path));
        prorunner.redirectErrorStream(true);
        prorunner.redirectOutput(Redirect.appendTo(output));
        prorunner.redirectInput(new File(path + "TestCases/" + relPath));
    }

    //Main Execution code.
    public static boolean execute(String[] execute, String relPath) throws IOException, InterruptedException, ExecutionException{
        boolean flag = false;
        tle = false;
        try {    
            File output = new File(path + "output.txt");
            setUpProcess(execute, output, relPath);
            System.out.println("Running..");
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.submit(new ExecuteThread(prorunner)).get(30, TimeUnit.SECONDS);
            if(compareOutput(relPath)){
                System.out.println("Correct Output!");
                flag = true;
            }
            else{
                System.out.println("Incorrect Output!");
                flag = false;
            }
            //Delete generated files
            new File(path + "Solution.class").delete();
            new File(path + "a.out").delete();
            output.delete();
            return flag;
        } catch (TimeoutException ex) {
            //For TLE, destroy the process.
            tle =true;
            exec.destroyForcibly();
            System.out.println(exec.isAlive());
        }
        return flag;
    }

    //Check for correct Output
    public static boolean compareOutput(String relPath) throws IOException{
        boolean flag = true;
        BufferedReader outputReader = new BufferedReader(new FileReader(path + "output.txt"));     
        String result = null;
        BufferedReader compare = new BufferedReader(new FileReader(path + "Results/" + 
                                                        relPath));     
        String compareResult = null;
        //Compare till both files end.
        while((result=outputReader.readLine())!=null && (compareResult=compare.readLine())!=null ){
            if(!result.trim().equals(compareResult.trim())){
                flag=false;
                break;
            }
        }
        //Check if any file has more than other.
        if((result=outputReader.readLine())!=null || (compareResult=compare.readLine())!=null){
            flag=false;
        }
        //Close Streams
        outputReader.close();
        compare.close();
        return flag;
    }
	
}