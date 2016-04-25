package Judge;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

public class Compile {
    public static String path = new File("").getAbsolutePath().concat("/");
    public static boolean flag;
    private static ProcessBuilder probuilder;

    //Set up the ProcessBuilder Streams.
    private static void setUpProcess(String[] compile, File beforeoutput){
        probuilder = new ProcessBuilder( compile );
        probuilder.directory(new File(path));
        probuilder.redirectErrorStream(true);
        probuilder.redirectOutput(Redirect.appendTo(beforeoutput));
    }

    //Main Compile Code.
    public static boolean compile(String[] compile) throws IOException, InterruptedException{
        File beforeoutput = new File(path + "compile.txt");
        setUpProcess(compile, beforeoutput);
        //All compiles are set to false by default.
        flag = false;
        Process proccess = probuilder.start();
        proccess.waitFor();
        //Test if compile was successful or not.
        BufferedReader compileReader = new BufferedReader(new FileReader(path + "compile.txt"));
        String error = null;
        if ((error=compileReader.readLine()) == null) {
                //If file is empty, the compile was a success.
                flag = true;
            System.out.println("Compiled successfully!");
        }
        else{
            do{
                //Print the error to the console.
                System.out.println(error);
            }while((error=compileReader.readLine()) != null);
        }
        //Close the files opened.
        compileReader.close();
        //Delete the compile.txt
        beforeoutput.delete();
        //Delete the compiled file.
        switch (compile[0]) {
            case "gcc":
                new File("Solution.c").delete();
                break;
            case "g++":
                new File("Solution.cpp").delete();
                break;
            case "javac":
                new File("Solution.java").delete();
                break;
        }
        return flag;
    }
	
}