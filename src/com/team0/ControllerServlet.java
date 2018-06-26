package com.team0;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("*.tm0")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String url = request.getRequestURL().toString();
		String url2 = request.getRequestURI();
//		System.out.println(url);
//		System.out.println(url2);
		
		String [] sub = url.split("/");
		String [] sub2 = url2.split("/");
//		int idx = 0;
//		for (String s : sub2) {
//			System.out.println(idx++ + s);
//		}
		String subUrl = sub[4];
		String subUrl2 = sub2[0];
		
//		System.out.println(subUrl2);
		String site = null;
		switch (subUrl) {
		case "login.tm0":
			//response.getWriter().append("login page");
//			System.out.println(subUrl);
			site = "lion/login.jsp";
			break;
		case "login_proc.tm0":
			site = "LoginProc";	 // 모델 (model)
			break;	
		case "joinus.tm0":
			site = "signup/joinus.jsp";   // 뷰 (view)
			break;
		case "joinus_proc.tm0":
			site = "JoinUsProc";	 // 모델 (model)
			break;
		case "main.tm0":
			// response.getWriter().append("login success");
			site = "main/index.jsp";   // 뷰 (view)
			break;
		default:
			response.getWriter().append("error page");
			System.out.println("잘못된 URL");
			break;
		}
		// 서버내에서 페이지 이동
		RequestDispatcher dis = request.getRequestDispatcher(site);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
