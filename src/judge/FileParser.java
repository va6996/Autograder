
package judge;

import java.io.File;
import javax.swing.DefaultListModel;

public class FileParser {
    public static DefaultListModel<String> parser(String directory){
        DefaultListModel<String> textFiles = new DefaultListModel<>();
        File dir = new File(directory);
        if(dir.exists()){
            for (File file : dir.listFiles()) {
              if (file.getName().endsWith((".txt"))) {
                textFiles.addElement(file.getName().replace(".txt", ""));
              }
            }
        }
        else
            ErrorHandling.ioError();
        return textFiles;
    }
}
