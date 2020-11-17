package aakash;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class fee extends HttpServlet{
		public void service(HttpServletRequest req, HttpServletResponse res)throws IOException
		{
			
			String rno=req.getParameter("rno");
			try {
				   Class.forName("com.mysql.jdbc.Driver"); 
				   String url="jdbc:mysql://localhost:3306/hello";
				   String un="root";
				   String pa="1234";
				  Connection con=(Connection) DriverManager.getConnection(url,un,pa);  
							  Statement stmt=con.createStatement();  
							 ResultSet rs=stmt.executeQuery("select * from st where rno="+rno+"");  
							 while(rs.next())
							 {  PrintWriter out1=res.getWriter();
                                                                out1.println("<font size='6'>");
							 	out1.println("STUDENT DETAILS<br>Registration no.="+rs.getInt(1)+"<br>Name= "+rs.getString(2)+"<br>Fathera's Name= "+rs.getString(3)+" <br> ");							 }
							  con.close();  
			   
			   		}
			   catch(Exception e)
			   {
			   JOptionPane.showMessageDialog(null, e.getMessage());
			   }
			PrintWriter out=res.getWriter();
			out.print("Please pay 12000/- to deposite annual fee");

		}
}
