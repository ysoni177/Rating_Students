package corejava;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import corejava.input;
import corejava.structures;
import corejava.customSheet;



public class rating {
final static Scanner sc=new Scanner(System.in);
 final static HashMap<Integer,structures> mp= new HashMap<Integer,structures>();
	public static void main(String[] args) {
		
		  
	      	          
	         
	    	  
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
	    	  System.out.println("thank you");
		// TODO Auto-generated method stub

	
	}

	public static void showResult() {
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
		// TODO Auto-generated method stub
		
	}

	private static void ShowSubjectReport() {
		 System.out.println("Input the subject's name");
		   String  subject= sc.next();
		  
	         ArrayList<input> list = new ArrayList<input>();
	         structures op;
		        Iterator<Entry<Integer, structures>> it = mp.entrySet().iterator();
		       while(it.hasNext()) {
		           Map.Entry obj = (Entry)it.next();
		           op = ((structures)obj.getValue());
	       
	        	String name=op.name;
	        	 String as=op.asscat;
	        	int points=op.points;
	        	 list.add(new input(name, as, points));
	         }
	         HashMap<String, customSheet> mp1 = new HashMap<String, customSheet>();
	         for(int i=0;i<list.size();i++) {
	        	 if(!mp1.containsKey(list.get(i).getSub())) {
	        		 mp1.put(list.get(i).getSub(),new customSheet());
	        	 }
	        	 mp1.get(list.get(i).getSub()).addData(list.get(i).getAsCat(), list.get(i).getPoints());
	         }
	         customSheet sheet;
	        
          while(it.hasNext()) {
             Map.Entry obj = (Entry)it.next();
             sheet = ((customSheet)obj.getValue());
             System.out.print(obj.getKey().toString() + "    ");
             sheet.printData();
             System.out.print("\n");
          } 
	          
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		
	}

	private static void ShowStudentReport() {
		// TODO Auto-generated method stub
		System.out.println("enter the name of the student");
		 String  name= sc.next();
		  
         ArrayList<input> list = new ArrayList<input>();
         structures op;
	        Iterator<Entry<Integer, structures>> it = mp.entrySet().iterator();
	       while(it.hasNext()) {
	           Map.Entry obj = (Entry)it.next();
	           op = ((structures)obj.getValue());
       
        	String subject=op.subject;
        	 String as=op.asscat;
        	int points=op.points;
        	
        	 list.add(new input(subject, as, points));
        	 System.out.println(list);
         }
         HashMap<String, customSheet> mp1 = new HashMap<String, customSheet>();
         for(int i=0;i<list.size();i++) {
        	 if(!mp1.containsKey(list.get(i).getSub())) {
        		 mp1.put(list.get(i).getSub(),new customSheet());
        		 System.out.println("entered");
        	 }
        	 mp1.get(list.get(i).getSub()).addData(list.get(i).getAsCat(), list.get(i).getPoints());
         }
         customSheet sheet;
        
      while(it.hasNext()) {
         Map.Entry obj = (Entry)it.next();
         sheet = ((customSheet)obj.getValue());
         System.out.print(obj.getKey().toString() + "    ");
         sheet.printData();
         System.out.print("\n");
      } 
          
	}

	public static void deleteData() {
		// TODO Auto-generated method stub
		System.out.println("enter all the details to be deleted");
		String n=sc.next();
		String arr[]=n.split(",",0);
		int id=Integer.parseInt(arr[0]);
        String name=arr[1];
        String sub=arr[2];
        String ac=arr[3];
        String d=arr[4];
        int points=Integer.valueOf(arr[5]);
        mp.remove(id, new structures(id,name,sub,ac,d,points));
        System.out.println("removed succesfully");
		
	}

	public static void updateTable() {
		 int y= 0;
   	  while(true) {
   		  
   		  System.out.println("Enter your operation");
   		  System.out.println("1. Enter the date to be changed");
   		  System.out.println("2. enter points to be changed");
   		 
   		  System.out.println("-1 to Exit");
   		  y = sc.nextInt();
   		  if(y == 1) {
   			  System.out.println("enter id, name,subject,ass_cat,date to be cahnged,points");
   			  String w=sc.next();
   			  
   			  String[] z=w.split(",",0);
   			int id=Integer.parseInt(z[0]);
   			  String aname =z[1];
   			 String  ssub=z[2];
   			  String ax=z[3];
   			  String da=z[4];
   			  int points=Integer.parseInt(z[5]);
  
   			 
   			 mp.put(id, new structures(id,aname,ssub,ax,da,points));
   		       
   			  System.out.println("date changed succesfully");
   			  
   			  
   		  } else if(y== 2) 
   		  {
   			 System.out.println("enter id, name,subject,ass_cat,date,points to be changed");
  			  String w=sc.next();
  			  
  			  String[] z=w.split(",",0);
  			int id=Integer.parseInt(z[0]);
  			  String aname =z[1];
  			 String  ssub=z[2];
  			  String ax=z[3];
  			  String da=z[4];
  			  int points=Integer.parseInt(z[5]);
 
  			 
  			 mp.put(id, new structures(id,aname,ssub,ax,da,points));
  			 System.out.println("points changed succesfully");
  		       }
   			  
   		 
   	  }
		
		
	}
		// TODO Auto-generated method stub
		
	

	public static void outputData() {
		// TODO Auto-generated method stub
		 structures op;
	        Iterator<Entry<Integer, structures>> it = mp.entrySet().iterator();
	       while(it.hasNext()) {
	           Map.Entry obj = (Entry)it.next();
	           op = ((structures)obj.getValue());
	           //System.out.print(obj.getKey().toString() +"  ");
	          op.printdata();
	           System.out.print("\n");
	         
	       
	       }
		
	}

	public static void inputData() {
		// TODO Auto-generated method stub
		 System.out.print("enter id,name,subject,assignment_category,doj,points\n");
         String input=sc.next();
         
		
		String arr[]=input.split(",",0);
		int id=Integer.parseInt(arr[0]);
        String name=arr[1];
        String sub=arr[2];
        String ac=arr[3];
        String d=arr[4];
        int points=Integer.valueOf(arr[5]);
       // structures s=new structures(id,name,sub,ac,d,points);
        ArrayList<structures> list= new ArrayList<structures>();
        list.add(new structures(id,name,sub,ac,d,points));
        
        
        //HashMap<String, customSheet> mp = new HashMap<String, customSheet>();
        for(int i=0;i<list.size();i++) {
       	 if(!mp.containsKey(list.get(i).getName())) {
       		 mp.put(list.get(i).getId(), new structures(list.get(i).getId(),list.get(i).getName(),list.get(i).getSubject(),list.get(i).getAsscat(),list.get(i).getDate(),list.get(i).getPoints()));
       	 }
       	
        }
      
	}
	
	

}