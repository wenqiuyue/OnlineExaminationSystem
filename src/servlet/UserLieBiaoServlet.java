package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AllStudentUserBean;
import bean.UserListBean;
import model.User;

/**
 * Servlet implementation class UserLieBiaoServlet
 */
@WebServlet("/UserLieBiaoServlet")
public class UserLieBiaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLieBiaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllStudentUserBean allStudentUserBean=new AllStudentUserBean();
		//将所有用户信息存入session
		List<User> userList=allStudentUserBean.AllStudentUser();
		request.getSession().setAttribute("userList1", userList);
		System.out.println("查询学生");
		response.sendRedirect("../OnlineExaminationSystem/Manager/jsp/StudentsLieBiao.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
