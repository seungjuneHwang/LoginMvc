package com.team0.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.team0.dao.UserDAO;
import com.team0.vo.UserVO;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String site = "admin/admin.jsp";
		
		// 로그인이 되었는지 체크(세션 session)
		HttpSession session = request.getSession();
		String idCheck = (String)session.getAttribute("email");
		// 만약에 idCheck 의 값이 있으면 amdin.jsp 로 보내고
		// 없으면 login.jsp 로 보내고(login.tm0)
		if (idCheck == null) {
			site = "login.tm0";
			response.sendRedirect(site);   // 로그인 페이지로 리다이렉트
			return;  // if 문 아래에 코드 진행을 막고 login 페이지로
		}
		// 여기에 DB 정보를 불러 와서 사용자 리스트 보여주기
		// UserDAO 에서 회원 정보 리스트를 받아 오는거 만들기
		try {
			ArrayList<UserVO> getList = UserDAO.getUser();
			// getList를 브라우저(jsp)에서 전달을 해줘야 하는데
			// 전달 할 수 있는 방법이 
			request.setAttribute("userlist", getList);  // userlist 이름으로 저장
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(site);   // "admin/admin.jsp";
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
