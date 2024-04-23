package com.hostmdy.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import com.hostmdy.model.Result;
import com.hostmdy.model.ResultDAO;
import com.hostmdy.model.User;

/**
 * Servlet implementation class ResultController
 */
public class ResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/examResult")
	private DataSource dataSource;
	
	private  ResultDAO resultDAO;
	
	@Override
	public void init() throws ServletException {
		resultDAO = new ResultDAO(dataSource);
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		if (user != null) {
		String mode = request.getParameter("mode");
		
		if(mode == null) {
			mode = "LIST";
		}
		
		switch (mode) {
		case "LIST":
			showResultList(request, response);
			break;
//		case "SEARCH":
//			searchResult(request, response);
//			break;
		case "CREATE":
			createResult(request, response);
			break;
		case "UPDATE":
			updateResult(request, response);
			break;
		case "DELETE":
			deleteResult(request, response);
			break;
		case "LOAD":
			loadResultById(request, response);
			break;
		case "LOGOUT":
			session.invalidate();
			response.sendRedirect("login");
			break;
		default:
			showResultList(request, response);
			break;
			
		}
		}else {
			response.sendRedirect("login");
		}
	}
	
	private void showResultList(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);

		List<Result> resultList =this.resultDAO.getResuList();
		
		
		request.setAttribute("resultList", resultList);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	
	}
		
//		PrintWriter out = response.getWriter();
//		 for(final Result result: resultList) {
//			 out.println(result +"\n");
//			 
//		 }
	
	private void loadResultById(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);

		int id = Integer.parseInt(request.getParameter("id"));
		Result result =this.resultDAO.getResult( id);
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("updateform.jsp");
		rd.forward(request, response);
	}
	
	
	private void createResult(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);

		String major = request.getParameter("major");
		
		int seatNo = Integer.parseInt(request.getParameter("seatnumber"));
		String name = request.getParameter("name");
		int year = Integer.parseInt(request.getParameter("year"));
		double grade = Double.parseDouble(request.getParameter("grade"));
		boolean qualify = Boolean.parseBoolean(request.getParameter("qualify"));
		
		Result result =new Result(major, seatNo, name, year, grade, qualify);
		
		int rowEffected = this.resultDAO.createResult(result);
		
		if(rowEffected > 0)
			showResultList(request, response);
		
		//PrintWriter out = response.getWriter();
//		if(rowEffected >0 )
//			out.print("Successfully created result in database");
//		else
//			out.print("Fail to create result in database");
		
		
		
	}
	
	private void updateResult(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);

		int id = Integer.parseInt(request.getParameter("id"));
		String major = request.getParameter("major");
		
		int seatNo = Integer.parseInt(request.getParameter("seatnumber"));
		String name = request.getParameter("name");
		int year = Integer.parseInt(request.getParameter("year"));
		double grade = Double.parseDouble(request.getParameter("grade"));
		boolean qualify = Boolean.parseBoolean(request.getParameter("qualify"));
		
		Result result =new Result(id,major, seatNo, name, year, grade, qualify);
		
		int rowEffected = this.resultDAO.updateResult(result);
		if(rowEffected >0 )
			showResultList(request, response);
			
		
	}
	
	private void deleteResult(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);

		int id = Integer.parseInt(request.getParameter("id"));
		int rowEffected = this.resultDAO.deleteResult(id);
		PrintWriter out = response.getWriter();
		if(rowEffected >0 )
			showResultList(request, response);
			
		
	}
//	private void searchResult(HttpServletRequest request,HttpServletResponse response) throws IOException {
//		
//		String query = request.getParameter("query");
//		String value = request.getParameter("value");
//		
//		List<Result> resultList =this.resultDAO.getResult(query, value);
//		
//		PrintWriter out = response.getWriter();
//		 for(final Result result: resultList) {
//			 out.println(result +"\n");
//			 
//		 }
//	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
