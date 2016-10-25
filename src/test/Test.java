package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;


//Run the execution in a different thread so that it can be terminated explicitly
//a.exe still runs in infinite loop, need to explicitly stop it
class Execute extends Thread{
    private static Process proc;
    public Execute(ProcessBuilder p) throws IOException{
        proc = p.start();
        Test.exec = proc;
    }
    @Override
    public void run(){
        try {
            proc.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(Execute.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

public class Test {
    public static String path = new File("").getAbsolutePath().concat("\\");

//"C:\\Users\\Sith Lord\\Documents\\judge\\";
    public static String npath = path + "bin\\";
    public static boolean flag;
    public static boolean tle;
    public static Process exec = null;
    public static boolean compile(String[] compile){
        ProcessBuilder probuilder = new ProcessBuilder( compile );
        probuilder.directory(new File(npath));
        File beforeoutput = new File(path + "compile.txt");
        probuilder.redirectErrorStream(true);
        probuilder.redirectOutput(Redirect.appendTo(beforeoutput));
        System.out.println("Compiling..");
        try {
            flag = true;
            Process proccess = probuilder.start();
            proccess.waitFor();
            BufferedReader compileReader = new BufferedReader(new FileReader(path + "compile.txt"));
            String error = null;
            if ((error=compileReader.readLine()) == null) {
                System.out.println("Compiled successfully!");
            }
            else{
                flag=false;
                do{
                    System.out.println(error);
                }while((error=compileReader.readLine()) != null);
            }
            compileReader.close();
            beforeoutput.delete();
            new File(path + compile[1]).delete();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return flag;
    }
    public static boolean execute(String[] execute){
        ProcessBuilder prorunner = new ProcessBuilder ( execute );
        prorunner.directory(new File(npath));
        File output = new File(path + "output.txt");
        prorunner.redirectErrorStream(true);
        prorunner.redirectOutput(Redirect.appendTo(output));
        String relPath = Main.questionList.get(Main.index);
        ExecutorService executor = null;
        try {
            prorunner.redirectInput(new File(path + "TestCases//" + relPath.substring(0,relPath.length()-4)));
            System.out.println("Running..");
            
            //Execute run = new Execute(prorunner);
            //Process proccess = run.getProcess();
            //proccess.waitFor();
            //run.start();
            //System.out.println(run.isAlive());
            //run.join();
            //System.out.println(run.isAlive());
            executor = Executors.newSingleThreadExecutor();
            executor.submit(new Execute(prorunner)).get(30, TimeUnit.SECONDS);
            //boolean stop = executor.awaitTermination(30, TimeUnit.SECONDS);
            //System.out.println(stop);
            BufferedReader outputReader = new BufferedReader(new FileReader(path + "output.txt"));     
            String result = null;
            BufferedReader compare = new BufferedReader(new FileReader(path + "Results//" + relPath.substring(0,relPath.length()-4)));     
            String compareResult = null;
            while((result=outputReader.readLine())!=null && (compareResult=compare.readLine())!=null ){
                if(!result.trim().equals(compareResult)){
                    flag=false;
                    break;
                }
            }
            if((result=outputReader.readLine())!=null || (compareResult=compare.readLine())!=null){
                flag=false;
            }
            outputReader.close();
            output.delete();
            new File(path + "Solution.class").delete();
            new File(npath + "a.exe").delete();
            if(flag)
                System.out.println("Correct Output!");
            else{
                System.out.println("Incorrect Output!");
                flag = false;
            }
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            tle =true;
            exec.destroyForcibly();
            System.out.println(exec.isAlive());
        }
                
        return flag;
    }
    
    public static void java(){
        String[] compile = {"javac", "Solution.java"};
        boolean isCompiled = compile(compile);
        if(isCompiled){
            String[] execute = {"java", "Solution"};
            boolean isExecuted = execute(execute);
            
        }
    }
    
    public static void c(){
        
    }
    
    public static void cpp(){
        
    }
    
    public static void main(String [] args) {
        //new Main();
        File dir =new File(path + "Questions\\" );
        System.out.println(dir);
        for (File file : dir.listFiles()) {
          System.out.println(file.getName());
        }
    }
}