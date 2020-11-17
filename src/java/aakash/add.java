package aakash;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class add extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException ,ServletException
	{	
		String rno=(req.getParameter("rno"));
		String i=(req.getParameter("name"));
		String j=(req.getParameter("fname"));
		String kk=(req.getParameter("isTitles"));
		String ii=(req.getParameter("mname"));
		String jj=(req.getParameter("mob"));
		String gg=(req.getParameter("gender"));
		PrintWriter out=res.getWriter();
		//addstudent(rno,i,j,ii,jj,kk,gg);
		//out.println("DETAILS IS\nRegistration no="+rno+"\nName="+i+"\nFathers name"+j+"\nMothers name"+ii+"\nMoblie no"+jj+"\nClass="+kk+"\nGender="+gg);
                
                //request dispatcher
                req.setAttribute("name",i);
                req.setAttribute("rno",rno);
                req.setAttribute("fname",j);
                req.setAttribute("isTitles",kk);
                req.setAttribute("mname",ii);
                req.setAttribute("mob",jj);
                req.setAttribute("gender",gg);
                RequestDispatcher rd= req.getRequestDispatcher("call_servlet");
                rd.forward(req, res);
               

	}		
	/*void addstudent(String rno,String i,String j,String ii,String jj,String kk,String gg) 
	{
		try {
			   Class.forName("com.mysql.jdbc.Driver"); 
			   String url="jdbc:mysql://localhost:3306/hello";
			   String un="root";
			   String pa="1234";
			  Connection con=(Connection) DriverManager.getConnection(url,un,pa);  
						  Statement stmt=con.createStatement();  
						 // ResultSet rs=stmt.executeQuery("select * from emp");  
						  //while(rs.next())  
						 // System.out.println(rs.getInt(1)+"  "+rs.getString(2));
						  String sql = "INSERT INTO st " +
				                   "VALUES ('"+rno+"','"+i+"','"+j+"','"+ii+"','"+jj+"','"+kk+"','"+gg+"')";
				          stmt.executeUpdate(sql);
				          JOptionPane.showMessageDialog(null,"SUCCESFULLY ADDED");
						  con.close();  
		   
		   		}
		   catch(Exception e)
		   {
		   JOptionPane.showMessageDialog(null, e.getMessage());}
		   }*/

	}
		
		
		
		
	

