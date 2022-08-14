package webapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import webapp.model.student;
public class studentdao  {
	/*public int registration(student Student) throws ClassNotFoundException{
		
	}
	static final String JDBC_DRIVER = "org.h2.Driver";   
	   static final String DB_URL = "jdbc:h2:~/test";  
	   
	   //  Database credentials 
	   static final String USER = "sa"; 
	   static final String PASS = "1234"; 
	   static Statement stmt = null; 
	   static Connection conn = null;
	   static Scanner sc= new Scanner(System.in);
	   
	 
		   Class.forName(JDBC_DRIVER); 		          
	       conn = DriverManager.getConnection(DB_URL,USER,PASS);  		          
	       stmt = conn.createStatement(); 
	       
	       String sql= "INSERT INTO ENTRY(ID,name,subject,assignment_category,DOJ,POINTS) VALUES('" +id+ "','"+ name +"','" + sub + "','" + ac + "','" + d + "','" + points + "')";
	        stmt.execute(sql);*/
	 public int register(student Student) throws ClassNotFoundException {
		// static final String JDBC_DRIVER = "org.h2.Driver";   
		   String DB_URL = "jdbc:h2:~/test"; 
		   String USER = "sa";
		   String PASS = "1234"; 
		 String INSERT_USERS_SQL = "INSERT INTO ENTRY" +
	            "  (ID,name,subject,assignment_category,DOJ,POINTS) VALUES " +
	            " (?, ?, ?, ?, ?,?);";

	        int result = 0;

	        Class.forName("org.h2.Driver");

	        try (Connection connection = DriverManager
	            .getConnection(DB_URL,USER,PASS);

	            // Step 2:Create a statement using connection object
	           PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	         /*   preparedStatement.setInt(1,Student.getId());
	            preparedStatement.setString(2, Student.getName());
	            preparedStatement.setString(3, Student.getSubject());
	            preparedStatement.setString(4, Student.getAsscat());
	            preparedStatement.setString(5, Student.getDate());
	            preparedStatement.setInt(6, Student.getPoints());
	            */

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
	        return result;
	    }

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }

}
