package seproj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class McqClass {
	public static void main(String args[]){
		
	Connection connection = null;
	try{
		
	connection = DriverManager.getConnection("jdbc:sqlite:questionsdb.db");
    Statement statement = connection.createStatement();
    statement.setQueryTimeout(30);  // set timeout to 30 sec.
    
	}
	catch(SQLException e){
		
	}
	finally{
		
	}
	
}}

