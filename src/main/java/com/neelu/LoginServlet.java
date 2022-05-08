package com.neelu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neelu.service.LoginService;
import com.neelu.service.impl.LoginServiceImp;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// PrintWriter print = response.getWriter();
		// print.print("Dummy data");
		/*
		 * RequestDispatcher requestDispatcher =
		 * request.getRequestDispatcher("/WEB_INF/jsp/login.jsp");;
		 * requestDispatcher.forward(request, response);
		 */

		String myname = request.getParameter("name");
		System.out.println(myname);
		request.setAttribute("name", myname);
		
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		// System.out.println(request.getParameter("name"));

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in post method");
		//Reading the Values from browser
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(name + "---------" + password);
		
		// bussinees Logic 
		LoginService service = new LoginServiceImp();
		boolean isValid = service.isValidUser(name,password);
		
		
		// redirecting to JSPS
		if (isValid) {
			request.setAttribute("userName", name);
			request.getRequestDispatcher("/WEB-INF/jsp/welcome.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Invalid Credentials");
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		}
	}

}
