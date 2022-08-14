package javaexample;
import java.util.Map.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


import javaexample.input;

public class h2embedded {
 
		static final String JDBC_DRIVER = "org.h2.Driver";   
		   static final String DB_URL = "jdbc:h2:~/test";  
		   
		   //  Database credentials 
		   static final String USER = "sa"; 
		   static final String PASS = "1234"; 
		   static Statement stmt = null; 
		   static Connection conn = null;
		   static Scanner sc= new Scanner(System.in);
		   
		   static void init() throws ClassNotFoundException, SQLException {
			   Class.forName(JDBC_DRIVER); 		          
		       conn = DriverManager.getConnection(DB_URL,USER,PASS);  		          
		       stmt = conn.createStatement(); 
		   }
		   
		   static boolean validateData(String name, String sub, String asCat) throws SQLException {
			   String sql= "SELECT * FROM ENTRY WHERE name = '"+ name +"' AND subject = '" + sub + "' AND assignment_category = '" + asCat + "'";		        
			   			   
			   ResultSet s = stmt.executeQuery(sql);
			   return !s.next();
		   }
		   static void inputData() throws SQLException {
		         
		         System.out.print("enter id,name,subject,assignment_category,doj,points\n");
		         String input=sc.next();
		         String[] arr= input.split(",",0);
		         int id=Integer.parseInt(arr[0]);
		         String name=arr[1];
		         String sub=arr[2];
		         String ac=arr[3];
		         String d=arr[4];
		         int points=Integer.valueOf(arr[5]);
		         
		         boolean isValidated = validateData(name, sub, ac);
		         if(!isValidated) {
		        	 System.out.println("Duplicate data entry!");
		        	 return;
		         }
		        String sql= "INSERT INTO ENTRY(ID,name,subject,assignment_category,DOJ,POINTS) VALUES('" +id+ "','"+ name +"','" + sub + "','" + ac + "','" + d + "','" + points + "')";
		        stmt.execute(sql);
		         
		   }
		   
		   static void outputData() throws SQLException {
			   	String sql="SELECT * FROM ENTRY";
		         ResultSet s=stmt.executeQuery(sql);
		         int id, points;
		         String name;
		         
		         while(s.next())
		         {
		        	 id=s.getInt("id");
		        	 name=s.getString("name");
		        	 String subject=s.getString("subject");
		        	 String as=s.getString("assignment_category");
		        	 Date date=s.getDate("DOJ");
		        	 
		        	 points=s.getInt("points");
		        	 System.out.println(id+","+name+","+subject+","+as+","+date+","+points);
		         }
		   }
		   
		   static void updateData() throws SQLException {
			   	String sql="SELECT * FROM ENTRY";
		         ResultSet s=stmt.executeQuery(sql);
		         int id, points;
		         String name;
		         
		         while(s.next())
		         {
		        	 id=s.getInt("id");
		        	 name=s.getString("name");
		        	 String subject=s.getString("subject");
		        	 String as=s.getString("assignment_category");
		        	 Date date=s.getDate("DOJ");
		        	 
		        	 points=s.getInt("points");
		        	 System.out.println(id+","+name+","+subject+","+as+","+date+","+points);
		         }
		   }
		   
		   private static void updateDate(String aname, String ssub, String ax, String da) throws SQLException
		   {
			   String sql=String.format("UPDATE ENTRY SET DOJ='%s' where name='%s' AND SUBJECT='%s' AND assignment_category='%s'", da, aname, ssub, ax);
			   
		        stmt.execute(sql);
		        System.out.println("updated succesfully");

		   }
		    static void updatepoints(String name,String sub,String as,int points) throws SQLException
			   {
				   String sql=String.format("UPDATE ENTRY SET POINTS='%s' where name='%s' AND SUBJECT='%s' AND assignment_category='%s'",points,name,sub,as);
				   stmt.execute(sql);
				   System.out.println("updated succesfully");
			   }
		   
		   static void createTable() {
			   String sqlq =  "CREATE TABLE   ENTRYs " + 
	            "(id INTEGER not NULL, " + 
	            " name VARCHAR(255), " +  
	            " subject VARCHAR(255), " +  
	            " assignment_category VARCHAR(255),"+
	            "DOJ DATE,"+
	            " POINTS INTEGER, " +  
	            " PRIMARY KEY ( id ))";

		   }
		   static void updateTable() throws SQLException{
			   int y= 0;
		    	  while(true) {
		    		  
		    		  System.out.println("Enter your operation");
		    		  System.out.println("1. Enter the date to be changed");
		    		  System.out.println("2. enter points to be changed");
		    		 
		    		  System.out.println("-1 to Exit");
		    		  y = sc.nextInt();
		    		  if(y == 1) {
		    			  System.out.println("enter name,subject,ass_cat,date to be cahnged");
		    			  String w=sc.next();
		    			  String[] z=w.split(",",0);
		    			  String aname =z[0];
		    			 String  ssub=z[1];
		    			  String ax=z[2];
		    			  String da=z[3];
		    			  
		    			  
		    			  updateDate(aname,ssub,ax,da);
		    		  } else if(y== 2) {
		    			  System.out.println("enter name,subject,ass_cat,points to be cahnged");
		    			   String w=sc.next();
		    			   String[] z=w.split(",",0);
			    			  String aname =z[0];
			    			 String  ssub=z[1];
			    			  String ax=z[2];
			    			  int da=Integer.valueOf(z[3]);
		    			  
		    			  
		    			  updatepoints(aname,ssub,ax,da);
		    		  }
		    		  
		    		  if(y == -1) {
		    			  break;
		    		  }
		    	  }
			   
			   
		   }
		   
		   
		   static void ShowStudentReport() throws SQLException {
			   String name;
			   System.out.println("Input the student's name");
			    name = sc.next();
			  // name = "Chaya";
			   String sql= String.format("SELECT subject, assignment_category, points FROM ENTRY WHERE name = '%s'", name);
		         ResultSet s=stmt.executeQuery(sql);
		         int points;
		         ArrayList<input> list = new ArrayList<input>();
		         
		         while(s.next())
		         {
		        	 String subject=s.getString("subject");
		        	 String as=s.getString("assignment_category");
		        	 points=s.getInt("points");
		        	 list.add(new input(subject, as, points));
		         }
		         HashMap<String, customSheet> mp = new HashMap<String, customSheet>();
		         for(int i=0;i<list.size();i++) {
		        	 if(!mp.containsKey(list.get(i).getSub())) {
		        		 mp.put(list.get(i).getSub(), new customSheet());
		        	 }
		        	 mp.get(list.get(i).getSub()).addData(list.get(i).getAsCat(), list.get(i).getPoints());
		         }
		         customSheet sheet;
		         Iterator<Entry<String, customSheet>> it = mp.entrySet().iterator();
	             while(it.hasNext()) {
	                Map.Entry obj = (Entry)it.next();
	                sheet = ((customSheet)obj.getValue());
	                System.out.print(obj.getKey().toString() + "    ");
	                sheet.printData();
	                System.out.print("\n");
	             } 
		          

		   }
		   
		   static void showResult() throws SQLException{
	    		  System.out.println("Enter your operation");
	    		  System.out.println("1. Show Student Report");
	    		  System.out.println("2. Show Subject Report");
	    		  System.out.println("-1 Exit");
	    		 
	    		  int y = sc.nextInt();
	    		  if(y == 1) {
	    			  ShowStudentReport();
	    		  } else if(y == 2) {
	    			  ShowSubjectReport();
	    			  
	    		  }

		   }
		private static void ShowSubjectReport() throws SQLException {
			 String subject;
			   System.out.println("Input the subject's name");
			    subject= sc.next();
			  
			   String sql= String.format("SELECT name, assignment_category, points FROM ENTRY WHERE subject = '%s'", subject);
		         ResultSet s=stmt.executeQuery(sql);
		         int points;
		         ArrayList<input> list = new ArrayList<input>();
		         
		         while(s.next())
		         {
		        	 String name=s.getString("name");
		        	 String as=s.getString("assignment_category");
		        	 points=s.getInt("points");
		        	 list.add(new input(name, as, points));
		         }
		         HashMap<String, customSheet> mp = new HashMap<String, customSheet>();
		         for(int i=0;i<list.size();i++) {
		        	 if(!mp.containsKey(list.get(i).getSub())) {
		        		 mp.put(list.get(i).getSub(), new customSheet());
		        	 }
		        	 mp.get(list.get(i).getSub()).addData(list.get(i).getAsCat(), list.get(i).getPoints());
		         }
		         customSheet sheet;
		         Iterator<Entry<String, customSheet>> it = mp.entrySet().iterator();
	             while(it.hasNext()) {
	                Map.Entry obj = (Entry)it.next();
	                sheet = ((customSheet)obj.getValue());
	                System.out.print(obj.getKey().toString() + "    ");
	                sheet.printData();
	                System.out.print("\n");
	             } 
		          
			// TODO Auto-generated method stub
			
		}

		public static void main(String[] args) { 
		       
		      
		      try {		          
		         
		    	  init();
		    	  int x = 0;
		    	  while(true) {
		    		  
		    		  System.out.println("Enter your operation");
		    		  System.out.println("1. Enter new data");
		    		  System.out.println("2. Read the data");
		    		  System.out.println("3. Update the data");
		    		  System.out.println("4. Delete the data");
		    		  System.out.println("5. Show Result");
		    		  System.out.println("-1 to Exit");
		    		  x = sc.nextInt();
		    		  if(x == 1) {
		    			  inputData();
		    		  } else if(x == 2) {
		    			  outputData();
		    		  } else if(x == 3) {
		    			  updateTable();
		    		  } else if(x == 4) {
		    			  deleteData();
		    		  } else if(x == 5) {
		    			  showResult();
		    		  }
		    		  if(x == -1) {
		    			  break;
		    		  }
		    	  }
		
		         stmt.close(); 
		         conn.close(); 
		         System.out.println("Thank-you");
		      } catch(Exception e) { 
		         //Handle errors for JDBC 
		         e.printStackTrace(); 
		      } finally { 
		         //finally block used to close resources 
		         try{ 
		            if(stmt!=null) stmt.close();
		            if(conn!=null) conn.close();
		         } catch(SQLException ignore) { 
		         }
		      } 
	}

		private static void deleteData() throws SQLException {
			// TODO Auto-generated method stub
			System.out.println("enter the name of the record to be deleted");
			String n=sc.next();
			String sql=String.format("DELETE FROM ENTRY WHERE name='%s'",n);
			stmt.execute(sql);
			System.out.println("record deleted succesfully");
		}}
class customSheet{
	
	public double scoreTest, scoreQuiz, scoreLab, scoreProject;
	public int numTest, numQuiz, numLab, numProject;
	customSheet(){
		numTest = 0;
		numQuiz = 0;
		numLab = 0;
		numProject = 0;
		scoreTest = 0;
		scoreLab = 0;
		scoreProject = 0;
		scoreQuiz = 0;
	}
	void addData(String assCA, int point) {
		String ass = assCA.split("_")[0];
		//System.out.println(assCA + ":::" + point + ":::" + ass);
		if(ass.equals("test")) {
			numTest++;
			scoreTest += point;
		}
		else if(ass.equals("quiz"))
		{
			numQuiz++;
			scoreQuiz+=point;
		}
		else if(ass.equals("lab"))
		{
			numLab++;
			scoreLab+=point;
		}
		else if(ass.equals("project"))
		{
			numProject++;
			scoreProject+=point;
		}
	}
	void printData(){
		if(numTest == 0) {
			System.out.print("NA    ");
		} else {
			double finalScore = (scoreTest * 0.4f) / numTest;
			System.out.print(finalScore + "    ");
		}
		
		if(numLab == 0) {
			System.out.print("NA    ");
		} else {
			double finalScore = (scoreLab * 0.1f) / numLab;
			System.out.print(finalScore + "    ");
		}
		if(numQuiz == 0) {
			System.out.print("NA    ");
		} else {
			double finalScore = (scoreQuiz * 0.2f) / numQuiz;
			System.out.print(finalScore + "    ");
		}
		if(numProject == 0) {
			System.out.print("NA    ");
		} else {
			double finalScore = (scoreProject * 0.3f) / numProject;
			System.out.print(finalScore + "    ");
		}
		
		
	}
}
//90,v,v,v,2020-06-06,9
