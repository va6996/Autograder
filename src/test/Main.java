/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author Sith Lord
 */
public class Main extends javax.swing.JFrame {

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AnswerPane;
    private javax.swing.JTextArea CodeArea;
    private javax.swing.JLabel ExecuteText;
    private javax.swing.JComboBox<String> LangSelector;
    private javax.swing.JPanel ListPane;
    private javax.swing.JButton Open;
    private javax.swing.JLabel Question;
    private javax.swing.JScrollPane QuestionList;
    private javax.swing.JPanel QuestionPane;
    private javax.swing.JList<String> QuestionsList;
    private javax.swing.JButton Submit;
    private javax.swing.JLabel defaultText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane rightPane;
    // End of variables declaration//GEN-END:variables

 
    /**
     * Creates new form Main
     */
    public static Vector<String> questionList;
    public static int index =0;
    public Main() {
        initComponents();
        questionList = FileParser.parser(Test.path + "Questions\\");
        QuestionsList.setListData(questionList);
        Question.setBorder(new EmptyBorder(10, 10, 10, 10));
        //QuestionList.setBorder(new EmptyBorder(10, 10, 10, 10));     
        CodeArea.setText(CodeFormat.cCode());
        loadQuest(0);
        QuestionsList.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        ListPane = new javax.swing.JPanel();
        QuestionList = new javax.swing.JScrollPane();
        QuestionsList = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        rightPane = new javax.swing.JTabbedPane();
        QuestionPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Question = new javax.swing.JLabel();
        AnswerPane = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        LangSelector = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CodeArea = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        Submit = new javax.swing.JButton();
        Open = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        defaultText = new javax.swing.JLabel();
        ExecuteText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        QuestionsList.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        QuestionsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        QuestionsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                QuestionsListValueChanged(evt);
            }
        });
        QuestionList.setViewportView(QuestionsList);

        javax.swing.GroupLayout ListPaneLayout = new javax.swing.GroupLayout(ListPane);
        ListPane.setLayout(ListPaneLayout);
        ListPaneLayout.setHorizontalGroup(
            ListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QuestionList, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );
        ListPaneLayout.setVerticalGroup(
            ListPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QuestionList, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Questions", ListPane);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        jSplitPane1.setLeftComponent(jPanel1);

        rightPane.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        Question.setBackground(new java.awt.Color(255, 255, 255));
        Question.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        Question.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Question.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Question.setOpaque(true);
        Question.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jScrollPane1.setViewportView(Question);

        javax.swing.GroupLayout QuestionPaneLayout = new javax.swing.GroupLayout(QuestionPane);
        QuestionPane.setLayout(QuestionPaneLayout);
        QuestionPaneLayout.setHorizontalGroup(
            QuestionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        QuestionPaneLayout.setVerticalGroup(
            QuestionPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        rightPane.addTab("Question", QuestionPane);

        jPanel3.setBackground(new java.awt.Color(153, 255, 153));

        LangSelector.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        LangSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C", "C++", "Java" }));
        LangSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LangSelectorActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel1.setText("Enter code here");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 322, Short.MAX_VALUE)
                .addComponent(LangSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LangSelector, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addContainerGap())
        );

        CodeArea.setColumns(20);
        CodeArea.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        CodeArea.setRows(5);
        jScrollPane2.setViewportView(CodeArea);

        jPanel5.setBackground(new java.awt.Color(153, 255, 153));

        Submit.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        Submit.setText("Submit");
        Submit.setMaximumSize(new java.awt.Dimension(100, 30));
        Submit.setMinimumSize(new java.awt.Dimension(100, 30));
        Submit.setPreferredSize(new java.awt.Dimension(100, 30));
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        Open.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        Open.setText("Open File");
        Open.setMaximumSize(new java.awt.Dimension(100, 30));
        Open.setMinimumSize(new java.awt.Dimension(100, 30));
        Open.setPreferredSize(new java.awt.Dimension(100, 30));
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Open, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Submit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Open, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3))
                    .addComponent(Submit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout AnswerPaneLayout = new javax.swing.GroupLayout(AnswerPane);
        AnswerPane.setLayout(AnswerPaneLayout);
        AnswerPaneLayout.setHorizontalGroup(
            AnswerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        AnswerPaneLayout.setVerticalGroup(
            AnswerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnswerPaneLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        rightPane.addTab("Answer", AnswerPane);

        defaultText.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        defaultText.setText("You haven't submit the the code yet;");

        ExecuteText.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ExecuteText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(defaultText, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(defaultText, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ExecuteText, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(389, Short.MAX_VALUE))
        );

        rightPane.addTab("Result", jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightPane)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rightPane)
        );

        jSplitPane1.setRightComponent(jPanel2);

        getContentPane().add(jSplitPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        rightPane.setSelectedIndex(2);
        String text = CodeArea.getText();
        String fileName = null;
        int select = LangSelector.getSelectedIndex();
        if(select == 0)
            fileName = "Solution.c";
        else if (select == 1)
            fileName = "Solution.cpp";
        else if (select == 2){
            fileName = "Solution.java";
        }
        try {
            FileWriter file = new FileWriter(Test.path + fileName);
            BufferedWriter writeFile = new BufferedWriter(file);
            writeFile.write(text);
            writeFile.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        submitAction(select);
    }//GEN-LAST:event_submitActionPerformed
    private void submitAction(int select){
        defaultText.setText("Compiling..");
        String[] compile = null;
        String[] execute = null;
        if(select ==0){
            Test.npath =Test.path + "bin\\";
            compile = new String[]{Test.npath +"gcc", Test.path +"Solution.c"};
            execute = new String[]{Test.npath +"a.exe"};
        }
        else if(select ==1){
            Test.npath =Test.path + "bin\\";
            compile = new String[]{Test.npath + "g++", Test.path +"Solution.cpp"};
            execute = new String[]{Test.npath +"a.exe"};
        }
        else if(select ==2){
            Test.npath = Test.path;
            compile = new String[]{"javac", "Solution.java"};
            execute = new String[]{"java", "Solution"};
        }
        boolean isCompiled = Test.compile(compile);
        if(isCompiled){
            defaultText.setText("Compiled Successfully!");
            boolean correctlyExecuted = Test.execute(execute);
            ExecuteText.setText("Executing..");
            if(Test.tle){
                ExecuteText.setText("<html><b><font color='red'>Time Limit Exceeded!</font></b></html>");
            }
            else if(correctlyExecuted){
                ExecuteText.setText("<html><b><font color='green'>Solution Accepted!</font></b></html>");
            }
            else{
                ExecuteText.setText("<html><b><font color='red'>Solution Rejected!</font></b></html>");
            }
        }
        else{
            defaultText.setText("<html><b><font color='red'>Compile Error!</font></b></html>");
            ExecuteText.setText("");
        }
    }
    
    private void LangSelectorActionPerformed() {//GEN-FIRST:event_LangSelectorActionPerformed
        // TODO add your handling code here:
        int select = LangSelector.getSelectedIndex();
        if(select == 0)
            CodeArea.setText(CodeFormat.cCode());
        else if (select == 1)
            CodeArea.setText(CodeFormat.cppCode());
        else if (select == 2){
            CodeArea.setText(CodeFormat.javaCode());
            //Test.java();
        }
    }//GEN-LAST:event_LangSelectorActionPerformed

    private void QuestionsListValueChanged() {//GEN-FIRST:event_QuestionsListValueChanged
        // TODO add your handling code here:
        index = QuestionsList.getSelectedIndex();
        loadQuest(index);
                
        
    }//GEN-LAST:event_QuestionsListValueChanged

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        // TODO add your handling code here:
        JFileChooser open = new JFileChooser();
        open.setFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        
        open.setFileFilter(new FileNameExtensionFilter("Source Files", "c", "cpp", "java"));
        
        if(open.showOpenDialog(this) ==JFileChooser.APPROVE_OPTION){
            System.out.println(open.getSelectedFile().getName());
            System.out.println(open.getCurrentDirectory());
            try {     
                BufferedReader Reader = new BufferedReader(new FileReader(open.getCurrentDirectory() + "\\" + open.getSelectedFile().getName()));
                String result = "", temp = null;
                while((temp=Reader.readLine())!=null){
                    result = result.concat(temp);
                    result =result.concat("\n");
                }
                CodeArea.setText(result);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_openActionPerformed
    public void loadQuest(int index){
        try {     
            BufferedReader Reader = new BufferedReader(new FileReader(Test.path + "Questions\\" + questionList.get(index)));
            String result = "", temp = null;
            while((temp=Reader.readLine())!=null){
                result = result.concat(temp);
            }
            Question.setText(result);
            rightPane.setSelectedIndex(0);
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }    
}
