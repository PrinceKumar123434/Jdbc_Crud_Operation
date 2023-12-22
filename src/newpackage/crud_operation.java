//insert,show,update,delete 
package newpackage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class crud_operation 
{
 public static void main(String[] args) 
	{
	  int n;
	     Scanner in=new Scanner(System.in);
	     System.out.println("Jdbc crud operation...!");
	     System.out.println("1.Insert Data\n2.Show data\n3.Update data \n4.Delete data");
	     System.out.println("Enter your choice:");
	     n=in.nextInt();
	    
   //(......................*...................*.......................*...............)  
     //insert data
     switch(n)
     {
     case 1 ->
     {
    	 try
	     {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/userjdbc","root","");
	     
	      PreparedStatement ps=con.prepareStatement("insert into user values(?,?,?,?)");
	      
	      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	      
	      while(true)
	      {
	    	  System.out.println("Enter the roll:");
	    	  int roll=Integer.parseInt(br.readLine());
	    	  
	    	  System.out.println("Enter the name:");
	    	  String name=br.readLine();
	    	  
	    	  System.out.println("Enter the age:");
	    	  int age=Integer.parseInt(br.readLine());
	    	  
	    	  System.out.println("Enter the city:");
	    	  String city=br.readLine();
	    	  
	    	  ps.setInt(1, roll);
	    	  ps.setString(2, name);
	    	  ps.setInt(3, age);
	    	  ps.setString(4, city);
	    	  	   
	    	  int counte=ps.executeUpdate();
			 if(counte>0)
			 {
				 System.out.println(counte+ " :record add");
			 }
			 else 
			 {
				 System.out.println("no record add");
			 }
			System.out.println("Do you want to more records[Yes/No]");
			
			String sm=br.readLine();
			if(sm.equalsIgnoreCase("no"))
			{
				System.out.println("Thank you...!");
				break;
			}
	      }
	     }
	     catch(Exception e)
	     {
	    	 System.out.println(e);
	     } 
    	 break;
     }
     
   //(.................show data.......................*................*...........)   
     case 2->
     {
    	 try
	     {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/userjdbc","root","");
	     
	      Statement st=con.createStatement();
	      
	      ResultSet rs=st.executeQuery("Select * from user");
	      
	      while(rs.next())
	      {
	    	  int roll=rs.getInt(1);
	    	  String name=rs.getString(2);
	    	  int age=rs.getInt(3);
	    	  String city=rs.getString(4);
	    	  
	    	  System.out.println("Roll: "+roll);
	    	  System.out.println("Name: "+name);
	    	  System.out.println("Age: "+age);
	    	  System.out.println("City: "+city);
	    	  System.out.println();
	      }
	     }
	     catch(Exception e)
	     {
	    	 System.out.println(e);
	     }	
    	 break;
     }
     //(.............................Update database...............................)
     case 3 ->
     {
    	 try
	     {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/userjdbc","root","");
	      
	      String q="update user set name=?, age=? where roll=?";
	      
	      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	      
	      while(true)
	      {
	    System.out.println("Enter the new name:");	
	    String name=br.readLine();
	    
	    System.out.println("Enter the new age:");
	    int age=Integer.parseInt(br.readLine());
	    
	    System.out.println("Enter the student roll:");
	    int roll=Integer.parseInt(br.readLine());
	    
	    PreparedStatement ps=con.prepareStatement(q);
	    ps.setString(1, name);
	    ps.setInt(2, age);
	    ps.setInt(3, roll);
	    
	    int count=ps.executeUpdate();
	    if(count>0)
	    {
	    	System.out.println(count +" :record update ");
	    }
	    else 
	    {
	    	System.out.println("no record update ");	
	    }
	    
	    System.out.println("Do you want to update record [Yes/No]");
	    String ch=br.readLine();
	    if(ch.equalsIgnoreCase("no"))
	    {
	    	System.out.println("Your program closed...!");
	    break;
	    }
	      }
	     }
	     catch(Exception e)
	     {
	    	 System.out.println(e);
	     }	 
    break;	 
     }
     //(..................delete record..............................)
     case 4 ->
     {
    	 try
	     {
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      Connection con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/userjdbc","root","");
	     
	      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	      Statement st=con.createStatement();
	      
	      while(true)
	      {
	      System.out.println("Enter delete roll:");
	      int roll=Integer.parseInt(br.readLine());
	      
	      int counte=st.executeUpdate("delete from user where roll= "+roll);
			 if(counte>0)
			 {
				 System.out.println(counte+ " :record delete");
			 }
			 else 
			 {
				 System.out.println("no record delete");
			 }
	      
	      System.out.println("Do you want to delete more record[Yes/No]");
	      
	      String ch=br.readLine();
	      if(ch.equalsIgnoreCase("no"))
	      {
	    	  System.out.println("Thanks...!");
	      break;
	      }
	      }
	     }
	     catch(Exception e)
	     {
	    	 System.out.println(e);
	     }	 
    	 break;
     }
     
     default ->
     System.out.println("Your choice wrong...!");
     
		 
     }
     }
}
