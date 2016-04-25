/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Sith Lord
 */


public class CodeFormat {
    public static String javaCode(){
        String text = "import java.io.*;\nimport java.util.*;\n\npublic class Solution{\n\tpublic static void main(String[] args){\n\t\t\n\t}\n}";
        return text;
    }
    public static String cppCode(){
        String text = "#include<iostream>\nusing namespace std;\n\nint main(){\n\treturn 0;\n}";
        return text;
    }
    public static String cCode(){
        String text = "#include<stdio.h>\n\nint main(){\n\treturn 0;\n}";
        return text;
    }
}
