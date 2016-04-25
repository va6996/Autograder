/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;

import java.util.List;
import java.util.Vector;

/**
 *
 * @author Sith Lord
 */
public class FileParser {
    public static Vector<String> parser(String directory){
        System.out.println(directory);
        Vector<String> textFiles = new Vector<>();
        File dir = new File(directory);
        for (File file : dir.listFiles()) {
          if (file.getName().endsWith((".txt"))) {
            textFiles.add(file.getName());
          }
        }
        return textFiles;
    }
}
