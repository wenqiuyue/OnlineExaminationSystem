package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.AllSubjectBean;
import bean.LoginBean;
import bean.UserListBean;
import model.Subject;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		LoginBean loginBean=new LoginBean();
		User u=loginBean.Login(username, password);
		//如果查询到数据
		if(u!=null) {
			System.out.println("登录成功");
			request.getSession().setAttribute("user", u);
			//如果登录的用户类型是0管理员
			if(u.getUser_type().equals("0")) {
				System.out.println("管理员");

				UserListBean userListBean=new UserListBean();
				//将所有用户信息存入session
				List<User> userList=userListBean.UserList();
				request.getSession().setAttribute("userList", userList);
				
				response.sendRedirect("../OnlineExaminationSystem/ccps_11_lanseshuziOA/GuanLiYuan.jsp");
			}
			//如果登录的用户类型是1学生
			if(u.getUser_type().equals("1")) {
				response.sendRedirect("../OnlineExaminationSystem/ccps_11_lanseshuziOA/main.jsp");
			}
			//如果登录的用户类型是2教师
			if(u.getUser_type().equals("2")) {
				//查询一次科目
				AllSubjectBean allSubjectBean=new AllSubjectBean();
				//将所有科目信息存入session
				List<Subject> subjectList=allSubjectBean.AllSubject();
				request.getSession().setAttribute("subjectList2", subjectList);
				System.out.println("教师");
				response.sendRedirect("../OnlineExaminationSystem/ccps_11_lanseshuziOA/Teacher.jsp");
			}
		}else {
			System.out.println("登录失败");
			response.sendRedirect("Login.jsp");
		}
	}

}
