package aakash;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import java.awt.Desktop;
import java.io.FileWriter;


public class view extends HttpServlet{
	
		public void service(HttpServletRequest req,HttpServletResponse res)throws IOException
		{	String hhh="";
			int rno=Integer.parseInt(req.getParameter("rno"));	
			try {
				   Class.forName("com.mysql.jdbc.Driver"); 
				   String url="jdbc:mysql://localhost:3306/hello";
				   String un="root";
				   String pa="1234";
				  Connection con=(Connection) DriverManager.getConnection(url,un,pa);  
							  Statement stmt=con.createStatement();  
							 ResultSet rs=stmt.executeQuery("select * from st where rno="+rno+"");  
							 while(rs.next())
							 {  PrintWriter out=res.getWriter();
							 	//out.println("<font size ='6'>");
							 	//out.println("STUDENT DETAILS<br>Registration no.="+rs.getInt(1)+"<br>Name= "+rs.getString(2)+"<br>Fathera's Name= "+rs.getString(3)+"<br>Mother's Nmae= "+rs.getString(4)+"<br>Mobile no= "+rs.getString(5)+"<br>Class= "+rs.getString(6)+"<br>Gender= "+rs.getString(7)+"  ");
                                                                hhh=hhh+"STUDENT DETAILS\n\nRegistration no.=";
                                                                hhh=hhh+rs.getInt(1);hhh=hhh+"\nName= "+rs.getString(2);hhh=hhh+"\nFathera's Name= "+rs.getString(3);hhh=hhh+"\nMother's Nmae= "+rs.getString(4);
                                                                hhh=hhh+"\nMobile no= "+rs.getString(5);hhh=hhh+"\nClass= "+rs.getString(6);hhh=hhh+"\nGender= "+rs.getString(7);
                                                                    
                                                         }
							  con.close();  
			   
			   		}
			   catch(Exception e)
			   {
			   JOptionPane.showMessageDialog(null, e.getMessage());
			   }
                        try{
        FileWriter fw=new FileWriter("C:\\Users\\Aakash Kumawat\\Desktop\\resume11.txt");
           fw.write(hhh);
        
           fw.close();
     }
     catch(Exception e){
         JOptionPane.showMessageDialog(null, e.getMessage());
     }
                        File file = new File("C:\\Users\\Aakash Kumawat\\Desktop\\resume11.txt");
                        Desktop desktop = Desktop.getDesktop();
                        if(file.exists()) desktop.open(file);
                        else
                            JOptionPane.showMessageDialog(null,"NOT FOUND");
		}
}
