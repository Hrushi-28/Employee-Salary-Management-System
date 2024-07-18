package com.enquiry;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/enq")
public class EnqData extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter  out = response.getWriter();
		String c1 = request.getParameter("course");
		String fname = request.getParameter("fname");
		String mname = request.getParameter("mname");
		String lname = request.getParameter("lname");
		String enqdate = request.getParameter("enqdate");
		String admdate = request.getParameter("admdate");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String college = request.getParameter("college");
		String univ = request.getParameter("univ");
		String add = request.getParameter("address");
		String ref = request.getParameter("reference");
		String ctype = request.getParameter("candidate");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enquiry_db","root","0923");
			if(conn!=null)
			{
				PreparedStatement pstm = conn.prepareStatement("insert into studetails(cname,fname,mname,lname,enqdate,admdate,email,contact,college,university,address,reference,candtype) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pstm.setString(1, c1);
				pstm.setString(2, fname);
				pstm.setString(3, mname);
				pstm.setString(4, lname);
				pstm.setString(5, enqdate);
				pstm.setString(6, admdate);
				pstm.setString(7, email);
				pstm.setString(8, contact);
				pstm.setString(9, college);
				pstm.setString(10, univ);
				pstm.setString(11, add);
				pstm.setString(12, ref);
				pstm.setString(13, ctype);
				
				int value = pstm.executeUpdate();
				if(value>0)
				{
					out.println("<h1>Details added successfully...</h1>");
				}
				else
				{
					out.println("<h1>Submission failed</h1>");
				}
			}
			else
			{
				out.println("DB not connected");
			}
		}catch(Exception ex)
		{
			out.println("Error is "+ex);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
