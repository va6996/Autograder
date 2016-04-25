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
	      statement.executeUpdate("create table mcq (id integer PRIMARY KEY AUTOINCREMENT, question string, option1 string, option2 string,"
	      		+ "option3 string, option4 string, answer string)");
	      statement.executeUpdate("insert into mcq(QUESTION, OPTION1, OPTION2, OPTION3, OPTION4,ANSWER) values('Who is the pres of USA', 'Trump', 'Oprah', 'Obama',"
	      		+ "'Gates', 'Obama')");
	      statement.executeUpdate("insert into mcq(QUESTION, OPTION1, OPTION2, OPTION3, OPTION4,ANSWER) values( 'Who is the Prime Minister of India','Modi', 'Jaitley', 'Vajpayee', 'Gandhi', 'Modi')");
	      statement.executeUpdate("insert into mcq(QUESTION) values( 'Who is the President of India')");
	      statement.executeUpdate("insert into mcq(QUESTION) values( 'What is the qwrqjnornq')");
	      statement.executeUpdate("insert into mcq(QUESTION) values( 'What is the sajnscakjv')");
	      ResultSet rs = statement.executeQuery("select * from mcq");
	      while(rs.next())
	      {
	        // read the result set
	        System.out.println("question = " + rs.getString("question"));
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
