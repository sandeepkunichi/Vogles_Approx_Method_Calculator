package com.vam.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Servlet implementation class MyServlet
 */
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		VAM test = new VAM("Vogles approximation method");
		int i,j;
		int x=0,y=0,z=0;
		double m = Double.parseDouble(request.getParameter("m"));
		double n = Double.parseDouble(request.getParameter("n"));
		double[][] c = new double[(int)m][(int)n];
			for(i=0;i<(int)m;i++){
				for(j=0;j<(int)n;j++){
					c[i][j]=Double.parseDouble(request.getParameter("a"+x));
					x++;
				}
			}
			double[] supply=new double[(int)m];
			double[] demand=new double[(int)n];
			for(i=0;i<(int)m;i++){
				supply[i]=Double.parseDouble(request.getParameter("b"+y));
				y++;
			}
			for(j=0;j<(int)n;j++){
				demand[j]=Double.parseDouble(request.getParameter("c"+z));
				z++;
			}	
	    String result=Integer.toString(test.Voggle(c, supply, demand, m, n));
		response.setContentType("text/html");
	    request.setAttribute("todo", result);
	    request.getRequestDispatcher("/result.jsp").forward(request, response);
	}
}
