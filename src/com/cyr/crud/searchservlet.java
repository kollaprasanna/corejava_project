package com.cyr.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/searchServlet")
public class searchservlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String name = req.getParameter("search");
		out.println("search name ::" + name);
		out.println("<link rel='stylesheet' href='style.css'>");
		out.println(
				"<nav class='topnav' style='background:#006666;border:black; border-width:2px; border-style:solid;'>");
		out.println("<div class='navigation-bar'>");

		out.println("<div id='navigation-container'>");

		out.println("<img src='cyr technologies.jpg' width='6%' height='9%'>");

		out.println("<a href='index.html'>Home</a>|&nbsp;");
		out.println("<a href='nav.html'>Registration form</a> |&nbsp;");
		out.println("<a href='ViewServlet'>View employee</a> |&nbsp;");

		out.println(" <a href='login.html'>sign out</a>");
		out.println(" </nav>");
		out.println("  </div>");
		out.println(" </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");

		out.println("<h1>Employees List</h1>");

		out.println("<form action='searchServlet' method='post'>");

		out.println("<input type='text' name='search'  placeholder='Search for names..' >");
		out.print("<tr><td colspan='2'><input type='submit' value='search'/></td></tr>");

		Emp emp = new Emp();
		emp.setName(name);
		ArrayList<Emp> searchList = EmpDao.searchdByName(emp);

		out.print("<table border='1' width='100%'");
		out.print(

				"<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for (Emp e : searchList) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getPassword() + "</td><td>"
					+ e.getEmail() + "</td><td>" + e.getCountry() + "</td><td><a href='EditServlet?id=" + e.getId()
					+ "'>edit</a></td><td><a href='DeleteServlet?id=" + e.getId() + "'>delete</a></td></tr>");
		}
		out.print("</table>");
		out.print("</form>");
		out.close();

	}

}