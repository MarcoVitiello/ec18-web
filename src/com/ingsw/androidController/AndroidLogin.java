package com.ingsw.androidController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ingsw.model.CustomerDAO;

/**
 * Servlet implementation class AndroidLogin
 */
@WebServlet("/AndroidLogin")
public class AndroidLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AndroidLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mail=request.getParameter("mail");
		String password=request.getParameter("password");
		boolean validLogin=false;
		if (new CustomerDAO().isValid(mail, password)) {
			validLogin=true;
		}
		String booleanAsJSON=new Gson().toJson(validLogin);
		PrintWriter out = response.getWriter();	
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(booleanAsJSON);
        out.flush(); 
	}
}
