package com.sandbox;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoudBot
 */
@WebServlet("/LoudBot")
public class LoudBot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String API = "https://api.groupme.com/v3/groups";
	private String name;
	private String text;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoudBot() {
        super();
        name = "default";
        text = "default";
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			response.getWriter().append(name).append(": ").append(text);
		} else {
			name = request.getParameter("name");
			text = request.getParameter("text");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
