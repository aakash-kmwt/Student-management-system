
package aakash;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class req_dispatcher extends HttpServlet{
    public void service(HttpServletRequest req,HttpServletResponse res)throws IOException
    {   String gg=(String)req.getAttribute("name");
        String rno=(String)req.getAttribute("rno");
	String i=(String)req.getAttribute("name");
	String j=(String)req.getAttribute("fname");
	String kk=(String)req.getAttribute("isTitles");
	String ii=(String)req.getAttribute("mname");
	String jj=(String)req.getAttribute("mob");
        PrintWriter out=res.getWriter();
        out.println("HEELO FROM NOTHER SERVER"+gg);
        
        
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
		   }

  }

