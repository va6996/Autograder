package seproj;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class QuestionsDb {
	 public static void main(String[] args) 
	  {Connection connection = null;
	    try
	    {
	      // create a database connection
	      connection = DriverManager.getConnection("jdbc:sqlite:questionsdb.db");
	      Statement statement = connection.createStatement();
	      statement.setQueryTimeout(30);  // set timeout to 30 sec.

	      statement.executeUpdate("drop table if exists mcq");
	      statement.executeUpdate("drop table if exists lablist");
	      statement.executeUpdate("create table mcq (id integer PRIMARY KEY AUTOINCREMENT, question string, answer string,labid string,type string)");
	      statement.executeUpdate("create table lablist (id integer PRIMARY KEY AUTOINCREMENT, name string, password string,semester string,labid string)");
	      statement.executeUpdate("create table questemp (id integer PRIMARY KEY AUTOINCREMENT, question string, answer string)");
	      statement.executeUpdate("insert into lablist(name, password,semester,labid) values( 'SELab', 'sestudent','4', 'se')");
	      statement.executeUpdate("insert into lablist(name, password, semester,labid) values( 'CompLab', 'compstudent','4','comp')");
	      statement.executeUpdate("insert into lablist(name, password,semester,labid) values( 'OOPLab', 'oopstudent','3','oop')");
	      statement.executeUpdate("insert into lablist(name, password,semester,labid) values( 'DSLab', 'dsstudent','3','ds')");
	  
              statement.executeUpdate("insert into lablist(name, password,semester,labid) values( 'PSUCLab', 'psucstudent','1','psuc')");
              
                statement.executeUpdate("insert into mcq(QUESTION,labid,type) values('Sudoku','ds','coding')");
                 statement.executeUpdate("insert into mcq(QUESTION,labid,type) values('Not Funny','comp','coding')");
                  statement.executeUpdate("insert into mcq(QUESTION,labid,type) values('Create a gui for calculator','oop','gui')");
                   statement.executeUpdate("insert into mcq(QUESTION,labid,type) values('Create a state machine diagram for washing machine','se','gui')");
	      /* statement.executeUpdate("insert into mcq(QUESTION, ANSWER) values( 'Who is the Prime Minister of India','Modi')");
	      statement.executeUpdate("insert into mcq(QUESTION) values( 'Who is the President of India')");
	      statement.executeUpdate("insert into mcq(QUESTION) values( 'What is the qwrqjnornq')");
	      statement.executeUpdate("insert into mcq(QUESTION) values( 'What is the sajnscakjv')");*/
	      ResultSet rs = statement.executeQuery("select * from lablist");
	      while(rs.next())
	      {
	        // read the result set
	        System.out.println("question = " + rs.getString("name"));
	        System.out.println("id = " + rs.getInt("id"));
	      }
	     
	    }
	    catch(SQLException e)
	    {
	      // if the error message is "out of memory", 
	      // it probably means no database file is found
	      System.err.println(e.getMessage());
	    }
	    finally
	    {
	      try
	      {
	        if(connection != null)
	          connection.close();
	      }
	      catch(SQLException e)
	      {
	        // connection close failed.
	        System.err.println(e);
	      }
	    }
	  }
	

}
