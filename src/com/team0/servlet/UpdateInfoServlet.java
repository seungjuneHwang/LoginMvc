package com.team0.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team0.dao.UserDAO;
import com.team0.vo.UserVO;

/**
 * Servlet implementation class UpdateInfoServlet
 */
@WebServlet("/UpdateInfoServlet")
public class UpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// admin.jsp 에 있는 모달에 있는 저장 버튼을 누르면
		// ajax(updateInfo()여기 함수) 가 있는 함수가 실행 되어서 여기 서블릿으로 들어 옴.
		System.out.println("admin.jsp의 모달에서 저장 버튼으로 들어옴.");
		// 전달 되는 값은? u_idx, name, email, phone, pw
		String u_idx = request.getParameter("u_idx");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String pw = request.getParameter("pw");
		// 확인용
		System.out.println(u_idx + " " + name + " " + email + " " + phone + " " + pw);
		// 전달 되는 값을 받아서 각각의 정보를 업데이트 쿼리를 날려서 수정
		// 업데이트 쿼리가 실행 하는 UserDAO를 만들어서 호출
		UserVO vo = new UserVO();
		vo.setU_idx(Integer.parseInt(u_idx));
		vo.setName(name);
		vo.setPhone(phone);
		vo.setEmail(email);
		vo.setPw(pw);
		
		try {
			UserDAO.updateInfo(vo);
			// 성공 하면 다시 admin.jsp 에서 ajax로 다시 가서 success 쪽으로 성공
			response.getWriter().println("OK");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 메세지를 보내어서 성공 했다라고 하고 다시 페이지 로드(admin.jsp에서)
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
