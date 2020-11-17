package aakash;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class edit extends HttpServlet {
	public void service(HttpServletRequest req ,HttpServletResponse res)throws IOException
	{
		String rno=(req.getParameter("rno"));
		String i=(req.getParameter("name"));
		String j=(req.getParameter("fname"));
		String ii=(req.getParameter("mname"));
		String jj=(req.getParameter("mob"));
		String kk=(req.getParameter("isTitles"));
		String gg=(req.getParameter("gender"));
		addstudent(rno,i,j,ii,jj,kk,gg);
	}
		void addstudent(String rno,String i,String j,String ii,String jj,String kk,String gg) 
		{
			try {
				   Class.forName("com.mysql.jdbc.Driver"); 
				   String url="jdbc:mysql://localhost:3306/hello";
				   String un="root";
				   String pa="1234";
				  Connection con=(Connection) DriverManager.getConnection(url,un,pa);  
							  Statement stmt=con.createStatement();
							  String sql1="delete from st where rno="+rno+"";
							  if(stmt.executeUpdate(sql1)==0)
								  JOptionPane.showMessageDialog(null,"Record Not Found");
							  String sql = "INSERT INTO st " +
					                   "VALUES ('"+rno+"','"+i+"','"+j+"','"+ii+"','"+jj+"','"+kk+"','"+gg+"')";
					          if(stmt.executeUpdate(sql)!=0)
					          	JOptionPane.showMessageDialog(null,"SUCCESFULLY Updated");
					          else
					        	  JOptionPane.showMessageDialog(null,"Record Not Found");
							  con.close();  
			   
			   		}
			   catch(Exception e)
			   {
			   JOptionPane.showMessageDialog(null, e.getMessage());
			   }

	}
	
}	
